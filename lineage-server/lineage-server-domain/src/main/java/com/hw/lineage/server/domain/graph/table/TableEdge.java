package com.hw.lineage.server.domain.graph.table;

import com.hw.lineage.server.domain.graph.basic.Edge;
import com.hw.lineage.server.domain.graph.basic.Node;
import lombok.Data;

/**
 * @description: TableEdge
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class TableEdge extends Edge {

    private Long sqlId;

    public TableEdge(Node source, Node target, Long sqlId) {
        super(source, target);
        this.sqlId = sqlId;
    }
}
