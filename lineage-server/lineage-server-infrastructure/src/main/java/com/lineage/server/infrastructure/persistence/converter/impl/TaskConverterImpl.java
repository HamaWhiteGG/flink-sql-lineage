package com.lineage.server.infrastructure.persistence.converter.impl;

import com.lineage.server.domain.entity.Task;
import com.lineage.server.infrastructure.persistence.converter.TaskConverter;
import com.lineage.server.infrastructure.persistence.model.TaskDO;
import org.springframework.stereotype.Component;

/**
 * @description: TaskConverterImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:33 PM
 */
@Component
public class TaskConverterImpl implements TaskConverter {
    @Override
    public Task toTask(TaskDO taskDO) {
        return null;
    }

    @Override
    public TaskDO fromTask(Task task) {
        return null;
    }
}
