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

package com.hw.lineage.flink;

import com.hw.lineage.flink.cep.CepTest;
import com.hw.lineage.flink.common.CommonTest;
import com.hw.lineage.flink.common.SimpleTest;
import com.hw.lineage.flink.localtimestamp.LocaltimestampTest;
import com.hw.lineage.flink.lookup.join.LookupJoinTest;
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
        , TvfTest.class})
public class SuiteTest {

    /*
      The entry class of the test suite is just to organize the test classes together for testing,
      without any test methods.
     */
}
