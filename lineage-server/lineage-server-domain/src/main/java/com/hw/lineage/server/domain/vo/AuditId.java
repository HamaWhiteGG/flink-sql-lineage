package com.hw.lineage.server.domain.vo;

import com.hw.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: AuditId
 * @author: HamaWhite
 */
@Data
public class AuditId implements Identifier {

    private final Long value;

    public AuditId(Long value) {
        this.value = value;
    }
}
