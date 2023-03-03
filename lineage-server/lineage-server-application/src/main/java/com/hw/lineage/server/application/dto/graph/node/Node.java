package com.hw.lineage.server.application.dto.graph.node;

import lombok.Data;

import java.util.List;

/**
 * @description: Node
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class Node {

    private Integer id;

    private String name;

    private List<Column> columns;

    private Boolean hasUpstream;

    private Boolean hasDownstream;

    private String tableIcon;
}
