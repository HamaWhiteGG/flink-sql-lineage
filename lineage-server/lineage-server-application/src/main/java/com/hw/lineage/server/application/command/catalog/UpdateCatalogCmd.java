package com.hw.lineage.server.application.command.catalog;

import com.hw.lineage.common.model.Property;
import com.hw.lineage.server.domain.query.BasicCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @description: UpdateCatalogCmd
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class UpdateCatalogCmd extends BasicCriteria {

    @ApiModelProperty(hidden = true)
    private Long catalogId;

    private String catalogName;

    private String defaultDatabase;

    private String descr;

    private List<Property> propertyList;
}
