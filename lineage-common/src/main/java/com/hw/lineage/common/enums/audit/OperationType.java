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

package com.hw.lineage.common.enums.audit;

import com.hw.lineage.common.enums.basic.StringEnum;

/**
 * @description: OperationType
 * @author: HamaWhite
 */
public enum OperationType implements StringEnum<OperationType> {

    LOGIN("Login"),
    LOGOUT("Logout"),
    CREATE("Create"),
    DELETE("Delete"),
    UPDATE("Update"),
    QUERY("Query"),
    UPLOAD("Upload"),
    DOWNLOAD("Download"),
    PARSE_FUNCTION("Parse Function"),
    ANALYZE_LINEAGE("Analyze Lineage"),
    CHECK_SYNTAX("Check Syntax");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
