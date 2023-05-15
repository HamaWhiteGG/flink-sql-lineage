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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.domain.entity.Function;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionEntry;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.query.function.FunctionTaskQuery;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;
import com.hw.lineage.server.domain.repository.FunctionRepository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.FunctionId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.FunctionDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.FunctionMapper;
import com.hw.lineage.server.infrastructure.persistence.mapper.custom.CustomFunctionMapper;
import com.hw.lineage.server.infrastructure.persistence.mybatis.function.GroupConcat;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static com.hw.lineage.server.infrastructure.persistence.mapper.CatalogDynamicSqlSupport.catalog;
import static com.hw.lineage.server.infrastructure.persistence.mapper.FunctionDynamicSqlSupport.*;
import static com.hw.lineage.server.infrastructure.persistence.mapper.PluginDynamicSqlSupport.plugin;
import static com.hw.lineage.server.infrastructure.persistence.mapper.TaskDynamicSqlSupport.task;
import static com.hw.lineage.server.infrastructure.persistence.mapper.TaskFunctionDynamicSqlSupport.taskFunction;
import static com.hw.lineage.server.infrastructure.persistence.mapper.custom.CustomFunctionMapper.SQL_IDS;
import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @description: FunctionRepositoryImpl
 * @author: HamaWhite
 */
@Repository
public class FunctionRepositoryImpl extends AbstractBasicRepository implements FunctionRepository {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionRepositoryImpl.class);

    @Resource
    private FunctionMapper functionMapper;

    @Resource
    private CustomFunctionMapper customFunctionMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Function find(FunctionId functionId) {
        FunctionDO functionDO = functionMapper.selectByPrimaryKey(functionId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("functionId [%d] is not existed", functionId.getValue()))
                );
        return converter.toFunction(functionDO);
    }

    @Override
    public Function find(CatalogId catalogId, String database, String functionName) {
        FunctionDO functionDO = functionMapper.selectOne(completer ->
                        completer.where(function.catalogId, isEqualTo(catalogId.getValue()))
                                .and(function.database, isEqualTo(database))
                                .and(function.functionName, isEqualTo(functionName)))
                .orElseThrow(() ->
                        new LineageException(String.format("catalogId [%d], database [%s], functionName[%s] is not existed"
                                , catalogId.getValue(), database, functionName))
                );
        return converter.toFunction(functionDO);
    }

    @Override
    public boolean check(FunctionCheck functionCheck) {
        return !functionMapper.select(completer -> completer.where(catalogId, isEqualTo(functionCheck.getCatalogId()))
                .and(database, isEqualTo(functionCheck.getDatabase()))
                .and(functionName, isEqualTo(functionCheck.getFunctionName()))).isEmpty();
    }

    @Override
    public Function save(Function function) {
        FunctionDO functionDO = converter.fromFunction(function);
        if (functionDO.getFunctionId() == null) {
            functionMapper.insertSelective(functionDO);
        } else {
            functionMapper.updateByPrimaryKeySelective(functionDO);
        }
        return converter.toFunction(functionDO);
    }

    @Override
    public void remove(FunctionId functionId) {
        functionMapper.deleteByPrimaryKey(functionId.getValue());
    }

    @Override
    public PageInfo<Function> findAll(FunctionQuery functionQuery) {
        try (Page<FunctionDO> page = PageMethod.startPage(functionQuery.getPageNum(), functionQuery.getPageSize())) {
            PageInfo<FunctionDO> pageInfo = page.doSelectPageInfo(() ->
                    functionMapper.select(completer ->
                            completer.where(catalogId, isEqualTo(functionQuery.getCatalogId()))
                                    .and(database, isEqualTo(functionQuery.getDatabase()))
                                    .and(functionName, isLike(buildLikeValue(functionQuery.getFunctionName())))
                                    .orderBy(buildSortSpecification(functionQuery))
                    )
            );
            return PageUtils.convertPage(pageInfo, converter::toFunction);
        }
    }

    @Override
    public PageInfo<FunctionTaskDTO> findFunctionTasks(FunctionTaskQuery query) {
        try (Page<FunctionTaskDTO> page = PageMethod.startPage(query.getPageNum(), query.getPageSize())) {
            SelectStatementProvider selectStatement =
                    select(taskFunction.taskId, task.taskName, GroupConcat.of(taskFunction.sqlId).as(SQL_IDS), max(taskFunction.createTime).as(taskFunction.createTime.name()))
                            .from(taskFunction)
                            .join(task).on(taskFunction.taskId, equalTo(task.taskId))
                            .where(taskFunction.functionId, isEqualTo(query.getFunctionId()))
                            .groupBy(taskFunction.taskId, task.taskName)
                            .orderBy(buildSortSpecification(query))
                            .build().render(RenderingStrategies.MYBATIS3);

            LOG.info("generated sql: {}", selectStatement.getSelectStatement());
            return page.doSelectPageInfo(() -> customFunctionMapper.selectMany(selectStatement));
        }
    }

    @Override
    public FunctionEntry findEntry(FunctionId functionId) {
        SelectStatementProvider selectStatement =
                select(plugin.pluginCode, catalog.catalogName, function.database, function.functionId, function.functionName)
                        .from(function)
                        .join(catalog).on(function.catalogId, equalTo(catalog.catalogId))
                        .join(plugin).on(catalog.pluginId, equalTo(plugin.pluginId))
                        .where(function.functionId, isEqualTo(functionId.getValue()))
                        .build().render(RenderingStrategies.MYBATIS3);

        return customFunctionMapper.selectOne(selectStatement).orElseThrow(() ->
                new LineageException(String.format("functionId [%s] is not existed", functionId.getValue()))
        );
    }

    @Override
    public List<Function> findMemory() {
        List<FunctionDO> functionDOList = functionMapper.select(completer ->
                completer.join(catalog).on(function.catalogId, equalTo(catalog.catalogId))
                        .where(catalog.catalogType, isEqualToWhenPresent(CatalogType.MEMORY))
        );
        return converter.toFunctionList(functionDOList);
    }
}
