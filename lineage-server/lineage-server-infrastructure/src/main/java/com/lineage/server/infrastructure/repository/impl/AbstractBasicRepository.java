package com.lineage.server.infrastructure.repository.impl;

import com.google.common.base.CaseFormat;
import com.lineage.server.domain.query.OrderCriteria;
import org.mybatis.dynamic.sql.SortSpecification;

import static org.mybatis.dynamic.sql.SqlBuilder.sortColumn;

/**
 * @description: AbstractBasicRepository
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 6:57 PM
 */
public abstract class AbstractBasicRepository {

    protected String buildLikeValue(String value) {
        if (value == null) {
            value = "";
        }
        return "%" + value + "%";
    }

    public SortSpecification buildSortSpecification(OrderCriteria criteria) {
        String columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, criteria.getSortColumn());
        SortSpecification sortSpec = sortColumn(columnName);
        return criteria.isDescending() ? sortSpec.descending() : sortSpec;
    }
}
