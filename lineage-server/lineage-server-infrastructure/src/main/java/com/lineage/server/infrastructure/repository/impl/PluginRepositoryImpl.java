package com.lineage.server.infrastructure.repository.impl;

import com.hw.lineage.common.exception.LineageException;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.repository.PluginRepository;
import com.lineage.server.domain.vo.PluginId;
import com.lineage.server.domain.vo.PluginId;
import com.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.lineage.server.infrastructure.persistence.dos.PluginDO;
import com.lineage.server.infrastructure.persistence.mapper.CatalogMapper;
import com.lineage.server.infrastructure.persistence.mapper.PluginMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description: PluginRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:20 PM
 */
@Repository
public class PluginRepositoryImpl implements PluginRepository {

    @Resource
    private PluginMapper pluginMapper;

    @Override
    public Plugin find(PluginId pluginId) {
        PluginDO pluginDO = pluginMapper.selectByPrimaryKey(pluginId.getValue())
                .orElseThrow(() -> new LineageException(String.format("pluginId [%s] is not existed", pluginId.getValue())));
        return DataConverter.INSTANCE.toPlugin(pluginDO);
    }

    @Override
    public Plugin save(Plugin plugin) {
        PluginDO pluginDO = DataConverter.INSTANCE.fromPlugin(plugin);
        pluginMapper.insertSelective(pluginDO);
        return DataConverter.INSTANCE.toPlugin(pluginDO);
    }

    @Override
    public Boolean remove(PluginId pluginId) {
        return pluginMapper.deleteByPrimaryKey(pluginId.getValue()) > 0;
    }

    @Override
    public Boolean update(Plugin plugin) {
        PluginDO pluginDO = DataConverter.INSTANCE.fromPlugin(plugin);
        return pluginMapper.updateByPrimaryKeySelective(pluginDO) > 0;
    }
}
