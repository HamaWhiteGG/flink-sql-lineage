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
import com.hw.lineage.server.domain.entity.Audit;
import com.hw.lineage.server.domain.query.audit.AuditQuery;
import com.hw.lineage.server.domain.repository.AuditRepository;
import com.hw.lineage.server.domain.vo.AuditId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.AuditDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.AuditMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static com.hw.lineage.server.infrastructure.persistence.mapper.AuditDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @description: AuditRepositoryImpl
 * @author: HamaWhite
 */
@Repository
public class AuditRepositoryImpl extends AbstractBasicRepository implements AuditRepository {

    @Resource
    private AuditMapper auditMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Audit find(AuditId auditId) {
        AuditDO auditDO = auditMapper.selectByPrimaryKey(auditId.getValue())
                .orElseThrow(
                        () -> new LineageException(String.format("auditId [%d] is not existed", auditId.getValue())));
        return converter.toAudit(auditDO);
    }

    @Override
    public Audit save(Audit audit) {
        AuditDO auditDO = converter.fromAudit(audit);
        if (auditDO.getAuditId() == null) {
            auditMapper.insertSelective(auditDO);
        } else {
            auditMapper.updateByPrimaryKeySelective(auditDO);
        }
        return converter.toAudit(auditDO);
    }

    @Override
    public void remove(AuditId auditId) {
        auditMapper.deleteByPrimaryKey(auditId.getValue());
    }

    @Override
    public PageInfo<Audit> findAll(AuditQuery auditQuery) {
        try (Page<AuditDO> page = PageMethod.startPage(auditQuery.getPageNum(), auditQuery.getPageSize())) {
            PageInfo<AuditDO> pageInfo = page.doSelectPageInfo(() -> auditMapper
                    .select(completer -> completer.where(username, isLike(buildLikeValue(auditQuery.getUsername())))
                            .and(moduleCode, isEqualToWhenPresent(auditQuery.getModuleCode()))
                            .and(operationType, isEqualToWhenPresent(auditQuery.getOperationType()))
                            .and(operationStatus, isEqualToWhenPresent(auditQuery.getOperationStatus()))
                            .and(ip, isEqualToWhenPresent(auditQuery.getIp()))
                            .and(createTime, isGreaterThanOrEqualToWhenPresent(auditQuery.getCreateTime()))
                            .orderBy(buildSortSpecification(auditQuery))));
            return PageUtils.convertPage(pageInfo, converter::toAudit);
        }
    }

}
