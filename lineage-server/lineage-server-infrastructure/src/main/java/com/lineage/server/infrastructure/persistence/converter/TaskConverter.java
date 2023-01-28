package com.lineage.server.infrastructure.persistence.converter;

import com.lineage.server.domain.entity.Task;
import com.lineage.server.infrastructure.persistence.model.TaskDO;

/**
 * @description: TaskBuilder
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:20 PM
 */
public interface TaskConverter {

    Task toTask(TaskDO taskDO);

    TaskDO fromTask(Task task);
}
