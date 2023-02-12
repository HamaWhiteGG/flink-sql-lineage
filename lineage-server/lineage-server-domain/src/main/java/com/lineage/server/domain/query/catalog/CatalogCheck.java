package com.lineage.server.domain.query.catalog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: CatalogCheck
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 8:43 PM
 */
@Data
public class CatalogCheck {

    @NotNull
    private String catalogName;
}
