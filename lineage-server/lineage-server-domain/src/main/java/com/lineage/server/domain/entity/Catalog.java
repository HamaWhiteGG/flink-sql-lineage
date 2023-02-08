package com.lineage.server.domain.entity;

import com.hw.lineage.common.enums.CatalogType;
import com.lineage.server.domain.entity.basic.BasicEntity;
import com.lineage.server.domain.repository.basic.Entity;
import com.lineage.server.domain.vo.CatalogId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Catalog
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 11:55 PM
 */
@Data
@Accessors(chain = true)
public class Catalog extends BasicEntity implements Entity {

    private CatalogId catalogId;

    private String catalogName;

    private CatalogType catalogType;

    private String defaultDatabase;

    private String descr;
}
