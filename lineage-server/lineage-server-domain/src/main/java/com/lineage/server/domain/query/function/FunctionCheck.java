package com.lineage.server.domain.query.function;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: FunctionCheck
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class FunctionCheck {

    @NotNull
    private String functionName;
}
