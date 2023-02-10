package com.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.lineage.server.application.command.plugin.CreatePluginCmd;
import com.lineage.server.application.command.plugin.UpdatePluginCmd;
import com.lineage.server.application.dto.PluginDTO;
import com.lineage.server.domain.query.plugin.PluginCheck;
import com.lineage.server.domain.query.plugin.PluginQuery;

/**
 * @description: PluginService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:26 PM
 */
public interface PluginService {

    Long createPlugin(CreatePluginCmd createPluginCmd);

    PluginDTO queryPlugin(Long pluginId);

    Boolean checkPluginExist(PluginCheck pluginCheck);

    PageInfo<PluginDTO> queryPlugins(PluginQuery pluginQuery);

    void deletePlugin(Long pluginId);

    void updatePlugin(UpdatePluginCmd updatePluginCmd);
}
