package com.lineage.server.domain.query.function;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: FunctionCheck
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 8:51 PM
 */
@Data
public class FunctionCheck {

    @NotNull
    private String functionName;
}
