package com.lineage.server.application.command.function;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: CreateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class
CreateFunctionCmd {

    @NotBlank
    private String functionName;

    private String functionFormat;

    @NotBlank
    private String functionPath;

    @NotBlank
    private String functionClass;

    private String descr;
}
