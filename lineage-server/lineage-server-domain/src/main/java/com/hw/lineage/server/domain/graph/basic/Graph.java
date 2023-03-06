package com.hw.lineage.server.domain.graph.basic;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: Graph
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class Graph<N extends Node, E extends Edge> {

    private Map<String, Node> nodeMap;

    private Set<E> edgeSet;

    public Graph() {
        this.nodeMap = new HashMap<>();
        this.edgeSet = new HashSet<>();
    }

    public Node getNode(String nodeName) {
        return nodeMap.get(nodeName);
    }

    public void putNode(String nodeName, N node) {
        nodeMap.put(nodeName, node);
    }

    public void addEdge(E edge) {
        edgeSet.add(edge);
    }
}

