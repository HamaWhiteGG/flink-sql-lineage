package com.lineage.server.application.dto;

import com.hw.lineage.common.enums.CatalogType;
import lombok.Data;

/**
 * @description: CatalogDTO
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class CatalogDTO extends BasicDTO {

    private Long catalogId;

    private String catalogName;

    private CatalogType catalogType;

    private String defaultDatabase;

    private String descr;
}
