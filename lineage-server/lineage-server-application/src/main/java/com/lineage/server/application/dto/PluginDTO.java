package com.lineage.server.application.dto;

import lombok.Data;

/**
 * @description: PluginDTO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:29 PM
 */
@Data
public class PluginDTO extends BasicDTO {

    private Long pluginId;

    private String pluginName;

    private String descr;
}
