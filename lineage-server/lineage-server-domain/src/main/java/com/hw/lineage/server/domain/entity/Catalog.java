package com.hw.lineage.server.domain.entity;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.server.domain.entity.basic.BasicEntity;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.CatalogId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Catalog
 * @author: HamaWhite
 * @version: 1.0.0
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
