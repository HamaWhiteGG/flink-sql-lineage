package com.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.util.PageUtils;
import com.lineage.server.application.assembler.DtoAssembler;
import com.lineage.server.application.command.function.CreateFunctionCmd;
import com.lineage.server.application.command.function.UpdateFunctionCmd;
import com.lineage.server.application.dto.FunctionDTO;
import com.lineage.server.application.service.FunctionService;
import com.lineage.server.domain.entity.Function;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.query.function.FunctionCheck;
import com.lineage.server.domain.query.function.FunctionQuery;
import com.lineage.server.domain.repository.FunctionRepository;
import com.lineage.server.domain.vo.FunctionId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: FunctionServiceImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:27 PM
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionRepository repository;

    @Resource
    private DtoAssembler assembler;
    
    @Override
    public Long createFunction(CreateFunctionCmd createFunctionCmd) {
        Function function = new Function()
                .setFunctionName(createFunctionCmd.getFunctionName())
                .setFunctionFormat(createFunctionCmd.getFunctionFormat())
                .setFunctionPath(createFunctionCmd.getFunctionPath())
                .setFunctionClass(createFunctionCmd.getFunctionClass())
                .setDescr(createFunctionCmd.getDescr());

        function.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        function = repository.save(function);
        return function.getFunctionId().getValue();
    }

    @Override
    public FunctionDTO queryFunction(Long functionId) {
        Function function = repository.find(new FunctionId(functionId));
        return assembler.fromFunction(function);
    }

    @Override
    public Boolean checkFunctionExist(FunctionCheck functionCheck) {
        return repository.find(functionCheck.getFunctionName());
    }

    @Override
    public PageInfo<FunctionDTO> queryFunctions(FunctionQuery functionQuery) {
        PageInfo<Function> pageInfo = repository.findAll(functionQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromFunction);
    }

    @Override
    public void deleteFunction(Long functionId) {
         repository.remove(new FunctionId(functionId));
    }

    @Override
    public void updateFunction(UpdateFunctionCmd updateFunctionCmd) {
        Function function = new Function()
                .setFunctionId(new FunctionId(updateFunctionCmd.getFunctionId()))
                .setFunctionName(updateFunctionCmd.getFunctionName())
                .setFunctionFormat(updateFunctionCmd.getFunctionFormat())
                .setFunctionPath(updateFunctionCmd.getFunctionPath())
                .setFunctionClass(updateFunctionCmd.getFunctionClass())
                .setDescr(updateFunctionCmd.getDescr());

        function.setModifyTime(System.currentTimeMillis());
         repository.save(function);
    }
}