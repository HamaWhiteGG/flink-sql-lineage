package com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.audit.OperationType;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.StringEnumTypeHandler;

/**
 * @description: OperationTypeHandler
 * @author: HamaWhite
 */
public class OperationTypeHandler extends StringEnumTypeHandler<OperationType> {
    public OperationTypeHandler() {
        super(OperationType.class);
    }
}
