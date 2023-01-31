package com.lineage.server.domain.entity;

import com.lineage.server.domain.types.TaskId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Task
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:43 PM
 */
@Data
@Accessors(chain = true)
public class Task extends BasicDO {
    private TaskId taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private String source;
}
