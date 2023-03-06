package com.hw.lineage.server.domain.graph.column;

import com.hw.lineage.server.domain.graph.basic.Edge;
import com.hw.lineage.server.domain.graph.basic.Node;
import lombok.Data;

/**
 * @description: ColumnEdge
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class ColumnEdge extends Edge {

    private String transform;

    public ColumnEdge(Node source, Node target, String transform) {
        super(source, target);
        this.transform = transform;
    }
}
