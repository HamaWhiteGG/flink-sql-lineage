package com.lineage.server.infrastructure.repository.impl;

import com.hw.lineage.common.exception.LineageException;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.repository.TaskRepository;
import com.lineage.server.domain.types.TaskId;
import com.lineage.server.infrastructure.persistence.converter.TaskConverter;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
import com.lineage.server.infrastructure.persistence.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description: TaskRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 10:27 PM
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskConverter taskConverter;

    @Override
    public Task find(TaskId taskId) {
        TaskDO taskDO = taskMapper.selectByPrimaryKey(taskId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("taskId [%s] cannot be found", taskId.getValue()))
                );
        return taskConverter.toTask(taskDO);
    }

    @Override
    public Task save(Task task) {
        TaskDO taskDO = taskConverter.fromTask(task);
        if (taskDO.getTaskId() == null) {
            taskMapper.insertSelective(taskDO);
        } else {
            taskMapper.updateByPrimaryKey(taskDO);
        }
        return taskConverter.toTask(taskDO);
    }

    @Override
    public void remove(TaskId taskId) {
        taskMapper.deleteByPrimaryKey(taskId.getValue());
    }
}
