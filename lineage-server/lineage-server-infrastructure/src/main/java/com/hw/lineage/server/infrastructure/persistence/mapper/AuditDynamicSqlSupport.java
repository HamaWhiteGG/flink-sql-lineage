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

package com.hw.lineage.server.infrastructure.persistence.mapper;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AuditDynamicSqlSupport {
    public static final Audit audit = new Audit();

    public static final SqlColumn<Long> auditId = audit.auditId;

    public static final SqlColumn<Long> userId = audit.userId;

    public static final SqlColumn<String> username = audit.username;

    public static final SqlColumn<ModuleCode> moduleCode = audit.moduleCode;

    public static final SqlColumn<OperationType> operationType = audit.operationType;

    public static final SqlColumn<String> descr = audit.descr;

    /**
     * Request duration
     */
    public static final SqlColumn<Long> duration = audit.duration;

    public static final SqlColumn<OperationStatus> operationStatus = audit.operationStatus;

    public static final SqlColumn<String> method = audit.method;

    public static final SqlColumn<String> ip = audit.ip;

    public static final SqlColumn<Long> createTime = audit.createTime;

    public static final SqlColumn<Boolean> invalid = audit.invalid;

    public static final SqlColumn<JSONObject> parameters = audit.parameters;

    public static final SqlColumn<String> exception = audit.exception;

    public static final class Audit extends AliasableSqlTable<Audit> {
        public final SqlColumn<Long> auditId = column("`audit_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("`user_id`", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("`username`", JDBCType.VARCHAR);

        public final SqlColumn<ModuleCode> moduleCode = column("`module_code`", JDBCType.VARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.ModuleCodeHandler");

        public final SqlColumn<OperationType> operationType = column("`operation_type`", JDBCType.VARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.OperationTypeHandler");

        public final SqlColumn<String> descr = column("`descr`", JDBCType.VARCHAR);

        public final SqlColumn<Long> duration = column("`duration`", JDBCType.BIGINT);

        public final SqlColumn<OperationStatus> operationStatus = column("`operation_status`", JDBCType.TINYINT, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.OperationStatusTypeHandler");

        public final SqlColumn<String> method = column("`method`", JDBCType.VARCHAR);

        public final SqlColumn<String> ip = column("`ip`", JDBCType.VARCHAR);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public final SqlColumn<JSONObject> parameters = column("`parameters`", JDBCType.LONGVARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.JsonTypeHandler");

        public final SqlColumn<String> exception = column("`exception`", JDBCType.LONGVARCHAR);

        public Audit() {
            super("bas_audit", Audit::new);
        }
    }
}