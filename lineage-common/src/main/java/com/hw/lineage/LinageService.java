package com.hw.lineage;

import java.util.List;

/**
 * @description: LinageService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 8:39 PM
 */
public interface LinageService {

    /**
     * Parse the field blood relationship of the input SQL
     */
     List<LineageResult> parseFieldLineage(String sql);

    /**
     * Execute the single sql
     */
     void execute(String singleSql);
}
