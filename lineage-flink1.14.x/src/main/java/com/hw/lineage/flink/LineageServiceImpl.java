/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.flink;

import com.hw.lineage.common.enums.TableKind;
import com.hw.lineage.common.model.*;
import com.hw.lineage.common.service.LineageService;

import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.metadata.JaninoRelMetadataProvider;
import org.apache.calcite.rel.metadata.RelColumnOrigin;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.rel.metadata.RelMetadataQueryBase;
import org.apache.calcite.sql.SqlNode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.shaded.guava30.com.google.common.base.CaseFormat;
import org.apache.flink.shaded.guava30.com.google.common.collect.ImmutableMap;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.annotation.FunctionHint;
import org.apache.flink.table.api.*;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.api.internal.TableEnvironmentImpl;
import org.apache.flink.table.catalog.*;
import org.apache.flink.table.delegation.Parser;
import org.apache.flink.table.functions.AggregateFunction;
import org.apache.flink.table.functions.ScalarFunction;
import org.apache.flink.table.functions.TableAggregateFunction;
import org.apache.flink.table.functions.TableFunction;
import org.apache.flink.table.operations.CatalogSinkModifyOperation;
import org.apache.flink.table.operations.Operation;
import org.apache.flink.table.planner.delegation.ParserImpl;
import org.apache.flink.table.planner.delegation.PlannerBase;
import org.apache.flink.table.planner.operations.PlannerQueryOperation;
import org.apache.flink.table.planner.plan.metadata.FlinkDefaultRelMetadataProvider;
import org.apache.flink.table.planner.plan.schema.TableSourceTable;
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
import static java.util.Objects.requireNonNull;

/**
 * @description: LineageContext
 * @author: HamaWhite
 */
public class LineageServiceImpl implements LineageService {

    private static final Logger LOG = LoggerFactory.getLogger(LineageServiceImpl.class);

    private static final String SHOW_CREATE_TABLE_SQL = "SHOW CREATE TABLE %s.`%s`.%s";

    private static final String SHOW_CREATE_VIEW_SQL = "SHOW CREATE VIEW %s.`%s`.%s";

    private static final Map<String, String> FUNCTION_SUFFIX_MAP = ImmutableMap.of(
            ScalarFunction.class.getName(), "udf",
            TableFunction.class.getName(), "udtf",
            AggregateFunction.class.getName(), "udaf",
            TableAggregateFunction.class.getName(), "udtaf");

    private final TableEnvironmentImpl tableEnv;

    public LineageServiceImpl() {
        Configuration configuration = new Configuration();
        configuration.setBoolean("table.dynamic-table-options.enabled", true);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(configuration);

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .build();

        this.tableEnv = (TableEnvironmentImpl) StreamTableEnvironment.create(env, settings);
    }

    public void useCatalog(AbstractCatalog catalog) {
        if (!tableEnv.getCatalog(catalog.getName()).isPresent()) {
            tableEnv.registerCatalog(catalog.getName(), catalog);
        }
        tableEnv.useCatalog(catalog.getName());
    }

    @Override
    public void execute(String singleSql) {
        executeSql(singleSql);
    }

    @Override
    public Set<FunctionResult> analyzeFunction(String singleSql) {
        LOG.info("Analyze function Sql: \n {}", singleSql);
        ParserImpl parser = (ParserImpl) tableEnv.getParser();

        // parsing sql and return the abstract syntax tree
        SqlNode sqlNode = parser.parseSql(singleSql);

        // validate the query
        SqlNode validated = parser.validate(sqlNode);

        // look for all functions
        FunctionVisitor visitor = new FunctionVisitor();
        validated.accept(visitor);
        List<UnresolvedIdentifier> fullFunctionList = visitor.getFunctionList();

        // filter custom functions
        Set<FunctionResult> resultSet = new HashSet<>();
        for (UnresolvedIdentifier unresolvedIdentifier : fullFunctionList) {
            getFunctionCatalog()
                    .lookupFunction(unresolvedIdentifier)
                    // the objectIdentifier of the built-in function is null
                    .flatMap(e -> e.getFunctionIdentifier().getIdentifier())
                    .ifPresent(identifier -> {
                        FunctionResult functionResult = new FunctionResult()
                                .setCatalogName(identifier.getCatalogName())
                                .setDatabase(identifier.getDatabaseName())
                                .setFunctionName(identifier.getObjectName());
                        LOG.debug("analyzed function: {}", functionResult);
                        resultSet.add(functionResult);
                    });
        }
        return resultSet;
    }

