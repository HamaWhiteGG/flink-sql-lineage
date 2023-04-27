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
    PARSE_FUNCTION("Parse Function"),
    ANALYZE_LINEAGE("Analyze Lineage"),
    CHECK_SYNTAX("Check Syntax");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
