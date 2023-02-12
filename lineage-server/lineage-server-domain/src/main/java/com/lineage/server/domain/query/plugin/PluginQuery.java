package com.lineage.server.domain.query.plugin;

import com.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;

/**
 * @description: PluginQuery
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 8:45 PM
 */
@Data
public class PluginQuery extends PageOrderCriteria {

    private String pluginName;
}