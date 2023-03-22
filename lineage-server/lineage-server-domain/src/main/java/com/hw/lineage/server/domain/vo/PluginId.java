package com.hw.lineage.server.domain.vo;

import com.hw.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: PluginId
 * @author: HamaWhite
 */
@Data
public class PluginId implements Identifier {

    private final Long value;

    public PluginId(Long value) {
        this.value = value;
    }
}