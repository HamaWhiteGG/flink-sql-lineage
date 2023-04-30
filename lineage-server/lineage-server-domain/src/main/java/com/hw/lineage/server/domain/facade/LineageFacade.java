package com.hw.lineage.server.domain.facade;

import com.hw.lineage.common.result.FunctionInfo;
import com.hw.lineage.common.result.TableInfo;
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

    void createFunction(String pluginCode, String catalogName, String database, String functionName
            , String className, String functionPath);

    void deleteFunction(String pluginCode, String catalogName, String database, String functionName);

}
