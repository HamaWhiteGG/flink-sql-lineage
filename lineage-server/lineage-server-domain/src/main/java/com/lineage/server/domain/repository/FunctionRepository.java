package com.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.lineage.server.domain.entity.Function;
import com.lineage.server.domain.query.function.FunctionQuery;
import com.lineage.server.domain.repository.basic.Repository;
import com.lineage.server.domain.vo.FunctionId;

/**
 * @description: FunctionRepository
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:21 PM
 */
public interface FunctionRepository extends Repository<Function, FunctionId> {
    PageInfo<Function> findAll(FunctionQuery functionQuery);
}