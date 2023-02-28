package com.hw.lineage.server.application.command.function;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdateFunctionCmd {

    @NotNull
    private Long functionId;

    private String invocation;

    private String descr;
}
