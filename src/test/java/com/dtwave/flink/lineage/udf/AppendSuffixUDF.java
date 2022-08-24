package com.dtwave.flink.lineage.udf;

import org.apache.flink.table.functions.ScalarFunction;

/**
 * @description: AppendSuffixUDF
 * @author: baisong
 * @version: 1.0.0
 * @date: 2022/8/24 3:35 PM
 */
public class AppendSuffixUDF extends ScalarFunction {

    public String eval(String input) {
        return input.concat("-HamaWhite");
    }

}
