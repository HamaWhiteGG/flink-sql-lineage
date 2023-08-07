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

package com.hw.lineage.common.service;

import com.hw.lineage.common.model.FunctionInfo;
import com.hw.lineage.common.model.FunctionResult;
import com.hw.lineage.common.model.LineageResult;
import com.hw.lineage.common.model.TableInfo;
import com.hw.lineage.common.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @description: LinageService
 * @author: HamaWhite
 */
public interface LineageService extends Plugin {

    /**
     * Analyze the field lineage of the input SQL
     */
    List<LineageResult> analyzeLineage(String singleSql);

    /**
     *  Perform Parse and validate operations on SQL
     */
    void parseValidate(String singleSql);

    /**
     * Execute the single sql
     */
    void execute(String singleSql);

    /**
     * Analyze the custom functions used in this SQL
     */
    Set<FunctionResult> analyzeFunction(String singleSql);

    /**
     * Parse the function name, function format, function main class and description from the jar file
     */
    List<FunctionInfo> parseFunction(File file) throws IOException, ClassNotFoundException;

    /**
     * Get the names of all databases in this catalog.
     */
    List<String> listDatabases(String catalogName);

    /**
     * Get names of all tables and views under this database. An empty list is returned if none exists.
     */
    List<String> listTables(String catalogName, String database) throws Exception;

    /**
     * Get names of all views under this database. An empty list is returned if none exists.
     */
    List<String> listViews(String catalogName, String database) throws Exception;

    /**
     * Reads a registered table and returns the tableResult.
     */
    TableInfo getTable(String catalogName, String database, String tableName) throws Exception;

    String getTableDdl(String catalogName, String database, String tableName) throws Exception;

    void dropTable(String catalogName, String database, String tableName) throws Exception;
}
