package com.hw.flink.lineage;

import com.hw.flink.lineage.cep.CepTest;
import com.hw.flink.lineage.common.CommonTest;
import com.hw.flink.lineage.localtimestamp.LocaltimestampTest;
import com.hw.flink.lineage.lookup.join.LookupJoinTest;
import com.hw.flink.lineage.tablefuncion.TableFunctionTest;
import com.hw.flink.lineage.watermark.WatermarkTest;
import com.hw.flink.lineage.window.WindowTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @description: SuiteTest
 * @author: HamaWhite
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
