package com.hw.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.domain.entity.task.Task;
import com.hw.lineage.server.domain.entity.task.TaskFunction;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.entity.task.TaskSql;
import com.hw.lineage.server.domain.query.task.TaskFunctionQuery;
import com.hw.lineage.server.domain.query.task.TaskQuery;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.PluginId;
import com.hw.lineage.server.domain.vo.TaskId;

import java.util.List;

/**
 * @description: TaskRepository
 * @author: HamaWhite
 */
public interface TaskRepository extends Repository<Task, TaskId> {

    PageInfo<Task> findAll(TaskQuery taskQuery);

    /**
     * Design code according to the "Command Query Responsibility Segregation(CQRS)" architecture
     *
     * @param query TaskFunctionQuery
     * @return PageInfo<TaskFunction>
     */
    PageInfo<TaskFunction> findTaskFunctions(TaskFunctionQuery query);

    void saveTaskSql(Task task);

    void saveTaskLineage(Task task);

    void saveTaskFunction(Task task);

    void removeTaskSql(TaskId taskId);

    void removeTaskLineage(TaskId taskId);

    void removeTaskFunction(TaskId taskId);

    List<TaskLineage> findTaskLineages(PluginId pluginId);

    List<TaskSql> findTaskSqls(PluginId pluginId);
}
