package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.client.LineageClient;
import com.hw.lineage.common.enums.ParseStatus;
import com.hw.lineage.common.util.Base64Utils;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.entity.TaskLineage;
import com.lineage.server.domain.entity.TaskSql;
import com.lineage.server.domain.facade.LineageFacade;
import com.lineage.server.infrastructure.config.LineageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @description: LineageFacadeImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:52 PM
 */
@Service
public class LineageFacadeImpl implements LineageFacade {

    private static final Logger LOG = LoggerFactory.getLogger(LineageFacadeImpl.class);

    @Resource
    private LineageConfig config;

    private LineageClient lineageClient;

    @PostConstruct
    public void initLineageClient() {
        LOG.info("start loading plugins, directory: {}", config.getPluginDir());
        this.lineageClient = new LineageClient(config.getPluginDir());
        LOG.info("finished loading plugins, directory: {}", config.getPluginDir());
    }

    @Override
    public void parseLineage(Task task, String pluginName, Catalog catalog) {
        lineageClient.setCatalog(pluginName
                , catalog.getCatalogType()
                , catalog.getCatalogName()
                , catalog.getDefaultDatabase()
        );

        for (TaskSql taskSql : task.getTaskSqlList()) {
            String sqlCode = Base64Utils.decode(taskSql.getSqlCode());
            switch (taskSql.getSqlType()) {
                case CREATE:
                case DROP:
                    lineageClient.execute(pluginName, sqlCode);
                    break;
                case INSERT:
                    parseFieldLineage(pluginName, task, taskSql, sqlCode);
                    break;
                default:
            }
        }
    }


    private void parseFieldLineage(String pluginName, Task task, TaskSql taskSql, String sqlCode) {
        taskSql.setParseStatus(ParseStatus.PARSING);
        lineageClient.parseFieldLineage(pluginName, sqlCode)
                .forEach(lineageResult -> {
                    TaskLineage taskLineage = new TaskLineage()
                            .setTaskId(task.getTaskId())
                            .setSqlId(taskSql.getSqlId())
                            .setSourceCatalog(lineageResult.getSourceCatalog())
                            .setSourceDatabase(lineageResult.getSourceDatabase())
                            .setSourceTable(lineageResult.getSourceTable())
                            .setSourceColumn(lineageResult.getSourceColumn())
                            .setTargetCatalog(lineageResult.getTargetCatalog())
                            .setTargetDatabase(lineageResult.getTargetDatabase())
                            .setTargetTable(lineageResult.getTargetTable())
                            .setTargetColumn(lineageResult.getTargetColumn())
                            .setTransform(lineageResult.getTransform())
                            .setInvalid(false);

                    taskSql.setParseTime(System.currentTimeMillis());
                    taskSql.setParseStatus(ParseStatus.SUCCESS);
                    task.addTaskLineage(taskLineage);
                });
    }

}
