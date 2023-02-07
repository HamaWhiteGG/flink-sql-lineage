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
        pluginService.updatePlugin(updatePluginCmd);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{pluginId}")
    public Result<Boolean> deletePlugin(@PathVariable("pluginId") final Long pluginId) {
        pluginService.deletePlugin(pluginId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

}
