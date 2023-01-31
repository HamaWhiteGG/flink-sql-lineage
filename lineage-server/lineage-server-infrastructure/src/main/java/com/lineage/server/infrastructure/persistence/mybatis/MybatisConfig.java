package com.lineage.server.infrastructure.persistence.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MybatisConfig
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/30 8:43 PM
 */
@Configuration
@MapperScan("com.lineage.server.infrastructure.persistence.mapper")
public class MybatisConfig {
}
