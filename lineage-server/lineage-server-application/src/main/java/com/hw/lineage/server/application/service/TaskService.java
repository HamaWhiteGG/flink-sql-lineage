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
