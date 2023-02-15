package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.common.result.FunctionResult;
import com.hw.lineage.common.util.Preconditions;
import com.lineage.server.domain.facade.LineageFacade;
import com.lineage.server.start.LineageServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description: LineageFacadeImplTest
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/14 11:46 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LineageServerApplication.class)
public class LineageFacadeImplTest {

    @Resource
    private LineageFacade lineageFacade;

    private static final String[] PLUGIN_NAMES = {"flink1.14.x", "flink1.16.x"};


    /**
     * There is only one UDF in the Jar package, and only one parameter
     */
    @Test
    public void testParseFunctionA() throws IOException, ClassNotFoundException {
        Stream.of(PLUGIN_NAMES).forEach(pluginName -> {
            List<FunctionResult> resultList = parseFunction("function-a.jar", pluginName);

            assertThat(resultList)
                    .isNotNull()
                    .asList()
                    .hasSize(1)
                    .contains(new FunctionResult().setFunctionName("flink_suffix_udf")
                            .setFunctionFormat("flink_suffix_udf(String1)")
                            .setFunctionClass("com.lineage.flink.table.udf.functiona.FlinkSuffixFunction")
                            .setDescr("return String")
                    );
        });
    }


    /**
     * There is a UDF and a UDTF in the Jar package, and the UDF contains two parameters
     */
    @Test
    public void testParseFunctionB() throws IOException, ClassNotFoundException {
        Stream.of(PLUGIN_NAMES).forEach(pluginName -> {
            List<FunctionResult> resultList = parseFunction("function-b.jar", pluginName);

            assertThat(resultList)
                    .isNotNull()
                    .asList()
                    .hasSize(2)
                    .contains(new FunctionResult().setFunctionName("flink_prefix_udf")
                                    .setFunctionFormat("flink_prefix_udf(String1,Integer2)")
                                    .setFunctionClass("com.lineage.flink.table.udf.functionb.FlinkPrefixFunction")
                                    .setDescr("return String"),
                            new FunctionResult().setFunctionName("flink_split_udtf")
                                    .setFunctionFormat("flink_split_udtf(String1)")
                                    .setFunctionClass("com.lineage.flink.table.udf.functionb.FlinkSplitFunction")
                                    .setDescr("return ROW<word STRING, length INT>")
                    );
        });
    }


    private List<FunctionResult> parseFunction(String fileName, String pluginName) {
        File file = locateJarFile(fileName);
        try {
            return lineageFacade.parseFunction(pluginName, file);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private File locateJarFile(String fileString) {
        File file = new File(fileString);
        if (!file.exists()) {
            // for maven test
            file = new File("target/" + fileString);
        }
        if (!file.exists()) {
            // for idea test
            file = new File("lineage-server/lineage-server-start/target/" + fileString);
        }
        Preconditions.checkState(file.exists(), "Unable to locate jar file for test: " + fileString);
        return file;
    }
}