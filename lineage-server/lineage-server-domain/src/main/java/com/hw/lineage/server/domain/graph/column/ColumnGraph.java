package com.hw.lineage.server.domain.graph.column;

import com.hw.lineage.server.domain.graph.basic.Graph;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

/**
 * @description: ColumnGraph
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ColumnGraph extends Graph<ColumnNode, ColumnEdge> {

    public ColumnGraph(Map<String, ColumnNode> nodeMap, Set<ColumnEdge> edgeSet) {
        super(nodeMap, edgeSet);
    }
}
