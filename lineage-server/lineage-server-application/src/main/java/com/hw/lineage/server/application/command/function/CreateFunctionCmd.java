package com.hw.lineage.server.application.command.function;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CreateFunctionCmd {
    @NotNull
    private Long catalogId;

    @NotBlank
    private String functionName;

    private String database;

    private String invocation;

    @NotBlank
    private String functionPath;

    @NotBlank
    private String className;

    private String descr;
}
