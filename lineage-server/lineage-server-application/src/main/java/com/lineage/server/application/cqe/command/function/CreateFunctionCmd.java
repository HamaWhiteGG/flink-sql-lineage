package com.lineage.server.application.cqe.command.function;

import lombok.Data;

/**
 * @description: CreateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:37 PM
 */
@Data
public class CreateFunctionCmd {

    private String functionName;

    private String functionFormat;

    private String functionPath;

    private String functionClass;

    private String descr;
}
