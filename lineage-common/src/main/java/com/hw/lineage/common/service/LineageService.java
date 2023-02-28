package com.hw.lineage.common.service;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.plugin.Plugin;
import com.hw.lineage.common.result.FunctionResult;
import com.hw.lineage.common.result.LineageResult;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description: LinageService
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface LineageService extends Plugin {

    /**
     * Set the catalog information, the flink plugin defaults to GenericInMemoryCatalog
     */
    void setCatalog(CatalogType catalogType, String catalogName, String defaultDatabase, String... args);

    /**
     * Parse the field blood relationship of the input SQL
     */
    List<LineageResult> parseFieldLineage(String singleSql);

    /**
     * Execute the single sql
     */
    void execute(String singleSql);

    /**
     * Parse the function name, function format, function main class and description from the jar file
     */
    List<FunctionResult> parseFunction(File file) throws IOException, ClassNotFoundException;

//    /**
//     * Get the names of all databases in this catalog.
//     *
//     * @return a list of the names of all databases
//     */
//    List<String> listDatabases() throws RuntimeException;
//
//    /**
//     * Get names of all tables and views under this database. An empty list is returned if none
//     * exists.
//     *
//     * @return a list of the names of all tables and views in this database
//     */
//    List<String> listTables(String databaseName) throws Exception;
//
//    /**
//     * Get names of all views under this database. An empty list is returned if none exists.
//     *
//     * @param databaseName the name of the given database
//     * @return a list of the names of all views in the given database
//     */
//    List<String> listViews(String databaseName) throws Exception;
//
//    /**
//     * Reads a registered table and returns the tableResult.
//     */
//    TableResult getTable(String catalogName,String database,String tableName);
}
