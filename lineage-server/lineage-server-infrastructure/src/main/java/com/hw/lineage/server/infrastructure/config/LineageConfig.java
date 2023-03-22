package com.hw.lineage.server.infrastructure.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @description: LineageConfig
 * @author: HamaWhite
 */
@Data
@Component
public class LineageConfig {

    @Value("${lineage.plugin.dir}")
    private String pluginDir;

    @Value("${lineage.storage.dir}")
    private String storageDir;
}
