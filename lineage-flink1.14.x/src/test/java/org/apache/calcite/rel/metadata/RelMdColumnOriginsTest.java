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

package org.apache.calcite.rel.metadata;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RelMdColumnOriginsTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(RelMdColumnOriginsTest.class);

    /**
     * Test snippet code
     */
    public void testReplaceSourceColumn() {
        Set<String> sourceColumnSet = new LinkedHashSet<>();
        sourceColumnSet.add("name");
        sourceColumnSet.add("age");

        String input = "CONCAT($1, $1, $5)";
        Pattern pattern = Pattern.compile("\\$\\d+");
        Matcher matcher = pattern.matcher(input);

        Set<String> operandSet = new LinkedHashSet<>();
        while (matcher.find()) {
            operandSet.add(matcher.group());
        }

        Map<String, String> sourceColumnMap = new HashMap<>();
        Iterator<String> iterator = sourceColumnSet.iterator();
        operandSet.forEach(e -> sourceColumnMap.put(e, iterator.next()));
        LOG.debug("sourceColumnMap: {}", sourceColumnMap);

        matcher = pattern.matcher(input);
        String temp;
        while (matcher.find()) {
            temp = matcher.group();
            input = input.replace(temp, sourceColumnMap.get(temp));
        }

        assertEquals("CONCAT(name, name, age)", input);
    }
}