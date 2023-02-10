package com.lineage.server.domain.vo;

import com.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: CatalogId
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:17 PM
 */
@Data
public class CatalogId implements Identifier {

    private final Long value;

    public CatalogId(Long value) {
        this.value = value;
    }
}
