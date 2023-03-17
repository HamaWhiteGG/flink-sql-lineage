package com.hw.lineage.common.enums.audit;

import com.hw.lineage.common.enums.basic.StringEnum;

/**
 * @description: ModuleCode
 * @author: HamaWhite
 * @version: 1.0.0
 */
public enum ModuleCode implements StringEnum<ModuleCode> {

    SECURITIES("Securities"),
    USERS("Users"),
    ROLES("Roles"),
    PERMISSIONS("Permissions"),
    TASKS("Tasks"),
    PLUGINS("Plugins"),
    CATALOGS("Catalogs"),
    DATABASES("Databases"),
    TABLES("Tables"),
    STORAGES("Storages"),
    FUNCTIONS("Functions");

    private final String value;

    ModuleCode(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
