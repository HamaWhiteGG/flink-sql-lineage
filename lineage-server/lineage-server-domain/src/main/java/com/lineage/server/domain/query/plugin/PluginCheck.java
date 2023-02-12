package com.lineage.server.domain.query.plugin;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: PluginCheck
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 8:44 PM
 */
@Data
public class PluginCheck {

    @NotNull
    private String pluginName;
}
