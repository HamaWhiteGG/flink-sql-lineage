package com.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.lineage.server.application.assembler.DtoAssembler;
import com.lineage.server.application.cqe.command.task.CreateTaskCmd;
import com.lineage.server.application.cqe.command.task.UpdateTaskCmd;
import com.lineage.server.application.cqe.query.task.TaskQuery;
import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.application.service.TaskService;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.repository.TaskRepository;
import com.lineage.server.domain.types.TaskId;
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
    public Long createTask(CreateTaskCmd createTaskCmd) {
        Task task = new Task()
                .setTaskName(createTaskCmd.getTaskName())
                .setDescr(createTaskCmd.getDescr())
                .setPluginId(createTaskCmd.getPluginId())
                .setCatalogId(createTaskCmd.getCatalogId());

        task.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        task = repository.save(task);
        return task.getTaskId().getValue();
    }

    @Override
    public TaskDTO queryTask(Long taskId) {
        Task task = repository.find(new TaskId(taskId));
        return DtoAssembler.INSTANCE.fromTask(task);
    }

    @Override
    public PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery) {
        PageInfo<Task> pageInfo = repository.query(taskQuery.getPageNum(), taskQuery.getPageSize());
        return PageUtils.convertPage(pageInfo, DtoAssembler.INSTANCE::fromTask);
    }

    @Override
    public Boolean deleteTask(Long taskId) {
        return repository.remove(new TaskId(taskId));
    }

    @Override
    public Boolean updateTask(UpdateTaskCmd updateTaskCmd) {
        Task task = new Task()
                .setTaskId(new TaskId(updateTaskCmd.getTaskId()))
                .setTaskName(updateTaskCmd.getTaskName())
                .setDescr(updateTaskCmd.getDescr())
                .setPluginId(updateTaskCmd.getPluginId())
                .setCatalogId(updateTaskCmd.getCatalogId());

        task.setModifyTime(System.currentTimeMillis());
        return repository.update(task);
    }
}
