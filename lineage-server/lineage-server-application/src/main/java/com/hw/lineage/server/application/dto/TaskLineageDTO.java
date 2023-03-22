package com.hw.lineage.server.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: TaskLineageDTO
 * @author: HamaWhite
 */
@Data
public class TaskLineageDTO implements Serializable {
    private Long taskId;

    private Integer sqlId;

    private String sourceCatalog;

    private String sourceDatabase;

    private String sourceTable;

    private String sourceColumn;

    private String targetCatalog;

    private String targetDatabase;

    private String targetTable;

    private String targetColumn;

    private String transform;
}
