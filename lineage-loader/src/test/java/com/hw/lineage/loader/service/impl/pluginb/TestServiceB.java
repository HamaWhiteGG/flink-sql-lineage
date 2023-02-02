package com.hw.lineage.loader.service.impl.pluginb;

import com.hw.lineage.loader.service.TestService;

/**
 * @description: Second implementation of {@link TestService}.
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 11:51 PM
 */
public class TestServiceB implements TestService {
    @Override
    public String say(String name) {
        return "B-" + name;
    }
}
