package com.hw.lineage.server.domain.graph.basic;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: Graph
 * @author: HamaWhite
 */
@Data
public class Graph<N extends Node, E extends Edge<N>> {

    private Map<String, N> nodeMap;

    private Set<E> edgeSet;

    public Graph() {
        this.nodeMap = new HashMap<>();
        this.edgeSet = new HashSet<>();
    }

    public Graph(Map<String, N> nodeMap, Set<E> edgeSet) {
        this.nodeMap = nodeMap;
        this.edgeSet = edgeSet;
    }

    public Set<N> queryNodeSet() {
        return new HashSet<>(nodeMap.values());
    }

    public N queryNode(String nodeName) {
        return nodeMap.get(nodeName);
    }

    public void addNode(String nodeName, N node) {
        nodeMap.put(nodeName, node);
    }

    public void addEdge(E edge) {
        edgeSet.add(edge);
    }

    public Map<Integer, N> queryNodeIdMap() {
        return nodeMap.values()
                .stream()
                .collect(Collectors.toMap(N::getNodeId, node -> node));
    }

    public Set<Integer> queryNodeIdSet() {
        return nodeMap.values()
                .stream()
                .map(N::getNodeId)
                .collect(Collectors.toSet());
    }
}

