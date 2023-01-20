package com.hw.lineage;

import com.hw.lineage.plugin.Plugin;

import java.util.List;

/**
 * @description: LinageService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 8:39 PM
 */
public interface LineageService extends Plugin {

    /**
     * Parse the field blood relationship of the input SQL
     */
     List<LineageResult> parseFieldLineage(String singleSql);

    /**
     * Execute the single sql
     */
     void execute(String singleSql);
}
