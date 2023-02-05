package com.lineage.server.application.service.impl;

import com.hw.lineage.common.enums.CatalogType;
import com.lineage.server.application.assembler.DtoAssembler;
import com.lineage.server.application.cqe.command.catalog.CreateCatalogCmd;
import com.lineage.server.application.cqe.command.catalog.UpdateCatalogCmd;
import com.lineage.server.application.dto.CatalogDTO;
import com.lineage.server.application.service.CatalogService;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.repository.CatalogRepository;
import com.lineage.server.domain.repository.TaskRepository;
import com.lineage.server.domain.vo.CatalogId;
import com.lineage.server.domain.vo.TaskId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: CatalogServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:26 PM
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Resource
    private CatalogRepository repository;

    @Override
    public Long createCatalog(CreateCatalogCmd createCatalogCmd) {
        Catalog catalog = new Catalog()
                .setCatalogName(createCatalogCmd.getCatalogName())
                .setCatalogType(createCatalogCmd.getCatalogType())
                .setDefaultDatabase(createCatalogCmd.getDefaultDatabase())
                .setDescr(createCatalogCmd.getDescr());


        catalog.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        catalog = repository.save(catalog);
        return catalog.getCatalogId().getValue();
    }

    @Override
    public CatalogDTO queryCatalog(Long catalogId) {
        Catalog catalog = repository.find(new CatalogId(catalogId));
        return DtoAssembler.INSTANCE.fromCatalog(catalog);
    }

    @Override
    public Boolean deleteCatalog(Long catalogId) {
        return repository.remove(new CatalogId(catalogId));
    }

    @Override
    public Boolean updateCatalog(UpdateCatalogCmd updateCatalogCmd) {
        Catalog catalog = new Catalog()
                .setCatalogId(new CatalogId(updateCatalogCmd.getCatalogId()))
                .setCatalogName(updateCatalogCmd.getCatalogName())
                .setDefaultDatabase(updateCatalogCmd.getDefaultDatabase())
                .setDescr(updateCatalogCmd.getDescr());

        catalog.setModifyTime(System.currentTimeMillis());
        return repository.update(catalog);
    }
}
