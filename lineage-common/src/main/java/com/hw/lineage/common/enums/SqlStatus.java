package com.hw.lineage.common.enums;

import com.hw.lineage.common.enums.basic.IntEnum;

/**
 * @description: SqlStatus
 * @author: HamaWhite
 * @version: 1.0.0
 */
public enum SqlStatus implements IntEnum<SqlStatus> {

    UN_PARSE(0),
    PARSING(1),
    SUCCESS( 2),
    FAILED(3);


    private final int value;

    SqlStatus(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }
}