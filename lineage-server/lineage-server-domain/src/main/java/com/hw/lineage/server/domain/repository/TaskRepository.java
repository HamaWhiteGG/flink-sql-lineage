/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
