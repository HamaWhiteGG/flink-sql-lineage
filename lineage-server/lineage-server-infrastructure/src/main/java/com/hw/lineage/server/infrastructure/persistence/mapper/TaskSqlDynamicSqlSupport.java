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

import com.hw.lineage.common.enums.SqlStatus;
import com.hw.lineage.common.enums.SqlType;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TaskSqlDynamicSqlSupport {
    public static final TaskSql taskSql = new TaskSql();

    public static final SqlColumn<Long> sqlId = taskSql.sqlId;

    public static final SqlColumn<Long> taskId = taskSql.taskId;

    public static final SqlColumn<SqlType> sqlType = taskSql.sqlType;

    public static final SqlColumn<Long> startLineNumber = taskSql.startLineNumber;

    public static final SqlColumn<SqlStatus> sqlStatus = taskSql.sqlStatus;

    public static final SqlColumn<Boolean> invalid = taskSql.invalid;

    /**
     * Base64 encode
     */
    public static final SqlColumn<String> sqlSource = taskSql.sqlSource;

    public static final class TaskSql extends AliasableSqlTable<TaskSql> {
        public final SqlColumn<Long> sqlId = column("`sql_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> taskId = column("`task_id`", JDBCType.BIGINT);

        public final SqlColumn<SqlType> sqlType = column("`sql_type`", JDBCType.VARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.SqlTypeHandler");

        public final SqlColumn<Long> startLineNumber = column("`start_line_number`", JDBCType.BIGINT);

        public final SqlColumn<SqlStatus> sqlStatus = column("`sql_status`", JDBCType.TINYINT, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.SqlStatusTypeHandler");

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public final SqlColumn<String> sqlSource = column("`sql_source`", JDBCType.LONGVARCHAR);

        public TaskSql() {
            super("rel_task_sql", TaskSql::new);
        }
    }
}