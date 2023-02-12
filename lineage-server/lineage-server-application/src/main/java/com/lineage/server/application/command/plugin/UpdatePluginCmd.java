package com.lineage.server.application.command.plugin;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdatePluginCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:39 PM
 */
@Data
public class UpdatePluginCmd {

    @NotNull
    private Long pluginId;

    private String pluginName;

    private String descr;
}
