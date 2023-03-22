package com.hw.lineage.server.domain.query.function;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: FunctionQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class FunctionQuery extends PageOrderCriteria {
    @ApiModelProperty(hidden = true)
    private Long catalogId;

    @ApiModelProperty(hidden = true)
    private String database;

    private String functionName;
}