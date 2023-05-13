package com.hw.lineage.server.infrastructure.persistence.mybatis.handler;

import com.alibaba.fastjson2.JSON;
import com.hw.lineage.common.model.Property;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @description: PropertyListTypeHandler
 * @author: HamaWhite
 */
public class PropertyListTypeHandler extends BaseTypeHandler<List<Property>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Property> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public List<Property> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseToList(rs.getString(columnName));
    }

    @Override
    public List<Property> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseToList(rs.getString(columnIndex));
    }

    @Override
    public List<Property> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseToList(cs.getString(columnIndex));
    }

    private List<Property> parseToList(String value) {
        if (StringUtils.isEmpty(value)) {
            return Collections.emptyList();
        }
        return JSON.parseArray(value, Property.class);
    }
}
