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

package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.user.CreateUserCmd;
import com.hw.lineage.server.application.command.user.UpdateUserCmd;
import com.hw.lineage.server.application.dto.UserDTO;
import com.hw.lineage.server.application.service.UserService;
import com.hw.lineage.server.domain.entity.Permission;
import com.hw.lineage.server.domain.entity.Role;
import com.hw.lineage.server.domain.entity.User;
import com.hw.lineage.server.domain.facade.AvatarFacade;
import com.hw.lineage.server.domain.query.user.UserCheck;
import com.hw.lineage.server.domain.query.user.UserQuery;
import com.hw.lineage.server.domain.repository.UserRepository;
import com.hw.lineage.server.domain.vo.UserId;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.hw.lineage.common.util.Constant.DEFAULT_USER_ID;
import static com.hw.lineage.common.util.Preconditions.checkNotNull;


/**
 * @description: UserServiceImpl
 * @author: HamaWhite
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository repository;

    @Resource
    private AvatarFacade avatarFacade;

    @Resource
    private DtoAssembler assembler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.find(username);
        checkNotNull(user, new UsernameNotFoundException(username));

        List<Permission> permissionList = repository.findPermissions(user.getUserId());
        return assembler.fromUserPermissions(user, permissionList);
    }

    @Override
    public Long createUser(CreateUserCmd command) {
        User user = new User()
                .setUsername(command.getUsername())
                .setPassword(command.getPassword());

        user.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        // generate avatar
        user.setAvatar(avatarFacade.generateAvatar(System.currentTimeMillis()));

        user = repository.save(user);
        return user.getUserId().getValue();
    }

    @Override
    public UserDTO queryUser(Long userId) {
        User user = repository.find(new UserId(userId));
        List<Role> roleList = repository.findRoles(user.getUserId());
        return assembler.fromUserRoles(user, roleList);
    }

    @Override
    public Boolean checkUserExist(UserCheck userCheck) {
        return repository.check(userCheck.getUsername());
    }

    @Override
    public PageInfo<UserDTO> queryUsers(UserQuery userQuery) {
        PageInfo<User> pageInfo = repository.findAll(userQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromUser);
    }

    @Override
    public void deleteUser(Long userId) {
        repository.remove(new UserId(userId));
    }

    @Override
    public void updateUser(UpdateUserCmd command) {
        User user = new User()
                .setUserId(new UserId(command.getUserId()))
                .setUsername(command.getUsername())
                .setPassword(command.getPassword())
                .setLocked(command.getLocked());

        user.setModifyTime(System.currentTimeMillis());
        repository.save(user);
    }

    @Override
    public Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDTO) {
            return ((UserDTO) principal).getUserId();
        }
        // anonymous user, userId is 0
        return DEFAULT_USER_ID;
    }

    @Override
    public String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDTO) {
            return ((UserDTO) principal).getUsername();
        }
        // the value is anonymousUser
        return principal.toString();
    }
}
