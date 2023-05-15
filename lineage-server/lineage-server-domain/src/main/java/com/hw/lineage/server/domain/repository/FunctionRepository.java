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
import com.hw.lineage.server.domain.entity.Function;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionEntry;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.query.function.FunctionTaskQuery;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.FunctionId;

import java.util.List;

/**
 * @description: FunctionRepository
 * @author: HamaWhite
 */
public interface FunctionRepository extends Repository<Function, FunctionId> {

    Function find(CatalogId catalogId, String database, String functionName);

    PageInfo<Function> findAll(FunctionQuery functionQuery);

    PageInfo<FunctionTaskDTO> findFunctionTasks(FunctionTaskQuery query);

    boolean check(FunctionCheck functionCheck);

    FunctionEntry findEntry(FunctionId functionId);

    List<Function> findMemory();
}