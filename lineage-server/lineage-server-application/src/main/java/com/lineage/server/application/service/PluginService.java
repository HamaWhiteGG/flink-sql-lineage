package com.lineage.server.application.service;

import com.lineage.server.application.cqe.command.plugin.CreatePluginCmd;
import com.lineage.server.application.cqe.command.plugin.UpdatePluginCmd;
import com.lineage.server.application.dto.PluginDTO;

/**
 * @description: PluginService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:26 PM
 */
public interface PluginService {

    Long createPlugin(CreatePluginCmd createPluginCmd);

    PluginDTO queryPlugin(Long pluginId);

    void deletePlugin(Long pluginId);

    void updatePlugin(UpdatePluginCmd updatePluginCmd);
}
