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

package com.hw.lineage.common.enums;

import com.hw.lineage.common.enums.basic.StringEnum;

/**
 * @description: SqlType
 * @author: HamaWhite
 */
public enum SqlType implements StringEnum<SqlType> {
    SELECT("select"),
    CREATE("create"),
    DROP("drop"),
    ALTER("alter"),
    INSERT("insert"),
    ANALYZE("analyze"),
    DESCRIBE("describe"),
    EXPLAIN("explain"),
    USE("use"),
    SHOW("show"),
    LOAD("load"),
    UNLOAD("unload"),
    SET("set"),
    RESET("reset"),
    JAR("jar");

    private final String value;

    SqlType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
