package com.hw.lineage.server.infrastructure.persistence.mybatis.function;

import org.mybatis.dynamic.sql.BindableColumn;
import org.mybatis.dynamic.sql.render.TableAliasCalculator;
import org.mybatis.dynamic.sql.select.function.AbstractUniTypeFunction;

/**
 * @description: GroupConcat
 * @author: HamaWhite
 */

public class GroupConcat<T> extends AbstractUniTypeFunction<T, GroupConcat<T>> {

    private GroupConcat(BindableColumn<T> column) {
        super(column);
    }

    @Override
    public String renderWithTableAlias(TableAliasCalculator tableAliasCalculator) {
        return "group_concat(" + column.renderWithTableAlias(tableAliasCalculator) + ")";
    }

    @Override
    protected GroupConcat<T> copy() {
        return new GroupConcat<>(column);
    }

    public static <T> GroupConcat<T> of(BindableColumn<T> column) {
        return new GroupConcat<>(column);
    }
}
