package com.lineage.server.application.cqe.command.plugin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: CreatePluginCmd
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:38 PM
 */
@Data
public class CreatePluginCmd {

    @NotBlank
    private String pluginName;

    private String descr;
}
