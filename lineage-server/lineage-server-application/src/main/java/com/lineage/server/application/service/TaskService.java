package com.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.lineage.server.application.cqe.command.task.CreateTaskCmd;
import com.lineage.server.application.cqe.command.task.UpdateTaskCmd;
import com.lineage.server.application.cqe.query.task.TaskQuery;
import com.lineage.server.application.dto.TaskDTO;

/**
 * @description: TaskService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 11:29 PM
 */
public interface TaskService {

    Long createTask(CreateTaskCmd createTaskCmd);

    TaskDTO queryTask(Long taskId);

    PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery);

    void deleteTask(Long taskId);

    void updateTask(UpdateTaskCmd updateTaskCmd);

    TaskDTO parseTaskLineage(Long taskId);
}
