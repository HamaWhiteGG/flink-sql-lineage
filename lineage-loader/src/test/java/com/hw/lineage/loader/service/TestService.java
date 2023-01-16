package com.hw.lineage.loader.service;

import com.hw.lineage.loader.plugin.Plugin;

/**
 * @description: Service interface for tests of plugin mechanism.
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/16 10:46 PM
 */
public interface TestService extends Plugin {

     String say(String name);
}
