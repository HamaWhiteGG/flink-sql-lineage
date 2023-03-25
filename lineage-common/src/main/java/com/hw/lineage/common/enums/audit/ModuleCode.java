package com.hw.lineage.common.enums.audit;

import com.hw.lineage.common.enums.basic.StringEnum;

/**
 * @description: ModuleCode
 * @author: HamaWhite
 */
public enum ModuleCode implements StringEnum<ModuleCode> {

    SECURITY("Security"),
    USER("User"),
    ROLE("Role"),
    PERMISSION("Permission"),
    TASK("Task"),
    PLUGIN("Plugin"),
    CATALOG("Catalog"),
    DATABASE("Database"),
    TABLE("Table"),
    STORAGE("Storage"),
    FUNCTION("Function");

    private final String value;

    ModuleCode(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
