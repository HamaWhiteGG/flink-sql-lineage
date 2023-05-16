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

public final class UserDynamicSqlSupport {
    public static final User user = new User();

    public static final SqlColumn<Long> userId = user.userId;

    public static final SqlColumn<String> username = user.username;

    public static final SqlColumn<String> password = user.password;

    public static final SqlColumn<Boolean> locked = user.locked;

    public static final SqlColumn<Long> createTime = user.createTime;

    public static final SqlColumn<Long> modifyTime = user.modifyTime;

    public static final SqlColumn<Boolean> invalid = user.invalid;

    public static final SqlColumn<byte[]> avatar = user.avatar;

    public static final class User extends AliasableSqlTable<User> {
        public final SqlColumn<Long> userId = column("`user_id`", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("`username`", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("`password`", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> locked = column("`locked`", JDBCType.BIT);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyTime = column("`modify_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public final SqlColumn<byte[]> avatar = column("`avatar`", JDBCType.LONGVARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.ByteArrayBase64TypeHandler");

        public User() {
            super("bas_user", User::new);
        }
    }
}