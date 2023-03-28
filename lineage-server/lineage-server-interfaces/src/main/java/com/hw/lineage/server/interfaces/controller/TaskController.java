package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.task.CreateTaskCmd;
import com.hw.lineage.server.application.command.task.UpdateTaskCmd;
import com.hw.lineage.server.application.dto.TaskDTO;
import com.hw.lineage.server.application.dto.TaskSyntaxDTO;
import com.hw.lineage.server.application.service.TaskService;
import com.hw.lineage.server.domain.query.task.TaskCheck;
import com.hw.lineage.server.domain.query.task.TaskQuery;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.hw.lineage.common.enums.audit.ModuleCode.TASK;
import static com.hw.lineage.common.enums.audit.OperationType.*;

/**
 * @description: TaskController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Tasks API")
@RequestMapping("/tasks")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/{taskId}")
    @AuditLog(module = TASK, type = QUERY, descr = "'Query Task: ' + @taskService.queryTask(#taskId).taskName")
    public Result<TaskDTO> queryTask(@PathVariable("taskId") Long taskId) {
        TaskDTO taskDTO = taskService.queryTask(taskId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, taskDTO);
    }

    @GetMapping("")
    @AuditLog(module = TASK, type = QUERY, descr = "'Query Tasks'")
    public Result<PageInfo<TaskDTO>> queryTasks(TaskQuery taskQuery) {
        PageInfo<TaskDTO> pageInfo = taskService.queryTasks(taskQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @AuditLog(module = TASK, type = CREATE, descr = "'Create Task: ' + #command.taskName")
    public Result<Long> createTask(@Valid @RequestBody CreateTaskCmd command) {
        Long taskId = taskService.createTask(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, taskId);
    }

    @GetMapping("/exist")
    @AuditLog(module = TASK, type = QUERY, descr = "'Check Task Exist'")
    public Result<Boolean> checkTaskExist(@Valid TaskCheck taskCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, taskService.checkTaskExist(taskCheck));
    }

    @PutMapping("/{taskId}")
    @AuditLog(module = TASK, type = UPDATE, descr = "'Update Task: ' + @taskService.queryTask(#taskId).taskName")
    public Result<Boolean> updateTask(@PathVariable("taskId") Long taskId,
                                      @Valid @RequestBody UpdateTaskCmd command) {
        command.setTaskId(taskId);
        taskService.updateTask(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{taskId}")
    @AuditLog(module = TASK, type = DELETE, descr = "'Delete Task: ' + @taskService.queryTask(#taskId).taskName")
    public Result<Boolean> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @PostMapping("/{taskId}/lineage")
    @AuditLog(module = TASK, type = ANALYZE_LINEAGE, descr = "'Analyze Lineage: ' + @taskService.queryTask(#taskId).taskName")
    public Result<TaskDTO> analyzeTaskLineage(@PathVariable("taskId") Long taskId) {
        TaskDTO taskDTO = taskService.analyzeTaskLineage(taskId);
        return Result.success(ResultMessage.ANALYZE_LINEAGE_SUCCESS, taskDTO);
    }

    @PostMapping("/{taskId}/syntax")
    @AuditLog(module = TASK, type = CHECK_SYNTAX, descr = "'Check Syntax: ' + @taskService.queryTask(#taskId).taskName")
    public Result<TaskSyntaxDTO> checkTaskSyntax(@PathVariable("taskId") Long taskId) {
        TaskSyntaxDTO taskSyntaxDTO= taskService.checkTaskSyntax(taskId);
        return Result.success(ResultMessage.CHECK_SYNTAX_SUCCESS, taskSyntaxDTO);
    }
}
