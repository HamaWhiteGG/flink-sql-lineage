package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.plugin.CreatePluginCmd;
import com.hw.lineage.server.application.command.plugin.UpdatePluginCmd;
import com.hw.lineage.server.application.dto.PluginDTO;
import com.hw.lineage.server.application.service.PluginService;
import com.hw.lineage.server.domain.query.plugin.PluginCheck;
import com.hw.lineage.server.domain.query.plugin.PluginQuery;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.hw.lineage.common.enums.audit.ModuleCode.PLUGINS;
import static com.hw.lineage.common.enums.audit.OperationType.*;

/**
 * @description: PluginController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Plugins API")
@RequestMapping("/plugins")
public class PluginController {

    @Resource
    private PluginService pluginService;

    @GetMapping("/{pluginId}")
    @AuditLog(module = PLUGINS, type = QUERY, descr = "'Query Plugin: ' + @pluginService.queryPlugin(#pluginId).pluginName")
    public Result<PluginDTO> queryPlugin(@PathVariable("pluginId") Long pluginId) {
        PluginDTO pluginDTO = pluginService.queryPlugin(pluginId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, pluginDTO);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('system:plugin:list')")
    @AuditLog(module = PLUGINS, type = QUERY, descr = "'Query Plugins'")
    public Result<PageInfo<PluginDTO>> queryPlugins(PluginQuery pluginQuery) {
        PageInfo<PluginDTO> pageInfo = pluginService.queryPlugins(pluginQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('system:plugin:add')")
    @AuditLog(module = PLUGINS, type = CREATE, descr = "'Create Plugin: ' + #command.pluginName")
    public Result<Long> createPlugin(@Valid @RequestBody CreatePluginCmd command) {
        Long pluginId = pluginService.createPlugin(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, pluginId);
    }

    @GetMapping("/exist")
    @AuditLog(module = PLUGINS, type = QUERY, descr = "'Check Plugin Exist'")
    public Result<Boolean> checkPluginExist(@Valid PluginCheck pluginCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, pluginService.checkPluginExist(pluginCheck));
    }

    @PutMapping("/{pluginId}")
    @PreAuthorize("hasAuthority('system:plugin:edit')")
    @AuditLog(module = PLUGINS, type = UPDATE, descr = "'Update Plugin: ' + @pluginService.queryPlugin(#pluginId).pluginName")
    public Result<Boolean> updatePlugin(@PathVariable("pluginId") Long pluginId,
                                        @Valid @RequestBody UpdatePluginCmd command) {
        command.setPluginId(pluginId);
        pluginService.updatePlugin(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @PutMapping("/{pluginId}/default")
    @AuditLog(module = PLUGINS, type = UPDATE, descr = "'Default Plugin: ' + @pluginService.queryPlugin(#pluginId).pluginName")
    public Result<Boolean> defaultPlugin(@PathVariable("pluginId") Long pluginId) {
        pluginService.defaultPlugin(pluginId);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{pluginId}")
    @PreAuthorize("hasAuthority('system:plugin:delete')")
    @AuditLog(module = PLUGINS, type = DELETE, descr = "'Delete Plugin: ' + @pluginService.queryPlugin(#pluginId).pluginName")
    public Result<Boolean> deletePlugin(@PathVariable("pluginId") Long pluginId) {
        pluginService.deletePlugin(pluginId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

}
