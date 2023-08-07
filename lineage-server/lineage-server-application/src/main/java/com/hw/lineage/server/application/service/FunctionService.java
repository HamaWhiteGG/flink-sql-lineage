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
import com.hw.lineage.common.model.FunctionInfo;
import com.hw.lineage.server.application.command.function.CreateFunctionCmd;
import com.hw.lineage.server.application.command.function.ParseFunctionCmd;
import com.hw.lineage.server.application.command.function.UpdateFunctionCmd;
import com.hw.lineage.server.application.dto.FunctionDTO;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.query.function.FunctionTaskQuery;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;

import java.io.IOException;
import java.util.List;

/**
 * @description: FunctionService
 * @author: HamaWhite
 */
public interface FunctionService {

    Long createFunction(CreateFunctionCmd command);

    FunctionDTO queryFunction(Long functionId);

    Boolean checkFunctionExist(FunctionCheck functionCheck);

    PageInfo<FunctionDTO> queryFunctions(FunctionQuery functionQuery);

    PageInfo<FunctionTaskDTO> queryFunctionTasks(FunctionTaskQuery query);

    void deleteFunction(Long catalogId, String database, Long functionId);

    void updateFunction(UpdateFunctionCmd command);

    /**
     * Parse the function name, function format, function main class and description from the jar file
     */
    List<FunctionInfo> parseFunction(ParseFunctionCmd command) throws IOException, ClassNotFoundException;

    /**
     * Create the functions of memory type catalog to flink when the application start
     */
    void createMemoryFunctions();
}
