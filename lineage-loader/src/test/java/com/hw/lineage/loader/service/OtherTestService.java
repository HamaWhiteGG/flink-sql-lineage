package com.hw.lineage.loader.service;

import com.hw.lineage.common.plugin.Plugin;

/**
 * @description: Another service interface for tests of plugin mechanism.
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 10:46 PM
 */
public interface OtherTestService extends Plugin {

     String otherSay(String name);
}
