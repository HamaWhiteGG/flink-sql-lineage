package com.hw.lineage.server.domain.query.function;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: FunctionCheck
 * @author: HamaWhite
 */
@Data
public class FunctionCheck implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long catalogId;

    @ApiModelProperty(hidden = true)
    private String database;

    @NotNull
    private String functionName;
}
