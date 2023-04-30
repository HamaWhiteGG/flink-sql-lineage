package com.hw.lineage.server.infrastructure.facade.impl;

import com.hw.lineage.client.LineageClient;
import com.hw.lineage.common.enums.SqlStatus;
import com.hw.lineage.common.enums.TaskStatus;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.result.FunctionInfo;
import com.hw.lineage.common.result.FunctionResult;
import com.hw.lineage.common.result.LineageResult;
import com.hw.lineage.common.result.TableInfo;
import com.hw.lineage.common.supplier.CustomSupplier;
import com.hw.lineage.common.util.Base64Utils;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskFunction;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.entity.task.TaskSql;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.graph.GraphHelper;
import com.hw.lineage.server.domain.vo.SqlId;
import com.hw.lineage.server.infrastructure.config.LineageConfig;
import com.hw.lineage.server.infrastructure.graph.GraphFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.hw.lineage.common.util.Constant.ILLEGAL_PARAM;

/**
 * @description: LineageFacadeImpl
 * @author: HamaWhite
 */
@Service("lineageFacade")
public class LineageFacadeImpl implements LineageFacade {

    private static final Logger LOG = LoggerFactory.getLogger(LineageFacadeImpl.class);

    private static final String CTAS_REGEX = "CREATE\\s+TABLE(?s).*AS\\s+SELECT(?s).*";

    @Resource
    private LineageConfig config;

    private LineageClient lineageClient;

    @PostConstruct
    public void initLineageClient() {
        LOG.info("user's current working directory: {}", System.getProperty("user.dir"));
        LOG.info("start loading plugins, directory: {}", config.getPluginDir());
        this.lineageClient = new LineageClient(config.getPluginDir());
        LOG.info("finished loading plugins, directory: {}", config.getPluginDir());
    }

    @Override
    public void analyze(String pluginCode, String catalogName, Task task) {
        doProcessTask(task, () -> {
            for (TaskSql taskSql : task.getTaskSqlList()) {
                String singleSql = Base64Utils.decode(taskSql.getSqlSource());
                switch (taskSql.getSqlType()) {
                    case INSERT:
                        analyzeLineage(pluginCode, catalogName, task, taskSql, singleSql);
                        break;
                    case CREATE:
                        if (ctas(singleSql)) {
                            analyzeLineage(pluginCode, catalogName, task, taskSql, singleSql);
                        } else {
                            execute(pluginCode, catalogName, task, taskSql, singleSql);
                        }
                        break;
                    case DROP:
                    case ALTER:
                    case USE:
                    case LOAD:
                    case UNLOAD:
                    case SET:
                    case RESET:
                    case JAR:
                        execute(pluginCode, catalogName, task, taskSql, singleSql);
                        break;
                    default:
                        throw new LineageException(ILLEGAL_PARAM);
                }
                // analyze the custom functions used in this SQL
                analyzeFunction(pluginCode, catalogName, task, taskSql, singleSql);
            }
            // build tableGraph and columnGraph for the task
            buildLineageGraph(pluginCode, task);
        });
    }

    private void buildLineageGraph(String pluginCode, Task task) {
        GraphFactory graphFactory = new GraphFactory(this, task.getTaskSqlList());
        // create tableGraph and columnGraph for the task
        graphFactory.createLineageGraph(pluginCode, task.getTaskLineageList());
        // calculate the count of all downstream nodes for each node in the graph
        GraphHelper graphHelper = new GraphHelper();
        graphHelper.calculateChildrenCnt(graphFactory.getTableGraph(), graphFactory.getColumnGraph());

        task.setTableGraph(graphFactory.getTableGraph());
        task.setColumnGraph(graphFactory.getColumnGraph());
    }

    @Override
    public void checkSyntax(String pluginCode, String catalogName, Task task) {
        doProcessTask(task, () -> {
            long sqlId = 1L;
            for (TaskSql taskSql : task.getTaskSqlList()) {
                taskSql.setSqlId(new SqlId(sqlId++));
                String singleSql = Base64Utils.decode(taskSql.getSqlSource());
                parseValidate(pluginCode, catalogName, task, taskSql, singleSql);
            }
        });
    }

    private void doProcessTask(Task task, CustomSupplier supplier) {
        task.clearTaskLog();
        task.setTaskStatus(TaskStatus.RUNNING);
        try {
            supplier.run();
            task.setTaskStatus(TaskStatus.SUCCESS);
        } catch (Exception e) {
            task.setTaskStatus(TaskStatus.FAILED);
            task.appendTaskLog(e.getMessage());
            LOG.info("taskId: {}, taskName: {} is failed. the taskLog is: \n{}", task.getTaskId(), task.getTaskName(), task.getTaskLog());
        }
    }

    private void parseValidate(String pluginCode, String catalogName, Task task, TaskSql taskSql, String singleSql) {
        doProcessSql(task, taskSql, singleSql, () ->
                lineageClient.parseValidate(pluginCode, catalogName, task.getDatabase(), singleSql));
    }

    private void execute(String pluginCode, String catalogName, Task task, TaskSql taskSql, String singleSql) {
        doProcessSql(task, taskSql, singleSql, () ->
                lineageClient.execute(pluginCode, catalogName, task.getDatabase(), singleSql));
    }

