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

public final class RolePermissionDynamicSqlSupport {
    public static final RolePermission rolePermission = new RolePermission();

    public static final SqlColumn<Long> rid = rolePermission.rid;

    public static final SqlColumn<Long> roleId = rolePermission.roleId;

    public static final SqlColumn<Long> permissionId = rolePermission.permissionId;

    public static final SqlColumn<Boolean> invalid = rolePermission.invalid;

    public static final class RolePermission extends AliasableSqlTable<RolePermission> {
        public final SqlColumn<Long> rid = column("`rid`", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("`role_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> permissionId = column("`permission_id`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public RolePermission() {
            super("rel_role_permission", RolePermission::new);
        }
    }
}