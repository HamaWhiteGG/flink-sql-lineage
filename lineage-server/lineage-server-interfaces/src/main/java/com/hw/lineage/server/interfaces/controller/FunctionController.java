package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.result.FunctionResult;
import com.hw.lineage.server.application.command.function.CreateFunctionCmd;
import com.hw.lineage.server.application.command.function.ParseFunctionCmd;
import com.hw.lineage.server.application.command.function.UpdateFunctionCmd;
import com.hw.lineage.server.application.dto.FunctionDTO;
import com.hw.lineage.server.application.service.FunctionService;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @description: FunctionController
 * @author: HamaWhite
 * @version: 1.0.0
 */
@RestController
@Api(tags = "Functions API")
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
    public Result<Long> createFunction(@Valid @RequestBody CreateFunctionCmd command) {
        Long functionId = functionService.createFunction(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, functionId);
    }

    @GetMapping("/exist")
    public Result<Boolean> checkFunctionExist(@Valid FunctionCheck functionCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, functionService.checkFunctionExist(functionCheck));
    }

    @PutMapping("/{functionId}")
    public Result<Boolean> updateFunction(@PathVariable("functionId") Long functionId,
                                          @Valid @RequestBody UpdateFunctionCmd command) {
        command.setFunctionId(functionId);
        functionService.updateFunction(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{functionId}")
    public Result<Boolean> deleteFunction(@PathVariable("functionId") Long functionId) {
        functionService.deleteFunction(functionId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @PostMapping("/parse")
    public Result<List<FunctionResult>> parseFunction(@Valid @RequestBody ParseFunctionCmd command)
            throws IOException, ClassNotFoundException {
        List<FunctionResult> functionDTOList = functionService.parseFunction(command);
        return Result.success(ResultMessage.PARSE_FUNCTION_SUCCESS, functionDTOList);
    }
}
