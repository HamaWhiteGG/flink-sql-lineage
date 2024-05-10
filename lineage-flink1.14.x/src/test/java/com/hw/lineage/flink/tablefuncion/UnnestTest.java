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

package com.hw.lineage.flink.tablefuncion;

import com.hw.lineage.flink.basic.AbstractBasicTest;

import org.junit.Before;
import org.junit.Test;

public class UnnestTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        context.execute("drop table if exists kafka_source");
        context.execute(
                "CREATE TABLE kafka_source (\n"
                        + "id bigint,\n"
                        + "data row<c1 bigint,c2 string>\n"
                        + ") WITH (\n"
                        + "'connector' = 'kafka',\n"
                        + "'properties.bootstrap.servers' = 'hadoop101:9092',\n"
                        + "'topic' = 't1',\n"
                        + "'properties.group.id' = 'g1',\n"
                        + "'scan.startup.mode' = 'earliest-offset',\n"
                        + "'format' = 'json'\n"
                        + ")");

        context.execute("drop table if exists kafka_source_unnest");
        context.execute(
                "CREATE TABLE kafka_source_unnest (\n"
                        + "id bigint,\n"
                        + "data ARRAY<row<c1 bigint,c2 string>>\n"
                        + ") WITH (\n"
                        + "'connector' = 'kafka',\n"
                        + "'properties.bootstrap.servers' = 'hadoop101:9092',\n"
                        + "'topic' = 't1',\n"
                        + "'properties.group.id' = 'g1',\n"
                        + "'scan.startup.mode' = 'earliest-offset',\n"
                        + "'format' = 'json'\n"
                        + ")");

        context.execute("drop table if exists sink_print");
        context.execute(
                "CREATE TABLE sink_print (\n"
                        + "id bigint,\n"
                        + "c1 bigint,\n"
                        + "c2 string\n"
                        + ") WITH (\n"
                        + "'connector' = 'print'\n"
                        + ")");
    }

    @Test
    public void testStructureRowField() {

        String sql =
                "insert into sink_print\n"
                        + "SELECT id, data.c1, data.c2\n"
                        + "FROM kafka_source ";

        String[][] expectedArray = {
                {"kafka_source", "id", "sink_print", "id"},
                {"kafka_source", "data", "sink_print", "c1", "data"},
                {"kafka_source", "data", "sink_print", "c2", "data"}
        };

        analyzeLineage(sql, expectedArray);
    }

    @Test
    public void testUnnest() {

        String sql =
                "insert into sink_print\n"
                        + "SELECT id, t.c1, t.c2\n"
                        + "FROM kafka_source_unnest\n"
                        + "CROSS JOIN UNNEST(data) AS t(c1,c2) ";

        String[][] expectedArray = {
                {"kafka_source_unnest", "id", "sink_print", "id"},
                {"kafka_source_unnest", "data", "sink_print", "c1"},
                {"kafka_source_unnest", "data", "sink_print", "c2"}
        };

        analyzeLineage(sql, expectedArray);
    }

}
