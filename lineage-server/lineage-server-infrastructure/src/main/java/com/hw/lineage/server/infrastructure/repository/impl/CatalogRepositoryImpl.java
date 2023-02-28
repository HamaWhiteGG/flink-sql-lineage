package com.hw.lineage.server.infrastructure.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.CatalogDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.CatalogDynamicSqlSupport;
import com.hw.lineage.server.infrastructure.persistence.mapper.CatalogMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static com.hw.lineage.server.infrastructure.persistence.mapper.CatalogDynamicSqlSupport.catalog;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;

/**
 * @description: CatalogRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Repository
public class CatalogRepositoryImpl extends AbstractBasicRepository implements CatalogRepository {

    @Resource
    private CatalogMapper catalogMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Catalog find(CatalogId catalogId) {
        CatalogDO catalogDO = catalogMapper.selectByPrimaryKey(catalogId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("catalogId [%s] is not existed", catalogId.getValue()))
                );
        return converter.toCatalog(catalogDO);
    }

    @Override
    public boolean check(String name) {
        return !catalogMapper.select(completer -> completer.where(CatalogDynamicSqlSupport.catalogName, isEqualTo(name))).isEmpty();
    }

    @Override
    public Catalog save(Catalog catalog) {
        CatalogDO catalogDO = converter.fromCatalog(catalog);
        if (catalogDO.getCatalogId() == null) {
            catalogMapper.insertSelective(catalogDO);
        } else {
            catalogMapper.updateByPrimaryKeySelective(catalogDO);
        }
        return converter.toCatalog(catalogDO);
    }

    @Override
    public void remove(CatalogId catalogId) {
        catalogMapper.deleteByPrimaryKey(catalogId.getValue());
    }

    @Override
    public PageInfo<Catalog> findAll(CatalogQuery catalogQuery) {
        try (Page<CatalogDO> page = PageMethod.startPage(catalogQuery.getPageNum(), catalogQuery.getPageSize())) {
            PageInfo<CatalogDO> pageInfo = page.doSelectPageInfo(() ->
                    catalogMapper.select(completer ->
                            completer.where(CatalogDynamicSqlSupport.catalogName, isLike(buildLikeValue(catalogQuery.getCatalogName())))
                                    .orderBy(buildSortSpecification(catalogQuery))
                    )
            );
            return PageUtils.convertPage(pageInfo, converter::toCatalog);
        }
    }

    @Override
    public void setDefault(CatalogId catalogId) {
        catalogMapper.update(completer ->
                completer.set(catalog.defaultCatalog).equalTo(FALSE).where(catalog.defaultCatalog, isEqualTo(TRUE))
        );
        catalogMapper.update(completer ->
                completer.set(catalog.defaultCatalog).equalTo(TRUE).where(catalog.catalogId, isEqualTo(catalogId.getValue()))
        );
    }
}
