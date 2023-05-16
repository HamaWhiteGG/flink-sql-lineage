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

package com.hw.lineage.server.application.command.audit;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import com.hw.lineage.server.domain.query.BasicCriteria;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateAuditCmd
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class CreateAuditCmd extends BasicCriteria {

    @NotBlank
    private String username;

    @NotNull
    private ModuleCode moduleCode;

    @NotNull
    private OperationType operationType;

    @NotNull
    private String descr;

    @NotNull
    private Long duration;

    @NotNull
    private OperationStatus operationStatus;

    @NotBlank
    private String ip;

    private String method;

    private JSONObject parameters;

    private String exception;
}
