package com.hw.lineage.server.application.command.catalog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateTableCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CreateTableCmd {

    @NotNull
    private Long catalogId;

    @NotBlank
    private String database;

    @NotBlank
    private String createSql;
}
