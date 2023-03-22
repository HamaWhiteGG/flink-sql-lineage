package com.hw.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.domain.entity.Plugin;
import com.hw.lineage.server.domain.query.plugin.PluginCheck;
import com.hw.lineage.server.domain.query.plugin.PluginQuery;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.PluginId;

/**
 * @description: PluginRepository
 * @author: HamaWhite
 */
public interface PluginRepository extends Repository<Plugin, PluginId> {

    PageInfo<Plugin> findAll(PluginQuery pluginQuery);

    void setDefault(PluginId pluginId);

    boolean check(PluginCheck pluginCheck);

}
