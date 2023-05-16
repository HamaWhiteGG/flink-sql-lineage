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
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.domain.entity.Permission;
import com.hw.lineage.server.domain.query.permission.PermissionQuery;
import com.hw.lineage.server.domain.repository.PermissionRepository;
import com.hw.lineage.server.domain.vo.PermissionId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.PermissionDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.PermissionDynamicSqlSupport;
import com.hw.lineage.server.infrastructure.persistence.mapper.PermissionMapper;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static com.hw.lineage.server.infrastructure.persistence.mapper.PermissionDynamicSqlSupport.permissionCode;
import static com.hw.lineage.server.infrastructure.persistence.mapper.PermissionDynamicSqlSupport.permissionName;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @description: PermissionRepositoryImpl
 * @author: HamaWhite
 */
@Repository
public class PermissionRepositoryImpl extends AbstractBasicRepository implements PermissionRepository {

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Permission find(PermissionId permissionId) {
        PermissionDO permissionDO = permissionMapper.selectByPrimaryKey(permissionId.getValue())
                .orElseThrow(() -> new LineageException(
                        String.format("permissionId [%d] is not existed", permissionId.getValue())));
        return converter.toPermission(permissionDO);
    }

    @Override
    public Permission save(Permission permission) {
        PermissionDO permissionDO = converter.fromPermission(permission);
        if (permissionDO.getPermissionId() == null) {
            permissionMapper.insertSelective(permissionDO);
        } else {
            permissionMapper.updateByPrimaryKeySelective(permissionDO);
        }
        return converter.toPermission(permissionDO);
    }

    @Override
    public void remove(PermissionId permissionId) {
        permissionMapper.deleteByPrimaryKey(permissionId.getValue());
    }

    @Override
    public boolean check(String permissionName, String permissionCode) {
        return !permissionMapper
                .select(completer -> completer
                        .where(PermissionDynamicSqlSupport.permissionName, isEqualToWhenPresent(permissionName))
                        .or(PermissionDynamicSqlSupport.permissionCode, isEqualToWhenPresent(permissionCode)))
                .isEmpty();
    }

    @Override
    public PageInfo<Permission> findAll(PermissionQuery permissionQuery) {
        try (Page<PermissionDO> page =
                PageMethod.startPage(permissionQuery.getPageNum(), permissionQuery.getPageSize())) {
            PageInfo<PermissionDO> pageInfo = page.doSelectPageInfo(() -> permissionMapper.select(completer -> completer
                    .where(permissionName, isLike(buildLikeValue(permissionQuery.getPermissionName())))
                    .and(permissionCode, isLike(buildLikeValue(permissionQuery.getPermissionCode())))
                    .orderBy(buildSortSpecification(permissionQuery))));
            return PageUtils.convertPage(pageInfo, converter::toPermission);
        }
    }
}
