package com.hw.lineage.flink.localtimestamp;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @description: LocaltimestampTest
 * @author: HamaWhite
 */
public class LocaltimestampTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create datagen source table datagen_source
        createTableOfDatagenSource();

        // create print sink table print_sink
        createTableOfPrintSink();
    }

    @Test
    public void testInsertSelectLocaltimestamp() {
        String sql = "INSERT INTO print_sink " +
                "SELECT " +
                "       id          ," +
                "       name        ," +
                "       birthday    ," +
                "       ts           " +
                "FROM" +
                "       datagen_source ";

        String[][] expectedArray = {
                {"datagen_source", "id", "print_sink", "id"},
                {"datagen_source", "name", "print_sink", "name"},
                {"datagen_source", "birthday", "print_sink", "birthday"},
                {"datagen_source", "ts", "print_sink", "ts"}
        };

        analyzeLineage(sql, expectedArray);

    }


    /**
     * Create datagen source table datagen_source
     */
    protected void createTableOfDatagenSource() {
        context.execute("DROP TABLE IF EXISTS datagen_source ");

        context.execute("CREATE TABLE IF NOT EXISTS datagen_source (" +
                "       id              INT                        ," +
                "       name            STRING                     ," +
                "       birthday        AS LOCALTIMESTAMP          ," +
                "       ts              AS LOCALTIMESTAMP          ," +
                "       WATERMARK FOR ts AS ts                      " +
                ") WITH ( " +
                "       'connector' = 'datagen'                     " +
                ")"
        );
    }


    /**
     * Create print sink table print_sink
     */
    protected void createTableOfPrintSink() {

        context.execute("DROP TABLE IF EXISTS print_sink ");

        context.execute("CREATE TABLE IF NOT EXISTS print_sink (" +
                "       id              INT                         ," +
                "       name            STRING                      ," +
                "       birthday        TIMESTAMP(3)                ," +
                "       ts              TIMESTAMP(3)                 " +
                ") WITH ( " +
                "       'connector' = 'print'                        " +
                ")"
        );
    }
}
