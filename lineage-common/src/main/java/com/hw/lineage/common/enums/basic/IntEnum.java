package com.hw.lineage.common.enums.basic;

/**
 * @description: StringEnum
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 9:56 AM
 */
public interface IntEnum<E extends Enum<E>>{
    int value();
}
