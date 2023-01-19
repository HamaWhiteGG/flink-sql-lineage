package com.hw.lineage.client;

import com.hw.lineage.LineageResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @description: LineageClientTest
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 9:49 PM
 */
public class LineageClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(LineageClientTest.class);

    private LineageClient client = new LineageClient("target/plugins");


    @Test
    public void testParseFieldLineage() {
        parseFieldLineage("flink1.14.x");
        parseFieldLineage("flink1.16.x");
    }

    private void parseFieldLineage(String pluginId) {
        client.execute(pluginId, "DROP TABLE IF EXISTS ods_mysql_users ");

        client.execute(pluginId, "CREATE TABLE IF NOT EXISTS ods_mysql_users (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "       proc_time as proctime()                              " +
                ") WITH ( " +
                "       'connector' = 'mysql-cdc'            ," +
                "       'hostname'  = '127.0.0.1'       ," +
                "       'port'      = '3306'                 ," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'xxx'          ," +
                "       'server-time-zone' = 'Asia/Shanghai' ," +
                "       'database-name' = 'demo'             ," +
                "       'table-name'    = 'users' " +
                ")"
        );

        client.execute(pluginId, "DROP TABLE IF EXISTS dwd_hudi_users");

        client.execute(pluginId, "CREATE TABLE IF NOT EXISTS  dwd_hudi_users ( " +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       company_name        STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "        `partition`        VARCHAR(20)                      " +
                ") PARTITIONED BY (`partition`) WITH ( " +
                "       'connector' = 'hudi'                                    ," +
                "       'table.type' = 'COPY_ON_WRITE'                          ," +
                "       'read.streaming.enabled' = 'true'                       ," +
                "       'read.streaming.check-interval' = '1'                    " +
                ")"
        );


        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   name as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users";

        List<LineageResult> actualList = client.parseFieldLineage(pluginId, sql);
        LOG.info("Linage Result: ");
        actualList.forEach(e -> LOG.info(e.toString()));

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        List<LineageResult> expectedList = Stream.of(expectedArray)
                .map(e -> {
                    LineageResult result = buildResult(e[0], e[1], e[2], e[3]);
                    // transform field is optional
                    if (e.length == 5) {
                        result.setTransform(e[4]);
                    }
                    return result;
                }).collect(Collectors.toList());


        assertEquals(expectedList, actualList);
    }

    private LineageResult buildResult(String sourceTable, String sourceColumn, String targetTable, String targetColumn) {
        return LineageResult.builder()
                .sourceCatalog("default_catalog")
                .sourceDatabase("default_database")
                .sourceTable(sourceTable)
                .sourceColumn(sourceColumn)
                .targetCatalog("default_catalog")
                .targetDatabase("default_database")
                .targetTable(targetTable)
                .targetColumn(targetColumn)
                .build();
    }

}