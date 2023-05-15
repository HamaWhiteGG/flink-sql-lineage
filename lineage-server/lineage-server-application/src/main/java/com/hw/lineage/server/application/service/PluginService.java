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

package com.hw.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.server.application.command.plugin.CreatePluginCmd;
import com.hw.lineage.server.application.command.plugin.UpdatePluginCmd;
import com.hw.lineage.server.application.dto.PluginDTO;
import com.hw.lineage.server.domain.query.plugin.PluginCheck;
import com.hw.lineage.server.domain.query.plugin.PluginQuery;

/**
 * @description: PluginService
 * @author: HamaWhite
 */
public interface PluginService {

    Long createPlugin(CreatePluginCmd command);

    PluginDTO queryPlugin(Long pluginId);

    Boolean checkPluginExist(PluginCheck pluginCheck);

    PageInfo<PluginDTO> queryPlugins(PluginQuery pluginQuery);

    void deletePlugin(Long pluginId);

    void updatePlugin(UpdatePluginCmd command);

    void defaultPlugin(Long pluginId);
}
