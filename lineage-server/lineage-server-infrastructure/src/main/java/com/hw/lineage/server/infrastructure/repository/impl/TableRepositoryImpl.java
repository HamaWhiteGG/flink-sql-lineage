package com.hw.lineage.server.infrastructure.repository.impl;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.server.domain.entity.Table;
import com.hw.lineage.server.domain.repository.TableRepository;
import com.hw.lineage.server.domain.vo.TableId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.TableDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.TableMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static com.hw.lineage.server.infrastructure.persistence.mapper.CatalogDynamicSqlSupport.catalog;
import static com.hw.lineage.server.infrastructure.persistence.mapper.TableDynamicSqlSupport.table;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;


/**
 * @description: TableRepositoryImpl
 * @author: HamaWhite
 */
@Repository
public class TableRepositoryImpl extends AbstractBasicRepository implements TableRepository {

    @Resource
    private TableMapper tableMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Table find(TableId tableId) {
        TableDO tableDO = tableMapper.selectByPrimaryKey(tableId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("tableId [%s] is not existed", tableId.getValue()))
                );
        return converter.toTable(tableDO);
    }


    @Override
    public Table save(Table table) {
        TableDO tableDO = converter.fromTable(table);
        if (tableDO.getTableId() == null) {
            tableMapper.insertSelective(tableDO);
        } else {
            tableMapper.updateByPrimaryKeySelective(tableDO);
        }
        return converter.toTable(tableDO);
    }

    @Override
    public void remove(TableId tableId) {
        tableMapper.deleteByPrimaryKey(tableId.getValue());
    }


    @Override
    public List<Table> findMemory() {
        List<TableDO> tableDOList = tableMapper.select(completer ->
                completer.join(catalog).on(table.catalogId, equalTo(catalog.catalogId))
                        .where(catalog.catalogType, isEqualToWhenPresent(CatalogType.MEMORY))
        );
        return converter.toTableList(tableDOList);
    }
}
