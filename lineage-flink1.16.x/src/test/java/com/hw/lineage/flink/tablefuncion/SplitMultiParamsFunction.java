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

package com.hw.lineage.flink.tablefuncion;

import org.apache.flink.table.annotation.DataTypeHint;
import org.apache.flink.table.annotation.FunctionHint;
import org.apache.flink.table.functions.TableFunction;
import org.apache.flink.types.Row;

/**
 * The test case comes from <a href="https://github.com/HamaWhiteGG/flink-sql-lineage/pull/73">fix parse error when table function has multiple params</a>, thanks
 * <p>
 * A user-defined table function (UDTF) takes multiple scalar values as input arguments.
 *
 * @author: HamaWhite
 */
@FunctionHint(output = @DataTypeHint("ROW<word STRING, length INT>"))
public class SplitMultiParamsFunction extends TableFunction<Row> {

    public void eval(String str, String other) {
        for (String s : str.split(" ")) {
            // use collect(...) to emit a row
            collect(Row.of(s, other.length()));
        }
    }
}