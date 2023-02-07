package com.lineage.server.application.service;

import com.lineage.server.application.cqe.command.catalog.CreateCatalogCmd;
import com.lineage.server.application.cqe.command.catalog.UpdateCatalogCmd;
import com.lineage.server.application.dto.CatalogDTO;

/**
 * @description: CatalogService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:26 PM
 */
public interface CatalogService {

    Long createCatalog(CreateCatalogCmd createCatalogCmd);

    CatalogDTO queryCatalog(Long catalogId);

    void deleteCatalog(Long catalogId);

    void updateCatalog(UpdateCatalogCmd updateCatalogCmd);
}
