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

package com.hw.lineage.flink.basic;

import com.hw.lineage.common.model.FunctionResult;
import com.hw.lineage.common.model.LineageResult;
import com.hw.lineage.flink.LineageServiceImpl;

import org.apache.flink.table.catalog.hive.HiveCatalog;
import org.apache.flink.table.catalog.hive.HiveTestUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @description: AbstractBasicTest
 * @author: HamaWhite
 */
public abstract class AbstractBasicTest {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractBasicTest.class);

    private static String catalogName = "hive";

    private static String hiveVersion = "3.1.2";

    private static String defaultDatabase = "default";

    private static HiveCatalog hiveCatalog;

    protected static LineageServiceImpl context;

    @BeforeClass
    public static void setup() throws Exception {
        hiveCatalog = HiveTestUtils.createHiveCatalog(catalogName, defaultDatabase, hiveVersion);
        hiveCatalog.open();

        context = new LineageServiceImpl();
        context.useCatalog(hiveCatalog);
    }

    @AfterClass
    public static void closeCatalog() {
        if (hiveCatalog != null) {
            hiveCatalog.close();
        }
        HiveTestUtils.deleteTemporaryFolder();
    }

    protected void analyzeLineage(String sql, String[][] expectedArray) {
        List<LineageResult> actualList = analyzeLineage(sql);
        List<LineageResult> expectedList = LineageResult.buildResult(catalogName, defaultDatabase, expectedArray);
        assertEquals(expectedList, actualList);
    }

    protected void analyzeLineage(String catalogName, String sql, String[][] expectedArray) {
        List<LineageResult> actualList = analyzeLineage(sql);
        List<LineageResult> expectedList = LineageResult.buildResult(catalogName, defaultDatabase, expectedArray);
        assertEquals(expectedList, actualList);
    }

    private List<LineageResult> analyzeLineage(String sql) {
        List<LineageResult> actualList = context.analyzeLineage(sql);
        LOG.info("Analyze linage result: ");
        actualList.forEach(e -> LOG.info(e.toString()));
        return actualList;
    }

    protected void analyzeFunction(String sql, String[] expectedArray) {
        Set<FunctionResult> actualSet = analyzeFunction(sql);
        Set<FunctionResult> expectedSet = FunctionResult.buildResult(catalogName, defaultDatabase, expectedArray);
        assertEquals(expectedSet, actualSet);
    }

    private Set<FunctionResult> analyzeFunction(String sql) {
        Set<FunctionResult> actualSet = context.analyzeFunction(sql);
        LOG.info("Analyze function result: ");
        actualSet.forEach(e -> LOG.info(e.toString()));
        return actualSet;
    }

    /**
     * Create mysql cdc table ods_mysql_users
     */
    protected void createTableOfOdsMysqlUsers() {
        context.execute("DROP TABLE IF EXISTS ods_mysql_users ");

        context.execute("CREATE TABLE IF NOT EXISTS ods_mysql_users (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
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
     * Create mysql cdc table ods_mysql_users_watermark
     */
    protected void createTableOfOdsMysqlUsersWatermark() {
        context.execute("DROP TABLE IF EXISTS ods_mysql_users_watermark ");

        context.execute("CREATE TABLE IF NOT EXISTS ods_mysql_users_watermark (" +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "       proc_time as proctime()                             ," +
                "       WATERMARK FOR ts AS ts - INTERVAL '5' SECOND         " +
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
     * Create mysql dim table dim_mysql_company
     */
    protected void createTableOfDimMysqlCompany() {
        context.execute("DROP TABLE IF EXISTS dim_mysql_company ");

        context.execute("CREATE TABLE IF NOT EXISTS dim_mysql_company (" +
                "       user_id                  BIGINT     ," +
                "       company_name              STRING     " +
                ") WITH ( " +
                "       'connector' = 'jdbc'                 ," +
                "       'url'       = 'jdbc:mysql://127.0.0.1:3306/demo?useSSL=false&characterEncoding=UTF-8'," +
                "       'username'  = 'root'                 ," +
                "       'password'  = 'xxx'          ," +
                "       'table-name'= 'company' " +
                ")");
    }

    /**
     * Create Hudi sink table dwd_hudi_users
     */
    protected void createTableOfDwdHudiUsers() {
        context.execute("DROP TABLE IF EXISTS dwd_hudi_users");

        context.execute("CREATE TABLE IF NOT EXISTS  dwd_hudi_users ( " +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name                STRING                          ," +
                "       company_name        STRING                          ," +
                "       birthday            TIMESTAMP(3)                    ," +
                "       ts                  TIMESTAMP(3)                    ," +
                "        `partition`        VARCHAR(20)                      " +
                ") PARTITIONED BY (`partition`) WITH ( " +
                "       'connector' = 'hudi'                                    ," +
                "       'table.type' = 'COPY_ON_WRITE'                          ," +
                "       'path' = '/hudi/users'                                  ," +
                "       'read.streaming.enabled' = 'true'                       ," +
                "       'read.streaming.check-interval' = '1'                    " +
                ")");
    }

    /**
     * Create Hudi sink table dws_users_cnt
     */
    protected void createTableOfDwsHudiUsersCnt() {
        context.execute("DROP TABLE IF EXISTS dws_users_cnt");

        context.execute("CREATE TABLE IF NOT EXISTS  dws_users_cnt ( " +
                "       id                  BIGINT PRIMARY KEY NOT ENFORCED ," +
                "       name_cnt            BIGINT                          ," +
                "       company_name_cnt    BIGINT                           " +
                ") WITH ( " +
                "       'connector' = 'hudi'                                    ," +
                "       'table.type' = 'MERGE_ON_READ'                           " +
                ")");
    }

}
