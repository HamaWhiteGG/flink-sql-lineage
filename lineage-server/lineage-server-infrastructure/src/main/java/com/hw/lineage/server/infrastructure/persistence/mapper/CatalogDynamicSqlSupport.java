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

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.model.Property;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.List;

public final class CatalogDynamicSqlSupport {
    public static final Catalog catalog = new Catalog();

    public static final SqlColumn<Long> catalogId = catalog.catalogId;

    public static final SqlColumn<Long> pluginId = catalog.pluginId;

    public static final SqlColumn<String> catalogName = catalog.catalogName;

    public static final SqlColumn<CatalogType> catalogType = catalog.catalogType;

    public static final SqlColumn<String> defaultDatabase = catalog.defaultDatabase;

    public static final SqlColumn<String> descr = catalog.descr;

    public static final SqlColumn<Boolean> defaultCatalog = catalog.defaultCatalog;

    public static final SqlColumn<Long> createUserId = catalog.createUserId;

    public static final SqlColumn<Long> modifyUserId = catalog.modifyUserId;

    public static final SqlColumn<Long> createTime = catalog.createTime;

    public static final SqlColumn<Long> modifyTime = catalog.modifyTime;

    public static final SqlColumn<Boolean> invalid = catalog.invalid;

    public static final SqlColumn<List<Property>> propertyList = catalog.propertyList;

    public static final class Catalog extends AliasableSqlTable<Catalog> {
        public final SqlColumn<Long> catalogId = column("`catalog_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> pluginId = column("`plugin_id`", JDBCType.BIGINT);

        public final SqlColumn<String> catalogName = column("`catalog_name`", JDBCType.VARCHAR);

        public final SqlColumn<CatalogType> catalogType = column("`catalog_type`", JDBCType.VARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.CatalogTypeHandler");

        public final SqlColumn<String> defaultDatabase = column("`default_database`", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("`descr`", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> defaultCatalog = column("`default_catalog`", JDBCType.BIT);

        public final SqlColumn<Long> createUserId = column("`create_user_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("`modify_user_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyTime = column("`modify_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public final SqlColumn<List<Property>> propertyList = column("`properties`", JDBCType.LONGVARCHAR, "com.hw.lineage.server.infrastructure.persistence.mybatis.handler.PropertyListTypeHandler");

        public Catalog() {
            super("bas_catalog", Catalog::new);
        }
    }
}