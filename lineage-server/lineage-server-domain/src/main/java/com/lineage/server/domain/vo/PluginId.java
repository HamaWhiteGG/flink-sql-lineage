package com.lineage.server.domain.vo;

import com.lineage.server.domain.repository.basic.Identifier;
import lombok.Data;

/**
 * @description: PluginId
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:16 PM
 */
@Data
public class PluginId implements Identifier {

    private final Long value;

    public PluginId(Long value) {
        this.value = value;
    }
}