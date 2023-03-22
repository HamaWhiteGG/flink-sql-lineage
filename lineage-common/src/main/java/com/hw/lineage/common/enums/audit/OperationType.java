package com.hw.lineage.common.enums.audit;

import com.hw.lineage.common.enums.basic.StringEnum;

/**
 * @description: OperationType
 * @author: HamaWhite
 */
public enum OperationType  implements StringEnum<OperationType> {

    LOGIN("Login"),
    LOGOUT("Logout"),
    CREATE("Create"),
    DELETE("Delete"),
    UPDATE("Update"),
    QUERY("Query"),
    UPLOAD("Upload"),
    DOWNLOAD("Download"),
    PARSE("Parse");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
