package com.hw.lineage.server.application.dto;

import lombok.Data;

/**
 * @description: PluginDTO
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class PluginDTO extends BasicDTO {

    private Long pluginId;

    private String pluginName;

    private String descr;
}
