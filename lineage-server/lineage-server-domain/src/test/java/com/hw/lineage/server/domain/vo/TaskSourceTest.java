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

package com.hw.lineage.server.domain.vo;

import com.hw.lineage.common.util.Base64Utils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.hw.lineage.server.domain.vo.TaskSource.SplitSource;

/**
 * @description: TaskSourceTest
 * @author: HamaWhite
 */
public class TaskSourceTest {

    /**
     * Semicolons enclosed by single quotes
     */
    @Test
    public void testFirstSplitSource() {
        String source =
                "SELECT * FROM t1;SELECT SPLIT_INDEX(str, ';', 0) FROM t2;SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3";
        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(3);
        assertThat(splitList.get(0)).isEqualTo(new SplitSource("SELECT * FROM t1", 1L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, ';', 0) FROM t2", 1L));
        assertThat(splitList.get(2)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3", 1L));
    }

    /**
     * Semicolons enclosed by double quotes
     */
    @Test
    public void testSecondSplitSource() {
        String source =
                "SELECT * FROM t1;SELECT SPLIT_INDEX(str, \";\", 0) FROM t2;SELECT SPLIT_INDEX(str, \"m;2\", 0) FROM t3";
        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<TaskSource.SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(3);
        assertThat(splitList.get(0)).isEqualTo(new SplitSource("SELECT * FROM t1", 1L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, \";\", 0) FROM t2", 1L));
        assertThat(splitList.get(2)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, \"m;2\", 0) FROM t3", 1L));
    }

    /**
     * Semicolons enclosed by both single quotes and double quotes
     */
    @Test
    public void testThirdSplitSource() {
        String source =
                "SELECT * FROM t1;SELECT SPLIT_INDEX(str,':', 0) FROM t2;SELECT SPLIT_INDEX(str, \"m;2\", 0) FROM t3";
        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<TaskSource.SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(3);
        assertThat(splitList.get(0)).isEqualTo(new SplitSource("SELECT * FROM t1", 1L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str,':', 0) FROM t2", 1L));
        assertThat(splitList.get(2)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, \"m;2\", 0) FROM t3", 1L));
    }

    /**
     * Source has a semicolon at the end
     */
    @Test
    public void testFourthSplitSource() {
        String source = "SELECT * FROM t1;SELECT SPLIT_INDEX(str,':', 0) FROM t2;";
        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<TaskSource.SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(2);
        assertThat(splitList.get(0)).isEqualTo(new SplitSource("SELECT * FROM t1", 1L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str,':', 0) FROM t2", 1L));
    }

    /**
     * SQL lines contain multiple semicolons
     */
    @Test
    public void testFifthSplitSource() {
        String source =
                "SELECT * FROM t1;;SELECT SPLIT_INDEX(str, ';', 0) FROM t2;;;SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3";
        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<TaskSource.SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(3);
        assertThat(splitList.get(0)).isEqualTo(new SplitSource("SELECT * FROM t1", 1L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, ';', 0) FROM t2", 1L));
        assertThat(splitList.get(2)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3", 1L));
    }

    /**
     * Remove comments and line break
     */
    @Test
    public void testSixthSplitSource() {
        String source = "-- first\n" +
                "SELECT * FROM t1;\n" +
                "\n" +
                "\n" +
                "SELECT SPLIT_INDEX(str, ';', 0) \n" +
                "FROM t2;  -- second \n" +
                "\n" +
                "--\n" +
                "----third\n" +
                "SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3";

        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<TaskSource.SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(3);
        assertThat(splitList.get(0)).isEqualTo(new SplitSource("SELECT * FROM t1", 2L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, ';', 0) \nFROM t2", 5L));
        assertThat(splitList.get(2)).isEqualTo(new SplitSource("SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3", 10L));
    }

    /**
     * Remove comments and line break
     */
    @Test
    public void testSeventhSplitSource() {
        String source = "-- create users table\n" +
                "CREATE TABLE users (\n" +
                "  id INT PRIMARY KEY,\n" +
                "  name VARCHAR(100)\n" +
                ");\n" +
                "\n" +
                "-- insert data\n" +
                "INSERT INTO users (id, name) VALUES (1, 'Alice');\n" +
                "INSERT INTO users (id, name) VALUES (2, 'Bob');\n";

        source = Base64Utils.encode(source);
        TaskSource taskSource = new TaskSource(source);
        List<TaskSource.SplitSource> splitList = taskSource.split();
        assertThat(splitList).isNotNull().asList().hasSize(3);
        System.out.println(splitList);
        assertThat(splitList.get(0)).isEqualTo(
                new SplitSource("CREATE TABLE users (\n" + "  id INT PRIMARY KEY,\n" + "  name VARCHAR(100)\n)", 2L));
        assertThat(splitList.get(1)).isEqualTo(new SplitSource("INSERT INTO users (id, name) VALUES (1, 'Alice')", 8L));
        assertThat(splitList.get(2)).isEqualTo(new SplitSource("INSERT INTO users (id, name) VALUES (2, 'Bob')", 9L));
    }
}