package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.task.CreateTaskCmd;
import com.hw.lineage.server.application.command.task.UpdateTaskCmd;
import com.hw.lineage.server.application.dto.TaskDTO;
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

import static com.hw.lineage.common.enums.audit.ModuleCode.TASKS;
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
    @AuditLog(module = TASKS, type = QUERY, descr = "'Query Task: ' + @taskService.queryTask(#taskId).taskName")
    public Result<TaskDTO> queryTask(@PathVariable("taskId") Long taskId) {
        TaskDTO taskDTO = taskService.queryTask(taskId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, taskDTO);
    }

    @GetMapping("")
    @AuditLog(module = TASKS, type = QUERY, descr = "'Query Tasks'")
    public Result<PageInfo<TaskDTO>> queryTasks(TaskQuery taskQuery) {
        PageInfo<TaskDTO> pageInfo = taskService.queryTasks(taskQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @AuditLog(module = TASKS, type = CREATE, descr = "'Create Task: ' + #command.taskName")
    public Result<Long> createTask(@Valid @RequestBody CreateTaskCmd command) {
        Long taskId = taskService.createTask(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, taskId);
    }

    @GetMapping("/exist")
    @AuditLog(module = TASKS, type = QUERY, descr = "'Check Task Exist'")
    public Result<Boolean> checkTaskExist(@Valid TaskCheck taskCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, taskService.checkTaskExist(taskCheck));
    }

    @PutMapping("/{taskId}")
    @AuditLog(module = TASKS, type = UPDATE, descr = "'Update Task: ' + @taskService.queryTask(#taskId).taskName")
    public Result<Boolean> updateTask(@PathVariable("taskId") Long taskId,
                                      @Valid @RequestBody UpdateTaskCmd command) {
        command.setTaskId(taskId);
        taskService.updateTask(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{taskId}")
    @AuditLog(module = TASKS, type = DELETE, descr = "'Delete Task: ' + @taskService.queryTask(#taskId).taskName")
    public Result<Boolean> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @PostMapping("/{taskId}/lineage")
    @AuditLog(module = TASKS, type = CREATE, descr = "'Parse Lineage: ' + @taskService.queryTask(#taskId).taskName")
    public Result<TaskDTO> parseTaskLineage(@PathVariable("taskId") Long taskId) {
        TaskDTO taskDTO = taskService.parseTaskLineage(taskId);
        return Result.success(ResultMessage.PARSE_LINEAGE_SUCCESS, taskDTO);
    }
}
