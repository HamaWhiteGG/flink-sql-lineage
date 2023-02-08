package com.lineage.server.application.cqe.command.catalog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateCatalogCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:34 PM
 */
@Data
public class UpdateCatalogCmd {

    @NotNull
    private Long catalogId;

    private String catalogName;

    private String defaultDatabase;

    private String descr;
}
