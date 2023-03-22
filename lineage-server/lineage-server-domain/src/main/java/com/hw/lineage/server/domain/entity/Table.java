package com.hw.lineage.server.domain.entity;

import com.hw.lineage.server.domain.entity.basic.BasicEntity;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Table
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Table extends BasicEntity implements Entity {

    private TableId tableId;

    private CatalogId catalogId;

    private String database;

    private String tableName;

    /**
     * Base64 encode
     */
    private String ddl;

    private String descr;
}
