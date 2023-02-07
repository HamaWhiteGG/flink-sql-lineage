package com.lineage.server.application.service.impl;

import com.lineage.server.application.assembler.DtoAssembler;
import com.lineage.server.application.cqe.command.plugin.CreatePluginCmd;
import com.lineage.server.application.cqe.command.plugin.UpdatePluginCmd;
import com.lineage.server.application.dto.PluginDTO;
import com.lineage.server.application.service.PluginService;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.repository.PluginRepository;
import com.lineage.server.domain.vo.PluginId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: PluginServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:27 PM
 */
@Service
public class PluginServiceImpl implements PluginService {

    @Resource
    private PluginRepository repository;

    @Override
    public Long createPlugin(CreatePluginCmd createPluginCmd) {
        Plugin plugin = new Plugin()
                .setPluginName(createPluginCmd.getPluginName())
                .setDescr(createPluginCmd.getDescr());

        plugin.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        plugin = repository.save(plugin);
        return plugin.getPluginId().getValue();
    }

    @Override
    public PluginDTO queryPlugin(Long pluginId) {
        Plugin plugin = repository.find(new PluginId(pluginId));
        return DtoAssembler.INSTANCE.fromPlugin(plugin);
    }

    @Override
    public void deletePlugin(Long pluginId) {
        repository.remove(new PluginId(pluginId));
    }

    @Override
    public void updatePlugin(UpdatePluginCmd updatePluginCmd) {
        Plugin plugin = new Plugin()
                .setPluginId(new PluginId(updatePluginCmd.getPluginId()))
                .setPluginName(updatePluginCmd.getPluginName())
                .setDescr(updatePluginCmd.getDescr());

        plugin.setModifyTime(System.currentTimeMillis());
        repository.save(plugin);
    }
}
