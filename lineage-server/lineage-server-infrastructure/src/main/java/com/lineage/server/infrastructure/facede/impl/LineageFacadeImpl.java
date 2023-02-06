package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.client.LineageClient;
import com.hw.lineage.common.enums.ParseStatus;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.entity.TaskLineage;
import com.lineage.server.domain.entity.TaskSql;
import com.lineage.server.domain.facade.LineageFacade;
import org.springframework.stereotype.Service;

/**
 * @description: LineageFacadeImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:52 PM
 */
@Service
public class LineageFacadeImpl implements LineageFacade {

    private LineageClient lineageClient;

    public LineageFacadeImpl() {
//        this.lineageClient = new LineageClient("target/plugins");
    }

    @Override
    public void parseLineage(Task task, String pluginName, Catalog catalog) {
        lineageClient.setCatalog(pluginName
                , catalog.getCatalogType()
                , catalog.getCatalogName()
                , catalog.getDefaultDatabase()
        );

        for (TaskSql taskSql : task.getTaskSqlList()) {
            switch (taskSql.getSqlType()) {
                case CREATE:
                    lineageClient.execute(pluginName, taskSql.getSqlCode());
                    break;
                case INSERT:
                    parseFieldLineage(pluginName, task, taskSql);
                    break;
                default:
            }
        }
    }


    private void parseFieldLineage(String pluginName, Task task, TaskSql taskSql) {
        taskSql.setParseStatus(ParseStatus.PARSING);
        lineageClient.parseFieldLineage(pluginName, taskSql.getSqlCode()).forEach(lineageResult -> {
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
