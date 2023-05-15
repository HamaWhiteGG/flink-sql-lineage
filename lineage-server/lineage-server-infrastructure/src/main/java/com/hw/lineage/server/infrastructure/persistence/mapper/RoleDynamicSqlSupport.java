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

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class RoleDynamicSqlSupport {
    public static final Role role = new Role();

    public static final SqlColumn<Long> roleId = role.roleId;

    public static final SqlColumn<String> roleName = role.roleName;

    public static final SqlColumn<Long> createTime = role.createTime;

    public static final SqlColumn<Long> modifyTime = role.modifyTime;

    public static final SqlColumn<Boolean> invalid = role.invalid;

    public static final class Role extends AliasableSqlTable<Role> {
        public final SqlColumn<Long> roleId = column("`role_id`", JDBCType.BIGINT);

        public final SqlColumn<String> roleName = column("`role_name`", JDBCType.VARCHAR);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyTime = column("`modify_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public Role() {
            super("bas_role", Role::new);
        }
    }
}