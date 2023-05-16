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

package com.hw.lineage.server.domain.entity;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.AuditId;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Audit
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
public class Audit implements Entity {

    private AuditId auditId;

    private Long userId;

    private String username;

    private ModuleCode moduleCode;

    private OperationType operationType;

    private String descr;

    /**
     * Request duration
     */
    private Long duration;

    private OperationStatus operationStatus;

    private String ip;

    private Long createTime;

    private Boolean invalid;

    private String method;

    private JSONObject parameters;

    private String exception;
}
