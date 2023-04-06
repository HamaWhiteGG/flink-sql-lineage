package extensions.org.apache.flink.table.planner.delegation.ParserImpl;


import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Jailbreak;
import manifold.ext.rt.api.This;
import org.apache.calcite.sql.SqlNode;
import org.apache.flink.table.planner.calcite.FlinkPlannerImpl;
import org.apache.flink.table.planner.delegation.ParserImpl;
import org.apache.flink.table.planner.parse.CalciteParser;

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

        // parse the sql query
        return parser.parse(statement);
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
