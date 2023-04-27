package com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.SqlType;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.StringEnumTypeHandler;

/**
 * @description: SqlTypeHandler
 * @author: HamaWhite
 */
public class SqlTypeHandler extends StringEnumTypeHandler<SqlType> {
    public SqlTypeHandler() {
        super(SqlType.class);
    }
}
