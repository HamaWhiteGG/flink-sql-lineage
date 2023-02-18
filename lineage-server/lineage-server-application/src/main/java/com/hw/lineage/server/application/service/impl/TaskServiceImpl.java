package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.task.CreateTaskCmd;
import com.hw.lineage.server.application.command.task.UpdateTaskCmd;
import com.hw.lineage.server.application.dto.TaskDTO;
import com.hw.lineage.server.application.service.TaskService;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.entity.Plugin;
import com.hw.lineage.server.domain.entity.Task;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.query.task.TaskCheck;
import com.hw.lineage.server.domain.query.task.TaskQuery;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.repository.PluginRepository;
import com.hw.lineage.server.domain.repository.TaskRepository;
import com.hw.lineage.server.domain.service.TaskDomainService;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import com.hw.lineage.server.domain.vo.TaskId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: TaskServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
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
    public Boolean checkTaskExist(TaskCheck taskCheck) {
        return taskRepository.find(taskCheck.getTaskName());
    }

    @Override
    public PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery) {
        PageInfo<Task> pageInfo = taskRepository.findAll(taskQuery);
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

        lineageFacade.parseLineage(plugin.getPluginName(), task, catalog);
        taskRepository.saveTaskLineage(task);

        return assembler.fromTask(task);
    }
}
