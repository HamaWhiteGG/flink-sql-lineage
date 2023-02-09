package com.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.lineage.server.application.assembler.DtoAssembler;
import com.lineage.server.application.cqe.command.task.CreateTaskCmd;
import com.lineage.server.application.cqe.command.task.UpdateTaskCmd;
import com.lineage.server.application.cqe.query.task.TaskQuery;
import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.application.service.TaskService;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.facade.LineageFacade;
import com.lineage.server.domain.repository.CatalogRepository;
import com.lineage.server.domain.repository.PluginRepository;
import com.lineage.server.domain.repository.TaskRepository;
import com.lineage.server.domain.service.TaskDomainService;
import com.lineage.server.domain.vo.CatalogId;
import com.lineage.server.domain.vo.PluginId;
import com.lineage.server.domain.vo.TaskId;
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
    private TaskRepository taskRepository;

    @Resource
    private CatalogRepository catalogRepository;

    @Resource
    private PluginRepository pluginRepository;

    @Resource
    private TaskDomainService taskDomainService;

    @Resource
    private LineageFacade lineageFacade;
    
    @Resource
    private DtoAssembler assembler;

    @Override
    public Long createTask(CreateTaskCmd createTaskCmd) {
        Task task = new Task()
                .setTaskName(createTaskCmd.getTaskName())
                .setDescr(createTaskCmd.getDescr())
                .setPluginId(new PluginId(createTaskCmd.getPluginId()))
                .setCatalogId(new CatalogId(createTaskCmd.getCatalogId()));

        task.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        task = taskRepository.save(task);
        return task.getTaskId().getValue();
    }

    @Override
    public TaskDTO queryTask(Long taskId) {
        Task task = taskRepository.find(new TaskId(taskId));
        return assembler.fromTask(task);
    }

    @Override
    public PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery) {
        PageInfo<Task> pageInfo = taskRepository.findAll(taskQuery.getPageNum(), taskQuery.getPageSize());
        return PageUtils.convertPage(pageInfo, assembler::fromTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.remove(new TaskId(taskId));
    }

    @Override
    public void updateTask(UpdateTaskCmd updateTaskCmd) {
        Task task = new Task()
                .setTaskId(new TaskId(updateTaskCmd.getTaskId()))
                .setTaskName(updateTaskCmd.getTaskName())
                .setDescr(updateTaskCmd.getDescr())
                .setPluginId(new PluginId(updateTaskCmd.getPluginId()))
                .setCatalogId(new CatalogId(updateTaskCmd.getCatalogId()));

        task.setModifyTime(System.currentTimeMillis());
        taskRepository.save(task);
    }

    @Override
    public TaskDTO parseTaskLineage(Long taskId) {
        Task task = taskRepository.find(new TaskId(taskId));
        Plugin plugin = pluginRepository.find(task.getPluginId());
        Catalog catalog = catalogRepository.find(task.getCatalogId());

        taskRepository.removeTaskLineage(task.getTaskId());
        taskRepository.removeTaskSql(task.getTaskId());

        taskDomainService.buildTaskSql(task);
        taskRepository.saveTaskSql(task);

        lineageFacade.parseLineage(task, plugin.getPluginName(), catalog);
        taskRepository.saveTaskLineage(task);

        return assembler.fromTask(task);
    }
}
