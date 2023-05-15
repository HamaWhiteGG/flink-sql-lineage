/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
                .orElseThrow(
                        () -> new LineageException(String.format("tableId [%d] is not existed", tableId.getValue())));
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
        List<TableDO> tableDOList =
                tableMapper.select(completer -> completer.join(catalog).on(table.catalogId, equalTo(catalog.catalogId))
                        .where(catalog.catalogType, isEqualToWhenPresent(CatalogType.MEMORY)));
        return converter.toTableList(tableDOList);
    }
}
