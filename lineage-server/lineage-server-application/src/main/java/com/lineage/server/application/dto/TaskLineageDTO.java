package com.lineage.server.application.dto;

import lombok.Data;

/**
 * @description: TaskLineageDTO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/7 11:55 PM
 */
@Data
public class TaskLineageDTO {

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