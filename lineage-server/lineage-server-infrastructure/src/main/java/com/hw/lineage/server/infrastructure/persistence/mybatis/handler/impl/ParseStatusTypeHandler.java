package com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.common.enums.ParseStatus;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.IntEnumTypeHandler;

/**
 * @description: ParseStatusTypeHandler
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class ParseStatusTypeHandler extends IntEnumTypeHandler<ParseStatus> {
    public ParseStatusTypeHandler() {
        super(ParseStatus.class);
    }
}
