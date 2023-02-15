package com.lineage.server.application.command.catalog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateCatalogCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdateCatalogCmd {

    @NotNull
    private Long catalogId;

    private String catalogName;

    private String defaultDatabase;

    private String descr;
}
