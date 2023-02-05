package com.lineage.server.application.cqe.command.catalog;

import lombok.Data;

/**
 * @description: UpdateCatalogCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:34 PM
 */
@Data
public class UpdateCatalogCmd {

    private Long catalogId;

    private String catalogName;

    private String defaultDatabase;

    private String descr;
}