    private FunctionCatalog getFunctionCatalog() {
        PlannerBase planner = (PlannerBase) tableEnv.getPlanner();
        return planner.getFlinkContext().getFunctionCatalog();
    }

    private TableResult executeSql(String singleSql) {
        LOG.info("Execute SQL: {}", singleSql);
        return tableEnv.executeSql(singleSql);
    }

    @Override
    public List<LineageResult> analyzeLineage(String singleSql) {
        /*
         * Since TableEnvironment is not thread-safe, add this sentence to solve it. Otherwise, NullPointerException
         * will appear when org.apache.calcite.rel.metadata.RelMetadataQuery.<init>
         * http://apache-flink.370.s1.nabble.com/flink1-11-0-sqlQuery-NullPointException-td5466.html
         */
        RelMetadataQueryBase.THREAD_PROVIDERS
                .set(JaninoRelMetadataProvider.of(FlinkDefaultRelMetadataProvider.INSTANCE()));

        LOG.info("Analyze lineage Sql: \n {}", singleSql);
        // 1. Generate original relNode tree
        Tuple2<String, RelNode> parsed = parseStatement(singleSql);
        String sinkTable = parsed.getField(0);
        RelNode oriRelNode = parsed.getField(1);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Original RelNode: \n {}", oriRelNode.explain());
        }

