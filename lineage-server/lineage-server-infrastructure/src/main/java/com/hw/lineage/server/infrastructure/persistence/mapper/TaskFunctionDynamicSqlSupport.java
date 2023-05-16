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

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;

public final class TaskFunctionDynamicSqlSupport {
    public static final TaskFunction taskFunction = new TaskFunction();

    public static final SqlColumn<Long> rid = taskFunction.rid;

    public static final SqlColumn<Long> taskId = taskFunction.taskId;

    public static final SqlColumn<Long> sqlId = taskFunction.sqlId;

    public static final SqlColumn<Long> functionId = taskFunction.functionId;

    public static final SqlColumn<String> catalogName = taskFunction.catalogName;

    public static final SqlColumn<String> database = taskFunction.database;

    public static final SqlColumn<String> functionName = taskFunction.functionName;

    public static final SqlColumn<Long> createTime = taskFunction.createTime;

    public static final SqlColumn<Boolean> invalid = taskFunction.invalid;

    public static final class TaskFunction extends AliasableSqlTable<TaskFunction> {
        public final SqlColumn<Long> rid = column("`rid`", JDBCType.BIGINT);

        public final SqlColumn<Long> taskId = column("`task_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> sqlId = column("`sql_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> functionId = column("`function_id`", JDBCType.BIGINT);

        public final SqlColumn<String> catalogName = column("`catalog_name`", JDBCType.VARCHAR);

        public final SqlColumn<String> database = column("`database`", JDBCType.VARCHAR);

        public final SqlColumn<String> functionName = column("`function_name`", JDBCType.VARCHAR);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public TaskFunction() {
            super("rel_task_function", TaskFunction::new);
        }
    }
}