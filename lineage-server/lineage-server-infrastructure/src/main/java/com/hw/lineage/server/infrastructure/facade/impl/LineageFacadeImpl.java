package com.hw.lineage.server.infrastructure.facade.impl;

import com.hw.lineage.client.LineageClient;
import com.hw.lineage.common.enums.SqlStatus;
import com.hw.lineage.common.enums.TaskStatus;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.result.FunctionInfo;
import com.hw.lineage.common.result.LineageInfo;
import com.hw.lineage.common.result.TableInfo;
import com.hw.lineage.common.util.Base64Utils;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.entity.task.TaskSql;
import com.hw.lineage.server.domain.facade.LineageFacade;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hw.lineage.common.util.Constant.ILLEGAL_PARAM;
import static com.hw.lineage.common.util.Constant.INITIAL_CAPACITY;

/**
 * @description: LineageFacadeImpl
 * @author: HamaWhite
 */
@Service
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
    public void parseLineage(String pluginCode, String catalogName, Task task) {
        task.setTaskStatus(TaskStatus.RUNNING);
        try {
            Map<SqlId, String> sqlSourceMap = new HashMap<>(INITIAL_CAPACITY);
            for (TaskSql taskSql : task.getTaskSqlList()) {
                sqlSourceMap.put(taskSql.getSqlId(), taskSql.getSqlSource());
                String singleSql = Base64Utils.decode(taskSql.getSqlSource());
                switch (taskSql.getSqlType()) {
                    case INSERT:
                        parseFieldLineage(pluginCode, catalogName, task, taskSql, singleSql);
                        break;
                    case CREATE:
                        if (ctas(singleSql)) {
                            parseFieldLineage(pluginCode, catalogName, task, taskSql, singleSql);
                        } else {
                            executeSql(pluginCode, catalogName, task, taskSql, singleSql);
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
                        executeSql(pluginCode, catalogName, task, taskSql, singleSql);
                        break;
                    default:
                        throw new LineageException(ILLEGAL_PARAM);
                }
            }
            GraphFactory graphFactory = new GraphFactory(this, sqlSourceMap);
            graphFactory.createLineageGraph(pluginCode, task);
            task.setTaskStatus(TaskStatus.SUCCESS);
        } catch (Exception e) {
            task.setTaskStatus(TaskStatus.FAILED);
            throw new LineageException(e);
        }
    }


    private void executeSql(String pluginCode, String catalogName, Task task, TaskSql taskSql, String singleSql) {
        taskSql.setSqlStatus(SqlStatus.RUNNING);
        try {
            lineageClient.execute(pluginCode, catalogName, task.getDatabase(), singleSql);
            taskSql.setSqlStatus(SqlStatus.SUCCESS);
        } catch (Exception e) {
            taskSql.setSqlStatus(SqlStatus.FAILED);
            LOG.error("execute sql exception", e);
            throw new LineageException(String.format("execute sql failed, sql: %s", singleSql));
        }
    }

    private void parseFieldLineage(String pluginCode, String catalogName, Task task, TaskSql taskSql, String singleSql) {
        taskSql.setSqlStatus(SqlStatus.RUNNING);
        try {
            List<LineageInfo> resultList = lineageClient.parseFieldLineage(pluginCode, catalogName, task.getDatabase(), singleSql);
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
            taskSql.setSqlStatus(SqlStatus.SUCCESS);
        } catch (Exception e) {
            taskSql.setSqlStatus(SqlStatus.FAILED);
            throw new LineageException(e);
        }
    }

    private boolean ctas(String singleSql) {
        return singleSql.matches(CTAS_REGEX);
    }

    @Override
    public List<FunctionInfo> parseFunction(String pluginCode, File file) throws IOException, ClassNotFoundException {
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
    public void createDatabase(String pluginCode, String catalogName, String database, String comment) {
        lineageClient.createDatabase(pluginCode, catalogName, database, comment);
    }

    @Override
    public List<String> listDatabases(String pluginCode, String catalogName) throws Exception {
        return lineageClient.listDatabases(pluginCode, catalogName);
    }

    @Override
    public void deleteDatabase(String pluginCode, String catalogName, String database) {
        lineageClient.deleteDatabase(pluginCode, catalogName, database);
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
    public TableInfo getTable(String pluginCode, String catalogName, String database, String tableName) throws Exception {
        return lineageClient.getTable(pluginCode, catalogName, database, tableName);
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
    public void deleteTable(String pluginCode, String catalogName, String database, String tableName) throws Exception {
        lineageClient.deleteTable(pluginCode, catalogName, database, tableName);
    }

    @Override
    public void createFunction(String pluginCode, String catalogName, String database, String functionName, String className, String functionPath) {
        lineageClient.createFunction(pluginCode, catalogName, database, functionName, className, functionPath);
    }

    @Override
    public void deleteFunction(String pluginCode, String catalogName, String database, String functionName) {
        lineageClient.deleteFunction(pluginCode, catalogName, database, functionName);
    }
}
