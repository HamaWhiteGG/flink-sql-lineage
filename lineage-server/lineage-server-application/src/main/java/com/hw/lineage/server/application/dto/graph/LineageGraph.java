package com.hw.lineage.server.application.dto.graph;

import com.hw.lineage.server.application.dto.graph.link.basic.Link;
import com.hw.lineage.server.application.dto.graph.node.Node;
import lombok.Data;

import java.util.List;

/**
 * @description: LineageGraph
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class LineageGraph {

    private List<Node> nodes;

    private List<Link> links;

}
