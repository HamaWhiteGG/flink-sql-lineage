package com.hw.lineage.flink.catalog;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.hw.lineage.common.enums.TableKind;
import com.hw.lineage.common.model.ColumnInfo;
import com.hw.lineage.common.model.TableInfo;
import com.hw.lineage.flink.LineageServiceImpl;
import org.apache.flink.table.api.TableException;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * This unit test depends on the external Hive and Mysql environment,
 * if not, please comment out this unit test class(add @Ignore)
 *
 * @author: HamaWhite
 */
public class CatalogTest {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogTest.class);

    private static final String database = "lineage_db";

    private static final String tableName = "ods_mysql_users_watermark";

    private final LineageServiceImpl context = new LineageServiceImpl();

    @Test
    public void testMemoryCatalog() {
        // the default is default_catalog
        String catalogName = "memory_catalog";
        useMemoryCatalog(catalogName);
        assertThat(context.getCurrentCatalog(), is(catalogName));
    }


    private void useMemoryCatalog(String catalogName) {
        context.execute(String.format("CREATE CATALOG %s with ( 'type'='generic_in_memory','default-database'='" + database + "' )", catalogName));
        context.execute(String.format("USE CATALOG %s", catalogName));
    }

    @Test
    @Ignore("depends on the external Mysql environment")
    public void testJdbcCatalog() {
        String catalogName = "jdbc_catalog";
        useJdbcCatalog(catalogName);
        assertThat(context.getCurrentCatalog(), is(catalogName));
    }


    private void useJdbcCatalog(String catalogName) {
        // The database must be created in advance, otherwise an error will be reported when creating the catalog
        context.execute("CREATE CATALOG " + catalogName + " with (  " +
                "       'type' = 'jdbc'                                     ," +
                "       'default-database' = '" + database + "'             ," +
                "       'username' = 'root'                                 ," +
                "       'password' = 'root@123456'                          ," +
                "       'base-url' = 'jdbc:mysql://192.168.90.150:3306'      " +
                ")"
        );
        context.execute(String.format("USE CATALOG %s", catalogName));
    }

    @Test
    @Ignore("depends on the external Hive environment")
    public void testHiveCatalog() {
        String catalogName = "hive_catalog";
        useHiveCatalog(catalogName);
        assertThat(context.getCurrentCatalog(), is(catalogName));
    }

    private void useHiveCatalog(String catalogName) {
        // The database must be created in advance, otherwise an error will be reported when creating the catalog
        context.execute("CREATE CATALOG " + catalogName + " with (          " +
                "       'type' = 'hive'                                              ," +
                "       'default-database' = '" + database + "'                      ," +
                "       'hive-conf-dir' = '../data/hive-conf-dir'                    ," +
                "       'hive-version' = '3.1.2'                                      " +
                ")"
        );
        context.execute(String.format("USE CATALOG %s", catalogName));
    }


    @Test
    public void testQueryMemoryCatalogInfo() throws Exception {
        String catalogName = "memory_catalog";
        useMemoryCatalog(catalogName);
        checkQueryCatalogInfo(catalogName);
    }

    @Test
    @Ignore("depends on the external Mysql environment")
    public void testQueryJdbcCatalogInfo() throws Exception {
        String catalogName = "jdbc_catalog";
        useJdbcCatalog(catalogName);

        assertThrows(String.format("Could not execute CreateTable in path `%s`.`%s`.`%s`", catalogName, database, tableName)
                , TableException.class
                , () -> checkQueryCatalogInfo(catalogName));
    }


    @Test
    @Ignore("depends on the external Hive environment")
    public void testQueryHiveCatalogInfo() throws Exception {
        String catalogName = "hive_catalog";
        useHiveCatalog(catalogName);
        checkQueryCatalogInfo(catalogName);
    }


    private void checkQueryCatalogInfo(String catalogName) throws Exception {
        createTableOfOdsMysqlUsersWatermark();
        assertThat(context.listDatabases(catalogName), hasItem(database));
        assertThat(context.listTables(catalogName, database), hasItem(tableName));
        assertEquals(Collections.emptyList(), context.listViews(catalogName, database));

        TableInfo expectedTableInfo = new TableInfo()
                .setTableName(tableName)
                .setTableKind(TableKind.TABLE)
                .setComment("Users Table")
                .setColumnList(
                        ImmutableList.of(
                                new ColumnInfo("id", "BIGINT", "", true, ""),
                                new ColumnInfo("name", "STRING", "", false, ""),
                                new ColumnInfo("birthday", "TIMESTAMP(3)", "", false, ""),
                                new ColumnInfo("ts", "TIMESTAMP(3)", "", false, "[`ts` - INTERVAL '5' SECOND]"),
                                /**
                                 * TODO optimize,this should be PROCTIME(),but [PROCTIME()]
                                 * Because the asSummaryString method of different subclasses of Expression is different
                                 */
                                new ColumnInfo("proc_time", "[PROCTIME()]", "", false, "")
                        )
                ).setPropertiesMap(
                        ImmutableMap.of(
                                "password", "xxx",
                                "hostname", "127.0.0.1",
                                "server-time-zone", "Asia/Shanghai",
                                "connector", "mysql-cdc",
                                "port", "3306",
                                "database-name", "demo",
                                "table-name", "users",
                                "username", "root"
                        )
                );
        TableInfo tableInfo = context.getTable(catalogName, database, tableName);
        LOG.info("tableInfo: {}", tableInfo);
        assertEquals(expectedTableInfo, tableInfo);

        String expectedTableDdl = "CREATE TABLE `ods_mysql_users_watermark` (\n" +
                "  `id` BIGINT NOT NULL,\n" +
                "  `name` VARCHAR(2147483647),\n" +
                "  `birthday` TIMESTAMP(3),\n" +
                "  `ts` TIMESTAMP(3),\n" +
                "  `proc_time` AS PROCTIME(),\n" +
                "  WATERMARK FOR `ts` AS `ts` - INTERVAL '5' SECOND,\n" +
                "  CONSTRAINT `PK_3386` PRIMARY KEY (`id`) NOT ENFORCED\n" +
                ") COMMENT 'Users Table'\n" +
                "WITH (\n" +
                "  'hostname' = '127.0.0.1',\n" +
                "  'password' = 'xxx',\n" +
                "  'connector' = 'mysql-cdc',\n" +
                "  'port' = '3306',\n" +
                "  'database-name' = 'demo',\n" +
                "  'server-time-zone' = 'Asia/Shanghai',\n" +
                "  'table-name' = 'users',\n" +
                "  'username' = 'root'\n" +
                ")\n";

        String tableDdl = context.getTableDdl(catalogName, database, tableName);
        LOG.info("tableDdl: {}", tableDdl);
        assertEquals(expectedTableDdl, tableDdl);
    }

    private void createTableOfOdsMysqlUsersWatermark() {
        context.execute("DROP TABLE IF EXISTS " + tableName);

        context.execute("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING  COMMENT 'User Name'     ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "       proc_time as proctime()                             ," +
                "       WATERMARK FOR ts AS ts - INTERVAL '5' SECOND         " +
                " ) " +
                " COMMENT 'Users Table' " +
                " WITH ( " +
                "       'connector' = 'mysql-cdc'            ," +
                "       'hostname'  = '127.0.0.1'            ," +
                "       'port'      = '3306'                 ," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'xxx'                  ," +
                "       'server-time-zone' = 'Asia/Shanghai' ," +
                "       'database-name' = 'demo'             ," +
                "       'table-name'    = 'users' " +
                ")"
        );
    }
}
