package com.hw.lineage.flink.aggregatefunction;

import org.apache.flink.table.functions.AggregateFunction;

public class TestAggregateFunction extends AggregateFunction<String, TestAggregateFunction.TestAggregateAcc> {

    public void accumulate(TestAggregateAcc acc, String param1, String param2, String param3) {
        acc.test = param1 + param2 + param3;
    }

    @Override
    public String getValue(TestAggregateAcc accumulator) {
        return accumulator.test;
    }

    @Override
    public TestAggregateAcc createAccumulator() {
        return new TestAggregateAcc();
    }

    public static class TestAggregateAcc {
        public String test;
    }
}
