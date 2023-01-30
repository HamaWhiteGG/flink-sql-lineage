package com.lineage.server.application.service.impl;

import com.lineage.server.application.cqe.command.task.CreateTaskCmd;
import com.lineage.server.application.service.TaskService;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: TaskServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 11:29 PM
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskRepository repository;

    @Override
    public long createTask(CreateTaskCmd createTaskCmd) {
        Task task = new Task()
                .taskName(createTaskCmd.getTaskName())
                .descr(createTaskCmd.getDescr())
                .pluginId(createTaskCmd.getPluginId())
                .catalogId(createTaskCmd.getCatalogId());

        task.createTime(System.currentTimeMillis())
                .modifyTime(System.currentTimeMillis());

        task = repository.save(task);
        return task.taskId().getValue();
    }
}
