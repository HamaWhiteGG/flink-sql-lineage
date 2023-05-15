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

package com.hw.lineage.server.application.dto.graph.link;

import com.hw.lineage.server.application.dto.graph.link.basic.Link;
import lombok.Data;

/**
 * @description: ColumnLink
 * @author: HamaWhite
 */
@Data
public class ColumnLink extends Link {

    private String u;

    private String v;

    private String transform;

    public ColumnLink(String id, String relU, String relV, String u, String v, String transform) {
        super(id, relU, relV);
        this.u = u;
        this.v = v;
        this.transform = transform;
    }
}
