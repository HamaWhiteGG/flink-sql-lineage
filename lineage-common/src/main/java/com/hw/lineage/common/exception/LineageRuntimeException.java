package com.hw.lineage.common.exception;

/**
 * @description: LineageRuntimeException
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 9:21 PM
 */
public class LineageRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 193141189399279147L;

    /**
     * Creates a new Exception with the given message and null as the cause.
     *
     * @param message The exception message
     */
    public LineageRuntimeException(String message) {
        super(message);
    }

    /**
     * Creates a new exception with a null message and the given cause.
     *
     * @param cause The exception that caused this exception
     */
    public LineageRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new exception with the given message and cause.
     *
     * @param message The exception message
     * @param cause   The exception that caused this exception
     */
    public LineageRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
