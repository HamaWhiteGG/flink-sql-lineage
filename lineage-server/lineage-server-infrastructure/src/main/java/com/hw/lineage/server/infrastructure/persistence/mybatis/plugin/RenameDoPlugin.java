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

package com.hw.lineage.server.infrastructure.persistence.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

/**
 * @description: RenameDomainPlugin
 * @author: HamaWhite
 */
public class RenameDoPlugin extends PluginAdapter {

    private static final String DATA_OBJECT_SUFFIX = "DO";

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        // add DO suffix to Data Object
        String recordType = introspectedTable.getBaseRecordType();
        introspectedTable.setBaseRecordType(recordType + DATA_OBJECT_SUFFIX);

        // DO suffix is not required in Mapper
        String mapperType = introspectedTable.getMyBatis3JavaMapperType();
        introspectedTable.setMyBatis3JavaMapperType(mapperType.replace(DATA_OBJECT_SUFFIX, ""));
    }
}
