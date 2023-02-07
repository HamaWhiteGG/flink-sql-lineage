package com.lineage.server.infrastructure.config;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


/**
 * @description: LineageConfig
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/7 8:27 PM
 */
@Data
@Component
public class LineageConfig {

    @Value("${lineage.plugin.dir}")
    private String pluginDir;
}
