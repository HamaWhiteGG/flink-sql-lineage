package com.hw.lineage.client;

import org.junit.Test;

/**
 * @description: LineageClientTest
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 9:49 PM
 */
public class LineageClientTest {
    private LineageClient client=new LineageClient("target/plugins");


    @Test
    public void testParseFieldLineage() {
        client.parseFieldLineage("flink1.14.x","select 1");
        client.parseFieldLineage("flink1.16.x","select 1");
    }

    @Test
    public void testExecute() {

    }


    @Test
    public void testTmp() {
        System.out.println(System.getProperty("user.dir"));
    }

}
