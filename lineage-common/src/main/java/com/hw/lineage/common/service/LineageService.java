package com.hw.lineage.common.service;

import com.hw.lineage.common.plugin.Plugin;
import com.hw.lineage.common.result.FunctionInfo;
import com.hw.lineage.common.result.FunctionResult;
import com.hw.lineage.common.result.LineageResult;
import com.hw.lineage.common.result.TableInfo;

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
