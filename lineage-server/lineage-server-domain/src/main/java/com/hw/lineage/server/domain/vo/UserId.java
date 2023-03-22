package com.hw.lineage.server.domain.vo;

import com.hw.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: UserId
 * @author: HamaWhite
 */
@Data
public class UserId implements Identifier {

    private final Long value;

    public UserId(Long value) {
        this.value = value;
    }
}

