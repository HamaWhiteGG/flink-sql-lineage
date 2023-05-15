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

package com.hw.lineage.server.domain.graph.basic;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Edge
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
public class Edge<N extends Node> {

    private Integer edgeId;

    private N source;

    private N target;

    public Edge(Integer edgeId, N source, N target) {
        this.edgeId = edgeId;
        this.source = source;
        this.target = target;

        this.source.getChildIdSet().add(target.getNodeId());
        this.target.getParentIdSet().add(source.getNodeId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!source.equals(edge.source)) return false;
        return target.equals(edge.target);
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + target.hashCode();
        return result;
    }
}
