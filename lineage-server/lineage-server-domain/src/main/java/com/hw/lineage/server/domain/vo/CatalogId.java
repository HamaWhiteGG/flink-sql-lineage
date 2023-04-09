package com.hw.lineage.server.domain.vo;

import com.hw.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: CatalogId
 * @author: HamaWhite
 */
@Data
public class CatalogId implements Identifier {

    private final Long value;

    public CatalogId(Long value) {
        this.value = value;
    }
}
