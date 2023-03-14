package com.hw.lineage.server.domain.query;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(hidden = true)
    private Long userId;
}
