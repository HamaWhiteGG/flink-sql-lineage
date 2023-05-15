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

package com.hw.lineage.server.domain.repository;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.AbstractSpringBootTest;
import com.hw.lineage.server.domain.entity.Function;
import com.hw.lineage.server.domain.query.function.FunctionEntry;
import com.hw.lineage.server.domain.query.function.FunctionTaskQuery;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.FunctionId;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description: FunctionRepositoryTest
 * @author: HamaWhite
 */
public class FunctionRepositoryTest extends AbstractSpringBootTest {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionRepositoryTest.class);

    @Resource
    private FunctionRepository functionRepository;

    @Test
    public void testFindEntry() {
        FunctionId functionId = new FunctionId(1L);
        FunctionEntry entry = functionRepository.findEntry(functionId);

        assertThat(entry).isNotNull();
        assertThat(entry.getPluginCode()).isEqualTo("flink1.16.x");
        assertThat(entry.getCatalogName()).isEqualTo("Flink1_16_Memory");
        assertThat(entry.getDatabase()).isEqualTo("default");
        assertThat(entry.getFunctionId()).isEqualTo(1L);
        assertThat(entry.getFunctionName()).isEqualTo("flink_suffix_udf");
    }

    @Test
    public void testFind() {
        CatalogId catalogId = new CatalogId(1L);
        Function function = functionRepository.find(catalogId, "default", "flink_suffix_udf");

        assertThat(function).isNotNull();
        assertThat(function.getFunctionId()).isEqualTo(new FunctionId(1L));
    }

    @Test
    public void testFindMemory() {
        List<Function> functionList = functionRepository.findMemory();
        assertThat(functionList).isNotNull();
        functionList.forEach(function -> LOG.info("memory function: {}", function.toString()));
        assertThat(functionList).asList().hasSize(3);
    }

    @Test
    public void testFindFunctionTasks() {
        FunctionTaskQuery query = new FunctionTaskQuery();
        query.setFunctionId(1L);
        PageInfo<FunctionTaskDTO> pageInfo = functionRepository.findFunctionTasks(query);
        LOG.info("result: {}", pageInfo);
        assertThat(pageInfo).isNotNull();
    }
}
