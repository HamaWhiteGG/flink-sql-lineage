package com.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.CatalogType;
import com.lineage.server.infrastructure.persistence.mybatis.handler.IntEnumTypeHandler;

/**
 * @description: CatalogTypeHandler
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class CatalogTypeHandler extends IntEnumTypeHandler<CatalogType> {
    public CatalogTypeHandler() {
        super(CatalogType.class);
    }
}
