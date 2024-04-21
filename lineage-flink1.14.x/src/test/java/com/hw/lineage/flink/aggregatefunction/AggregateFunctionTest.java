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

package com.hw.lineage.flink.aggregatefunction;

import com.hw.lineage.flink.basic.AbstractBasicTest;

import org.junit.Before;
import org.junit.Test;

public class AggregateFunctionTest extends AbstractBasicTest {

    @Before
    public void createTable() {

        createTableOfOdsMysqlUsers();

        createTableOfDwdHudiUsers();

        createTableOfOdsMysqlUsersDetail();

        createPrintTable();

        createFunction();
    }

    /**
     * #125 issue
     */
    @Test
    public void testAggregateFunction() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   test_aggregate(concat_ws('_', name, 'test'), name, 'test')," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users group by id, name, birthday, ts ";

        String[][] expectedArray = {
                {"ods_mysql_users", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name",
                        "test_aggregate(CONCAT_WS('_', name, 'test'), name, 'test')"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
    }

    /**
     * #128 issue
     */
    @Test
    public void testMultiTierUdf() {
        String sql = "INSERT INTO print_table " +
                "SELECT " +
                "   round( COUNT(*) /  COUNT( DISTINCT  name ) , 2 )" +
                "FROM" +
                "   ods_mysql_users group by ts ";

        String[][] expectedArray = {
                {"ods_mysql_users", "name", "print_table", "num", "ROUND(/(COUNT(DISTINCT name), $2), 2)"},

        };

        analyzeLineage(sql, expectedArray);
    }

    /**
     * #126 issue
     */
    @Test
    public void testAggregateFunctionInputArgument() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   test_aggregate(concat_ws('_', name, email), address, 'test')," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_user_detail group by id, name, birthday, ts ";

        String[][] expectedArray = {
                {"ods_mysql_user_detail", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_user_detail", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_user_detail", "name", "dwd_hudi_users", "company_name",
                        "test_aggregate(CONCAT_WS('_', name, email), address, 'test')"},
                {"ods_mysql_user_detail", "email", "dwd_hudi_users", "company_name",
                        "test_aggregate(CONCAT_WS('_', name, email), address, 'test')"},
                {"ods_mysql_user_detail", "address", "dwd_hudi_users", "company_name",
                        "test_aggregate(CONCAT_WS('_', name, email), address, 'test')"},
                {"ods_mysql_user_detail", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_user_detail", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_user_detail", "birthday", "dwd_hudi_users", "partition",
                        "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
    }

    private void createPrintTable() {
        context.execute("drop table if exists print_table");
        context.execute("create table print_table (num double) with ('connector'='print')");
    }
    protected void createTableOfOdsMysqlUsersDetail() {
        context.execute("DROP TABLE IF EXISTS ods_mysql_user_detail ");

        context.execute("CREATE TABLE IF NOT EXISTS ods_mysql_user_detail (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "       email               STRING                          ," +
                "       address             STRING                          ," +
                "       proc_time as proctime()                              " +
                ") WITH ( " +
                "       'connector' = 'mysql-cdc'            ," +
                "       'hostname'  = '127.0.0.1'       ," +
                "       'port'      = '3306'                 ," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'xxx'          ," +
                "       'server-time-zone' = 'Asia/Shanghai' ," +
                "       'database-name' = 'demo'             ," +
                "       'table-name'    = 'users' " +
                ")");
    }

    private void createFunction() {
        context.execute("drop function if exists test_aggregate");
        context.execute(
                "create function test_aggregate as 'com.hw.lineage.flink.aggregatefunction.TestAggregateFunction'");
    }

}
