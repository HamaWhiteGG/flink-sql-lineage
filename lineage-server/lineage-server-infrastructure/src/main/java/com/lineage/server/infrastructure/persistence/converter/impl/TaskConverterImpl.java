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
                .taskId(new TaskId(taskDO.getTaskId()))
                .taskName(taskDO.getTaskName())
                .descr(taskDO.getDescr())
                .pluginId(taskDO.getPluginId())
                .catalogId(taskDO.getCatalogId())
                .source(taskDO.getSource());

        task.createUserId(taskDO.getCreateUserId())
                .modifyUserId(taskDO.getModifyUserId())
                .createTime(taskDO.getCreateTime())
                .modifyTime(taskDO.getModifyTime());
        return task;
    }

    @Override
    public TaskDO fromTask(Task task) {
        TaskDO taskDO = new TaskDO();
        if (task.taskId() != null) {
            taskDO.setTaskId(task.taskId().getValue());
        }
        taskDO.setTaskName(task.taskName());
        taskDO.setDescr(task.descr());
        taskDO.setPluginId(task.pluginId());
        taskDO.setCatalogId(task.catalogId());
        taskDO.setSource(task.source());
        taskDO.setCreateUserId(task.createUserId());
        taskDO.setModifyUserId(task.modifyUserId());
        taskDO.setCreateTime(task.createTime());
        taskDO.setModifyTime(task.modifyTime());
        return taskDO;
    }
}
