/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.start;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * There is a custom implementation in Mybatis Generator, and an error will be reported when using the maven plugin.
 * At this time, it will be run through the Java program MybatisGenerator
 *
 * @description: MybatisGenerator
 * @author: HamaWhite
 */
public class MybatisGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(MybatisGenerator.class);

    private static final String MYBATIS_GENERATOR_CONFIG = "mybatis/mybatis-generator.xml";

    public static void main(String[] args) {
        try {
            InputStream input = MybatisGenerator.class.getClassLoader().getResourceAsStream(MYBATIS_GENERATOR_CONFIG);
            List<String> warnings = new ArrayList<>();
            ConfigurationParser cp = new ConfigurationParser(warnings);

            Configuration config = cp.parseConfiguration(input);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            // generate file
            myBatisGenerator.generate(null);
            warnings.forEach(LOG::warn);
        } catch (Exception e) {
            LOG.error("Mybatis Generator is error", e);
            Thread.currentThread().interrupt();
        }
    }
}
