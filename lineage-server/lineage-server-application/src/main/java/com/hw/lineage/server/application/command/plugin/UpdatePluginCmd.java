package com.hw.lineage.server.application.command.plugin;

import com.hw.lineage.server.domain.query.BasicCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description: UpdatePluginCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class UpdatePluginCmd extends BasicCriteria {

    @ApiModelProperty(hidden = true)
    private Long pluginId;

    private String pluginName;

    private String descr;
}
