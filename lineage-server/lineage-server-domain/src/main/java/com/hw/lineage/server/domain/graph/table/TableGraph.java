package com.hw.lineage.server.domain.graph.table;

import com.hw.lineage.server.domain.graph.basic.Graph;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

/**
 * @description: TableGraph
 * @author: HamaWhite
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TableGraph extends Graph<TableNode, TableEdge> {

    public TableGraph(Map<String, TableNode> nodeMap, Set<TableEdge> edgeSet) {
        super(nodeMap, edgeSet);
    }
}