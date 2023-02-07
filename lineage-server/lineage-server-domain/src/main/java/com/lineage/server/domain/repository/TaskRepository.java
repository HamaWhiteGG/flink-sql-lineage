package com.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.repository.basic.Repository;
import com.lineage.server.domain.vo.TaskId;

/**
 * @description: TaskRepository
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:21 PM
 */
public interface TaskRepository extends Repository<Task, TaskId> {

    PageInfo<Task> findAll(Integer pageNum, Integer pageSize);

    void saveTaskSql(Task task);

    void saveTaskLineage(Task task);

    void removeTaskSql(TaskId taskId);

    void removeTaskLineage(TaskId taskId);
}
