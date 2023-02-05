package com.lineage.server.application.cqe.command.plugin;

import lombok.Data;

/**
 * @description: CreatePluginCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:38 PM
 */
@Data
public class CreatePluginCmd {

    private String pluginName;

    private String descr;
}
