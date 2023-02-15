package com.hw.lineage.client;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.result.LineageResult;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @description: LineageClientTest
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class LineageClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(LineageClientTest.class);

    private static final String[] PLUGIN_NAMES = {"flink1.14.x", "flink1.16.x"};

    private static final String catalogName = "default";

    private static final String defaultDatabase = "default";

    private static LineageClient client;

    @BeforeClass
    public static void setup() {
        client = new LineageClient("target/plugins");

        Stream.of(PLUGIN_NAMES).forEach(pluginName -> {
            client.setCatalog(pluginName, CatalogType.MEMORY, catalogName, defaultDatabase);
            // create mysql cdc table ods_mysql_users
            createTableOfOdsMysqlUsers(pluginName);
            // create hudi sink table dwd_hudi_users
            createTableOfDwdHudiUsers(pluginName);
        });
    }

    @Test
    public void testInsertSelect() {
        Stream.of(PLUGIN_NAMES).forEach(this::testInsertSelect);
    }

    private void testInsertSelect(String pluginName) {
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

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        parseFieldLineage(pluginName, sql, expectedArray);
    }

    private void parseFieldLineage(String pluginName, String sql, String[][] expectedArray) {
        List<LineageResult> actualList = client.parseFieldLineage(pluginName, sql);
        LOG.info("Linage Result: ");
        actualList.forEach(e -> LOG.info(e.toString()));

        List<LineageResult> expectedList = LineageResult.buildResult(catalogName, defaultDatabase, expectedArray);
        assertEquals(expectedList, actualList);
    }

    /**
     * Create mysql cdc table ods_mysql_users
     */
    private static void createTableOfOdsMysqlUsers(String pluginName) {
        client.execute(pluginName, "DROP TABLE IF EXISTS ods_mysql_users ");

        client.execute(pluginName, "CREATE TABLE IF NOT EXISTS ods_mysql_users (" +
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
    }

    /**
     * Create Hudi sink table dwd_hudi_users
     */
    private static void createTableOfDwdHudiUsers(String pluginName) {
        client.execute(pluginName, "DROP TABLE IF EXISTS dwd_hudi_users");

        client.execute(pluginName, "CREATE TABLE IF NOT EXISTS  dwd_hudi_users ( " +
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
    }

}