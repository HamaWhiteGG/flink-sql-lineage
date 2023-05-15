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
import com.hw.lineage.server.domain.entity.Role;
import com.hw.lineage.server.domain.entity.User;
import com.hw.lineage.server.domain.query.role.RoleQuery;
import com.hw.lineage.server.domain.repository.RoleRepository;
import com.hw.lineage.server.domain.vo.RoleId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.PermissionDO;
import com.hw.lineage.server.infrastructure.persistence.dos.RoleDO;
import com.hw.lineage.server.infrastructure.persistence.dos.UserDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.PermissionMapper;
import com.hw.lineage.server.infrastructure.persistence.mapper.RoleDynamicSqlSupport;
import com.hw.lineage.server.infrastructure.persistence.mapper.RoleMapper;
import com.hw.lineage.server.infrastructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static com.hw.lineage.server.infrastructure.persistence.mapper.PermissionDynamicSqlSupport.permission;
import static com.hw.lineage.server.infrastructure.persistence.mapper.RolePermissionDynamicSqlSupport.rolePermission;
import static com.hw.lineage.server.infrastructure.persistence.mapper.RoleUserDynamicSqlSupport.roleUser;
import static com.hw.lineage.server.infrastructure.persistence.mapper.UserDynamicSqlSupport.user;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @description: RoleRepositoryImpl
 * @author: HamaWhite
 */
@Repository
public class RoleRepositoryImpl extends AbstractBasicRepository implements RoleRepository {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Role find(RoleId roleId) {
        RoleDO roleDO = roleMapper.selectByPrimaryKey(roleId.getValue())
                .orElseThrow(
                        () -> new LineageException(String.format("roleId [%d] is not existed", roleId.getValue())));
        return converter.toRole(roleDO);
    }

    @Override
    public boolean check(String name) {
        return !roleMapper.select(completer -> completer.where(RoleDynamicSqlSupport.roleName, isEqualTo(name)))
                .isEmpty();
    }

    @Override
    public Role save(Role role) {
        RoleDO roleDO = converter.fromRole(role);
        if (roleDO.getRoleId() == null) {
            roleMapper.insertSelective(roleDO);
        } else {
            roleMapper.updateByPrimaryKeySelective(roleDO);
        }
        return converter.toRole(roleDO);
    }

    @Override
    public void remove(RoleId roleId) {
        roleMapper.deleteByPrimaryKey(roleId.getValue());
    }

    @Override
    public List<User> findUsers(RoleId roleId) {
        List<UserDO> userDOList =
                userMapper.select(completer -> completer.join(roleUser).on(user.userId, equalTo(roleUser.userId))
                        .where(roleUser.roleId, isEqualTo(roleId.getValue())));
        return converter.toUserList(userDOList);
    }

    @Override
    public List<Permission> findPermissions(RoleId roleId) {
        List<PermissionDO> permissionDOList = permissionMapper.select(completer -> completer.join(rolePermission)
                .on(permission.permissionId, equalTo(rolePermission.permissionId))
                .where(rolePermission.roleId, isEqualTo(roleId.getValue())));
        return converter.toPermissionList(permissionDOList);
    }

    @Override
    public PageInfo<Role> findAll(RoleQuery roleQuery) {
        try (Page<RoleDO> page = PageMethod.startPage(roleQuery.getPageNum(), roleQuery.getPageSize())) {
            PageInfo<RoleDO> pageInfo = page.doSelectPageInfo(() -> roleMapper.select(completer -> completer
                    .where(RoleDynamicSqlSupport.roleName, isLike(buildLikeValue(roleQuery.getRoleName())))
                    .orderBy(buildSortSpecification(roleQuery))));
            return PageUtils.convertPage(pageInfo, converter::toRole);
        }
    }
}
