package com.hw.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;

/**
 * @description: CatalogRepository
 * @author: HamaWhite
 */
public interface CatalogRepository extends Repository<Catalog, CatalogId> {

    /**
     * In the future, it may be changed to the unique catalog name under the plugin,
     * which is currently globally unique
     */
    Catalog find(PluginId pluginId, String catalogName);

    PageInfo<Catalog> findAll(CatalogQuery catalogQuery);

    void setDefault(CatalogId catalogId);

    CatalogEntry findEntry(CatalogId catalogId);
}

