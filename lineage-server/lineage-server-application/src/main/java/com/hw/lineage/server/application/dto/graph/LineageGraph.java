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

package com.hw.lineage.server.application.dto.graph;

import com.hw.lineage.server.application.dto.graph.link.basic.Link;
import com.hw.lineage.server.application.dto.graph.vertex.Vertex;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: LineageGraph
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
public class LineageGraph {

    private List<Vertex> nodes;

    private List<Link> links;

    public LineageGraph() {
        this.nodes = new ArrayList<>();
        this.links = new ArrayList<>();
    }
}
