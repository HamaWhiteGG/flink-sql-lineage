package com.hw.lineage.server.domain.vo;

import com.hw.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: FunctionId
 * @author: HamaWhite
 */
@Data
public class FunctionId implements Identifier {

    private final Long value;

    public FunctionId(Long value) {
        this.value = value;
    }
}
