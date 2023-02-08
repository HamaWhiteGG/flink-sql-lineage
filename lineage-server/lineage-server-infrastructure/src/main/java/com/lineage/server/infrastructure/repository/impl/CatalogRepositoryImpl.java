package com.lineage.server.infrastructure.repository.impl;

import com.hw.lineage.common.exception.LineageException;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.repository.CatalogRepository;
import com.lineage.server.domain.vo.CatalogId;
import com.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.lineage.server.infrastructure.persistence.dos.CatalogDO;
import com.lineage.server.infrastructure.persistence.mapper.CatalogMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description: CatalogRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:19 PM
 */
@Repository
public class CatalogRepositoryImpl implements CatalogRepository {

    @Resource
    private CatalogMapper catalogMapper;

    @Override
    public Catalog find(CatalogId catalogId) {
        CatalogDO catalogDO = catalogMapper.selectByPrimaryKey(catalogId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("catalogId [%s] is not existed", catalogId.getValue()))
                );
        return DataConverter.INSTANCE.toCatalog(catalogDO);
    }

    @Override
    public Catalog save(Catalog catalog) {
        CatalogDO catalogDO = DataConverter.INSTANCE.fromCatalog(catalog);
        if (catalogDO.getCatalogId() == null) {
            catalogMapper.insertSelective(catalogDO);
        } else {
            catalogMapper.updateByPrimaryKeySelective(catalogDO);
        }
        return DataConverter.INSTANCE.toCatalog(catalogDO);
    }

    @Override
    public void remove(CatalogId catalogId) {
        catalogMapper.deleteByPrimaryKey(catalogId.getValue());
    }
}
