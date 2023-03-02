package com.hw.lineage.server.application.command.plugin;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdatePluginCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdatePluginCmd {

    private Long pluginId;

    private String pluginName;

    private String descr;
}
