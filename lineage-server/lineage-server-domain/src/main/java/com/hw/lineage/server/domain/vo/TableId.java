package com.hw.lineage.server.domain.vo;

import com.hw.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: TableId
 * @author: HamaWhite
 */
@Data
public class TableId implements Identifier {

    private final Long value;

    public TableId(Long value) {
        this.value = value;
    }
}
