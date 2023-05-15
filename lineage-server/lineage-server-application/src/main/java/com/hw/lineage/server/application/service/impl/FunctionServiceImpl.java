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

package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.model.FunctionInfo;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.function.CreateFunctionCmd;
import com.hw.lineage.server.application.command.function.ParseFunctionCmd;
import com.hw.lineage.server.application.command.function.UpdateFunctionCmd;
import com.hw.lineage.server.application.dto.FunctionDTO;
import com.hw.lineage.server.application.service.FunctionService;
import com.hw.lineage.server.domain.entity.Function;
import com.hw.lineage.server.domain.entity.Plugin;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.facade.StorageFacade;
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionEntry;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.query.function.FunctionTaskQuery;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.repository.FunctionRepository;
import com.hw.lineage.server.domain.repository.PluginRepository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.FunctionId;
import com.hw.lineage.server.domain.vo.PluginId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description: FunctionServiceImpl
 * @author: HamaWhite
 */
@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionServiceImpl.class);

    @Resource
    private FunctionRepository functionRepository;

    @Resource
    private PluginRepository pluginRepository;

    @Resource
    private CatalogRepository catalogRepository;

    @Resource
    private StorageFacade storageFacade;

    @Resource
    private LineageFacade lineageFacade;

    @Resource
    private DtoAssembler assembler;

    @Override
    public Long createFunction(CreateFunctionCmd command) {
        Function function = new Function()
                .setCatalogId(new CatalogId(command.getCatalogId()))
                .setDatabase(command.getDatabase())
                .setFunctionName(command.getFunctionName())
                .setInvocation(command.getInvocation())
                .setFunctionPath(command.getFunctionPath())
                .setClassName(command.getClassName())
                .setDescr(command.getDescr());

        function.setCreateUserId(command.getUserId())
                .setModifyUserId(command.getUserId());

        function.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        createFunctionInEngine(function);

        function = functionRepository.save(function);
        return function.getFunctionId().getValue();
    }

    @Override
    public FunctionDTO queryFunction(Long functionId) {
        Function function = functionRepository.find(new FunctionId(functionId));
        return assembler.fromFunction(function);
    }

    @Override
    public Boolean checkFunctionExist(FunctionCheck functionCheck) {
        return functionRepository.check(functionCheck);
    }

    @Override
    public PageInfo<FunctionDTO> queryFunctions(FunctionQuery functionQuery) {
        PageInfo<Function> pageInfo = functionRepository.findAll(functionQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromFunction);
    }

    @Override
    public PageInfo<FunctionTaskDTO> queryFunctionTasks(FunctionTaskQuery query) {
        return functionRepository.findFunctionTasks(query);
    }

    @Override
    public void deleteFunction(Long catalogId, String database, Long functionId) {
        FunctionId id = new FunctionId(functionId);
        FunctionEntry entry = functionRepository.findEntry(id);
        lineageFacade.deleteFunction(entry.getPluginCode(), entry.getCatalogName(), database, entry.getFunctionName());
        functionRepository.remove(id);
    }

    @Override
    public void updateFunction(UpdateFunctionCmd command) {
        Function function = new Function()
                .setFunctionId(new FunctionId(command.getFunctionId()))
                .setInvocation(command.getInvocation())
                .setDescr(command.getDescr());

        function.setModifyUserId(command.getUserId());
        function.setModifyTime(System.currentTimeMillis());
        functionRepository.save(function);
    }

    @Override
    public List<FunctionInfo> parseFunction(ParseFunctionCmd command) throws IOException, ClassNotFoundException {
        File file = storageFacade.loadAsResource(command.getFunctionPath()).getFile();
        Plugin plugin = pluginRepository.find(new PluginId(command.getPluginId()));
        // parse function info
        return lineageFacade.parseFunction(plugin.getPluginCode(), file);

    }

    @Override
    public void createMemoryFunctions() {
        List<Function> functionList = functionRepository.findMemory();
        // create functions of memory catalog in flink
        functionList.forEach(this::createFunctionInEngine);
    }


    private void createFunctionInEngine(Function function) {
        CatalogEntry entry = catalogRepository.findEntry(function.getCatalogId());
        String functionPath = storageFacade.getUri(function.getFunctionPath());
        lineageFacade.createFunction(entry.getPluginCode(), entry.getCatalogName(), function.getDatabase()
                , function.getFunctionName(), function.getClassName(), functionPath);
        LOG.info("created function: [{}] in catalog: [{}]", function.getFunctionName(), entry.getCatalogName());
    }
}