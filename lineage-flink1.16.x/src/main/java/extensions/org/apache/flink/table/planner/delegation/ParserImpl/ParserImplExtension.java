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

package extensions.org.apache.flink.table.planner.delegation.ParserImpl;


import com.google.common.base.Preconditions;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Jailbreak;
import manifold.ext.rt.api.This;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlNodeList;
import org.apache.flink.table.planner.calcite.FlinkPlannerImpl;
import org.apache.flink.table.planner.delegation.ParserImpl;
import org.apache.flink.table.planner.parse.CalciteParser;

import java.util.List;

/**
 * Extend {@link ParserImpl} with manifold-ext to add new methods.
 *
 * @author: HamaWhite
 */
@Extension
public class ParserImplExtension {

    /**
     * Entry point for parsing SQL and return the abstract syntax tree
     *
     * @param statement the SQL statement to evaluate
     * @return abstract syntax tree
     * @throws org.apache.flink.table.api.SqlParserException when failed to parse the statement
     */
    public static SqlNode parseSql(@This @Jailbreak ParserImpl thiz, String statement) {
        // add @Jailbreak annotation to access private variables
        CalciteParser parser = thiz.calciteParserSupplier.get();

        // use parseSqlList here because we need to support statement end with ';' in sql client.
        SqlNodeList sqlNodeList = parser.parseSqlList(statement);
        List<SqlNode> parsed = sqlNodeList.getList();
        Preconditions.checkArgument(parsed.size() == 1, "only single statement supported");
        return parsed.get(0);
    }


    /**
     * validate the query
     *
     * @param thiz    Implementation of Parser that uses Calcite.
     * @param sqlNode SqlNode to execute on
     * @return validated sqlNode
     */
    public static SqlNode validate(@This @Jailbreak ParserImpl thiz, SqlNode sqlNode) {
        // add @Jailbreak annotation to access private variables
        FlinkPlannerImpl flinkPlanner = thiz.validatorSupplier.get();
        return flinkPlanner.validate(sqlNode);
    }
}
