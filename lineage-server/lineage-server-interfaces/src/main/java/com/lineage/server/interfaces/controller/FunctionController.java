package com.lineage.server.interfaces.controller;

import com.lineage.server.application.cqe.command.function.CreateFunctionCmd;
import com.lineage.server.application.cqe.command.function.UpdateFunctionCmd;
import com.lineage.server.application.dto.FunctionDTO;
import com.lineage.server.application.service.FunctionService;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: FunctionController
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:28 PM
 */
@RestController
@RequestMapping("/functions")
public class FunctionController {

    @Resource
    private FunctionService functionService;


    @GetMapping("/{functionId}")
    public Result<FunctionDTO> queryFunction(@PathVariable("functionId") final Long functionId) {
        FunctionDTO functionDTO = functionService.queryFunction(functionId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, functionDTO);
    }

    @PostMapping("")
    public Result<Long> createFunction(@RequestBody final CreateFunctionCmd createFunctionCmd) {
        Long functionId = functionService.createFunction(createFunctionCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, functionId);
    }

    @PutMapping("/{functionId}")
    public Result<Boolean> updateFunction(@PathVariable("functionId") final Long functionId,
                                      @RequestBody final UpdateFunctionCmd updateFunctionCmd) {
        updateFunctionCmd.setFunctionId(functionId);
        Boolean result = functionService.updateFunction(updateFunctionCmd);
        return Boolean.TRUE.equals(result)
                ? Result.success(ResultMessage.UPDATE_SUCCESS)
                : Result.error(ResultMessage.UPDATE_FAILED);
    }

    @DeleteMapping("/{functionId}")
    public Result<Boolean> deleteFunction(@PathVariable("functionId") final Long functionId) {
        Boolean result = functionService.deleteFunction(functionId);
        return Boolean.TRUE.equals(result)
                ? Result.success(ResultMessage.DELETE_SUCCESS)
                : Result.success(ResultMessage.DELETE_FAILED);
    }

}
