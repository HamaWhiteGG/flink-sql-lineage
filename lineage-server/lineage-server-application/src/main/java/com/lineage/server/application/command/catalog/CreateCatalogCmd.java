package com.lineage.server.application.command.catalog;

import com.hw.lineage.common.enums.CatalogType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateCatalogCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:32 PM
 */
@Data
public class CreateCatalogCmd {

    @NotBlank
    private String catalogName;

    @NotNull
    private CatalogType catalogType;

    @NotBlank
    private String defaultDatabase;

    private String descr;
}
