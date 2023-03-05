package com.hw.lineage.server.application.dto.graph.link.basic;

import lombok.Data;

/**
 * @description: Link
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public abstract class Link {

    private Integer id;

    private Integer relU;

    private Integer relV;
}
