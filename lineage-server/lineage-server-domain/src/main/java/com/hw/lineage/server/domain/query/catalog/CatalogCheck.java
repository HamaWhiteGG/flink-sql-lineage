package com.hw.lineage.server.domain.query.catalog;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: CatalogCheck
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CatalogCheck implements Serializable {

    @NotNull
    private String catalogName;
}
