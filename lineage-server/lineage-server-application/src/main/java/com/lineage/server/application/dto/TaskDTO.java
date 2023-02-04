package com.lineage.server.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: TaskDto
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 11:36 AM
 */
@Data
public class TaskDTO implements Serializable {
    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private String taskSource;

    private Long createUserId;

    private Long modifyUserId;

    private Long createTime;

    private Long modifyTime;
}
