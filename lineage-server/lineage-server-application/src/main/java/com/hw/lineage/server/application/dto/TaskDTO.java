package com.hw.lineage.server.application.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: TaskDto
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class TaskDTO extends BasicDTO {
    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private String taskSource;

    private List<TaskSqlDTO> taskSqlList;

    private List<TaskLineageDTO> taskLineageList;
}
