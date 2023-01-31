package com.hw.lineage.common.enums;


import com.hw.lineage.common.enums.basic.IntEnum;

/**
 * @description: CatalogType
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 9:51 AM
 */
public enum CatalogType implements IntEnum<CatalogType> {

    MEMORY(0),
    HIVE(1),
    JDBC(2),
    ;

    private final int value;

    CatalogType(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }
}
