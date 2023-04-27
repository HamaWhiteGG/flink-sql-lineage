package com.hw.lineage.server.application.dto.graph.link;

import com.hw.lineage.server.application.dto.graph.link.basic.Link;
import lombok.Data;

/**
 * @description: ColumnLink
 * @author: HamaWhite
 */
@Data
public class ColumnLink extends Link {

    private String u;

    private String v;

    private String transform;

    public ColumnLink(String id, String relU, String relV, String u, String v, String transform) {
        super(id, relU, relV);
        this.u = u;
        this.v = v;
        this.transform = transform;
    }
}
