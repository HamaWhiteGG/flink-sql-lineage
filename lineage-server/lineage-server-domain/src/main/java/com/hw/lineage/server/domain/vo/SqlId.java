package com.hw.lineage.server.domain.vo;

import lombok.Data;

/**
 * @description: SqlId
 * @author: HamaWhite
 */
@Data
public class SqlId {

    private final Long value;

    public SqlId(Long value) {
        this.value = value;
    }
}
