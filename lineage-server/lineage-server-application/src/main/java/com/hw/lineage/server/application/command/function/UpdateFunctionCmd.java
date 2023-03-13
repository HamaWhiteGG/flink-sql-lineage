package com.hw.lineage.server.application.command.function;

import com.hw.lineage.server.domain.query.BasicCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: UpdateFunctionCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@ToString(callSuper = true)
public class UpdateFunctionCmd extends BasicCriteria {

    @ApiModelProperty(hidden = true)
    private Long functionId;

    private String invocation;

    private String descr;
}
