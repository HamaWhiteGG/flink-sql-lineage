package com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.SqlStatus;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.IntEnumTypeHandler;

/**
 * @description: SqlStatusTypeHandler
 * @author: HamaWhite
 */
public class SqlStatusTypeHandler extends IntEnumTypeHandler<SqlStatus> {
    public SqlStatusTypeHandler() {
        super(SqlStatus.class);
    }
}
