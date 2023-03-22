package com.hw.lineage.common.enums;

import com.hw.lineage.common.enums.basic.StringEnum;

/**
 * @description: SqlType
 * @author: HamaWhite
 * @version: 1.0.0
 */
public enum SqlType implements StringEnum<SqlType> {
    SELECT("select"),
    CREATE("create"),
    DROP("drop"),
    ALTER("alter"),
    INSERT("insert"),
    ANALYZE("analyze"),
    DESCRIBE("describe"),
    EXPLAIN("explain"),
    USE("use"),
    SHOW("show"),
    LOAD("load"),
    UNLOAD("unload"),
    SET("set"),
    RESET("reset"),
    JAR("jar");

    private final String value;

    SqlType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