        // 2. Build lineage based from RelMetadataQuery
        return buildFiledLineageResult(sinkTable, oriRelNode);
    }

    private Tuple2<String, RelNode> parseStatement(String singleSql) {
        // do parse, validate and convert
        Operation operation = parseValidateConvert(singleSql);

        if (operation instanceof CatalogSinkModifyOperation) {
            CatalogSinkModifyOperation sinkOperation = (CatalogSinkModifyOperation) operation;

            PlannerQueryOperation queryOperation = (PlannerQueryOperation) sinkOperation.getChild();
            RelNode relNode = queryOperation.getCalciteTree();
            return new Tuple2<>(
                    sinkOperation.getTableIdentifier().asSummaryString(),
                    relNode);
        } else {
            throw new TableException("Only insert is supported now.");
        }
    }

    /**
     * Note: {@link Parser#parse(String)} will do three stages: parse, validate and convert
     */
    private Operation parseValidateConvert(String singleSql) {
        /*
         * Since TableEnvironment is not thread-safe, add this sentence to solve it. Otherwise, NullPointerException
         * will appear when org.apache.calcite.rel.metadata.RelMetadataQuery.<init>
         * http://apache-flink.370.s1.nabble.com/flink1-11-0-sqlQuery-NullPointException-td5466.html
         */
        RelMetadataQueryBase.THREAD_PROVIDERS
                .set(JaninoRelMetadataProvider.of(FlinkDefaultRelMetadataProvider.INSTANCE()));

        List<Operation> operations = tableEnv.getParser().parse(singleSql);
        if (operations.size() != 1) {
            throw new TableException(
                    "Unsupported SQL query! only accepts a single SQL statement.");
        }
        return operations.get(0);
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
                    List<String> fieldNames =
                            ((TableSourceTable) table).catalogTable().getResolvedSchema().getColumnNames();
                    String sourceColumn = fieldNames.get(ordinal);
                    LOG.debug("----------------------------------------------------------");
                    LOG.debug("Source table: {}", sourceTable);
                    LOG.debug("Source column: {}", sourceColumn);
                    if (StringUtils.isNotEmpty(rco.getTransform())) {
                        LOG.debug("transform: {}", rco.getTransform());
                    }
                    // add record
                    resultList.add(
                            new LineageResult(sourceTable, sourceColumn, sinkTable, targetColumn, rco.getTransform()));
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

    @Override
    public void parseValidate(String singleSql) {
        LOG.info("Input Sql: \n {}", singleSql);
        parseValidateConvert(singleSql);
    }

    @Override
    public List<FunctionInfo> parseFunction(File file) throws IOException, ClassNotFoundException {
        List<FunctionInfo> resultList = new ArrayList<>();
        URL url = file.toURI().toURL();

        try (URLClassLoader classLoader = new URLClassLoader(new URL[]{url}, getClass().getClassLoader());
                JarFile jarFile = new JarFile(file)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                String entryName = entries.nextElement().getName();
                if (entryName.endsWith(".class")) {
                    String className = entryName.replace("/", ".").substring(0, entryName.length() - 6);
                    // filter commons-compress.jar because of asm
                    if (!className.startsWith("org.apache.commons.compress.harmony")
                            && !className.startsWith("org.apache.flink.table.functions")) {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.getSuperclass() != null
                                && FUNCTION_SUFFIX_MAP.containsKey(clazz.getSuperclass().getName())) {
                            resultList.add(parseUserDefinedFunction(clazz));
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public FunctionInfo parseUserDefinedFunction(Class<?> clazz) {
        String functionClass = clazz.getName();
        String className = searchClassName(functionClass);
        String functionName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, className);
        // replace function with udf
        functionName = functionName.replace("function", FUNCTION_SUFFIX_MAP.get(clazz.getSuperclass().getName()));
        // consider only the case of one eval function
        Optional<Method> methodOptional = Arrays.stream(clazz.getDeclaredMethods())
                .filter(e -> "eval".equals(e.getName()))
                .findFirst();

        FunctionInfo result = new FunctionInfo();
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

    private Catalog getCatalog(String catalogName) {
        return tableEnv.getCatalog(catalogName)
                .orElseThrow(() -> new ValidationException(String.format("Catalog %s does not exist", catalogName)));
    }

    @Override
    public List<String> listDatabases(String catalogName) {
        return getCatalog(catalogName).listDatabases();
    }

    @Override
    public List<String> listTables(String catalogName, String database) throws Exception {
        return getCatalog(catalogName).listTables(database);
    }

    @Override
    public List<String> listViews(String catalogName, String database) throws Exception {
        return getCatalog(catalogName).listViews(database);
    }

    @Override
    public TableInfo getTable(String catalogName, String database, String tableName) throws Exception {
        ObjectPath objectPath = new ObjectPath(database, tableName);
        CatalogBaseTable table = getCatalog(catalogName).getTable(objectPath);
        Schema schema = table.getUnresolvedSchema();
        LOG.info("table.schema: {}", schema);
        List<String> primaryKeyList = new ArrayList<>();
        schema.getPrimaryKey()
                .ifPresent(pk -> primaryKeyList.addAll(pk.getColumnNames()));

        Map<String, String> watermarkMap = schema.getWatermarkSpecs()
                .stream()
                .collect(Collectors.toMap(Schema.UnresolvedWatermarkSpec::getColumnName,
                        entry -> entry.getWatermarkExpression().toString()));

        List<ColumnInfo> columnList = schema.getColumns()
                .stream()
                .map(column -> new ColumnInfo()
                        .setColumnName(column.getName())
                        .setColumnType(processColumnType(column))
                        .setComment(column.getComment().orElse(""))
                        .setPrimaryKey(primaryKeyList.contains(column.getName()))
                        .setWatermark(watermarkMap.getOrDefault(column.getName(), "")))
                .collect(Collectors.toList());

        return new TableInfo()
                .setTableName(tableName)
                .setTableKind(TableKind.valueOf(table.getTableKind().name()))
                .setComment(table.getComment())
                .setColumnList(columnList)
                .setPropertiesMap(table.getOptions());
    }

    private String processColumnType(Schema.UnresolvedColumn column) {
        if (column instanceof Schema.UnresolvedComputedColumn) {
            return ((Schema.UnresolvedComputedColumn) column)
                    .getExpression()
                    .asSummaryString();
        } else if (column instanceof Schema.UnresolvedPhysicalColumn) {
            return ((Schema.UnresolvedPhysicalColumn) column).getDataType()
                    .toString()
                    // BIGINT NOT NULL
                    .replace("NOT NULL", "")
                    .trim();
        } else if (column instanceof Schema.UnresolvedMetadataColumn) {
            return ((Schema.UnresolvedMetadataColumn) column).getDataType().toString();
        }
        return "unknown";
    }

    @Override
    public void dropTable(String catalogName, String database, String tableName) throws Exception {
        ObjectPath objectPath = new ObjectPath(database, tableName);
        getCatalog(catalogName).dropTable(objectPath, false);
    }

    @Override
    public String getTableDdl(String catalogName, String database, String tableName) throws Exception {
        TableInfo tableInfo = getTable(catalogName, database, tableName);
        String showCreateSql = tableInfo.getTableKind().equals(TableKind.TABLE)
                ? String.format(SHOW_CREATE_TABLE_SQL, catalogName, database, tableName)
                : String.format(SHOW_CREATE_VIEW_SQL, catalogName, database, tableName);

        TableResult tableResult = executeSql(showCreateSql);
        String tableDdl = requireNonNull(tableResult.collect().next().getField(0)).toString();

        // simplified table name
        return tableDdl.replace(String.format("`%s`.`%s`.", catalogName, database), "");
    }

    public String getCurrentCatalog() {
        return tableEnv.getCurrentCatalog();
    }
}
