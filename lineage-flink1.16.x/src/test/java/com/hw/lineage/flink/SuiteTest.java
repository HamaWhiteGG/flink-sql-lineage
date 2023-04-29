package com.hw.lineage.flink;

import com.hw.lineage.flink.cep.CepTest;
import com.hw.lineage.flink.common.CommonTest;
import com.hw.lineage.flink.common.SimpleTest;
import com.hw.lineage.flink.ctas.CtasTest;
import com.hw.lineage.flink.localtimestamp.LocaltimestampTest;
import com.hw.lineage.flink.lookup.join.LookupJoinTest;
import com.hw.lineage.flink.paimon.PaimonTest;
import com.hw.lineage.flink.proctime.ProctimeTest;
import com.hw.lineage.flink.tablefuncion.TableFunctionTest;
import com.hw.lineage.flink.tvf.TvfTest;
import com.hw.lineage.flink.watermark.WatermarkTest;
import com.hw.lineage.flink.window.WindowTest;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Add the @Ignore annotation and run it manually
 *
 * @description: SuiteTest
 * @author: HamaWhite
 */
@Ignore
@RunWith(Suite.class)
@Suite.SuiteClasses({CommonTest.class
        , SimpleTest.class
        , LookupJoinTest.class
        , TableFunctionTest.class
        , WatermarkTest.class
        , LocaltimestampTest.class
        , CepTest.class
        , WindowTest.class
        , ProctimeTest.class
        , CtasTest.class
        , PaimonTest.class
        , TvfTest.class})
public class SuiteTest {

    /*
      The entry class of the test suite is just to organize the test classes together for testing,
      without any test methods.
     */
}
