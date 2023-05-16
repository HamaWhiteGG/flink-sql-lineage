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

package com.hw.lineage.server.infrastructure.persistence.mybatis.handler;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

/**
 * @description: MapTypeHandler
 * @author: HamaWhite
 */
public class MapTypeHandler extends BaseTypeHandler<Map<String, String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, String> parameter, JdbcType jdbcType)
            throws SQLException {
        if (MapUtils.isNotEmpty(parameter)) {
            String x = JSON.toJSONString(parameter);
            ps.setString(i, x);
        } else {
            ps.setString(i, null);
        }
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseToMap(rs.getString(columnName));
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseToMap(rs.getString(columnIndex));
    }

    @Override
    public Map<String, String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseToMap(cs.getString(columnIndex));
    }

    private Map<String, String> parseToMap(String value) {
        if (StringUtils.isEmpty(value)) {
            return Collections.emptyMap();
        }
        return JSON.parseObject(value, new TypeReference<Map<String, String>>() {
        });
    }
}
