package com.hw.lineage.flink;


import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.result.FunctionResult;
import com.hw.lineage.common.result.LineageResult;
import com.hw.lineage.common.service.LineageService;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.metadata.JaninoRelMetadataProvider;
import org.apache.calcite.rel.metadata.RelColumnOrigin;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.rel.metadata.RelMetadataQueryBase;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.jdbc.catalog.JdbcCatalog;
import org.apache.flink.shaded.guava30.com.google.common.base.CaseFormat;
import org.apache.flink.shaded.guava30.com.google.common.collect.ImmutableMap;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.annotation.FunctionHint;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableConfig;
import org.apache.flink.table.api.TableException;
import org.apache.flink.table.api.ValidationException;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.api.internal.TableEnvironmentImpl;
import org.apache.flink.table.catalog.*;
import org.apache.flink.table.catalog.hive.HiveCatalog;
import org.apache.flink.table.functions.AggregateFunction;
import org.apache.flink.table.functions.ScalarFunction;
import org.apache.flink.table.functions.TableAggregateFunction;
import org.apache.flink.table.functions.TableFunction;
import org.apache.flink.table.module.ModuleManager;
import org.apache.flink.table.operations.Operation;
import org.apache.flink.table.operations.SinkModifyOperation;
import org.apache.flink.table.planner.calcite.FlinkRelBuilder;
import org.apache.flink.table.planner.calcite.RexFactory;
import org.apache.flink.table.planner.delegation.PlannerBase;
import org.apache.flink.table.planner.operations.PlannerQueryOperation;
import org.apache.flink.table.planner.plan.metadata.FlinkDefaultRelMetadataProvider;
import org.apache.flink.table.planner.plan.optimize.program.FlinkChainedProgram;
import org.apache.flink.table.planner.plan.optimize.program.StreamOptimizeContext;
import org.apache.flink.table.planner.plan.schema.TableSourceTable;
import org.apache.flink.table.planner.plan.trait.MiniBatchInterval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import static com.hw.lineage.common.util.Constant.DELIMITER;

