package com.hw.lineage.server.application.dto.graph.link.basic;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Link
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
public abstract class Link {

    private String id;

    private String relU;

    private String relV;

    public Link(String id, String relU, String relV) {
        this.id = id;
        this.relU = relU;
        this.relV = relV;
    }
}
