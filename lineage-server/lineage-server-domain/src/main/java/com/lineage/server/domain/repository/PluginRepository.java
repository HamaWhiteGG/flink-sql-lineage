package com.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.query.plugin.PluginQuery;
import com.lineage.server.domain.repository.basic.Repository;
import com.lineage.server.domain.vo.PluginId;

/**
 * @description: PluginRepository
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 11:53 PM
 */
public interface PluginRepository extends Repository<Plugin, PluginId> {

    PageInfo<Plugin> findAll(PluginQuery pluginQuery);

}
