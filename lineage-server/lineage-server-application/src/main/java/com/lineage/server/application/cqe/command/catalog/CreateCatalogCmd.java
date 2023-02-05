package com.lineage.server.application.cqe.command.catalog;

import com.hw.lineage.common.enums.CatalogType;
import lombok.Data;

/**
 * @description: CreateCatalogCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:32 PM
 */
@Data
public class CreateCatalogCmd {

    private String catalogName;

    private CatalogType catalogType;

    private String defaultDatabase;

    private String descr;
}
