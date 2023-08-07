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

import java.util.HashSet;
import java.util.Set;

/**
 * @description: node.Node
 * @author: HamaWhite
 */
@Data
@NoArgsConstructor
public class Node {

    private Integer nodeId;

    private String nodeName;

    private Set<Integer> parentIdSet;

    private Set<Integer> childIdSet;

    private Integer childrenCnt;

    public Node(Integer nodeId, String nodeName) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;

        this.parentIdSet = new HashSet<>();
        this.childIdSet = new HashSet<>();
        this.childrenCnt = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        return nodeId.equals(node.nodeId);
    }

    @Override
    public int hashCode() {
        return nodeId.hashCode();
    }
}
