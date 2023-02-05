package com.lineage.server.interfaces.controller;

import com.lineage.server.application.cqe.command.plugin.CreatePluginCmd;
import com.lineage.server.application.cqe.command.plugin.UpdatePluginCmd;
import com.lineage.server.application.dto.PluginDTO;
import com.lineage.server.application.service.PluginService;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: PluginController
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:28 PM
 */
@RestController
@RequestMapping("/plugins")
public class PluginController {

    @Resource
    private PluginService pluginService;

    @GetMapping("/{pluginId}")
    public Result<PluginDTO> queryPlugin(@PathVariable("pluginId") final Long pluginId) {
        PluginDTO pluginDTO = pluginService.queryPlugin(pluginId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, pluginDTO);
    }
    
    @PostMapping("")
    public Result<Long> createPlugin(@RequestBody final CreatePluginCmd createPluginCmd) {
        Long pluginId = pluginService.createPlugin(createPluginCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, pluginId);
    }

    @PutMapping("/{pluginId}")
    public Result<Boolean> updatePlugin(@PathVariable("pluginId") final Long pluginId,
                                      @RequestBody final UpdatePluginCmd updatePluginCmd) {
        updatePluginCmd.setPluginId(pluginId);
        Boolean result = pluginService.updatePlugin(updatePluginCmd);
        return Boolean.TRUE.equals(result)
                ? Result.success(ResultMessage.UPDATE_SUCCESS)
                : Result.error(ResultMessage.UPDATE_FAILED);
    }

    @DeleteMapping("/{pluginId}")
    public Result<Boolean> deletePlugin(@PathVariable("pluginId") final Long pluginId) {
        Boolean result = pluginService.deletePlugin(pluginId);
        return Boolean.TRUE.equals(result)
                ? Result.success(ResultMessage.DELETE_SUCCESS)
                : Result.success(ResultMessage.DELETE_FAILED);
    }

}
