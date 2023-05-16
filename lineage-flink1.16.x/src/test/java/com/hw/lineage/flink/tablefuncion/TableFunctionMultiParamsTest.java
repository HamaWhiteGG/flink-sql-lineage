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
 * The test case comes from <a href="https://github.com/HamaWhiteGG/flink-sql-lineage/pull/73">fix parse error when table function has multiple params</a>, thanks
 *
 * @description: TableFunctionMultiParamsTest
 * @author: HamaWhite
 */
public class TableFunctionMultiParamsTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users_extra
        createTableOfOdsMysqlUsersExtra();

        // create split_multi_params_udtf
        createFunctionOfSplitMultiParams();

        // create hudi sink table dwd_hudi_users_extra
        createTableOfDwdHudiUsersExtra();
    }

    /**
     * insert-select with split_multi_params_udtf
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectWithUDTF() {
        String sql = "INSERT INTO dwd_hudi_users_extra " +
                "SELECT " +
                "   length ," +
                "   name ," +
                "   extra_name ," +
                "   word as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users_extra ," +
                "   LATERAL TABLE(split_multi_params_udtf(name, extra_name))";

        String[][] expectedArray = {
                {"ods_mysql_users_extra", "name", "dwd_hudi_users_extra", "id", "my_split_udtf(name, extra_name).length"},
                {"ods_mysql_users_extra", "extra_name", "dwd_hudi_users_extra", "id", "my_split_udtf(name, extra_name).length"},
                {"ods_mysql_users_extra", "name", "dwd_hudi_users_extra", "name"},
                {"ods_mysql_users_extra", "extra_name", "dwd_hudi_users_extra", "extra_name"},
                {"ods_mysql_users_extra", "name", "dwd_hudi_users_extra", "company_name", "my_split_udtf(name, extra_name).word"},
                {"ods_mysql_users_extra", "extra_name", "dwd_hudi_users_extra", "company_name", "my_split_udtf(name, extra_name).word"},
                {"ods_mysql_users_extra", "birthday", "dwd_hudi_users_extra", "birthday"},
                {"ods_mysql_users_extra", "ts", "dwd_hudi_users_extra", "ts"},
                {"ods_mysql_users_extra", "birthday", "dwd_hudi_users_extra", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
        analyzeFunction(sql, new String[]{"split_multi_params_udtf"});
    }

    /**
     * Create mysql cdc table ods_mysql_users
     */
    private void createTableOfOdsMysqlUsersExtra() {
        context.execute("DROP TABLE IF EXISTS ods_mysql_users_extra ");

        context.execute("CREATE TABLE IF NOT EXISTS ods_mysql_users_extra (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       extra_name          STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
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


    /**
     * Create Hudi sink table dwd_hudi_users_extra.
     * <p>
     * Since flink1.16 does not support hudi, temporarily change the connector to print,
     * but the table name remains unchanged
     */
    private void createTableOfDwdHudiUsersExtra() {
        context.execute("DROP TABLE IF EXISTS dwd_hudi_users_extra");

        context.execute("CREATE TABLE IF NOT EXISTS  dwd_hudi_users_extra ( " +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       extra_name          STRING                          ," +
                "       company_name        STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "        `partition`        VARCHAR(20)                      " +
                ") PARTITIONED BY (`partition`) WITH ( " +
                "       'connector' = 'print'                                " +
                ")");
    }

    /**
     * Create split_multi_params_udtf
     */
    private void createFunctionOfSplitMultiParams() {
        context.execute("DROP FUNCTION IF EXISTS split_multi_params_udtf");

        context.execute("CREATE FUNCTION IF NOT EXISTS split_multi_params_udtf " +
                "AS 'com.hw.lineage.flink.tablefuncion.SplitMultiParamsFunction'");
    }
}
