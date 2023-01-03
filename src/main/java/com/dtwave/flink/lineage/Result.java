package com.dtwave.flink.lineage;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * @description: Result
 * @author: baisong
 * @version: 1.0.0
 * @date: 2022/8/7 12:48 AM
 */
@Data
@Builder
public class Result {

    private String sourceCatalog;

    private String sourceDatabase;

    private String sourceTable;

    private String sourceColumn;

    private String targetCatalog;

    private String targetDatabase;

    private String targetTable;

    private String targetColumn;

    /**
     * Stores the expression for data conversion,
     * which source table fields are transformed by which expression the target field
     */
    private String transform;

}
