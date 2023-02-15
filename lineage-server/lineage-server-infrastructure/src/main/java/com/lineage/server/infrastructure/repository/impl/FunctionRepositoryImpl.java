package com.lineage.server.infrastructure.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.lineage.server.domain.entity.Function;
import com.lineage.server.domain.query.function.FunctionQuery;
import com.lineage.server.domain.repository.FunctionRepository;
import com.lineage.server.domain.vo.FunctionId;
import com.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.lineage.server.infrastructure.persistence.dos.FunctionDO;
import com.lineage.server.infrastructure.persistence.mapper.FunctionMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static com.lineage.server.infrastructure.persistence.mapper.FunctionDynamicSqlSupport.functionName;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;


/**
 * @description: FunctionRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Repository
public class FunctionRepositoryImpl extends AbstractBasicRepository implements FunctionRepository {

    @Resource
    private FunctionMapper functionMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Function find(FunctionId functionId) {
        FunctionDO functionDO = functionMapper.selectByPrimaryKey(functionId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("functionId [%s] is not existed", functionId.getValue()))
                );
        return converter.toFunction(functionDO);
    }

    @Override
    public boolean find(String name) {
        return !functionMapper.select(completer -> completer.where(functionName, isEqualTo(name))).isEmpty();
    }

    @Override
    public Function save(Function function) {
        FunctionDO functionDO = converter.fromFunction(function);
        if (functionDO.getFunctionId() == null) {
            functionMapper.insertSelective(functionDO);
        } else {
            functionMapper.updateByPrimaryKeySelective(functionDO);
        }
        return converter.toFunction(functionDO);
    }

    @Override
    public void remove(FunctionId functionId) {
        functionMapper.deleteByPrimaryKey(functionId.getValue());
    }

    @Override
    public PageInfo<Function> findAll(FunctionQuery functionQuery) {
        try (Page<FunctionDO> page = PageMethod.startPage(functionQuery.getPageNum(), functionQuery.getPageSize())) {
            PageInfo<FunctionDO> pageInfo = page.doSelectPageInfo(() ->
                    functionMapper.select(completer ->
                            completer.where(functionName, isLike(buildLikeValue(functionQuery.getFunctionName())))
                                    .orderBy(buildSortSpecification(functionQuery))
                    )
            );
            return PageUtils.convertPage(pageInfo, converter::toFunction);
        }
    }
}
