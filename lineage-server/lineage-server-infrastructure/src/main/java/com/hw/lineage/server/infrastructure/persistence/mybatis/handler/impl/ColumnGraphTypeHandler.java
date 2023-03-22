package com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl;

import com.hw.lineage.server.domain.graph.column.ColumnGraph;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.JsonTypeHandler;

/**
 * @description: ColumnGraphTypeHandler
 * @author: HamaWhite
 */
public class ColumnGraphTypeHandler extends JsonTypeHandler<ColumnGraph> {
    public ColumnGraphTypeHandler() {
        super(ColumnGraph.class);
    }
}
