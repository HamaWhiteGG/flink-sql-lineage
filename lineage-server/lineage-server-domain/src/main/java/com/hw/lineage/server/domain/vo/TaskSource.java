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

package com.hw.lineage.server.domain.vo;

import com.hw.lineage.common.util.Base64Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TaskSource
 * @author: HamaWhite
 */
@Data
public class TaskSource {

    /**
     * ;(?=([^'"]*(['"])[^'"]*(['"]))*[^'"]*$)
     * <p>
     * Note that in order to avoid sonar S5998, + is added after the penultimate *
     */
    private static final String SPLIT_REGEX = ";(?=([^\'\"]*([\'\"])[^\'\"]*([\'\"]))*+[^\'\"]*$)";

    private static final String NEWLINE_REGEX = "\r?\n";

    private final String value;

    public TaskSource(String value) {
        this.value = value;
    }

    /**
     * Intercept according to the semicolon,
     * but ignore a semicolon surrounded by single quotes or double quotes inside SQL
     * <p>
     * Note that in order to avoid sonar S5998, + is added after the last *
     */
    public List<SplitSource> split() {
        List<SplitSource> splitList = new ArrayList<>();
        if (StringUtils.isNotEmpty(value)) {
            // base64 decode
            String source = Base64Utils.decode(value);
            // split the SQL code into separate statements
            String[] statements = source.split(SPLIT_REGEX);
            long startLineNumber = 1;
            // process comments and record the start line number of the statement
            for (String statement : statements) {
                if (statement.trim().isEmpty()) {
                    continue;
                }
                // source is preceded by comment lines or new line
                String[] lines = statement.split(NEWLINE_REGEX);
                for (String line : lines) {
                    line = line.trim();
                    if (line.startsWith("--") || line.isEmpty()) {
                        startLineNumber++;
                    }
                }
                statement = statement.replaceAll("--[^'\n]*('[^'\n]*')?[^'\n]*+", "").trim();
                splitList.add(new SplitSource(statement, startLineNumber));
                // the subtracted part supports the unwrapped
                startLineNumber += statement.split(NEWLINE_REGEX).length - (statement.endsWith(NEWLINE_REGEX) ? 0 : 1);
            }
        }
        return splitList;
    }

    @Data
    @AllArgsConstructor
    public static class SplitSource {

        private String sqlSource;

        private Long startLineNumber;
    }
}
