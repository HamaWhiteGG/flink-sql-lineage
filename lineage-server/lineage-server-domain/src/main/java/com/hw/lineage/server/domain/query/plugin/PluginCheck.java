package com.hw.lineage.server.domain.query.plugin;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: PluginCheck
 * @author: HamaWhite
 */
@Data
public class PluginCheck implements Serializable {

    private String pluginName;

    private String pluginCode;

}
