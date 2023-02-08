package com.lineage.server.interfaces.controller;

import com.lineage.server.application.cqe.command.function.CreateFunctionCmd;
import com.lineage.server.application.cqe.command.function.UpdateFunctionCmd;
import com.lineage.server.application.dto.FunctionDTO;
import com.lineage.server.application.service.FunctionService;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public Result<FunctionDTO> queryFunction(@PathVariable("functionId") Long functionId) {
        FunctionDTO functionDTO = functionService.queryFunction(functionId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, functionDTO);
    }

    @PostMapping("")
    public Result<Long> createFunction(@Valid @RequestBody CreateFunctionCmd createFunctionCmd) {
        Long functionId = functionService.createFunction(createFunctionCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, functionId);
    }

    @PutMapping("/{functionId}")
    public Result<Boolean> updateFunction(@PathVariable("functionId") Long functionId,
                                          @Valid @RequestBody UpdateFunctionCmd updateFunctionCmd) {
        updateFunctionCmd.setFunctionId(functionId);
        functionService.updateFunction(updateFunctionCmd);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{functionId}")
    public Result<Boolean> deleteFunction(@PathVariable("functionId") Long functionId) {
        functionService.deleteFunction(functionId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

}
