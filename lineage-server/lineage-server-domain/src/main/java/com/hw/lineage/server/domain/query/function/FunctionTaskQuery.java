package com.hw.lineage.server.domain.query.function;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: FunctionTaskQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class FunctionTaskQuery extends PageOrderCriteria {

    @ApiModelProperty(hidden = true)
    private Long functionId;
}