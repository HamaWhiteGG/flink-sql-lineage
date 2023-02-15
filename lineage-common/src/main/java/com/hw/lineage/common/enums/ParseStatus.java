package com.hw.lineage.common.enums;

import com.hw.lineage.common.enums.basic.IntEnum;

/**
 * @description: ParseStatus
 * @author: HamaWhite
 * @version: 1.0.0
 */
public enum ParseStatus implements IntEnum<ParseStatus> {

    UN_PARSE(0),
    PARSING(1),
    SUCCESS(3),
    FAILED(4);


    private final int value;

    ParseStatus(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }
}