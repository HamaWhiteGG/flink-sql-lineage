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

package com.hw.lineage.flink.window;

import com.hw.lineage.flink.basic.AbstractBasicTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @description: WindowTest
 * @author: HamaWhite
 */
public class WindowTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();

        // create hudi sink table dwd_hudi_users
        createTableOfDwdHudiUsers();
    }


    /**
     * insert-select with ROW_NUMBER()
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectRowNumber() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   ROW_NUMBER() OVER (PARTITION BY id ORDER BY ts DESC) as rowNum ," +
                "   name ," +
                "   name as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users";

        String[][] expectedArray = {
                {"ods_mysql_users", "ts", "dwd_hudi_users", "id", "ROW_NUMBER() OVER (PARTITION BY id ORDER BY ts DESC NULLS LAST)"},
                {"ods_mysql_users", "id", "dwd_hudi_users", "id", "ROW_NUMBER() OVER (PARTITION BY id ORDER BY ts DESC NULLS LAST)"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
    }

    /**
     * insert-select with two ROW_NUMBER()
     * <p>
     * insert into hudi table from mysql cdc stream table.
     */
    @Test
    public void testInsertSelectTwoRowNumber() {
        String sql = "INSERT INTO dwd_hudi_users " +
                "SELECT " +
                "   ROW_NUMBER() OVER (PARTITION BY id ORDER BY ts DESC) as rowNum ," +
                "   name ," +
                "   CAST(ROW_NUMBER() OVER (PARTITION BY name ORDER BY ts DESC) as STRING) as company_name ," +
                "   birthday ," +
                "   ts ," +
                "   DATE_FORMAT(birthday, 'yyyyMMdd') " +
                "FROM" +
                "   ods_mysql_users";

        String[][] expectedArray = {
                {"ods_mysql_users", "ts", "dwd_hudi_users", "id", "ROW_NUMBER() OVER (PARTITION BY id ORDER BY ts DESC NULLS LAST)"},
                {"ods_mysql_users", "id", "dwd_hudi_users", "id", "ROW_NUMBER() OVER (PARTITION BY id ORDER BY ts DESC NULLS LAST)"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "name"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "company_name","CAST(ROW_NUMBER() OVER (PARTITION BY name ORDER BY ts DESC NULLS LAST)):VARCHAR(2147483647) CHARACTER SET \"UTF-16LE\" NOT NULL"},
                {"ods_mysql_users", "name", "dwd_hudi_users", "company_name","CAST(ROW_NUMBER() OVER (PARTITION BY name ORDER BY ts DESC NULLS LAST)):VARCHAR(2147483647) CHARACTER SET \"UTF-16LE\" NOT NULL"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "birthday"},
                {"ods_mysql_users", "ts", "dwd_hudi_users", "ts"},
                {"ods_mysql_users", "birthday", "dwd_hudi_users", "partition", "DATE_FORMAT(birthday, 'yyyyMMdd')"}
        };

        analyzeLineage(sql, expectedArray);
    }
}