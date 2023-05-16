/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.interfaces.controller;

import com.hw.lineage.common.model.FunctionInfo;
import com.hw.lineage.server.application.command.function.ParseFunctionCmd;
import com.hw.lineage.server.application.service.FunctionService;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

import static com.hw.lineage.common.enums.audit.ModuleCode.FUNCTION;
import static com.hw.lineage.common.enums.audit.OperationType.PARSE_FUNCTION;

/**
 * @description: FunctionController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Functions API")
@RequestMapping("/functions")
public class FunctionController {

    @Resource
    private FunctionService functionService;

    @PostMapping("/parse")
    @AuditLog(module = FUNCTION, type = PARSE_FUNCTION, descr = "'Parse File: ' + #command.functionPath")
    public Result<List<FunctionInfo>> parseFunction(@Valid @RequestBody ParseFunctionCmd command)
            throws IOException, ClassNotFoundException {
        List<FunctionInfo> functionDTOList = functionService.parseFunction(command);
        return Result.success(ResultMessage.PARSE_FUNCTION_SUCCESS, functionDTOList);
    }
}
