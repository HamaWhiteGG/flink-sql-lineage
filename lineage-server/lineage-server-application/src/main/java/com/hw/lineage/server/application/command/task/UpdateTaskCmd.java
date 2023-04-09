package com.hw.lineage.server.application.command.task;

import com.hw.lineage.server.domain.query.BasicCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: UpdateTaskCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class UpdateTaskCmd extends BasicCriteria {

    @ApiModelProperty(hidden = true)
    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private String source;

}
