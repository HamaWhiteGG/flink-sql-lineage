package com.lineage.server.domain.vo;

import com.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: FunctionId
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:20 PM
 */
@Data
public class FunctionId implements Identifier {

    private final Long value;

    public FunctionId(Long value) {
        this.value = value;
    }
}
