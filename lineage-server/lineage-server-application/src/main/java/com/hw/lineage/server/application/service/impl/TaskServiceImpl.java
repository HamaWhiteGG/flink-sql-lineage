package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.enums.TaskStatus;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.task.CreateTaskCmd;
import com.hw.lineage.server.application.command.task.UpdateTaskCmd;
import com.hw.lineage.server.application.dto.TaskDTO;
import com.hw.lineage.server.application.dto.TaskFunctionDTO;
import com.hw.lineage.server.application.dto.TaskSyntaxDTO;
import com.hw.lineage.server.application.service.TaskService;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.entity.Function;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskFunction;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.query.task.TaskCheck;
import com.hw.lineage.server.domain.query.task.TaskFunctionQuery;
import com.hw.lineage.server.domain.query.task.TaskQuery;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.repository.FunctionRepository;
import com.hw.lineage.server.domain.repository.TaskRepository;
import com.hw.lineage.server.domain.service.TaskDomainService;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import com.hw.lineage.server.domain.vo.TaskId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: TaskServiceImpl
 * @author: HamaWhite
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskRepository taskRepository;

    @Resource
    private CatalogRepository catalogRepository;

    @Resource
    private FunctionRepository functionRepository;

    @Resource
    private TaskDomainService taskDomainService;

    @Resource
    private LineageFacade lineageFacade;

    @Resource
    private DtoAssembler assembler;

    @Override
    public Long createTask(CreateTaskCmd command) {
        Task task = new Task()
                .setTaskName(command.getTaskName())
                .setCatalogId(new CatalogId(command.getCatalogId()))
                .setDatabase(command.getDatabase())
                .setDescr(command.getDescr())
                .setTaskStatus(TaskStatus.INIT);

        task.setCreateUserId(command.getUserId())
                .setModifyUserId(command.getUserId());

        task.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        task = taskRepository.save(task);
        return task.getTaskId().getValue();
    }

    @Override
    public TaskDTO queryTask(Long taskId) {
        Task task = taskRepository.find(new TaskId(taskId));
        CatalogEntry entry = catalogRepository.findEntry(task.getCatalogId());
        return assembler.fromTask(task, entry.getCatalogName());
    }

    @Override
    public Boolean checkTaskExist(TaskCheck taskCheck) {
        return taskRepository.check(taskCheck.getTaskName());
    }

    @Override
    public PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery) {
        PageInfo<Task> pageInfo = taskRepository.findAll(taskQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromTask);
    }

    @Override
    public PageInfo<TaskFunctionDTO> queryTaskFunctions(TaskFunctionQuery query) {
        PageInfo<TaskFunction> pageInfo = taskRepository.findTaskFunctions(query);
        return PageUtils.convertPage(pageInfo, assembler::fromTaskFunction);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.remove(new TaskId(taskId));
    }

    @Override
    public void updateTask(UpdateTaskCmd command) {
        Task task = new Task()
                .setTaskId(new TaskId(command.getTaskId()))
                .setTaskName(command.getTaskName())
                .setDescr(command.getDescr())
                .setCatalogId(new CatalogId(command.getCatalogId()));

        if (StringUtils.isNotEmpty(command.getSource())) {
            task.setTaskStatus(TaskStatus.MODIFIED);
        }

        task.setModifyUserId(command.getUserId());
        task.setModifyTime(System.currentTimeMillis());
        taskRepository.save(task);
    }

    @Override
    public TaskDTO analyzeTaskLineage(Long taskId) {
        Task task = taskRepository.find(new TaskId(taskId));
        task.clearGraph();

        // split sql
        taskDomainService.generateTaskSql(task);
        // remove task sql, lineage and function
        taskRepository.removeTaskSql(task.getTaskId());
        taskRepository.removeTaskLineage(task.getTaskId());
        taskRepository.removeTaskFunction(task.getTaskId());
        // save split sql
        taskRepository.saveTaskSql(task);

        // analyze lineages and custom functions
        CatalogEntry entry = catalogRepository.findEntry(task.getCatalogId());
        lineageFacade.analyze(entry.getPluginCode(), entry.getCatalogName(), task);

        // save lineages
        taskRepository.saveTaskLineage(task);

        // save custom functions
        addFunctionId(entry.getPluginId(), task.getTaskFunctionList());
        taskRepository.saveTaskFunction(task);

        task.setLineageTime(System.currentTimeMillis());
        taskRepository.save(task);
        return assembler.fromTask(task, entry.getCatalogName());
    }

    private void addFunctionId(Long pluginId, List<TaskFunction> taskFunctionList) {
        taskFunctionList.forEach(e -> {
            Catalog catalog = catalogRepository.find(new PluginId(pluginId), e.getCatalogName());
            Function function = functionRepository.find(catalog.getCatalogId(), e.getDatabase(), e.getFunctionName());
            e.setFunctionId(function.getFunctionId());
        });
    }

    @Override
    public TaskSyntaxDTO checkTaskSyntax(Long taskId) {
        Task task = taskRepository.find(new TaskId(taskId));
        taskDomainService.generateTaskSql(task);

        CatalogEntry entry = catalogRepository.findEntry(task.getCatalogId());
        lineageFacade.checkSyntax(entry.getPluginCode(), entry.getCatalogName(), task);
        return assembler.toTaskSyntaxDTO(task);
    }
}
