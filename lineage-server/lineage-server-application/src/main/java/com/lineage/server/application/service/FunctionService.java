package com.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.result.FunctionResult;
import com.lineage.server.application.command.function.CreateFunctionCmd;
import com.lineage.server.application.command.function.ParseFunctionCmd;
import com.lineage.server.application.command.function.UpdateFunctionCmd;
import com.lineage.server.application.dto.FunctionDTO;
import com.lineage.server.domain.query.function.FunctionCheck;
import com.lineage.server.domain.query.function.FunctionQuery;

import java.io.IOException;
import java.util.List;


/**
 * @description: FunctionService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:26 PM
 */
public interface FunctionService {

    Long createFunction(CreateFunctionCmd createFunctionCmd);

    FunctionDTO queryFunction(Long functionId);

    Boolean checkFunctionExist(FunctionCheck functionCheck);

    PageInfo<FunctionDTO> queryFunctions(FunctionQuery functionQuery);

    void deleteFunction(Long functionId);

    void updateFunction(UpdateFunctionCmd updateFunctionCmd);

    /**
     * Parse the function name, function format, function main class and description from the jar file
     */
    List<FunctionResult> parseFunction(ParseFunctionCmd parseFunctionCmd) throws IOException,ClassNotFoundException;
}
