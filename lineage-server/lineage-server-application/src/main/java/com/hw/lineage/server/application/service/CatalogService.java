package com.hw.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.catalog.CreateCatalogCmd;
import com.hw.lineage.server.application.command.catalog.UpdateCatalogCmd;
import com.hw.lineage.server.application.dto.CatalogDTO;
import com.hw.lineage.server.domain.query.catalog.CatalogCheck;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;


/**
 * @description: CatalogService
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface CatalogService {

    Long createCatalog(CreateCatalogCmd createCatalogCmd);

    CatalogDTO queryCatalog(Long catalogId);

    Boolean checkCatalogExist(CatalogCheck catalogCheck);

    PageInfo<CatalogDTO> queryCatalogs(CatalogQuery catalogQuery);

    void deleteCatalog(Long catalogId);

    void updateCatalog(UpdateCatalogCmd updateCatalogCmd);
}
