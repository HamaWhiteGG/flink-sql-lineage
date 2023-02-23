package com.hw.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.domain.entity.User;
import com.hw.lineage.server.domain.query.user.UserQuery;
import com.hw.lineage.server.domain.repository.basic.Repository;
import com.hw.lineage.server.domain.vo.UserId;

/**
 * @description: UserRepository
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface UserRepository extends Repository<User, UserId> {

    User find(String username);

    PageInfo<User> findAll(UserQuery userQuery);
}