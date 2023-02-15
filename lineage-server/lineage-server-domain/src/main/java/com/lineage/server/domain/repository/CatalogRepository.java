package com.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.query.catalog.CatalogQuery;
import com.lineage.server.domain.repository.basic.Repository;
import com.lineage.server.domain.vo.CatalogId;

/**
 * @description: CatalogRepository
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface CatalogRepository extends Repository<Catalog, CatalogId> {
    PageInfo<Catalog> findAll(CatalogQuery catalogQuery);
}

