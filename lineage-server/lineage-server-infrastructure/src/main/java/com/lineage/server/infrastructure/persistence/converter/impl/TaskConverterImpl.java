package com.lineage.server.infrastructure.persistence.converter.impl;

import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.types.TaskId;
import com.lineage.server.infrastructure.persistence.converter.TaskConverter;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
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
        Task task = new Task()
                .setTaskId(new TaskId(taskDO.getTaskId()))
                .setTaskName(taskDO.getTaskName())
                .setDescr(taskDO.getDescr())
                .setPluginId(taskDO.getPluginId())
                .setCatalogId(taskDO.getCatalogId())
                .setSource(taskDO.getSource());

        task.setCreateUserId(taskDO.getCreateUserId())
                .setModifyUserId(taskDO.getModifyUserId())
                .setCreateTime(taskDO.getCreateTime())
                .setModifyTime(taskDO.getModifyTime())
                .setInvalid(task.getInvalid());
        return task;
    }

    @Override
    public TaskDO fromTask(Task task) {
        TaskDO taskDO = new TaskDO();
        if (task.getTaskId() != null) {
            taskDO.setTaskId(task.getTaskId().getValue());
        }
        taskDO.setTaskName(task.getTaskName());
        taskDO.setDescr(task.getDescr());
        taskDO.setPluginId(task.getPluginId());
        taskDO.setCatalogId(task.getCatalogId());
        taskDO.setSource(task.getSource());
        taskDO.setCreateUserId(task.getCreateUserId());
        taskDO.setModifyUserId(task.getModifyUserId());
        taskDO.setCreateTime(task.getCreateTime());
        taskDO.setModifyTime(task.getModifyTime());
        return taskDO;
    }
}
