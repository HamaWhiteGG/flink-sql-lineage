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

import com.hw.lineage.server.application.service.CatalogService;
import com.hw.lineage.server.application.service.FunctionService;
import com.hw.lineage.server.application.service.StorageService;
import com.hw.lineage.server.application.service.TableService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description: LineageServerApplication
 * @author: HamaWhite
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.hw.lineage.server.*"})
public class LineageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LineageServerApplication.class, args);
    }

    @Bean
    @Order(1)
    CommandLineRunner initStorage(StorageService storageService) {
        return args -> storageService.init();
    }

    @Bean
    @Order(2)
    CommandLineRunner createMemoryCatalogs(CatalogService catalogService) {
        return args -> catalogService.createMemoryCatalogs();
    }

    @Bean
    @Order(3)
    CommandLineRunner createMemoryTables(TableService tableService) {
        return args -> tableService.createMemoryTables();
    }

    @Bean
    @Order(4)
    CommandLineRunner createMemoryFunctions(FunctionService functionService) {
        return args -> functionService.createMemoryFunctions();
    }
}
