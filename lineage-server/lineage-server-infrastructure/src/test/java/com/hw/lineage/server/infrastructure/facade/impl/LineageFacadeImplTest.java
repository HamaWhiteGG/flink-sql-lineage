package com.hw.lineage.server.infrastructure.facade.impl;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @description: LineageFacadeImplTest
 * @author: HamaWhite
 */

public class LineageFacadeImplTest {

    @Test
    public void testCtas() throws Exception {
        LineageFacadeImpl lineageFacade=new LineageFacadeImpl();

        String singleSql = "CREATE TABLE IF NOT EXISTS my_ctas_table          " +
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

        boolean result = Whitebox.invokeMethod(lineageFacade, "ctas", singleSql);
        assertThat(result).isTrue();
    }
}