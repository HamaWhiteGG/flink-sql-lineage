package com.hw.lineage.server.infrastructure.persistence.mybatis.handler;

import com.hw.lineage.common.util.Base64Utils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: ByteArrayBase64TypeHandler
 * @author: HamaWhite
 */
public class ByteArrayBase64TypeHandler extends BaseTypeHandler<byte[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, byte[] parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, Base64Utils.encodeBytes(parameter));
    }

    @Override
    public byte[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return decodeBytes(rs.getString(columnName));
    }

    @Override
    public byte[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return decodeBytes(rs.getString(columnIndex));
    }

    @Override
    public byte[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return decodeBytes(cs.getString(columnIndex));
    }

    private byte[] decodeBytes(String value) {
        return value != null ? Base64Utils.decodeBytes(value) : new byte[0];
    }
}
