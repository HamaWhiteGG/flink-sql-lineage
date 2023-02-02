package com.lineage.server.domain.types;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description: Test
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/2 11:50 PM
 */
public class Test {


    @org.junit.Test
    public void testSplitSource() {
        String sixthSource="-- first\n" +
                "SELECT * FROM t1;\n" +
                "\n" +
                "\n" +
                "SELECT SPLIT_INDEX(str, ';', 0) FROM t2;  -- second \n" +
                "\n" +
                "--\n" +
                "SELECT SPLIT_INDEX(str, 'm;2', 0) FROM t3";

        String tmp=sixthSource.replaceAll("\u00A0", " ")
                .replaceAll("[\r\n]+", "\n")
                .replaceAll("--([^'\n]{0,}('[^'\n]{0,}'){0,1}[^'\n]{0,}){0,}", "")
                .trim();

        TaskSource sixthTaskSource = new TaskSource(sixthSource);
        String[] sixthResults = sixthTaskSource.splitSource();

    }
}
