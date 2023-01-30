package com.lineage.server.application.service;

import com.lineage.server.application.cqe.command.task.CreateTaskCmd;

/**
 * @description: TaskService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 11:29 PM
 */
public interface TaskService {

    long createTask(CreateTaskCmd createTaskCmd);
}