/**
 * @description: LineageContext
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class LineageServiceImpl implements LineageService {
    private static final Logger LOG = LoggerFactory.getLogger(LineageServiceImpl.class);

    private static final Map<String, String> FUNCTION_SUFFIX_MAP = ImmutableMap.of(
            ScalarFunction.class.getName(), "udf",
            TableFunction.class.getName(), "udtf",
            AggregateFunction.class.getName(), "udaf",
            TableAggregateFunction.class.getName(), "udtaf"
    );


    private TableEnvironmentImpl tableEnv;
    private FlinkChainedProgram<StreamOptimizeContext> flinkChainedProgram;

    public LineageServiceImpl() {
        Configuration configuration = new Configuration();
        configuration.setBoolean("table.dynamic-table-options.enabled", true);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(configuration);

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .build();

        this.tableEnv = (TableEnvironmentImpl) StreamTableEnvironment.create(env, settings);
        this.flinkChainedProgram = FlinkStreamProgramWithoutPhysical.buildProgram(configuration);
    }

    public void useCatalog(AbstractCatalog catalog) {
        if (!tableEnv.getCatalog(catalog.getName()).isPresent()) {
            tableEnv.registerCatalog(catalog.getName(), catalog);
        }
        tableEnv.useCatalog(catalog.getName());
    }

    @Override
    public void setCatalog(CatalogType catalogType, String catalogName, String defaultDatabase, String... args) {
        AbstractCatalog catalog;
        switch (catalogType) {
            case HIVE:
                catalog = new HiveCatalog(catalogName, defaultDatabase, args[0]);
                break;
            case JDBC:
                catalog = new JdbcCatalog(getClassLoader(), catalogName, defaultDatabase, args[0], args[1], args[2]);
                break;
            default:
                catalog = new GenericInMemoryCatalog(catalogName, defaultDatabase);
        }
        useCatalog(catalog);
    }

    @Override
    public void execute(String singleSql) {
        LOG.info("Input Sql: \n {}", singleSql);
        tableEnv.executeSql(singleSql);
    }

    @Override
    public List<LineageResult> parseFieldLineage(String singleSql) {
        /**
         * Since TableEnvironment is not thread-safe, add this sentence to solve it.
         * Otherwise, NullPointerException will appear when org.apache.calcite.rel.metadata.RelMetadataQuery.<init>
         * http://apache-flink.370.s1.nabble.com/flink1-11-0-sqlQuery-NullPointException-td5466.html
         */
        RelMetadataQueryBase.THREAD_PROVIDERS.set(JaninoRelMetadataProvider.of(FlinkDefaultRelMetadataProvider.INSTANCE()));

        LOG.info("Input Sql: \n {}", singleSql);
        // 1. Generate original relNode tree
        Tuple2<String, RelNode> parsed = parseStatement(singleSql);
        String sinkTable = parsed.getField(0);
        RelNode oriRelNode = parsed.getField(1);

        // 2. Optimize original relNode to generate Optimized Logical Plan
        RelNode optRelNode = optimize(oriRelNode);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Original RelNode: \n {}", oriRelNode.explain());
            LOG.debug("Optimized RelNode: \n {}", optRelNode.explain());
        }

        // 3. Build lineage based from RelMetadataQuery
        return buildFiledLineageResult(sinkTable, optRelNode);
    }


    private Tuple2<String, RelNode> parseStatement(String sql) {
        List<Operation> operations = tableEnv.getParser().parse(sql);

        if (operations.size() != 1) {
            throw new TableException(
                    "Unsupported SQL query! only accepts a single SQL statement.");
        }
        Operation operation = operations.get(0);
        if (operation instanceof SinkModifyOperation) {
            SinkModifyOperation sinkOperation = (SinkModifyOperation) operation;

            PlannerQueryOperation queryOperation = (PlannerQueryOperation) sinkOperation.getChild();
            RelNode relNode = queryOperation.getCalciteTree();
            return new Tuple2<>(
                    sinkOperation.getContextResolvedTable().getIdentifier().asSummaryString(),
                    relNode);
        } else {
            throw new TableException("Only insert is supported now.");
        }
    }


    /**
     * Calling each program's optimize method in sequence.
     * <p>
     * Modified based on flink's source code {@link org.apache.flink.table.planner.plan.optimize.StreamCommonSubGraphBasedOptimizer}#optimizeTree
     */
    private RelNode optimize(RelNode relNode) {
        return flinkChainedProgram.optimize(relNode, new StreamOptimizeContext() {
            @Override
            public boolean isBatchMode() {
                return false;
            }

            @Override
            public TableConfig getTableConfig() {
                return tableEnv.getConfig();
            }

            @Override
            public FunctionCatalog getFunctionCatalog() {
                return getPlanner().functionCatalog();
            }

            @Override
            public CatalogManager getCatalogManager() {
                return tableEnv.getCatalogManager();
            }

            @Override
            public ModuleManager getModuleManager() {
                return getPlanner().moduleManager();
            }

            @Override
            public RexFactory getRexFactory() {
                return getPlanner().getFlinkContext().getRexFactory();
            }

            @Override
            public FlinkRelBuilder getFlinkRelBuilder() {
                return getPlanner().createRelBuilder();
            }

            @Override
            public boolean isUpdateBeforeRequired() {
                return false;
            }

            @Override
            public MiniBatchInterval getMiniBatchInterval() {
                return MiniBatchInterval.NONE;
            }

            @Override
            public boolean needFinalTimeIndicatorConversion() {
                return true;
            }

            @Override
            public ClassLoader getClassLoader() {
                return getPlanner().getFlinkContext().getClassLoader();
            }

            @SuppressWarnings("squid:S5803")
            private PlannerBase getPlanner() {
                return (PlannerBase) tableEnv.getPlanner();
            }
        });
    }

    private List<LineageResult> buildFiledLineageResult(String sinkTable, RelNode optRelNode) {
        // target columns
        List<String> targetColumnList = tableEnv.from(sinkTable)
                .getResolvedSchema()
                .getColumnNames();

        // check the size of query and sink fields match
        validateSchema(sinkTable, optRelNode, targetColumnList);

        RelMetadataQuery metadataQuery = optRelNode.getCluster().getMetadataQuery();
        List<LineageResult> resultList = new ArrayList<>();

        for (int index = 0; index < targetColumnList.size(); index++) {
            String targetColumn = targetColumnList.get(index);

            LOG.debug("**********************************************************");
            LOG.debug("Target table: {}", sinkTable);
            LOG.debug("Target column: {}", targetColumn);

            Set<RelColumnOrigin> relColumnOriginSet = metadataQuery.getColumnOrigins(optRelNode, index);

            if (CollectionUtils.isNotEmpty(relColumnOriginSet)) {
                for (RelColumnOrigin rco : relColumnOriginSet) {
                    // table
                    RelOptTable table = rco.getOriginTable();
                    String sourceTable = String.join(DELIMITER, table.getQualifiedName());

                    // filed
                    int ordinal = rco.getOriginColumnOrdinal();
                    List<String> fieldNames = ((TableSourceTable) table).contextResolvedTable().getResolvedSchema().getColumnNames();
                    String sourceColumn = fieldNames.get(ordinal);
                    LOG.debug("----------------------------------------------------------");
                    LOG.debug("Source table: {}", sourceTable);
                    LOG.debug("Source column: {}", sourceColumn);
                    if (StringUtils.isNotEmpty(rco.getTransform())) {
                        LOG.debug("transform: {}", rco.getTransform());
                    }
                    // add record
                    resultList.add(new LineageResult(sourceTable, sourceColumn, sinkTable, targetColumn, rco.getTransform()));
                }
            }
        }
        return resultList;
    }


    /**
     * Check the size of query and sink fields match
     */
    private void validateSchema(String sinkTable, RelNode relNode, List<String> sinkFieldList) {
        List<String> queryFieldList = relNode.getRowType().getFieldNames();
        if (queryFieldList.size() != sinkFieldList.size()) {
            throw new ValidationException(
                    String.format(
                            "Column types of query result and sink for %s do not match.\n"
                                    + "Query schema: %s\n"
                                    + "Sink schema:  %s",
                            sinkTable, queryFieldList, sinkFieldList));
        }
    }


    public Catalog getCatalog(String catalogName) {
        return tableEnv.getCatalog(catalogName).orElseThrow(() ->
                new ValidationException(String.format("Catalog %s does not exist", catalogName))
        );
    }

    public TableEnvironmentImpl getTableEnv() {
       return tableEnv;
    }

    @Override
    public List<FunctionResult> parseFunction(File file) throws IOException, ClassNotFoundException {
        LOG.info("starting parse function from jar {}", file.getPath());
        List<FunctionResult> resultList = new ArrayList<>();
        URL url = file.toURI().toURL();

        try (URLClassLoader classLoader = new URLClassLoader(new URL[]{url}, getClass().getClassLoader());
             JarFile jarFile = new JarFile(file)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                String entryName = entries.nextElement().getName();
                if (entryName.endsWith(".class")) {
                    String className = entryName.replace("/", ".").substring(0, entryName.length() - 6);
                    // filter commons-compress.jar because of asm and org.apache.flink.table.functions.python.PythonScalarFunction
                    if (!className.startsWith("org.apache.commons.compress.harmony")
                            && !className.startsWith("org.apache.flink.table.functions")) {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.getSuperclass() != null && FUNCTION_SUFFIX_MAP.containsKey(clazz.getSuperclass().getName())) {
                            resultList.add(parseUserDefinedFunction(clazz));
                        }
                    }
                }
            }
        }
        LOG.info("finished parse function from jar {}, resultList: {}", file.getPath(), resultList);
        return resultList;
    }


    public FunctionResult parseUserDefinedFunction(Class<?> clazz) {
        String functionClass = clazz.getName();
        String className = searchClassName(functionClass);
        String functionName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, className);
        // replace function with udf
        functionName = functionName.replace("function", FUNCTION_SUFFIX_MAP.get(clazz.getSuperclass().getName()));
        // consider only the case of one eval function
        Optional<Method> methodOptional = Arrays.stream(clazz.getDeclaredMethods())
                .filter(e -> "eval".equals(e.getName()))
                .findFirst();

        FunctionResult result = new FunctionResult();
        result.setClassName(functionClass);
        result.setFunctionName(functionName);

        if (methodOptional.isPresent()) {
            Method method = methodOptional.get();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            String parameters = Arrays.stream(method.getParameters())
                    .map(parameter -> searchClassName(parameter.getType().getName() + atomicInteger.getAndIncrement()))
                    .collect(Collectors.joining(","));

            // set functionFormat
            result.setInvocation(String.format("%s(%s)", functionName, parameters));

            // use function return type as description
            result.setDescr(buildFunctionReturnType(clazz, method));
        }
        return result;
    }

    private String buildFunctionReturnType(Class<?> clazz, Method method) {
        if (clazz.getSuperclass().isAssignableFrom(TableFunction.class)
                && clazz.isAnnotationPresent(FunctionHint.class)) {
            return "return " + clazz.getAnnotation(FunctionHint.class).output().value();
        }
        return "return " + searchClassName(method.getReturnType().getName());
    }


    private String searchClassName(String value) {
        return value.contains(".") ? value.substring(value.lastIndexOf(".") + 1) : value;
    }
}
