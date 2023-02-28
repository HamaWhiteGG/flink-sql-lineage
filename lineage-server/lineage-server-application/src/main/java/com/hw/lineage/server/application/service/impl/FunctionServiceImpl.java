package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.result.FunctionResult;
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
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.repository.FunctionRepository;
import com.hw.lineage.server.domain.repository.PluginRepository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.FunctionId;
import com.hw.lineage.server.domain.vo.PluginId;
import com.hw.lineage.server.domain.vo.Storage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description: FunctionServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionRepository functionRepository;

    @Resource
    private PluginRepository pluginRepository;

    @Resource
    private StorageFacade storageFacade;

    @Resource
    private LineageFacade lineageFacade;

    @Resource
    private DtoAssembler assembler;

    @Override
    public Long createFunction(CreateFunctionCmd createFunctionCmd) {
        Function function = new Function()
                .setCatalogId(new CatalogId(createFunctionCmd.getCatalogId()))
                .setFunctionName(createFunctionCmd.getFunctionName())
                .setDatabase(createFunctionCmd.getDatabase())
                .setInvocation(createFunctionCmd.getInvocation())
                .setFunctionPath(createFunctionCmd.getFunctionPath())
                .setClassName(createFunctionCmd.getClassName())
                .setDescr(createFunctionCmd.getDescr());

        function.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

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
        return functionRepository.check(functionCheck.getFunctionName());
    }

    @Override
    public PageInfo<FunctionDTO> queryFunctions(FunctionQuery functionQuery) {
        PageInfo<Function> pageInfo = functionRepository.findAll(functionQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromFunction);
    }

    @Override
    public void deleteFunction(Long functionId) {
        functionRepository.remove(new FunctionId(functionId));
    }

    @Override
    public void updateFunction(UpdateFunctionCmd updateFunctionCmd) {
        Function function = new Function()
                .setFunctionId(new FunctionId(updateFunctionCmd.getFunctionId()))
                .setInvocation(updateFunctionCmd.getInvocation())
                .setDescr(updateFunctionCmd.getDescr());

        function.setModifyTime(System.currentTimeMillis());
        functionRepository.save(function);
    }

    @Override
    public List<FunctionResult> parseFunction(ParseFunctionCmd parseFunctionCmd) throws IOException,ClassNotFoundException{
        String fileName=parseFunctionCmd.getFileName();
        File file = storageFacade.loadAsResource(new Storage(fileName)).getFile();
        Plugin plugin=pluginRepository.find(new PluginId(parseFunctionCmd.getPluginId()));
        // parse function info
       return lineageFacade.parseFunction(plugin.getPluginName(),file);

    }
}