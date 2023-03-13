package com.hw.lineage.server.domain.query.plugin;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: PluginQuery
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@ToString(callSuper = true)
public class PluginQuery extends PageOrderCriteria {

    private String pluginName;

    private Boolean defaultPlugin;
}