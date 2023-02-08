package com.lineage.server.application.cqe.command.function;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: CreateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:37 PM
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
