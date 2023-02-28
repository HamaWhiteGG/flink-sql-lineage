package com.hw.lineage.flink.catalog;

import com.hw.lineage.flink.LineageServiceImpl;
import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.apache.flink.table.api.Table;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @description: CatalogTest
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class CatalogTest {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBasicTest.class);

    private static String defaultDatabase = "lineage_db";

    private LineageServiceImpl context = new LineageServiceImpl();

    @Test
    public void testMemoryCatalog() {
        // the default is default_catalog
        String catalogName = "memory_catalog";
        createMemoryCatalog(catalogName);
        assertThat(context.getTableEnv().getCurrentCatalog(), is(catalogName));
    }


    private void createMemoryCatalog(String catalogName) {
        context.execute(String.format("CREATE CATALOG %s with ( 'type'='generic_in_memory','default-database'='" + defaultDatabase + "' )", catalogName));
        context.execute(String.format("USE CATALOG %s", catalogName));
    }

    @Test
    public void testJdbcCatalog() {
        String catalogName = "jdbc_catalog";
        // The database must be created in advance, otherwise an error will be reported when creating the catalog
        context.execute("CREATE CATALOG " + catalogName + " with (  " +
                "       'type' = 'jdbc'                                     ," +
                "       'default-database' = '" + defaultDatabase + "'      ," +
                "       'username' = 'root'                                 ," +
                "       'password' = 'root@123456'                          ," +
                "       'base-url' = 'jdbc:mysql://192.168.90.150:3306'      " +
                ")"
        );
        context.execute(String.format("USE CATALOG %s", catalogName));
        assertThat(context.getTableEnv().getCurrentCatalog(), is(catalogName));
    }


    @Test
    public void testHiveCatalog() {
        String catalogName = "hive_catalog";
        // The database must be created in advance, otherwise an error will be reported when creating the catalog
        context.execute("CREATE CATALOG " + catalogName + " with (          " +
                "       'type' = 'hive'                                              ," +
                "       'default-database' = '" + defaultDatabase + "'               ," +
                "       'hive-conf-dir' = '../data/storage/catalog/1/hive-conf-dir'  ," +
                "       'hive-version' = '3.1.2'                                      " +
                ")"
        );
        context.execute(String.format("USE CATALOG %s", catalogName));
        assertThat(context.getTableEnv().getCurrentCatalog(), is(catalogName));
    }


    @Test
    public void testQueryCatalogInfo() throws Exception {
        String catalogName = "memory_catalog";
        String tableName = "ods_mysql_users_watermark";
        createMemoryCatalog(catalogName);

        context.execute("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING  COMMENT 'User Name'              ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "       proc_time as proctime()                             ," +
                "       WATERMARK FOR ts AS ts - INTERVAL '5' SECOND         " +
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

        LOG.info("databases: {}", context.getCatalog(catalogName).listDatabases());
        LOG.info("tables: {}", context.getCatalog(catalogName).listTables(defaultDatabase));
        LOG.info("views: {}", context.getCatalog(catalogName).listViews(defaultDatabase));

        Table table=context.getTableEnv().scan(catalogName, defaultDatabase, tableName);

        LOG.info("tableSchema: {}", table.getResolvedSchema());

    }
}
