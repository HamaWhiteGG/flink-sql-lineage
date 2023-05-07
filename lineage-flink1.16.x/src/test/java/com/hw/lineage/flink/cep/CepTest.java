package com.hw.lineage.flink.cep;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Test;


/**
 * The test case comes from https://www.jianshu.com/p/c0b76abe4224, thanks
 *
 * @description: CepTest
 * @author: HamaWhite
 */
public class CepTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create datagen source table temperature_source
        createTableOfTemperatureSource();

        // create print sink table print_sink
        createTableOfPrintSink();

        // another cep sql test case
        createSinkTable();
        createSourceTable();
    }

    @Test
    public void testInsertSelectCep() {
        String sql = "INSERT INTO print_sink                                " +
                "SELECT                                                     " +
                "   *                                                       " +
                "FROM                                                       " +
                "   temperature_source MATCH_RECOGNIZE (                    " +
                "       PARTITION BY rack_id                                " +
                "       ORDER BY ts                                         " +
                "       MEASURES                                            " +
                "           A.ts as start_ts,                               " +
                "           LAST(B.ts) as end_ts,                           " +
                "           A.temperature as start_temp,                    " +
                "           LAST(B.temperature) as end_temp,                " +
                "           AVG(B.temperature) as avg_temp                  " +
                "           ONE ROW PER MATCH                               " +
                "           AFTER MATCH SKIP TO NEXT ROW                    " +
                "           PATTERN (A B+ C) WITHIN INTERVAL '90' second    " +
                "           DEFINE                                          " +
                "               A as A.temperature < 50,                    " +
                "               B as B.temperature >=50,                    " +
                "               C as C.temperature < 50                     " +
                "    )";

        /**
         * Variables A and B in transform are not replaced.
         * LAST and AVG functions have also been replaced.
         */
        String[][] expectedArray = {
                {"temperature_source", "rack_id", "print_sink", "rack_id"},
                {"temperature_source", "ts", "print_sink", "start_ts", "A.ts"},
                {"temperature_source", "ts", "print_sink", "end_ts", "LAST(B.ts, 0)"},
                {"temperature_source", "temperature", "print_sink", "start_temp", "A.temperature"},
                {"temperature_source", "temperature", "print_sink", "end_temp", "LAST(B.temperature, 0)"},
                {"temperature_source", "temperature", "print_sink", "avg_temp", "CAST(/(SUM(B.temperature), COUNT(B.temperature))):INTEGER"}
        };

        analyzeLineage(sql, expectedArray);
    }


    @Test
    public void testInsertSelectViewCep() {
        context.execute("DROP VIEW IF EXISTS temperature_view ");

        context.execute("CREATE VIEW IF NOT EXISTS temperature_view AS " +
                "SELECT                                                     " +
                "   *                                                       " +
                "FROM                                                       " +
                "   temperature_source MATCH_RECOGNIZE (                    " +
                "       PARTITION BY rack_id                                " +
                "       ORDER BY ts                                         " +
                "       MEASURES                                            " +
                "           A.ts as start_ts,                               " +
                "           LAST(B.ts) as end_ts,                           " +
                "           A.temperature as start_temp,                    " +
                "           LAST(B.temperature) as end_temp,                " +
                "           AVG(B.temperature) as avg_temp                  " +
                "           ONE ROW PER MATCH                               " +
                "           AFTER MATCH SKIP TO NEXT ROW                    " +
                "           PATTERN (A B+ C) WITHIN INTERVAL '90' second    " +
                "           DEFINE                                          " +
                "               A as A.temperature < 50,                    " +
                "               B as B.temperature >=50,                    " +
                "               C as C.temperature < 50                     " +
                "   )"
        );

        String sql = "INSERT INTO print_sink (rack_id, start_ts, end_ts, start_temp, end_temp, avg_temp) " +
                "SELECT " +
                "   rack_id     ," +
                "   start_ts    ," +
                "   end_ts      ," +
                "   start_temp  ," +
                "   end_temp    ," +
                "   avg_temp     " +
                "FROM" +
                "   temperature_view";

        /**
         * Variables A and B in transform are not replaced.
         * LAST and AVG functions have also been replaced, and add CAST function.
         */
        String[][] expectedArray = {
                {"temperature_source", "rack_id", "print_sink", "rack_id"},
                {"temperature_source", "ts", "print_sink", "start_ts", "CAST(A.ts):TIMESTAMP(3)"},
                {"temperature_source", "ts", "print_sink", "end_ts", "CAST(LAST(B.ts, 0)):TIMESTAMP(3)"},
                {"temperature_source", "temperature", "print_sink", "start_temp", "A.temperature"},
                {"temperature_source", "temperature", "print_sink", "end_temp", "LAST(B.temperature, 0)"},
                {"temperature_source", "temperature", "print_sink", "avg_temp", "CAST(/(SUM(B.temperature), COUNT(B.temperature))):INTEGER"}
        };

        analyzeLineage(sql, expectedArray);
    }


    /**
     * Create datagen source table temperature_source
     */
    protected void createTableOfTemperatureSource() {
        context.execute("DROP TABLE IF EXISTS temperature_source ");

        context.execute("CREATE TABLE IF NOT EXISTS temperature_source (" +
                "       rack_id                 INT                         ," +
                "       ts                      TIMESTAMP(3)                ," +
                "       temperature             INT                         ," +
                "       WATERMARK FOR ts AS ts - INTERVAL '1' SECOND         " +
                ") WITH ( " +
                "       'connector' = 'filesystem'                          ," +
                "       'path' = 'data/temperature_record.csv'              ," +
                "       'format' = 'csv'                                     " +
                ")"
        );
    }


    /**
     * Create print sink table print_sink
     */
    protected void createTableOfPrintSink() {
        context.execute("DROP TABLE IF EXISTS print_sink ");

        context.execute("CREATE TABLE IF NOT EXISTS print_sink (" +
                "       rack_id             INT                         ," +
                "       start_ts            TIMESTAMP(3)                ," +
                "       end_ts              TIMESTAMP(3)                ," +
                "       start_temp          INT                         ," +
                "       end_temp            INT                         ," +
                "       avg_temp            INT                         " +
                ") WITH ( " +
                "       'connector' = 'print'                        " +
                ")"
        );
    }

    /**
     * Create source table `sink_table`
     */
    protected void createSinkTable() {
        context.execute("DROP TABLE IF EXISTS `sink_table` ");
        context.execute("CREATE TABLE `sink_table`(" +
                "`agent_id` STRING," +
                "`room_id` STRING," +
                "`application_id` STRING, " +
                "`type` STRING, " +
                "`begin_time` BIGINT, " +
                "`end_time` BIGINT) " +
                " WITH ('connector' = 'blackhole')"
        );
    }

    /**
     * Create source table `source_table`
     */
    protected void createSourceTable() {
        context.execute("DROP TABLE IF EXISTS `source_table` ");
        context.execute("CREATE TABLE `source_table`(" +
                "`agent_id` STRING, " +
                "`room_id` STRING, " +
                "`create_time` BIGINT, " +
                "`type` STRING, " +
                "`application_id` STRING, " +
                "`connect_time` BIGINT, " +
                "`row_time` AS PROCTIME()) " +
                " WITH ('connector' = 'datagen')"
        );
    }

    @Test
    public void testInsertSelectCepWithMultiplePartitionKeys(){
        String sql = "insert into sink_table (agent_id, room_id, application_id, type, begin_time, end_time)   " +
                "           select agent_id,room_id,application_id,type,begin_time,end_time                    " +
                "                   from source_table match_recognize(                                         " +
                "                       partition by agent_id,room_id,application_id                           " +
                "                       order by row_time                                                      " +
                "                       measures AF.type as type,last(BF.create_time) as begin_time,           " +
                "                           last(AF.create_time) as end_time                                   " +
                "                       one row per match                                                      " +
                "                       after match SKIP PAST LAST ROW                                         " +
                "                       pattern (BF+ AF) WITHIN INTERVAL '1' HOUR                              " +
                "                       define BF as BF.type = 'assign',AF as AF.type = 'pick_up'              " +
                "                   ) as T                                                                     ";

        String[][] expectedArray = {
                {"source_table", "agent_id", "sink_table", "agent_id"},
                {"source_table", "room_id", "sink_table", "room_id"},
                {"source_table", "application_id", "sink_table", "application_id"},
                {"source_table", "type", "sink_table", "type"},
                {"source_table", "create_time", "sink_table", "begin_time"},
                {"source_table", "create_time", "sink_table", "end_time"},
        };

        analyzeLineage(sql, expectedArray);
    }

}
