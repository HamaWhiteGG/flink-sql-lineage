package com.hw.lineage.server.application.command.catalog;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.model.Property;
import com.hw.lineage.server.domain.query.BasicCriteria;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: CreateCatalogCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class CreateCatalogCmd extends BasicCriteria {

    @NotNull
    private Long pluginId;

    @NotBlank
    private String catalogName;

    @NotNull
    private CatalogType catalogType;

    @NotBlank
    private String defaultDatabase;

    private String descr;

    private List<Property> propertyList;

    private Boolean defaultCatalog;
}
