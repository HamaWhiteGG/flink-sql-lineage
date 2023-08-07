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

/**
 *
 * The test case comes from <a href="https://nightlies.apache.org/flink/flink-docs-release-1.14/docs/dev/table/functions/udfs/#table-functions">flink-table-functions</a>
 *
 * @description: TableFunctionTest
 * @author: HamaWhite
 */
public class TableFunctionTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();

        // create my_split_udtf
        createFunctionOfMySplit();

        // create hudi sink table dwd_hudi_users
        createTableOfDwdHudiUsers();
    }

    /**
     * insert-select with my_split_udtf
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectWithUDTF() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   length ," +
                "   name ," +
                "   word as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users ," +
                "   LATERAL TABLE(my_split_udtf(name))";

        String[][] expectedArray = {
                {"ods_mysql_users", "name", "dwd_hudi_users", "id", "my_split_udtf(name).length"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name", "my_split_udtf(name).word"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
        analyzeFunction(sql, new String[]{"my_split_udtf"});
    }

    /**
     * insert-select left join with my_split_udtf
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectLeftJoinUDTF() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   length ," +
                "   name ," +
                "   word as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users " +
                "LEFT JOIN " +
                "   LATERAL TABLE(my_split_udtf(name)) ON TRUE";

        String[][] expectedArray = {
                {"ods_mysql_users", "name", "dwd_hudi_users", "id", "my_split_udtf(name).length"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name", "my_split_udtf(name).word"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
        analyzeFunction(sql, new String[]{"my_split_udtf"});
    }

    /**
     * insert-select left join with my_split_udtf and rename fields of the function in SQL
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectLeftJoinAndRenameUDTF() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   new_length ," +
                "   name ," +
                "   new_word as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users " +
                "LEFT JOIN " +
                "   LATERAL TABLE(my_split_udtf(name)) AS T(new_word, new_length) ON TRUE";

        String[][] expectedArray = {
                {"ods_mysql_users", "name", "dwd_hudi_users", "id", "my_split_udtf(name).length"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name", "my_split_udtf(name).word"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
        analyzeFunction(sql, new String[]{"my_split_udtf"});
    }

    /**
     * <a href="https://github.com/HamaWhiteGG/flink-sql-lineage/issues/66">UDTF resolve exceptions when functions in it</a>
     */
    @Test
    public void testInsertSelectWithFunctionInUDTF() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   new_length ," +
                "   name ," +
                "   new_word as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users ," +
                "   LATERAL TABLE(my_split_udtf(CAST(name AS STRING))) AS T(new_word, new_length)";

        String[][] expectedArray = {
                {"ods_mysql_users", "name", "dwd_hudi_users", "id",
                        "my_split_udtf(CAST(name):VARCHAR(2147483647) CHARACTER SET \"UTF-16LE\").length"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name",
                        "my_split_udtf(CAST(name):VARCHAR(2147483647) CHARACTER SET \"UTF-16LE\").word"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
        analyzeFunction(sql, new String[]{"my_split_udtf"});
    }

    /**
     * Create my_split_udtf
     */
    private void createFunctionOfMySplit() {
        context.execute("DROP FUNCTION IF EXISTS my_split_udtf");

        context.execute("CREATE FUNCTION IF NOT EXISTS my_split_udtf " +
                "AS 'com.hw.lineage.flink.tablefuncion.MySplitFunction'");
    }
}
