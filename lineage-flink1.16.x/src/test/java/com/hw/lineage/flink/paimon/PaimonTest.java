package com.hw.lineage.flink.paimon;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 * @description: PaimonTest
 * @author: HamaWhite
 */
public class PaimonTest extends AbstractBasicTest {

    private static final String catalogName = "paimon";

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void createCatalogAndTable() throws IOException {
        // create and use paimon_catalog
        usePaimonCatalog();

        // create table demo_log_01
        createTableOfDemoLog01();

        // create table demo_log_02
        createTableOfDemoLog02();

        // create table demo_log_05
        createTableOfDemoLog05();

        // create table demo_log_agg
        createTableOfDemoLogAgg();
    }

    private void usePaimonCatalog() throws IOException {
        File warehouse = temporaryFolder.newFolder();

        context.execute("CREATE CATALOG " + catalogName + " with (          " +
                "       'type' = 'paimon'                                           ," +
                "       'warehouse' = '" + warehouse.toURI() + "'                    " +
                ")"
        );
        context.execute(String.format("USE CATALOG %s", catalogName));
    }

    @Test
    public void testPaimon() {
        String firstSql = "INSERT INTO demo_log_05  " +
                "SELECT                             " +
                "       a.user_id                  ," +
                "       b.item_id                  ," +
                "       b.behavior                 ," +
                "       a.dt                       ," +
                "       a.hh                        " +
                "FROM                               " +
                "       demo_log_01 a               " +
                "LEFT JOIN                          " +
                "       demo_log_02 b               " +
                "ON                                 " +
                "       a.user_id = b.user_id       " +
                "LIMIT 1000                         ";

        String[][] firstExpected = {
                {"demo_log_01", "user_id", "demo_log_05", "user_id"},
                {"demo_log_02", "item_id", "demo_log_05", "item_id"},
                {"demo_log_02", "behavior", "demo_log_05", "behavior"},
                {"demo_log_01", "dt", "demo_log_05", "dt"},
                {"demo_log_01", "hh", "demo_log_05", "hh"}
        };
        analyzeLineage(catalogName, firstSql, firstExpected);

        String secondSql = "INSERT INTO demo_log_agg " +
                "SELECT                              " +
                "       user_id                     ," +
                "       count(distinct item_id)     ," +
                "       dt                           " +
                "FROM                                " +
                "       demo_log_05                  " +
                "WHERE                               " +
                "       dt='2023-17-02'              " +
                "GROUP BY                            " +
                "       user_id,dt                   ";

        String[][] secondExpected = {
                {"demo_log_05", "user_id", "demo_log_agg", "user_id"},
                {"demo_log_05", "item_id", "demo_log_agg", "cnt", "COUNT(DISTINCT item_id)"},
                {"demo_log_05", "dt", "demo_log_agg", "dt"}
        };
        analyzeLineage(catalogName, secondSql, secondExpected);
    }


    /**
     * Create table demo_log_01
     */
    private void createTableOfDemoLog01() {
        context.execute("DROP TABLE IF EXISTS demo_log_01 ");

        context.execute("CREATE TABLE IF NOT EXISTS demo_log_01 (   " +
                "       user_id                 BIGINT                       ," +
                "       item_id                 BIGINT                       ," +
                "       behavior                STRING                       ," +
                "       dt                      STRING                       ," +
                "       hh                      STRING                       ," +
                "       PRIMARY KEY (dt, hh, user_id) NOT ENFORCED            " +
                ") PARTITIONED BY (dt, hh) with (                             " +
                "        'bucket' = '4'                                       " +
                ")"
        );
    }

    /**
     * Create table demo_log_02
     */
    private void createTableOfDemoLog02() {
        context.execute("DROP TABLE IF EXISTS demo_log_02 ");

        context.execute("CREATE TABLE IF NOT EXISTS demo_log_02 (   " +
                "       user_id                 BIGINT                       ," +
                "       item_id                 BIGINT                       ," +
                "       behavior                STRING                       ," +
                "       dt                      STRING                       ," +
                "       hh                      STRING                       ," +
                "       PRIMARY KEY (dt, hh, user_id) NOT ENFORCED            " +
                ") PARTITIONED BY (dt, hh) with (                             " +
                "        'bucket' = '4'                                       " +
                ")"
        );
    }

    /**
     * Create table demo_log_05
     */
    private void createTableOfDemoLog05() {
        context.execute("DROP TABLE IF EXISTS demo_log_05 ");

        context.execute("CREATE TABLE IF NOT EXISTS demo_log_05 (   " +
                "       user_id                 BIGINT                       ," +
                "       item_id                 BIGINT                       ," +
                "       behavior                STRING                       ," +
                "       dt                      STRING                       ," +
                "       hh                      STRING                       ," +
                "       PRIMARY KEY (dt, hh, user_id) NOT ENFORCED            " +
                ") PARTITIONED BY (dt, hh) with (                             " +
                "        'bucket' = '4'                                       " +
                ")"
        );
    }


    /**
     * Create table demo_log_agg
     */
    private void createTableOfDemoLogAgg() {
        context.execute("DROP TABLE IF EXISTS demo_log_agg ");

        context.execute("CREATE TABLE IF NOT EXISTS demo_log_agg (  " +
                "       user_id                 BIGINT                       ," +
                "       cnt                     BIGINT                       ," +
                "       dt                      STRING                       ," +
                "       PRIMARY KEY (dt, user_id) NOT ENFORCED                " +
                ") PARTITIONED BY (dt) with (                                 " +
                "        'bucket' = '2'                                       " +
                ")"
        );
    }
}
