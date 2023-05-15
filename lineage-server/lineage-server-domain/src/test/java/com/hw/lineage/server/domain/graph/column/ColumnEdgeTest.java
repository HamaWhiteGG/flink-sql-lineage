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

package com.hw.lineage.server.domain.graph.column;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description: ColumnEdgeTest
 * @author: HamaWhite
 */
public class ColumnEdgeTest {

    /**
     * Add @EqualsAndHashCode(callSuper = true) to ColumnEdge and ColumnNode, otherwise the result is true
     */
    @Test
    public void testColumnEdgeEquals() {
        ColumnNode source1 = new ColumnNode(1, "id", 100);
        ColumnNode target1 = new ColumnNode(2, "id", 102);
        ColumnEdge edge1 = new ColumnEdge(1, source1, target1, null);

        ColumnNode source2 = new ColumnNode(3, "name", 100);
        ColumnNode target2 = new ColumnNode(4, "name", 102);
        ColumnEdge edge2 = new ColumnEdge(2, source2, target2, null);

        assertThat(edge1.equals(edge2)).isFalse();
    }

}