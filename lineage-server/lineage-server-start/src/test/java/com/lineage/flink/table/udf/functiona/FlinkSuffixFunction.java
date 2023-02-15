package com.lineage.flink.table.udf.functiona;

import org.apache.flink.table.functions.ScalarFunction;

/**
 * @description: FlinkSuffixFunction
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/14 11:49 PM
 */
public class FlinkSuffixFunction extends ScalarFunction {

    public String eval(String input) {
        return input.concat("-HamaWhite");
    }

}