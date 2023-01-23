package com.lineage.server.infrastructure.persistence;

import lombok.Data;

/**
 * @description: TaskDo
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:19 PM
 */
@Data
public class TaskDO extends BasicDO {
    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;
}
