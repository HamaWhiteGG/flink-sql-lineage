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
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.repository.CatalogRepository;
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
                .setFunctionName(command.getFunctionName())
                .setDatabase(command.getDatabase())
                .setInvocation(command.getInvocation())
                .setFunctionPath(command.getFunctionPath())
                .setClassName(command.getClassName())
                .setDescr(command.getDescr());

        function.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        CatalogEntry entry = catalogRepository.findEntry(function.getCatalogId());
        lineageFacade.createFunction(entry.getPluginCode(), entry.getCatalogName(), function.getDatabase()
                , function.getFunctionName(), function.getClassName(), function.getFunctionPath());

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
        FunctionId id = new FunctionId(functionId);
        Function function = functionRepository.find(id);
        CatalogEntry entry = catalogRepository.findEntry(function.getCatalogId());
        lineageFacade.deleteCatalog(entry.getPluginCode(), entry.getCatalogName());
        functionRepository.remove(id);
    }

    @Override
    public void updateFunction(UpdateFunctionCmd command) {
        Function function = new Function()
                .setFunctionId(new FunctionId(command.getFunctionId()))
                .setInvocation(command.getInvocation())
                .setDescr(command.getDescr());

        function.setModifyTime(System.currentTimeMillis());
        functionRepository.save(function);
    }

    @Override
    public List<FunctionResult> parseFunction(ParseFunctionCmd command) throws IOException, ClassNotFoundException {
        String fileName = command.getFileName();
        File file = storageFacade.loadAsResource(new Storage(fileName)).getFile();
        Plugin plugin = pluginRepository.find(new PluginId(command.getPluginId()));
        // parse function info
        return lineageFacade.parseFunction(plugin.getPluginName(), file);

    }
}