package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.catalog.CreateCatalogCmd;
import com.hw.lineage.server.application.command.catalog.UpdateCatalogCmd;
import com.hw.lineage.server.application.dto.CatalogDTO;
import com.hw.lineage.server.application.service.CatalogService;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.query.catalog.CatalogCheck;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.vo.CatalogId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: CatalogServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Resource
    private CatalogRepository repository;

    @Resource
    private DtoAssembler assembler;

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
        return assembler.fromCatalog(catalog);
    }

    @Override
    public Boolean checkCatalogExist(CatalogCheck catalogCheck) {
        return repository.check(catalogCheck.getCatalogName());
    }

    @Override
    public PageInfo<CatalogDTO> queryCatalogs(CatalogQuery catalogQuery) {
        PageInfo<Catalog> pageInfo = repository.findAll(catalogQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromCatalog);
    }

    @Override
    public void deleteCatalog(Long catalogId) {
        repository.remove(new CatalogId(catalogId));
    }

    @Override
    public void updateCatalog(UpdateCatalogCmd updateCatalogCmd) {
        Catalog catalog = new Catalog()
                .setCatalogId(new CatalogId(updateCatalogCmd.getCatalogId()))
                .setCatalogName(updateCatalogCmd.getCatalogName())
                .setDefaultDatabase(updateCatalogCmd.getDefaultDatabase())
                .setDescr(updateCatalogCmd.getDescr());

        catalog.setModifyTime(System.currentTimeMillis());
        repository.save(catalog);
    }
}
