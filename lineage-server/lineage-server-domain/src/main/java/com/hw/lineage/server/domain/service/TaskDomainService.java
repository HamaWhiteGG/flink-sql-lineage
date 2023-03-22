package com.hw.lineage.server.domain.service;

import com.hw.lineage.server.domain.entity.task.Task;

/**
 * @description: TaskDomainService
 * @author: HamaWhite
 */
public interface TaskDomainService {

    void generateTaskSql(Task task);
}
