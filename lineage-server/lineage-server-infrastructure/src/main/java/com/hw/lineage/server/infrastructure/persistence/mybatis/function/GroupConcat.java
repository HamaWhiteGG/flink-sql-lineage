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
