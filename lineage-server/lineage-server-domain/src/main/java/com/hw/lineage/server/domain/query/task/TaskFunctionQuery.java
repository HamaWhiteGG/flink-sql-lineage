package com.hw.lineage.server.domain.query.task;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: TaskFunctionQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class TaskFunctionQuery extends PageOrderCriteria {

    @ApiModelProperty(hidden = true)
    private Long taskId;
}
