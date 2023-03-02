package com.hw.lineage.server.application.command.function;

import lombok.Data;

/**
 * @description: UpdateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdateFunctionCmd {

    private Long functionId;

    private String invocation;

    private String descr;
}
