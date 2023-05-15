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

package com.hw.lineage.server.domain.facade;

import com.hw.lineage.common.model.FunctionInfo;
import com.hw.lineage.common.model.TableInfo;
import com.hw.lineage.server.domain.entity.task.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @description: LineageFacade
 * @author: HamaWhite
 */
public interface LineageFacade {

    void analyze(String pluginCode, String catalogName, Task task);

    void checkSyntax(String pluginCode, String catalogName, Task task);

    List<FunctionInfo> parseFunction(String pluginCode, File file) throws IOException, ClassNotFoundException;

    void createCatalog(String pluginCode, String catalogName, Map<String, String> propertiesMap);

    void deleteCatalog(String pluginCode, String catalogName);

    void useCatalog(String pluginCode, String catalogName);

    void createDatabase(String pluginCode, String catalogName, String database, String comment);

    List<String> listDatabases(String pluginCode, String catalogName);

    void deleteDatabase(String pluginCode, String catalogName, String database);

    void useDatabase(String pluginCode, String catalogName, String database);

    void createTable(String pluginCode, String catalogName, String database, String ddl);

    List<String> listTables(String pluginCode, String catalogName, String database) throws Exception;

    TableInfo getTable(String pluginCode, String catalogName, String database, String tableName);

    String getTableDdl(String pluginCode, String catalogName, String database, String tableName) throws Exception;

    List<String> listViews(String pluginCode, String catalogName, String database) throws Exception;

    void deleteTable(String pluginCode, String catalogName, String database, String tableName) throws Exception;

    void createFunction(String pluginCode, String catalogName, String database, String functionName, String className,
            String functionPath);

    void deleteFunction(String pluginCode, String catalogName, String database, String functionName);

}
