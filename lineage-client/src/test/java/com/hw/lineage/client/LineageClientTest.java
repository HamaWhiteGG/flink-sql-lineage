package com.hw.lineage.client;

import org.junit.Test;

/**
 * @description: LineageClientTest
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 9:49 PM
 */
public class LineageClientTest {
    private LineageClient client=new LineageClient("target/plugins");


    @Test
    public void testParseFieldLineage() {
        client.parseFieldLineage("flink1.14.x","select 1");
        client.parseFieldLineage("flink1.16.x","select 1");
    }

    @Test
    public void testExecute() {
        client.execute("flink1.14.x","show tables");
        client.execute("flink1.16.x","show tables");
    }


    @Test
    public void testTmp() {
        client.execute("flink1.14.x","DROP TABLE IF EXISTS ods_mysql_users ");

        client.execute("flink1.14.x","CREATE TABLE IF NOT EXISTS ods_mysql_users (" +
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

        client.execute("flink1.14.x","DROP TABLE IF EXISTS dwd_hudi_users");

        client.execute("flink1.14.x","CREATE TABLE IF NOT EXISTS  dwd_hudi_users ( " +
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


        client.parseFieldLineage("flink1.14.x",sql);

    }

}
