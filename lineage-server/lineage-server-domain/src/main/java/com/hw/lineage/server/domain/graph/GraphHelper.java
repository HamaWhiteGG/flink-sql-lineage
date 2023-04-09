package com.hw.lineage.server.domain.graph;

import com.hw.lineage.server.domain.graph.column.ColumnEdge;
import com.hw.lineage.server.domain.graph.column.ColumnGraph;
import com.hw.lineage.server.domain.graph.column.ColumnNode;
import com.hw.lineage.server.domain.graph.table.TableEdge;
import com.hw.lineage.server.domain.graph.table.TableGraph;
import com.hw.lineage.server.domain.graph.table.TableNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: GraphHelper
 * @author: HamaWhite
 */
public class GraphHelper {

    public void calculateChildrenCnt(TableGraph tableGraph, ColumnGraph columnGraph) {
        GraphCalculator<TableNode, TableEdge> tableCalculator = new GraphCalculator<>(tableGraph);
        tableCalculator.calculateChildrenCnt();

        GraphCalculator<ColumnNode, ColumnEdge> columnCalculator = new GraphCalculator<>(columnGraph);
        columnCalculator.calculateChildrenCnt();
    }

    public TableGraph filter(TableGraph tableGraph, String nodeName) {
        TableNode currentNode = tableGraph.queryNode(nodeName);
        Set<TableNode> resultSet = new HashSet<>();
        resultSet.add(currentNode);

        Map<Integer, TableNode> nodeIdMap = tableGraph.queryNodeIdMap();
        searchParents(nodeIdMap, currentNode, resultSet);
        searchChildren(nodeIdMap, currentNode, resultSet);

        Map<String, TableNode> filterNodeMap = tableGraph.getNodeMap()
                .entrySet()
                .stream()
                .filter(entry -> resultSet.contains(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Set<TableEdge> filterEdgeSet = tableGraph.getEdgeSet()
                .stream()
                .filter(e -> resultSet.contains(e.getSource()) && resultSet.contains(e.getTarget()))
                .collect(Collectors.toSet());

        return new TableGraph(filterNodeMap, filterEdgeSet);
    }

    private void searchParents(Map<Integer, TableNode> nodeIdMap, TableNode currentNode, Set<TableNode> nodeSet) {
        for (Integer parentId : currentNode.getParentIdSet()) {
            TableNode parentNode = nodeIdMap.get(parentId);
            nodeSet.add(parentNode);
            searchParents(nodeIdMap, parentNode, nodeSet);
        }
    }

    private void searchChildren(Map<Integer, TableNode> nodeIdMap, TableNode currentNode, Set<TableNode> nodeSet) {
        for (Integer childId : currentNode.getChildIdSet()) {
            TableNode childNode = nodeIdMap.get(childId);
            nodeSet.add(childNode);
            searchChildren(nodeIdMap, childNode, nodeSet);
        }
    }

    public ColumnGraph filter(ColumnGraph columnGraph, Set<Integer> tableNodeIdSet) {
        Map<String, ColumnNode> filterNodeMap = columnGraph.getNodeMap()
                .entrySet()
                .stream()
                .filter(entry -> tableNodeIdSet.contains(entry.getValue().getTableNodeId()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Set<ColumnEdge> filterEdgeSet = columnGraph.getEdgeSet()
                .stream()
                .filter(e -> tableNodeIdSet.contains(e.getSource().getTableNodeId())
                        && tableNodeIdSet.contains(e.getTarget().getTableNodeId()))
                .collect(Collectors.toSet());

        return new ColumnGraph(filterNodeMap, filterEdgeSet);
    }
}
