package com.hw.lineage.common.enums.audit;

import com.hw.lineage.common.enums.basic.IntEnum;

/**
 * @description: OperationStatus
 * @author: HamaWhite
 * @version: 1.0.0
 */
public enum OperationStatus implements IntEnum<OperationStatus> {

    FAILED(-1),
    SUCCESS(0);

    private final int value;

    OperationStatus(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }
}