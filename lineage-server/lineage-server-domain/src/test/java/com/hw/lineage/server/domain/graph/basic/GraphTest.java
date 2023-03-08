package com.hw.lineage.server.domain.graph.basic;


import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @description: GraphTest
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class GraphTest {

    /**
     * <pre>
     *    1 ------------> 2
     *                 ->  -
     *                -        -
     *              -             ->
     *            -                  5 ------> 6
     *          -                 ->
     *        -                -
     *      -              -
     *    3 -----------> 4
     * </pre>
     */
    @Test
    public void testComputeChildrenCnt() {
        Graph<Node, Edge<Node>> graph = new Graph<>();
        Node node1 = new Node(1, "node1");
        Node node2 = new Node(2, "node2");
        Node node3 = new Node(3, "node3");
        Node node4 = new Node(4, "node4");
        Node node5 = new Node(5, "node5");
        Node node6 = new Node(6, "node6");


        graph.addNode(node1.getNodeName(), node1);
        graph.addNode(node2.getNodeName(), node2);
        graph.addNode(node3.getNodeName(), node3);
        graph.addNode(node4.getNodeName(), node4);
        graph.addNode(node5.getNodeName(), node5);
        graph.addNode(node6.getNodeName(), node6);

        Edge<Node> edge1 = new Edge<>(7, node1, node2);
        Edge<Node> edge2 = new Edge<>(8, node2, node5);
        Edge<Node> edge3 = new Edge<>(9, node5, node6);
        Edge<Node> edge4 = new Edge<>(10, node3, node2);
        Edge<Node> edge5 = new Edge<>(11, node3, node4);
        Edge<Node> edge6 = new Edge<>(12, node4, node5);

        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        graph.addEdge(edge4);
        graph.addEdge(edge5);
        graph.addEdge(edge6);


        Set<Node> headSet=graph.queryNodeSet()
                .stream()
                .filter(node->node.getParentIdSet().isEmpty())
                .collect(Collectors.toSet())
                ;


        Map<Integer, Node> nodeIdMap = graph.getNodeMap()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getValue().getNodeId(),
                        Map.Entry::getValue
                ));



    }


}