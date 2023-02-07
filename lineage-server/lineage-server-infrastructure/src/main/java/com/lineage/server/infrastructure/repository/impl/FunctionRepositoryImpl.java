package com.lineage.server.infrastructure.repository.impl;

import com.hw.lineage.common.exception.LineageException;
import com.lineage.server.domain.entity.Function;
import com.lineage.server.domain.repository.FunctionRepository;
import com.lineage.server.domain.vo.FunctionId;
import com.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.lineage.server.infrastructure.persistence.dos.FunctionDO;
import com.lineage.server.infrastructure.persistence.mapper.FunctionMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * @description: FunctionRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:23 PM
 */
@Repository
public class FunctionRepositoryImpl implements FunctionRepository {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public Function find(FunctionId functionId) {
        FunctionDO functionDO = functionMapper.selectByPrimaryKey(functionId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("functionId [%s] is not existed", functionId.getValue()))
                );
        return DataConverter.INSTANCE.toFunction(functionDO);
    }

    @Override
    public Function save(Function function) {
        FunctionDO functionDO = DataConverter.INSTANCE.fromFunction(function);
        if (functionDO.getFunctionId() == null) {
            functionMapper.insertSelective(functionDO);
        } else {
            functionMapper.updateByPrimaryKeySelective(functionDO);
        }
        return DataConverter.INSTANCE.toFunction(functionDO);
    }

    @Override
    public void remove(FunctionId functionId) {
        functionMapper.deleteByPrimaryKey(functionId.getValue());
    }
}
