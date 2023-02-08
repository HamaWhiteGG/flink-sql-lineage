package com.lineage.server.application.service;

import com.lineage.server.application.cqe.command.function.CreateFunctionCmd;
import com.lineage.server.application.cqe.command.function.UpdateFunctionCmd;
import com.lineage.server.application.dto.FunctionDTO;

/**
 * @description: FunctionService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:26 PM
 */
public interface FunctionService {
    
    Long createFunction(CreateFunctionCmd createFunctionCmd);

    FunctionDTO queryFunction(Long functionId);

    void deleteFunction(Long functionId);

    void updateFunction(UpdateFunctionCmd updateFunctionCmd);
}
