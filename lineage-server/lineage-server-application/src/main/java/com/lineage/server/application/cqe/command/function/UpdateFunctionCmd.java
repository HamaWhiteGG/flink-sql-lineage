package com.lineage.server.application.cqe.command.function;

import lombok.Data;

/**
 * @description: UpdateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:38 PM
 */
@Data
public class UpdateFunctionCmd {

    private Long functionId;

    private String functionName;

    private String functionFormat;

    private String functionPath;

    private String functionClass;

    private String descr;
}
