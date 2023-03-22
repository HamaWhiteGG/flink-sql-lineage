package com.hw.lineage.server.domain.query.catalog;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: CatalogQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class CatalogQuery extends PageOrderCriteria {

    private String catalogName;

    private CatalogType catalogType;
}
