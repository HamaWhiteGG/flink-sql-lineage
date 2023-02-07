package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.client.LineageClient;
import com.hw.lineage.common.enums.ParseStatus;
import com.hw.lineage.common.util.Base64Utils;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.entity.TaskLineage;
import com.lineage.server.domain.entity.TaskSql;
import com.lineage.server.domain.facade.LineageFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: LineageFacadeImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:52 PM
 */
@Service
public class LineageFacadeImpl implements LineageFacade {

    private static final Logger LOG = LoggerFactory.getLogger(LineageFacadeImpl.class);

    private LineageClient lineageClient;

    public LineageFacadeImpl() {
//        this.lineageClient = new LineageClient("lineage-client/target/plugins");
    }


//    public static void main(String[] args) {
//        final String pluginName = "flink1.14.x";
//
//        final String catalogName = "default";
//
//        final String defaultDatabase = "default";
//
//        LineageClient client = new LineageClient("lineage-client/target/plugins");
//
//            client.setCatalog(pluginName, CatalogType.MEMORY, catalogName, defaultDatabase);
//        client.execute(pluginName, "DROP TABLE IF EXISTS ods_mysql_users ");
//
//        client.execute(pluginName, "CREATE TABLE IF NOT EXISTS ods_mysql_users (" +
//                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
//                "       name                STRING                          ," +
//                "       birthday            TIMESTAMP(3)                    ," +
//                "       ts                  TIMESTAMP(3)                    ," +
//                "       proc_time as proctime()                              " +
//                ") WITH ( " +
//                "       'connector' = 'mysql-cdc'            ," +
//                "       'hostname'  = '127.0.0.1'       ," +
//                "       'port'      = '3306'                 ," +
//                "       'username'  = 'root'                 ," +
//                "       'password'  = 'xxx'          ," +
//                "       'server-time-zone' = 'Asia/Shanghai' ," +
//                "       'database-name' = 'demo'             ," +
//                "       'table-name'    = 'users' " +
//                ")"
//        );
//
//        client.execute(pluginName, "DROP TABLE IF EXISTS dwd_hudi_users");
//
//        client.execute(pluginName, "CREATE TABLE IF NOT EXISTS  dwd_hudi_users ( " +
//                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
//                "       name                STRING                          ," +
//                "       company_name        STRING                          ," +
//                "       birthday            TIMESTAMP(3)                    ," +
//                "       ts                  TIMESTAMP(3)                    ," +
//                "        `partition`        VARCHAR(20)                      " +
//                ") PARTITIONED BY (`partition`) WITH ( " +
//                "       'connector' = 'hudi'                                    ," +
//                "       'table.type' = 'COPY_ON_WRITE'                          ," +
//                "       'read.streaming.enabled' = 'true'                       ," +
//                "       'read.streaming.check-interval' = '1'                    " +
//                ")"
//        );
//
//        String sql = "INSERT INTO dwd_hudi_users " +
//                "SELECT " +
//                "   id ," +
//                "   name ," +
//                "   name as company_name ," +
//                "   birthday ," +
//                "   ts ," +
//                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
//                "FROM" +
//                "   ods_mysql_users";
//
//        List< LineageResult > actualList = client.parseFieldLineage(pluginName, sql);
//        LOG.info("Linage Result: ");
//        actualList.forEach(e -> LOG.info(e.toString()));
//
//        System.out.println("hello");
//    }

    @Override
    public void parseLineage(Task task, String pluginName, Catalog catalog) {
        if (lineageClient == null) {
            this.lineageClient = new LineageClient("lineage-client/target/plugins");
        }

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
        lineageClient.parseFieldLineage(pluginName, sqlCode).forEach(lineageResult -> {
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
