package com.hw.lineage.loader.service.impl.pluginb;

import com.hw.lineage.loader.service.OtherTestService;

/**
 * @description: Implementation of {@link OtherTestService}.
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 11:56 PM
 */
public class OtherTestServiceB implements OtherTestService {

    public String otherSay(String name) {
        return "Other-B-" + name;
    }
}
