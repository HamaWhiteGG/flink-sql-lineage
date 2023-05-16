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

package com.hw.lineage.flink.watermark;

import com.hw.lineage.flink.basic.AbstractBasicTest;

import org.junit.Before;
import org.junit.Test;

/**
 * @description: WatermarkTest
 * @author: HamaWhite
 */
public class WatermarkTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users_watermark
        createTableOfOdsMysqlUsersWatermark();

        // create mysql dim table dim_mysql_company
        createTableOfDimMysqlCompany();

        // create hudi sink table dwd_hudi_users
        createTableOfDwdHudiUsers();
    }

    /**
     * insert-select-watermark.
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectWatermark() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   id ," +
                "   name ," +
                "   name as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users_watermark";

        String[][] expectedArray = {
                {"ods_mysql_users_watermark", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users_watermark", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users_watermark", "name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users_watermark", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users_watermark", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users_watermark", "birthday", "dwd_hudi_users", "partition",
                        "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
    }

    /**
     * insert-select-two-table-watermark join.
     * <p>
     * insert into hudi table from mysql cdc(watermark) stream join mysql dim table, which has system udf
     * CONCAT
     */
    @Test
    public void testInsertSelectTwoJoinWatermark() {
        String sql = "INSERT into dwd_hudi_users " +
                "SELECT " +
                "       a.id as id1," +
                "       CONCAT(a.name,b.company_name) , " +
                "       b.company_name , " +
                "       a.birthday ," +
                "       a.ts ," +
                "       DATE_FORMAT(a.birthday, 'yyyyMMdd') as p " +
                "FROM" +
                "       ods_mysql_users_watermark as a " +
                "JOIN " +
                "   dim_mysql_company as b " +
                "ON " +
                "   a.id = b.user_id";

        String[][] expectedArray = {
                {"ods_mysql_users_watermark", "id", "dwd_hudi_users", "id"},
                {"ods_mysql_users_watermark", "name", "dwd_hudi_users", "name",
                        "CONCAT(ods_mysql_users_watermark.name, dim_mysql_company.company_name)"},
                {"dim_mysql_company", "company_name", "dwd_hudi_users", "name",
                        "CONCAT(ods_mysql_users_watermark.name, dim_mysql_company.company_name)"},
                {"dim_mysql_company", "company_name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users_watermark", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users_watermark", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users_watermark", "birthday", "dwd_hudi_users", "partition",
                        "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);

    }
}
