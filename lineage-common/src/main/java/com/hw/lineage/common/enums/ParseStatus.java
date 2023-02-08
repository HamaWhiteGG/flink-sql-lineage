package com.hw.lineage.common.enums;

import com.hw.lineage.common.enums.basic.IntEnum;

/**
 * @description: ParseStatus
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 8:20 PM
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