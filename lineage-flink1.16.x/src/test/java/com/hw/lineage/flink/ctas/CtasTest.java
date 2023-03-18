package com.hw.lineage.flink.ctas;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Test;

/**
 * The test case comes from <a href="https://nightlies.apache.org/flink/flink-docs-release-1.16/docs/dev/table/sql/create/#as-select_statement">flink-1.16-create-table-as-select</a>, thanks
 *
 * @description: CtasTest
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class CtasTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create datagen source table datagen_source
        createTableOfDatagenSource();
    }

    @Test
    public void testCtas() {
        context.execute("DROP TABLE IF EXISTS my_ctas_table ");

        String ctasSql = "CREATE TABLE IF NOT EXISTS my_ctas_table            " +
                "WITH (                                                       " +
                "       'connector' = 'print'                                 " +
                ") AS                                                         " +
                "SELECT                                                       " +
                "       id                                                   ," +
                "       name                                                 ," +
                "       age                                                   " +
                "FROM                                                         " +
                "       datagen_source                                        " +
                "WHERE                                                        " +
                "       mod(id, 10) = 0                                       " ;

        String[][] expectedArray = {
                {"datagen_source", "id", "my_ctas_table", "id"},
                {"datagen_source", "name", "my_ctas_table", "name"},
                {"datagen_source", "age", "my_ctas_table", "age"}
        };
        parseFieldLineage(ctasSql, expectedArray);
    }


    /**
     * Create datagen source table datagen_source
     */
    protected void createTableOfDatagenSource() {
        context.execute("DROP TABLE IF EXISTS datagen_source ");

        context.execute("CREATE TABLE IF NOT EXISTS datagen_source ( " +
                "       id              BIGINT                               ," +
                "       name            STRING                               ," +
                "       age             INT                                   " +
                ") WITH (                                                     " +
                "       'connector' = 'datagen'                               " +
                ")"
        );
    }
}
