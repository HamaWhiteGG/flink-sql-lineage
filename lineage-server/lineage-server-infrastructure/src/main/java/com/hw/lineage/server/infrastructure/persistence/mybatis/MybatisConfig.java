package com.hw.lineage.server.infrastructure.persistence.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MybatisConfig
 * @author: HamaWhite
 */
@Configuration
@MapperScan("com.hw.lineage.server.infrastructure.persistence.mapper")
public class MybatisConfig {
}
