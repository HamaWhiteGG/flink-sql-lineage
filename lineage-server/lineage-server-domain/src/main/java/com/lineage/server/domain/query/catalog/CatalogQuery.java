package com.lineage.server.domain.query.catalog;

import com.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;

/**
 * @description: CatalogQuery
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 8:45 PM
 */
@Data
public class CatalogQuery extends PageOrderCriteria {

    private String catalogName;
}
