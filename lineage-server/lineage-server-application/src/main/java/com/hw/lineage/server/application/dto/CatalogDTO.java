package com.hw.lineage.server.application.dto;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.model.Property;
import com.hw.lineage.server.application.dto.basic.BasicDTO;
import lombok.Data;

import java.util.List;

/**
 * @description: CatalogDTO
 * @author: HamaWhite
 */
@Data
public class CatalogDTO extends BasicDTO {

    private Long catalogId;

    private Long pluginId;

    private String catalogName;

    private CatalogType catalogType;

    private String defaultDatabase;

    private String descr;

    private List<Property> propertyList;

    private Boolean defaultCatalog;
}
