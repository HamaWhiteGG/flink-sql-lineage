package com.hw.lineage.server.infrastructure.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.domain.entity.User;
import com.hw.lineage.server.domain.query.user.UserQuery;
import com.hw.lineage.server.domain.repository.UserRepository;
import com.hw.lineage.server.domain.vo.UserId;
import com.hw.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.hw.lineage.server.infrastructure.persistence.dos.UserDO;
import com.hw.lineage.server.infrastructure.persistence.mapper.UserDynamicSqlSupport;
import com.hw.lineage.server.infrastructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;


/**
 * @description: UserRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Repository
public class UserRepositoryImpl extends AbstractBasicRepository implements UserRepository {

    @Resource
    private UserMapper userMapper;

    @Resource
    private DataConverter converter;

    @Override
    public User find(UserId userId) {
        UserDO userDO = userMapper.selectByPrimaryKey(userId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("userId [%s] is not existed", userId.getValue()))
                );
        return converter.toUser(userDO);
    }

    @Override
    public boolean check(String name) {
        return !userMapper.select(completer -> completer.where(UserDynamicSqlSupport.username, isEqualTo(name))).isEmpty();
    }

    @Override
    public User save(User user) {
        UserDO userDO = converter.fromUser(user);
        if (userDO.getUserId() == null) {
            userMapper.insertSelective(userDO);
        } else {
            userMapper.updateByPrimaryKeySelective(userDO);
        }
        return converter.toUser(userDO);
    }

    @Override
    public void remove(UserId userId) {
        userMapper.deleteByPrimaryKey(userId.getValue());
    }

    @Override
    public User find(String username) {
        UserDO userDO = userMapper.selectOne(completer -> completer.where(UserDynamicSqlSupport.username, isEqualTo(username)))
                .orElseThrow(() ->
                        new LineageException("user account or password error")
                );
        return converter.toUser(userDO);
    }

    @Override
    public PageInfo<User> findAll(UserQuery userQuery) {
        try (Page<UserDO> page = PageMethod.startPage(userQuery.getPageNum(), userQuery.getPageSize())) {
            PageInfo<UserDO> pageInfo = page.doSelectPageInfo(() ->
                    userMapper.select(completer ->
                            completer.where(UserDynamicSqlSupport.username, isLike(buildLikeValue(userQuery.getUsername())))
                                    .orderBy(buildSortSpecification(userQuery))
                    )
            );
            return PageUtils.convertPage(pageInfo, converter::toUser);
        }
    }
}
