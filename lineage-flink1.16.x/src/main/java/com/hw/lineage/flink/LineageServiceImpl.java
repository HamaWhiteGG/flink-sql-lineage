package com.hw.lineage.flink;


import com.hw.lineage.LinageService;
import com.hw.lineage.LineageResult;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.metadata.RelColumnOrigin;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.*;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.api.internal.TableEnvironmentImpl;
import org.apache.flink.table.catalog.AbstractCatalog;
import org.apache.flink.table.catalog.CatalogManager;
import org.apache.flink.table.catalog.FunctionCatalog;
import org.apache.flink.table.module.ModuleManager;
import org.apache.flink.table.operations.Operation;
import org.apache.flink.table.operations.SinkModifyOperation;
import org.apache.flink.table.planner.calcite.FlinkRelBuilder;
import org.apache.flink.table.planner.calcite.RexFactory;
import org.apache.flink.table.planner.delegation.PlannerBase;
import org.apache.flink.table.planner.operations.PlannerQueryOperation;
import org.apache.flink.table.planner.plan.optimize.program.FlinkChainedProgram;
import org.apache.flink.table.planner.plan.optimize.program.StreamOptimizeContext;
import org.apache.flink.table.planner.plan.schema.TableSourceTable;
import org.apache.flink.table.planner.plan.trait.MiniBatchInterval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.hw.lineage.Constant.DELIMITER;

/**
 * @description: LineageContext
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2022/8/6 11:06 AM
 */
public class LineageServiceImpl implements LinageService {
    private static final Logger LOG = LoggerFactory.getLogger(LineageServiceImpl.class);
    private final TableEnvironmentImpl tableEnv;
    private final FlinkChainedProgram<StreamOptimizeContext> flinkChainedProgram;

    public LineageServiceImpl(AbstractCatalog catalog) {
        Configuration configuration = new Configuration();
        configuration.setBoolean("table.dynamic-table-options.enabled", true);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(configuration);

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .build();

        this.tableEnv = (TableEnvironmentImpl) StreamTableEnvironment.create(env, settings);

        tableEnv.registerCatalog(catalog.getName(), catalog);
        tableEnv.useCatalog(catalog.getName());

        this.flinkChainedProgram = FlinkStreamProgramWithoutPhysical.buildProgram(configuration);
    }


    @Override
    public void execute(String singleSql) {
        tableEnv.executeSql(singleSql);
    }

    @Override
    public List<LineageResult> parseFieldLineage(String sql) {
        LOG.info("Input Sql: \n {}", sql);
        // 1. Generate original relNode tree
        Tuple2<String, RelNode> parsed = parseStatement(sql);
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
     *
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
}
