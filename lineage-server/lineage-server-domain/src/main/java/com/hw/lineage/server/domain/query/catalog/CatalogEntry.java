package com.hw.lineage.server.domain.query.catalog;

import lombok.Data;

/**
 * @description: CatalogEntry
 * @author: HamaWhite
 */
@Data
public class CatalogEntry {
    private String pluginCode;

    private Long catalogId;
    
    private String catalogName;

}
