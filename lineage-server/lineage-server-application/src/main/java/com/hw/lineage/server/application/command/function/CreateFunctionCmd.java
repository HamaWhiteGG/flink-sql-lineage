package com.hw.lineage.server.application.command.function;

import com.hw.lineage.server.domain.query.BasicCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @description: CreateFunctionCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class CreateFunctionCmd extends BasicCriteria {
    @ApiModelProperty(hidden = true)
    private Long catalogId;

    @ApiModelProperty(hidden = true)
    private String database;

    @NotBlank
    private String functionName;

    private String invocation;

    @NotBlank
    private String functionPath;

    @NotBlank
    private String className;

    private String descr;
}
