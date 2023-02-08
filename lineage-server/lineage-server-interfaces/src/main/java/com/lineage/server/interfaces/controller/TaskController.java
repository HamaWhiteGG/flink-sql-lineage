package com.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.lineage.server.application.cqe.command.task.CreateTaskCmd;
import com.lineage.server.application.cqe.command.task.UpdateTaskCmd;
import com.lineage.server.application.cqe.query.task.TaskQuery;
import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.application.service.TaskService;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @description: TaskController
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 8:06 PM
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/{taskId}")
    public Result<TaskDTO> queryTask(@PathVariable("taskId") Long taskId) {
        TaskDTO taskDTO = taskService.queryTask(taskId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, taskDTO);
    }

    @GetMapping("")
    public Result<PageInfo<TaskDTO>> queryTasks(TaskQuery taskQuery) {
        PageInfo<TaskDTO> pageInfo = taskService.queryTasks(taskQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    public Result<Long> createTask(@Valid @RequestBody CreateTaskCmd createTaskCmd) {
        Long taskId = taskService.createTask(createTaskCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, taskId);
    }

    @PutMapping("/{taskId}")
    public Result<Boolean> updateTask(@PathVariable("taskId") Long taskId,
                                      @Valid @RequestBody UpdateTaskCmd updateTaskCmd) {
        updateTaskCmd.setTaskId(taskId);
        taskService.updateTask(updateTaskCmd);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{taskId}")
    public Result<Boolean> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @PostMapping("/{taskId}/lineage")
    public Result<TaskDTO> parseTaskLineage(@PathVariable("taskId") Long taskId) {
        TaskDTO taskDTO = taskService.parseTaskLineage(taskId);
        return Result.success(ResultMessage.PARSE_LINEAGE_SUCCESS, taskDTO);
    }
}
