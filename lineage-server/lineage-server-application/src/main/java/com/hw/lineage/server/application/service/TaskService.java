package com.hw.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.task.CreateTaskCmd;
import com.hw.lineage.server.application.command.task.UpdateTaskCmd;
import com.hw.lineage.server.application.dto.TaskDTO;
import com.hw.lineage.server.application.dto.TaskFunctionDTO;
import com.hw.lineage.server.application.dto.TaskSyntaxDTO;
import com.hw.lineage.server.domain.query.task.TaskCheck;
import com.hw.lineage.server.domain.query.task.TaskFunctionQuery;
import com.hw.lineage.server.domain.query.task.TaskQuery;

/**
 * @description: TaskService
 * @author: HamaWhite
 */
public interface TaskService {

    Long createTask(CreateTaskCmd command);

    TaskDTO queryTask(Long taskId);

    Boolean checkTaskExist(TaskCheck taskCheck);

    PageInfo<TaskDTO> queryTasks(TaskQuery taskQuery);

    PageInfo<TaskFunctionDTO> queryTaskFunctions(TaskFunctionQuery query);

    void deleteTask(Long taskId);

    void updateTask(UpdateTaskCmd command);

    TaskDTO analyzeTaskLineage(Long taskId);

    TaskSyntaxDTO checkTaskSyntax(Long taskId);
}
