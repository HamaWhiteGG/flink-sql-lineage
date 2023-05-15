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

package com.hw.lineage.server.infrastructure.persistence.mapper;

import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.server.AbstractSpringBootTest;
import com.hw.lineage.server.infrastructure.persistence.dos.PluginDO;
import org.junit.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description: PluginMapperTest
 * @author: HamaWhite
 */
public class PluginMapperTest extends AbstractSpringBootTest {

    @Resource
    private PluginMapper pluginMapper;

    @Test
    public void testSelectByPrimaryKey() {
        Long pluginId = 1L;

        PluginDO pluginDO=pluginMapper.selectByPrimaryKey(pluginId)
                .orElseThrow(() -> new LineageException(String.format("pluginId [%s] is not existed", pluginId)));

        assertThat(pluginDO).isNotNull();
        assertThat(pluginDO.getPluginId()).isEqualTo(1L);
        assertThat(pluginDO.getPluginCode()).isEqualTo("flink1.16.x");
        assertThat(pluginDO.getDescr()).isEqualTo("Field lineage plugin for flink1.16");
    }
}
