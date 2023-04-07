package com.hw.lineage.server.infrastructure.persistence.mybatis.handler;

import com.google.common.base.Splitter;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: ListTypeHandler
 * @author: HamaWhite
 */
public class ListTypeHandler extends BaseTypeHandler<List<Long>> {

    private static final String DELIM = ",";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Long> parameter, JdbcType jdbcType) throws SQLException {
        String value = StringUtils.collectionToDelimitedString(parameter, DELIM);
        ps.setString(i, value);
    }

    @Override
    public List<Long> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return Splitter.on(DELIM).splitToList(value).stream().map(Long::valueOf).collect(Collectors.toList());

    }

    @Override
    public List<Long> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return Splitter.on(DELIM).splitToList(value).stream().map(Long::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<Long> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return Splitter.on(DELIM).splitToList(value).stream().map(Long::valueOf).collect(Collectors.toList());
    }
}
