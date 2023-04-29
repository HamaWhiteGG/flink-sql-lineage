package com.hw.lineage.flink.tvf;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Refer to <a href="https://nightlies.apache.org/flink/flink-docs-master/docs/dev/table/sql/queries/window-tvf">Windowing table-valued functions (Windowing TVFs)</a>
 *
 * @description: TvfTest
 * @author: HamaWhite
 */
public class TvfTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table bid
        createTableOfBid();

        // create print sink table print_sink
        createTableOfPrintSink();

        // create print sink table print_sink_agg
        createTableOfPrintSinkAgg();
    }

    @Test
    public void testTumble() {
        String sql = "INSERT INTO print_sink                            " +
                "SELECT                                                 " +
                "       *                                               " +
                "FROM TABLE(                                            " +
                "       TUMBLE( TABLE bid                              ," +
                "               DESCRIPTOR(bid_time)                   ," +
                "               INTERVAL '10' MINUTES                   " +
                "       )                                               " +
                ")                                                      ";

        String[][] expectedArray = {
                {"bid", "bid_time", "print_sink", "bid_time"},
                {"bid", "price", "print_sink", "price"},
                {"bid", "item", "print_sink", "item"},
                {"bid", "bid_time", "print_sink", "window_start", "TUMBLE.window_start"},
                {"bid", "bid_time", "print_sink", "window_end", "TUMBLE.window_end"},
                {"bid", "bid_time", "print_sink", "window_time", "TUMBLE.window_time"}
        };

        analyzeLineage(sql, expectedArray);
    }

    @Test
    public void testTumbleAgg() {
        String sql = "INSERT INTO print_sink_agg                        " +
                "SELECT                                                 " +
                "       window_start                                   ," +
                "       window_end                                     ," +
                "       SUM(price)                                      " +
                "FROM TABLE(                                            " +
                "       TUMBLE( TABLE bid                              ," +
                "               DESCRIPTOR(bid_time)                   ," +
                "               INTERVAL '10' MINUTES                   " +
                "       )                                               " +
                ")                                                      " +
                "GROUP BY                                               " +
                "       window_start, window_end                        ";

        String[][] expectedArray = {
                {"bid", "bid_time", "print_sink_agg", "window_start", "TUMBLE.window_start"},
                {"bid", "bid_time", "print_sink_agg", "window_end", "TUMBLE.window_end"},
                {"bid", "price", "print_sink_agg", "price", "SUM(price)"}
        };

        analyzeLineage(sql, expectedArray);
    }

    @Test
    public void testHop() {
        String sql = "INSERT INTO print_sink                            " +
                "SELECT                                                 " +
                "       *                                               " +
                "FROM TABLE(                                            " +
                "       HOP( TABLE bid                                 ," +
                "               DESCRIPTOR(bid_time)                   ," +
                "               INTERVAL '5' MINUTES                   ," +
                "               INTERVAL '10' MINUTES                   " +
                "       )                                               " +
                ")                                                      ";

        String[][] expectedArray = {
                {"bid", "bid_time", "print_sink", "bid_time"},
                {"bid", "price", "print_sink", "price"},
                {"bid", "item", "print_sink", "item"},
                {"bid", "bid_time", "print_sink", "window_start", "HOP.window_start"},
                {"bid", "bid_time", "print_sink", "window_end", "HOP.window_end"},
                {"bid", "bid_time", "print_sink", "window_time", "HOP.window_time"}
        };

        analyzeLineage(sql, expectedArray);
    }

    @Test
    public void testHopAgg() {
        String sql = "INSERT INTO print_sink_agg                        " +
                "SELECT                                                 " +
                "       window_start                                   ," +
                "       window_end                                     ," +
                "       SUM(price)                                      " +
                "FROM TABLE(                                            " +
                "       HOP( TABLE bid                                 ," +
                "               DESCRIPTOR(bid_time)                   ," +
                "               INTERVAL '5' MINUTES                   ," +
                "               INTERVAL '10' MINUTES                   " +
                "       )                                               " +
                ")                                                      " +
                "GROUP BY                                               " +
                "       window_start, window_end                        ";

        String[][] expectedArray = {
                {"bid", "bid_time", "print_sink_agg", "window_start", "HOP.window_start"},
                {"bid", "bid_time", "print_sink_agg", "window_end", "HOP.window_end"},
                {"bid", "price", "print_sink_agg", "price", "SUM(price)"}
        };

        analyzeLineage(sql, expectedArray);
    }


    @Test
    public void testCumulate() {
        String sql = "INSERT INTO print_sink                            " +
                "SELECT                                                 " +
                "       *                                               " +
                "FROM TABLE(                                            " +
                "       CUMULATE( TABLE bid                            ," +
                "               DESCRIPTOR(bid_time)                   ," +
                "               INTERVAL '2' MINUTES                   ," +
                "               INTERVAL '10' MINUTES                   " +
                "       )                                               " +
                ")                                                      ";

        String[][] expectedArray = {
                {"bid", "bid_time", "print_sink", "bid_time"},
                {"bid", "price", "print_sink", "price"},
                {"bid", "item", "print_sink", "item"},
                {"bid", "bid_time", "print_sink", "window_start", "CUMULATE.window_start"},
                {"bid", "bid_time", "print_sink", "window_end", "CUMULATE.window_end"},
                {"bid", "bid_time", "print_sink", "window_time", "CUMULATE.window_time"}
        };

        analyzeLineage(sql, expectedArray);
    }

    @Test
    public void testCumulateAgg() {
        String sql = "INSERT INTO print_sink_agg                        " +
                "SELECT                                                 " +
                "       window_start                                   ," +
                "       window_end                                     ," +
                "       SUM(price)                                      " +
                "FROM TABLE(                                            " +
                "       CUMULATE( TABLE bid                            ," +
                "               DESCRIPTOR(bid_time)                   ," +
                "               INTERVAL '2' MINUTES                   ," +
                "               INTERVAL '10' MINUTES                   " +
                "       )                                               " +
                ")                                                      " +
                "GROUP BY                                               " +
                "       window_start, window_end                        ";

        String[][] expectedArray = {
                {"bid", "bid_time", "print_sink_agg", "window_start", "CUMULATE.window_start"},
                {"bid", "bid_time", "print_sink_agg", "window_end", "CUMULATE.window_end"},
                {"bid", "price", "print_sink_agg", "price", "SUM(price)"}
        };

        analyzeLineage(sql, expectedArray);
    }


    /**
     * Create mysql cdc table bid
     */
    protected void createTableOfBid() {
        context.execute("DROP TABLE IF EXISTS bid ");
        context.execute("CREATE TABLE IF NOT EXISTS bid (                   " +
                "       bid_time            TIMESTAMP(3)                            ," +
                "       price               DECIMAL(10, 2)                          ," +
                "       item                STRING                                  ," +
                "       WATERMARK FOR bid_time AS bid_time - INTERVAL '1' SECOND     " +
                ") WITH (                                     " +
                "       'connector' = 'mysql-cdc'            ," +
                "       'hostname'  = '127.0.0.1'            ," +
                "       'port'      = '3306'                 ," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'xxx'                  ," +
                "       'server-time-zone' = 'Asia/Shanghai' ," +
                "       'database-name' = 'demo'             ," +
                "       'table-name'    = 'users'            ," +
                "       'scan.incremental.snapshot.enabled' = 'false'   " +
                ")"
        );
    }

    /**
     * Create print sink table print_sink
     */
    protected void createTableOfPrintSink() {
        context.execute("DROP TABLE IF EXISTS print_sink ");

        context.execute("CREATE TABLE IF NOT EXISTS print_sink (    " +
                "       bid_time            TIMESTAMP(3)                    ," +
                "       price               DECIMAL(10, 2)                  ," +
                "       item                STRING                          ," +
                "       window_start        TIMESTAMP(3)                    ," +
                "       window_end          TIMESTAMP(3)                    ," +
                "       window_time         TIMESTAMP(3)                     " +
                ") WITH (                                                    " +
                "       'connector' = 'print'                                " +
                ")"
        );
    }

    /**
     * Create print sink table print_sink_agg
     */
    protected void createTableOfPrintSinkAgg() {
        context.execute("DROP TABLE IF EXISTS print_sink_agg ");

        context.execute("CREATE TABLE IF NOT EXISTS print_sink_agg ( " +
                "       window_start        TIMESTAMP(3)                     ," +
                "       window_end          TIMESTAMP(3)                     ," +
                "       price               DECIMAL(10, 2)                    " +
                ") WITH (                                                     " +
                "       'connector' = 'print'                                 " +
                ")"
        );
    }
}