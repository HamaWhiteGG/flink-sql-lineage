package com.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.lineage.server.application.command.function.CreateFunctionCmd;
import com.lineage.server.application.command.function.UpdateFunctionCmd;
import com.lineage.server.application.dto.FunctionDTO;
import com.lineage.server.application.service.FunctionService;
import com.lineage.server.domain.query.function.FunctionCheck;
import com.lineage.server.domain.query.function.FunctionQuery;
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

    @GetMapping("")
    public Result<PageInfo<FunctionDTO>> queryFunctions(FunctionQuery functionQuery) {
        PageInfo<FunctionDTO> pageInfo = functionService.queryFunctions(functionQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    public Result<Long> createFunction(@Valid @RequestBody CreateFunctionCmd createFunctionCmd) {
        Long functionId = functionService.createFunction(createFunctionCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, functionId);
    }

    @GetMapping("/exist")
    public Result<Boolean> checkFunctionExist(@Valid FunctionCheck functionCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, functionService.checkFunctionExist(functionCheck));
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
