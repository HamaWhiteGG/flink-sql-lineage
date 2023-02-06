package com.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.enums.SqlType;
import com.lineage.server.infrastructure.persistence.mybatis.handler.IntEnumTypeHandler;
import com.lineage.server.infrastructure.persistence.mybatis.handler.StringEnumTypeHandler;

/**
 * @description: SqlTypeHandler
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/6 8:50 PM
 */
public class SqlTypeHandler extends StringEnumTypeHandler<SqlType> {
    public SqlTypeHandler() {
        super(SqlType.class);
    }
}
