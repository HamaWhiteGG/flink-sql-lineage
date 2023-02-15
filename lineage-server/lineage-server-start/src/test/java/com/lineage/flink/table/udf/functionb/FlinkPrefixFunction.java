package com.lineage.flink.table.udf.functionb;

import org.apache.flink.table.functions.ScalarFunction;

/**
 * @description: FlinkPrefixFunction
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/14 11:49 PM
 */
public class FlinkPrefixFunction extends ScalarFunction {

    public String eval(String input, Integer value) {
        return "HamaWhite".concat(input).concat(" : " + value);
    }

}
