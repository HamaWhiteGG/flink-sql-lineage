package com.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.lineage.server.application.command.task.CreateTaskCmd;
import com.lineage.server.application.command.task.UpdateTaskCmd;
import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.domain.query.task.TaskCheck;
import com.lineage.server.domain.query.task.TaskQuery;

/**
 * @description: TaskService
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface TaskService {

    Long createTask(CreateTaskCmd createTaskCmd);

    TaskDTO queryTask(Long taskId);

    Boolean checkTaskExist(TaskCheck taskCheck);

    PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery);

    void deleteTask(Long taskId);

    void updateTask(UpdateTaskCmd updateTaskCmd);

    TaskDTO parseTaskLineage(Long taskId);
}
