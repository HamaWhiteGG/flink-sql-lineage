/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
