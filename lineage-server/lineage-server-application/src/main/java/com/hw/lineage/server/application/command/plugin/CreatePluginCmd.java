package com.hw.lineage.server.application.command.plugin;

import com.hw.lineage.server.domain.query.BasicCriteria;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @description: CreatePluginCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class CreatePluginCmd extends BasicCriteria {

    @NotBlank
    private String pluginName;

    @NotBlank
    private String pluginCode;

    private String descr;

    private Boolean defaultPlugin;
}
