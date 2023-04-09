package com.hw.lineage.server.domain.graph;

import com.hw.lineage.server.domain.graph.basic.Edge;
import com.hw.lineage.server.domain.graph.basic.Graph;
import com.hw.lineage.server.domain.graph.basic.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: GraphCalculator
 * @author: HamaWhite
 */
public class GraphCalculator<N extends Node, E extends Edge<N>> {

    private Graph<N, E> graph;

    private Map<Integer, N> nodeIdMap;

    private final Map<Integer, Set<Integer>> childrenMap;

    private final Set<Integer> visitIdSet;

    public GraphCalculator(Graph<N, E> graph) {
        this.graph = graph;
        this.childrenMap = new HashMap<>();
        this.visitIdSet = new HashSet<>();
        this.nodeIdMap = graph.queryNodeIdMap();
    }

    /**
     * Calculate the count of all downstream nodes for each node in the graph
     */
    public void calculateChildrenCnt() {
        Set<N> startSet = graph.queryNodeSet()
                .stream()
                .filter(node -> node.getParentIdSet().isEmpty())
                .collect(Collectors.toSet());

        startSet.forEach(this::searchChildrenSet);
        graph.queryNodeSet().forEach(node -> node.setChildrenCnt(childrenMap.get(node.getNodeId()).size()));
    }

    private void searchChildrenSet(N node) {
        Integer nodeId = node.getNodeId();
        visitIdSet.add(nodeId);
        if (node.getChildIdSet().isEmpty()) {
            childrenMap.put(nodeId, Collections.emptySet());
        }
        Set<Integer> childrenSet = new HashSet<>();
        for (Integer childId : node.getChildIdSet()) {
            if (!visitIdSet.contains(childId)) {
                searchChildrenSet(nodeIdMap.get(childId));
            }
            childrenSet.add(childId);
            childrenSet.addAll(childrenMap.get(childId));
        }
        childrenMap.put(nodeId, childrenSet);
    }

    public Map<Integer, Set<Integer>> getChildrenMap() {
        return childrenMap;
    }
}
