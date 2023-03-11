package com.hw.lineage.flink.proctime;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.apache.calcite.rel.core.Calc;
import org.apache.calcite.rel.metadata.RelMdColumnOrigins;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.junit.Before;
import org.junit.Test;

/**
 * The test case comes from <a href="https://github.com/HamaWhiteGG/flink-sql-lineage/issues/38">The field relationship
 * of PROCTIME() type is parsed incorrectly</a>, thanks
 * <p>
 * <p>
 * The solution of PROCTIME() is the same as LOCALTIMESTAMP, it is enhanced in the getColumnOrigins(Calc rel...) method.
 * LOCALTIMESTAMP has been processed, so the lineage of PROCTIME() can be directly parsed out.
 * <p>
 * But when PROCTIME() is the first field, the obtained blood relationship will be confused.
 * Therefore, add the computeIndexWithOffset method to calculate the correct source table number {@link RelMdColumnOrigins} ,
 * and this method is called by {@link RelMdColumnOrigins#getColumnOrigins(Calc, RelMetadataQuery, int)}
 *
 * @description: ProctimeTest
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class ProctimeTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create kafka source table ST
        createTableOfST();

        // create print sink table TT
        createTableOfWithFirstProcTime();

        // create datagen source table datagen_source
        createTableOfDatagenSource();

        // create print sink table print_sink
        createTableOfPrintSink();
    }

    /**
     * Optimized RelNode:
     * <pre>
     *  FlinkLogicalCalc(select=[PROCTIME() AS make_time, a, b])
     *   FlinkLogicalTableSourceScan(table=[[hive, default, ST]], fields=[a, b])
     * </pre>
     */
    @Test
    public void testInsertSelectWithFirstProcTimeField() {
        String sql = "INSERT INTO TT(make_time, A, B) " +
                "SELECT " +
                "       make_time               ," +
                "       a                       ," +
                "       b                        " +
                "FROM" +
                "       ST ";

        String[][] expectedArray = {
                {"ST", "make_time", "TT", "make_time"},
                {"ST", "a", "TT", "A"},
                {"ST", "b", "TT", "B"}
        };
        parseFieldLineage(sql, expectedArray);
    }

    /**
     * Optimized RelNode:
     * <pre>
     *  FlinkLogicalCalc(select=[id, name, PROCTIME() AS make_time])
     *   FlinkLogicalTableSourceScan(table=[[hive, default, datagen_source]], fields=[id, name])
     * </pre>
     */
    @Test
    public void testInsertSelectWithLastProctimeField() {
        String sql = "INSERT INTO print_sink(id, name, make_time) " +
                "SELECT " +
                "       id                  ," +
                "       name                ," +
                "       make_time            " +
                "FROM" +
                "       datagen_source ";

        String[][] expectedArray = {
                {"datagen_source", "id", "print_sink", "id"},
                {"datagen_source", "name", "print_sink", "name"},
                {"datagen_source", "make_time", "print_sink", "make_time"}
        };
        parseFieldLineage(sql, expectedArray);

    }

    /**
     * Create kafka source table st
     */
    protected void createTableOfST() {
        context.execute("DROP TABLE IF EXISTS ST ");

        context.execute("CREATE TABLE IF NOT EXISTS ST (    " +
                "       make_time       AS PROCTIME()                               ," +
                "       a               STRING                                      ," +
                "       b               STRING                                       " +
                ") WITH (                                                            " +
                "       'connector' = 'kafka',                                       " +
                "       'topic'     = 'user_behavior',                               " +
                "       'properties.bootstrap.servers' = '127.0.0.1:9092',           " +
                "       'properties.group.id'   = 'testGroup',                       " +
                "       'scan.startup.mode'     = 'earliest-offset',                 " +
                "       'format'    = 'json'                                         " +
                ")"
        );
    }

    /**
     * Create print sink table tt_first_proctime
     */
    protected void createTableOfWithFirstProcTime() {
        context.execute("DROP TABLE IF EXISTS TT ");

        context.execute("CREATE TABLE IF NOT EXISTS TT (    " +
                "       make_time       TIMESTAMP(3)                                ," +
                "       A               STRING                                      ," +
                "       B               STRING                                       " +
                ") WITH (                                                            " +
                "       'connector' = 'print'                                        " +
                ")"
        );
    }

    /**
     * Create datagen source table datagen_source
     */
    protected void createTableOfDatagenSource() {
        context.execute("DROP TABLE IF EXISTS datagen_source ");

        context.execute("CREATE TABLE IF NOT EXISTS datagen_source ( " +
                "       id              INT                                  ," +
                "       name            STRING                               ," +
                "       make_time       AS PROCTIME()                         " +
                ") WITH (                                                     " +
                "       'connector' = 'datagen'                               " +
                ")"
        );
    }


    /**
     * Create print sink table print_sink
     */
    protected void createTableOfPrintSink() {
        context.execute("DROP TABLE IF EXISTS print_sink ");

        context.execute("CREATE TABLE IF NOT EXISTS print_sink (    " +
                "       id              INT                                 ," +
                "       name            STRING                              ," +
                "       make_time       TIMESTAMP(3)                         " +
                ") WITH (                                                    " +
                "       'connector' = 'print'                                " +
                ")"
        );
    }
}
