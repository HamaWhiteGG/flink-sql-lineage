package com.lineage.server.interfaces.controller;

import com.lineage.server.application.cqe.command.task.CreateTaskCmd;
import com.lineage.server.application.cqe.command.task.UpdateTaskCmd;
import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.application.service.TaskService;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public Result<TaskDTO> queryTask(@PathVariable("taskId") final Long taskId) {
        TaskDTO taskDTO = taskService.queryTask(taskId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, taskDTO);
    }

    @GetMapping("")
    public List<TaskDTO> queryTasks() {
        return null;
    }

    @PostMapping("")
    public Result<Long> createTask(@RequestBody final CreateTaskCmd createTaskCmd) {
        Long taskId = taskService.createTask(createTaskCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, taskId);
    }

    @PutMapping("/{taskId}")
    public TaskDTO updateTask(@PathVariable("taskId") final Long taskId,
                              @RequestBody final UpdateTaskCmd updateTaskCmd) {
        return null;
    }

    @DeleteMapping("/{taskId}")
    public boolean deleteTask(@PathVariable("taskId") final Long taskId) {
        return false;
    }
}
