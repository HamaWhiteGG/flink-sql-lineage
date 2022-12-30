package com.dtwave.flink.lineage;

import com.dtwave.flink.lineage.cep.CepTest;
import com.dtwave.flink.lineage.common.CommonTest;
import com.dtwave.flink.lineage.localtimestamp.LocaltimestampTest;
import com.dtwave.flink.lineage.lookup.join.LookupJoinTest;
import com.dtwave.flink.lineage.tablefuncion.TableFunctionTest;
import com.dtwave.flink.lineage.watermark.WatermarkTest;

import com.dtwave.flink.lineage.window.WindowTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @description: SuiteTest
 * @author: baisong
 * @version: 1.0.0
 * @date: 2022/11/24 5:49 PM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CommonTest.class
        , LookupJoinTest.class
        , TableFunctionTest.class
        , WatermarkTest.class
        , LocaltimestampTest.class
        , CepTest.class
        , WindowTest.class})
public class SuiteTest {

    /**
     * The entry class of the test suite is just to organize the test classes together for testing,
     * without any test methods.
     */
}
