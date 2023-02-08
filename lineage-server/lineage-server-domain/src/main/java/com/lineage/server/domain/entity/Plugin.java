package com.lineage.server.domain.entity;

import com.lineage.server.domain.entity.basic.BasicEntity;
import com.lineage.server.domain.repository.basic.Entity;
import com.lineage.server.domain.vo.PluginId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Plugin
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 11:53 PM
 */
@Data
@Accessors(chain = true)
public class Plugin extends BasicEntity implements Entity {

    private PluginId pluginId;

    private String pluginName;

    private String descr;
}
