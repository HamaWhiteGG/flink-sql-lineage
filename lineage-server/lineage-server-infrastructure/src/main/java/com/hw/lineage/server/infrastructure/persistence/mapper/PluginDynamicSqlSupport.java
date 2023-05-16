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

public final class PluginDynamicSqlSupport {
    public static final Plugin plugin = new Plugin();

    public static final SqlColumn<Long> pluginId = plugin.pluginId;

    public static final SqlColumn<String> pluginName = plugin.pluginName;

    public static final SqlColumn<String> pluginCode = plugin.pluginCode;

    public static final SqlColumn<String> descr = plugin.descr;

    public static final SqlColumn<Boolean> defaultPlugin = plugin.defaultPlugin;

    public static final SqlColumn<Long> createUserId = plugin.createUserId;

    public static final SqlColumn<Long> modifyUserId = plugin.modifyUserId;

    public static final SqlColumn<Long> createTime = plugin.createTime;

    public static final SqlColumn<Long> modifyTime = plugin.modifyTime;

    public static final SqlColumn<Boolean> invalid = plugin.invalid;

    public static final class Plugin extends AliasableSqlTable<Plugin> {
        public final SqlColumn<Long> pluginId = column("`plugin_id`", JDBCType.BIGINT);

        public final SqlColumn<String> pluginName = column("`plugin_name`", JDBCType.VARCHAR);

        public final SqlColumn<String> pluginCode = column("`plugin_code`", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("`descr`", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> defaultPlugin = column("`default_plugin`", JDBCType.BIT);

        public final SqlColumn<Long> createUserId = column("`create_user_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("`modify_user_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyTime = column("`modify_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public Plugin() {
            super("bas_plugin", Plugin::new);
        }
    }
}