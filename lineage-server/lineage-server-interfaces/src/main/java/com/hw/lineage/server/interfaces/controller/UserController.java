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

package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.user.CreateUserCmd;
import com.hw.lineage.server.application.command.user.UpdateUserCmd;
import com.hw.lineage.server.application.dto.UserDTO;
import com.hw.lineage.server.application.service.UserService;
import com.hw.lineage.server.domain.query.user.UserCheck;
import com.hw.lineage.server.domain.query.user.UserQuery;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.hw.lineage.common.enums.audit.ModuleCode.USER;
import static com.hw.lineage.common.enums.audit.OperationType.*;

/**
 * @description: UserController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Users API")
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{userId}")
    @AuditLog(module = USER, type = QUERY, descr = "'Query User: ' + @userService.queryUser(#userId).username")
    public Result<UserDTO> queryUser(@PathVariable("userId") Long userId) {
        UserDTO userDTO = userService.queryUser(userId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, userDTO);
    }

    @GetMapping("/{userId}/avatar")
    @AuditLog(module = USER, type = QUERY, descr = "'Query User Avatar: ' + @userService.queryUser(#userId).username")
    public ResponseEntity<byte[]> queryUserAvatar(@PathVariable("userId") Long userId) {
        UserDTO userDTO = userService.queryUser(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(userDTO.getAvatar(), headers, HttpStatus.OK);
    }

    @GetMapping("")
    @AuditLog(module = USER, type = QUERY, descr = "'Query Users'")
    public Result<PageInfo<UserDTO>> queryUsers(UserQuery userQuery) {
        PageInfo<UserDTO> pageInfo = userService.queryUsers(userQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @AuditLog(module = USER, type = CREATE, descr = "'Create User: ' + #command.username")
    public Result<Long> createUser(@Valid @RequestBody CreateUserCmd command) {
        Long userId = userService.createUser(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, userId);
    }

    @GetMapping("/exist")
    @AuditLog(module = USER, type = QUERY, descr = "'Check User Exist'")
    public Result<Boolean> checkUserExist(@Valid UserCheck userCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, userService.checkUserExist(userCheck));
    }

    @PutMapping("/{userId}")
    @AuditLog(module = USER, type = UPDATE, descr = "'Update User: ' + @userService.queryUser(#userId).username")
    public Result<Boolean> updateUser(@PathVariable("userId") Long userId,
            @Valid @RequestBody UpdateUserCmd command) {
        command.setUserId(userId);
        userService.updateUser(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{userId}")
    @AuditLog(module = USER, type = DELETE, descr = "'Delete User: ' + @userService.queryUser(#userId).username")
    public Result<Boolean> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }
}
