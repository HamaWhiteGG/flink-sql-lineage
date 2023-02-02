package com.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.types.TaskId;

/**
 * @description: TaskRepository
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:21 PM
 */
public interface TaskRepository {

    Task find(TaskId taskId);

    Task save(Task task);

    Boolean update(Task task);

    Boolean remove(TaskId taskId);

    PageInfo<Task> query(Integer pageNum, Integer pageSize);

}
