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

package com.hw.lineage.server.application.command.catalog;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.model.Property;
import com.hw.lineage.server.domain.query.BasicCriteria;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * @description: CreateCatalogCmd
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class CreateCatalogCmd extends BasicCriteria {

    @NotNull
    private Long pluginId;

    @NotBlank
    private String catalogName;

    @NotNull
    private CatalogType catalogType;

    @NotBlank
    private String defaultDatabase;

    private String descr;

    private List<Property> propertyList;

    private Boolean defaultCatalog;
}
