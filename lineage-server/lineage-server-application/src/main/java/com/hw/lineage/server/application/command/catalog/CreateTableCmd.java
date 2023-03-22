package com.hw.lineage.server.application.command.catalog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: CreateTableCmd
 * @author: HamaWhite
 */
@Data
public class CreateTableCmd implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long catalogId;

    @ApiModelProperty(hidden = true)
    private String database;

    @NotBlank
    private String ddl;
}
