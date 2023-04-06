package com.hw.lineage.server.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: TaskFunctionDTO
 * @author: HamaWhite
 */
@Data
public class TaskFunctionDTO implements Serializable {

    private Long taskId;

    private Long sqlId;

    private Long functionId;

    private String catalogName;

    private String database;

    private String functionName;

    private Long createTime;

    private Boolean invalid;
}
