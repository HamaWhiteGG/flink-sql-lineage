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

package com.hw.lineage.flink.parse;

import com.hw.lineage.flink.basic.AbstractBasicTest;

import org.apache.flink.table.api.SqlParserException;
import org.apache.flink.table.api.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

/**
 * @description: ParseTest
 * @author: HamaWhite
 */
public class ParseTest extends AbstractBasicTest {

    @Before
    public void createTable() {
        // create mysql cdc table ods_mysql_users
        createTableOfOdsMysqlUsers();
    }

    @Test
    public void testParse() {
        context.parseValidate("SELECT id, name, birthday FROM ods_mysql_users");
    }

    @Test
    public void testParseWithErrorSyntax() {
        assertThrows("SQL parse failed. Encountered \"ods_mysql_users\" at line 1, column 38.",
                SqlParserException.class,
                () -> context.parseValidate("SELECT id, name, birthday ERROR_FROM ods_mysql_users"));
    }

    @Test
    public void testParseWithErrorTable() {
        assertThrows(
                "SQL validation failed. From line 1, column 32 to line 1, column 52: Object 'error_ods_mysql_users' not found",
                ValidationException.class,
                () -> context.parseValidate("SELECT id, name, birthday FROM error_ods_mysql_users"));

    }

    @Test
    public void testParseWithErrorFiled() {
        assertThrows(
                "SQL validation failed. From line 1, column 8 to line 1, column 15: Column 'error_id' not found in any table",
                ValidationException.class,
                () -> context.parseValidate("SELECT error_id, name, birthday FROM ods_mysql_users"));
    }

    @Test
    public void testParseShow() {
        context.parseValidate("SHOW CATALOGS");
    }
}
