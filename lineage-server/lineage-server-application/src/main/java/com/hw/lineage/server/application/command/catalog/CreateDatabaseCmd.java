package com.hw.lineage.server.application.command.catalog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: CreateDatabaseCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CreateDatabaseCmd implements Serializable {
    @ApiModelProperty(hidden = true)
    private Long catalogId;

    @NotBlank
    private String database;

    private String comment;

}
