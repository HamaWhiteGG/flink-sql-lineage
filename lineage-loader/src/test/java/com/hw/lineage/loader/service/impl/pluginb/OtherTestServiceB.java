package com.hw.lineage.loader.service.impl.pluginb;

import com.hw.lineage.loader.service.OtherTestService;

/**
 * @description: Implementation of {@link OtherTestService}.
 * @author: HamaWhite
 */
public class OtherTestServiceB implements OtherTestService {

    public String otherSay(String name) {
        return "Other-B-" + name;
    }
}
