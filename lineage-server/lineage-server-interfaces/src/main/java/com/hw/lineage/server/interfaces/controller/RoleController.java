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
import com.hw.lineage.server.application.command.role.CreateRoleCmd;
import com.hw.lineage.server.application.command.role.UpdateRoleCmd;
import com.hw.lineage.server.application.dto.RoleDTO;
import com.hw.lineage.server.application.service.RoleService;
import com.hw.lineage.server.domain.query.role.RoleCheck;
import com.hw.lineage.server.domain.query.role.RoleQuery;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.hw.lineage.common.enums.audit.ModuleCode.ROLE;
import static com.hw.lineage.common.enums.audit.OperationType.*;

/**
 * @description: RoleController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Roles API")
@RequestMapping("/roles")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/{roleId}")
    @AuditLog(module = ROLE, type = QUERY, descr = "'Query Role: ' + @roleService.queryRole(#roleId).roleName")
    public Result<RoleDTO> queryRole(@PathVariable("roleId") Long roleId) {
        RoleDTO roleDTO = roleService.queryRole(roleId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, roleDTO);
    }

    @GetMapping("")
    @AuditLog(module = ROLE, type = QUERY, descr = "'Query Roles'")
    public Result<PageInfo<RoleDTO>> queryRoles(RoleQuery roleQuery) {
        PageInfo<RoleDTO> pageInfo = roleService.queryRoles(roleQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @AuditLog(module = ROLE, type = CREATE, descr = "'Create Role: ' + #command.roleName")
    public Result<Long> createRole(@Valid @RequestBody CreateRoleCmd command) {
        Long roleId = roleService.createRole(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, roleId);
    }

    @GetMapping("/exist")
    @AuditLog(module = ROLE, type = QUERY, descr = "'Check Role Exist'")
    public Result<Boolean> checkRoleExist(@Valid RoleCheck roleCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, roleService.checkRoleExist(roleCheck));
    }

    @PutMapping("/{roleId}")
    @AuditLog(module = ROLE, type = UPDATE, descr = "'Update Role: ' + @roleService.queryRole(#roleId).roleName")
    public Result<Boolean> updateRole(@PathVariable("roleId") Long roleId,
                                        @Valid @RequestBody UpdateRoleCmd command) {
        command.setRoleId(roleId);
        roleService.updateRole(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{roleId}")
    @AuditLog(module = ROLE, type = DELETE, descr = "'Delete Role: ' + @roleService.queryRole(#roleId).roleName")
    public Result<Boolean> deleteRole(@PathVariable("roleId") Long roleId) {
        roleService.deleteRole(roleId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

}
