package com.hw.lineage.server.infrastructure.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.domain.entity.Role;
import com.hw.lineage.server.domain.query.role.RoleQuery;
import com.hw.lineage.server.domain.repository.RoleRepository;
import com.hw.lineage.server.domain.vo.RoleId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.RoleDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.RoleDynamicSqlSupport;
import com.hw.lineage.server.infrastructure.persistence.mapper.RoleMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;

/**
 * @description: RoleRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Repository
public class RoleRepositoryImpl extends AbstractBasicRepository implements RoleRepository {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Role find(RoleId roleId) {
        RoleDO roleDO = roleMapper.selectByPrimaryKey(roleId.getValue())
                .orElseThrow(() -> new LineageException(String.format("roleId [%s] is not existed", roleId.getValue())));
        return converter.toRole(roleDO);
    }

    @Override
    public boolean check(String name) {
        return !roleMapper.select(completer -> completer.where(RoleDynamicSqlSupport.roleName, isEqualTo(name))).isEmpty();
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
    public PageInfo<Role> findAll(RoleQuery roleQuery) {
        try (Page<RoleDO> page = PageMethod.startPage(roleQuery.getPageNum(), roleQuery.getPageSize())) {
            PageInfo<RoleDO> pageInfo = page.doSelectPageInfo(() ->
                    roleMapper.select(completer ->
                            completer.where(RoleDynamicSqlSupport.roleName, isLike(buildLikeValue(roleQuery.getRoleName())))
                                    .orderBy(buildSortSpecification(roleQuery))
                    )
            );
            return PageUtils.convertPage(pageInfo, converter::toRole);
        }
    }
}
