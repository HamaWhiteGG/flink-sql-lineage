package com.hw.lineage.common;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.plugin.Plugin;

import java.util.List;

/**
 * @description: LinageService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 8:39 PM
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
}
