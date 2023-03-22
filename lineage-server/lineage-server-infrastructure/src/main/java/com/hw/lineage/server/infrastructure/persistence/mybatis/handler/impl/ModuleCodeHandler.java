package com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.StringEnumTypeHandler;

/**
 * @description: ModuleCodeHandler
 * @author: HamaWhite
 */
public class ModuleCodeHandler extends StringEnumTypeHandler<ModuleCode> {
    public ModuleCodeHandler() {
        super(ModuleCode.class);
    }
}