    private void analyzeLineage(String pluginCode, String catalogName, Task task, TaskSql taskSql, String singleSql) {
        doProcessSql(task, taskSql, singleSql, () -> {
            List<LineageResult> resultList = lineageClient.analyzeLineage(pluginCode, catalogName, task.getDatabase(), singleSql);
            resultList.forEach(e -> {
                TaskLineage taskLineage = new TaskLineage()
                        .setTaskId(task.getTaskId())
                        .setSqlId(taskSql.getSqlId())
                        .setSourceCatalog(e.getSourceCatalog())
                        .setSourceDatabase(e.getSourceDatabase())
                        .setSourceTable(e.getSourceTable())
                        .setSourceColumn(e.getSourceColumn())
                        .setTargetCatalog(e.getTargetCatalog())
                        .setTargetDatabase(e.getTargetDatabase())
                        .setTargetTable(e.getTargetTable())
                        .setTargetColumn(e.getTargetColumn())
                        .setTransform(e.getTransform())
                        .setInvalid(false);
                task.addTaskLineage(taskLineage);
            });
        });
    }

    private void analyzeFunction(String pluginCode, String catalogName, Task task, TaskSql taskSql, String singleSql) {
        doProcessSql(task, taskSql, singleSql, () -> {
            Set<FunctionResult> resultSet = lineageClient.analyzeFunction(pluginCode, catalogName, task.getDatabase(), singleSql);
            resultSet.forEach(e -> {
                TaskFunction taskFunction = new TaskFunction()
                        .setTaskId(task.getTaskId())
                        .setSqlId(taskSql.getSqlId())
                        .setCatalogName(e.getCatalogName())
                        .setDatabase(e.getDatabase())
                        .setFunctionName(e.getFunctionName())
                        .setCreateTime(System.currentTimeMillis())
                        .setInvalid(false);
                task.addTaskFunction(taskFunction);
            });
        });
    }

    private void doProcessSql(Task task, TaskSql taskSql, String singleSql, CustomSupplier supplier) {
        taskSql.setSqlStatus(SqlStatus.RUNNING);
        try {
            supplier.run();
            taskSql.setSqlStatus(SqlStatus.SUCCESS);
        } catch (Exception e) {
            taskSql.setSqlStatus(SqlStatus.FAILED);
            task.appendTaskLog(singleSql);
            throw new LineageException(e);
        }
    }

    private boolean ctas(String singleSql) {
        return singleSql.matches(CTAS_REGEX);
    }

    @Override
    public List<FunctionInfo> parseFunction(String pluginCode, File file) throws
            IOException, ClassNotFoundException {
        return lineageClient.parseFunction(pluginCode, file);
    }

    @Override
    public void createCatalog(String pluginCode, String catalogName, Map<String, String> propertiesMap) {
        lineageClient.createCatalog(pluginCode, catalogName, propertiesMap);
    }

    @Override
    public void deleteCatalog(String pluginCode, String catalogName) {
        lineageClient.deleteCatalog(pluginCode, catalogName);
    }

    @Override
    public void useCatalog(String pluginCode, String catalogName) {
        lineageClient.useCatalog(pluginCode,catalogName);
    }

    @Override
    public void createDatabase(String pluginCode, String catalogName, String database, String comment) {
        lineageClient.createDatabase(pluginCode, catalogName, database, comment);
    }

    @Override
    public List<String> listDatabases(String pluginCode, String catalogName) {
        return lineageClient.listDatabases(pluginCode, catalogName);
    }

    @Override
    public void deleteDatabase(String pluginCode, String catalogName, String database) {
        lineageClient.deleteDatabase(pluginCode, catalogName, database);
    }

    @Override
    public void useDatabase(String pluginCode, String catalogName, String database) {
        lineageClient.useDatabase(pluginCode,catalogName,database);
    }

    @Override
    public void createTable(String pluginCode, String catalogName, String database, String ddl) {
        String singleSql = Base64Utils.decode(ddl);
        lineageClient.execute(pluginCode, catalogName, database, singleSql);
    }

    @Override
    public List<String> listTables(String pluginCode, String catalogName, String database) throws Exception {
        return lineageClient.listTables(pluginCode, catalogName, database);
    }

    @Override
    public TableInfo getTable(String pluginCode, String catalogName, String database, String tableName) {
        try {
            return lineageClient.getTable(pluginCode, catalogName, database, tableName);
        } catch (Exception e) {
            throw new LineageException(e);
        }
    }

    @Override
    public String getTableDdl(String pluginCode, String catalogName, String database, String tableName) throws Exception {
        String tableDdl = lineageClient.getTableDdl(pluginCode, catalogName, database, tableName);
        return Base64Utils.encode(tableDdl);
    }

    @Override
    public List<String> listViews(String pluginCode, String catalogName, String database) throws Exception {
        return lineageClient.listViews(pluginCode, catalogName, database);
    }

    @Override
    public void deleteTable(String pluginCode, String catalogName, String database, String tableName) throws
            Exception {
        lineageClient.deleteTable(pluginCode, catalogName, database, tableName);
    }

    @Override
    public void createFunction(String pluginCode, String catalogName, String database, String functionName, String
            className, String functionPath) {
        lineageClient.createFunction(pluginCode, catalogName, database, functionName, className, functionPath);
    }

    @Override
    public void deleteFunction(String pluginCode, String catalogName, String database, String functionName) {
        lineageClient.deleteFunction(pluginCode, catalogName, database, functionName);
    }
}