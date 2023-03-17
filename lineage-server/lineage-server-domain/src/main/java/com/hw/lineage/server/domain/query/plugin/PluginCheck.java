package com.hw.lineage.server.domain.query.plugin;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: PluginCheck
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class PluginCheck implements Serializable {

    private String pluginName;

    private String pluginCode;

}
