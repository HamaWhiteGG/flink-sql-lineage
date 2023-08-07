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

package com.hw.lineage.server.application.dto;

import com.hw.lineage.common.enums.TaskStatus;
import com.hw.lineage.server.application.dto.basic.BasicDTO;
import com.hw.lineage.server.application.dto.graph.LineageGraph;

import lombok.Data;

import java.util.List;

/**
 * @description: TaskDto
 * @author: HamaWhite
 */
@Data
public class TaskDTO extends BasicDTO {

    private Long taskId;

    private Long catalogId;

    private String taskName;

    private String descr;

    private String database;

    private String taskSource;

    private TaskStatus taskStatus;

    private String taskLog;

    private Long lineageTime;

    private List<TaskSqlDTO> taskSqlList;

    private List<TaskFunctionDTO> taskFunctionList;

    private LineageGraph lineageGraph;
}
