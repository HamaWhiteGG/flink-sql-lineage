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

package com.hw.lineage.server.infrastructure.persistence.mapper.custom;

import com.hw.lineage.server.domain.query.catalog.CatalogEntry;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.Optional;

/**
 * @description: CustomCatalogMapper
 * @author: HamaWhite
 */
@Mapper
public interface CustomCatalogMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "CatalogEntryResult", value = {
            @Result(column = "plugin_id", property = "pluginId", jdbcType = JdbcType.BIGINT),
            @Result(column = "plugin_code", property = "pluginCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "catalog_id", property = "catalogId", jdbcType = JdbcType.BIGINT),
            @Result(column = "catalog_name", property = "catalogName", jdbcType = JdbcType.VARCHAR)
    })
    Optional<CatalogEntry> selectOne(SelectStatementProvider selectStatement);
}