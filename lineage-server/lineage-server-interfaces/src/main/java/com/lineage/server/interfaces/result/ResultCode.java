package com.lineage.server.interfaces.result;

/**
 * @description: ResultCode
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/30 9:48 PM
 */
public class ResultCode {
    private ResultCode() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * The constant SUCCESSFUL.
     */
    public static final int SUCCESSFUL = 200;

    /**
     * The constant ERROR.
     */
    public static final int ERROR = 500;

    /**
     * The constant TOKEN_ERROR.
     */
    public static final int TOKEN_ERROR = 600;

    /**
     * The constant TOKEN_NO_PERMISSION.
     */
    public static final int TOKEN_NO_PERMISSION = 601;

    /**
     * The constant NOT_FOUND_EXCEPTION.
     */
    public static final int NOT_FOUND_EXCEPTION = 404;
}
