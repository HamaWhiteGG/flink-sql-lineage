package com.hw.lineage.server.domain.query;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: BasicCriteria
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class BasicCriteria {
    @NotNull
    private Long userId;
}
