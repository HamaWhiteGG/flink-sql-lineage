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

public final class PermissionDynamicSqlSupport {
    public static final Permission permission = new Permission();

    public static final SqlColumn<Long> permissionId = permission.permissionId;

    public static final SqlColumn<String> permissionGroup = permission.permissionGroup;

    public static final SqlColumn<String> permissionName = permission.permissionName;

    public static final SqlColumn<String> permissionCode = permission.permissionCode;

    public static final SqlColumn<Long> createTime = permission.createTime;

    public static final SqlColumn<Long> modifyTime = permission.modifyTime;

    public static final SqlColumn<Boolean> invalid = permission.invalid;

    public static final class Permission extends AliasableSqlTable<Permission> {
        public final SqlColumn<Long> permissionId = column("`permission_id`", JDBCType.BIGINT);

        public final SqlColumn<String> permissionGroup = column("`permission_group`", JDBCType.VARCHAR);

        public final SqlColumn<String> permissionName = column("`permission_name`", JDBCType.VARCHAR);

        public final SqlColumn<String> permissionCode = column("`permission_code`", JDBCType.VARCHAR);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyTime = column("`modify_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public Permission() {
            super("bas_permission", Permission::new);
        }
    }
}