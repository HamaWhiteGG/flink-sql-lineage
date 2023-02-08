package com.lineage.server.domain.vo;

import lombok.Data;

/**
 * @description: SqlId
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 9:47 PM
 */
@Data
public class SqlId {

    private final Integer value;

    public SqlId(Integer value) {
        this.value = value;
    }
}
