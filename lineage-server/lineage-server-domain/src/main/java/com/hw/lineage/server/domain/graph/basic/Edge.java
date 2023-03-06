package com.hw.lineage.server.domain.graph.basic;

import lombok.Data;

/**
 * @description: Edge
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class Edge {

    private Node source;

    private Node target;

    public Edge(Node source, Node target) {
        this.source = source;
        this.target = target;

        this.source.getChildIdSet().add(target.getNodeId());
        this.target.getParentIdSet().add(source.getNodeId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!source.equals(edge.source)) return false;
        return target.equals(edge.target);
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + target.hashCode();
        return result;
    }
}
