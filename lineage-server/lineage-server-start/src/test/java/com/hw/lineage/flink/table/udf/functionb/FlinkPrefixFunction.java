package com.hw.lineage.flink.table.udf.functionb;

import org.apache.flink.table.functions.ScalarFunction;

/**
 * @description: FlinkPrefixFunction
 * @author: HamaWhite
 */
public class FlinkPrefixFunction extends ScalarFunction {

    public String eval(String input, Integer value) {
        return "HamaWhite".concat(input).concat(" : " + value);
    }

}
