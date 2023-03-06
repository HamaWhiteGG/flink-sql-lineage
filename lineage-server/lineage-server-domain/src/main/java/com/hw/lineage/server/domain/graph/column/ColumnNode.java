package com.hw.lineage.server.domain.graph.column;

import com.hw.lineage.server.domain.graph.basic.Node;
import lombok.Data;

/**
 * @description: ColumnNode
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class ColumnNode extends Node {

    private Integer tableNodeId;

    public ColumnNode(Integer nodeId, String nodeName, Integer tableNodeId) {
        super(nodeId, nodeName);
        this.tableNodeId = tableNodeId;
    }
}
