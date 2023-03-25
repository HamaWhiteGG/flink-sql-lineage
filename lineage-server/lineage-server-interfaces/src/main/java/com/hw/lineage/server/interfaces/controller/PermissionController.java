package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.permission.CreatePermissionCmd;
import com.hw.lineage.server.application.command.permission.UpdatePermissionCmd;
import com.hw.lineage.server.application.dto.PermissionDTO;
import com.hw.lineage.server.application.service.PermissionService;
import com.hw.lineage.server.domain.query.permission.PermissionCheck;
import com.hw.lineage.server.domain.query.permission.PermissionQuery;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.hw.lineage.common.enums.audit.ModuleCode.PERMISSION;
import static com.hw.lineage.common.enums.audit.OperationType.*;

/**
 * @description: PermissionController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Permissions API")
@RequestMapping("/permissions")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @GetMapping("/{permissionId}")
    @AuditLog(module = PERMISSION, type = QUERY, descr = "'Query Permission: ' + @permissionService.queryPermission(#permissionId).permissionName")
    public Result<PermissionDTO> queryPermission(@PathVariable("permissionId") Long permissionId) {
        PermissionDTO permissionDTO = permissionService.queryPermission(permissionId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, permissionDTO);
    }

    @GetMapping("")
    @AuditLog(module = PERMISSION, type = QUERY, descr = "'Query Permissions'")
    public Result<PageInfo<PermissionDTO>> queryPermissions(PermissionQuery permissionQuery) {
        PageInfo<PermissionDTO> pageInfo = permissionService.queryPermissions(permissionQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @AuditLog(module = PERMISSION, type = CREATE, descr = "'Create Permission: ' + #command.permissionName")
    public Result<Long> createPermission(@Valid @RequestBody CreatePermissionCmd command) {
        Long permissionId = permissionService.createPermission(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, permissionId);
    }

    @GetMapping("/exist")
    @AuditLog(module = PERMISSION, type = QUERY, descr = "'Check Permission Exist'")
    public Result<Boolean> checkPermissionExist(@Valid PermissionCheck permissionCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, permissionService.checkPermissionExist(permissionCheck));
    }

    @PutMapping("/{permissionId}")
    @AuditLog(module = PERMISSION, type = UPDATE, descr = "'Update Permission: ' + @permissionService.queryPermission(#permissionId).permissionName")
    public Result<Boolean> updatePermission(@PathVariable("permissionId") Long permissionId,
                                        @Valid @RequestBody UpdatePermissionCmd command) {
        command.setPermissionId(permissionId);
        permissionService.updatePermission(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{permissionId}")
    @AuditLog(module = PERMISSION, type = DELETE, descr = "'Delete Permission: ' + @permissionService.queryPermission(#permissionId).permissionName")
    public Result<Boolean> deletePermission(@PathVariable("permissionId") Long permissionId) {
        permissionService.deletePermission(permissionId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

}
