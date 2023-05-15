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

package com.hw.lineage.loader.plugin.manager;

import com.google.common.collect.Lists;
import com.hw.lineage.common.util.Preconditions;
import com.hw.lineage.loader.PluginTestBase;
import com.hw.lineage.loader.plugin.PluginDescriptor;
import com.hw.lineage.loader.plugin.finder.DirectoryBasedPluginFinder;
import com.hw.lineage.loader.plugin.finder.PluginFinder;
import com.hw.lineage.loader.service.OtherTestService;
import com.hw.lineage.loader.service.TestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @description: DefaultPluginManagerTest
 * @author: HamaWhite
 */
public class DefaultPluginManagerTest extends PluginTestBase {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private Collection<PluginDescriptor> descriptors;

    /**
     * Prepare a plugin directory hierarchy and utilize DirectoryBasedPluginFinder to create the descriptors:
     *
     * <pre>
     * tmp/plugins-root/
     *          |-------------plugin-a/
     *          |             |-plugin-a.jar
     *          |
     *          |-------------plugin-a/
     *                        |-plugin-b.jar
     * </pre>
     */
    @Before
    public void setup() throws Exception {
        File pluginRootFolder = temporaryFolder.newFolder();
        Path pluginRootFolderPath = pluginRootFolder.toPath();
        File pluginAFolder = new File(pluginRootFolder, PLUGIN_A);
        File pluginBFolder = new File(pluginRootFolder, PLUGIN_B);

        Preconditions.checkState(pluginAFolder.mkdirs());
        Preconditions.checkState(pluginBFolder.mkdirs());
        Files.copy(locateJarFile(PLUGIN_A_JAR).toPath(), Paths.get(pluginAFolder.toString(), PLUGIN_A_JAR));
        Files.copy(locateJarFile(PLUGIN_B_JAR).toPath(), Paths.get(pluginBFolder.toString(), PLUGIN_B_JAR));

        PluginFinder descriptorsFactory = new DirectoryBasedPluginFinder(pluginRootFolderPath);
        descriptors = descriptorsFactory.findPlugins();
        Preconditions.checkState(descriptors.size() == 2);
    }

    @Test
    public void testLoadPlugin() {
        String[] parentPatterns = {TestService.class.getName(), OtherTestService.class.getName()};
        PluginManager pluginManager = new DefaultPluginManager(descriptors, PARENT_CLASS_LOADER, parentPatterns);

        Map<String, Iterator<TestService>> pluginIteratorMap = pluginManager.load(TestService.class);
        Assert.assertEquals(2, pluginIteratorMap.size());

        // check that all impl have unique classloader
        Set<ClassLoader> classLoaders = Collections.newSetFromMap(new IdentityHashMap<>(4));
        classLoaders.add(PARENT_CLASS_LOADER);

        List<TestService> testServiceListA = Lists.newArrayList(pluginIteratorMap.get(PLUGIN_A));
        List<TestService> testServiceListB = Lists.newArrayList(pluginIteratorMap.get(PLUGIN_B));
        Assert.assertEquals(1, testServiceListA.size());
        Assert.assertEquals(1, testServiceListB.size());

        TestService testServiceA = testServiceListA.get(0);
        TestService testServiceB = testServiceListB.get(0);

        Assert.assertEquals("A-hello-Dynamic-A-hello", testServiceA.say("hello"));
        Assert.assertEquals("B-hello", testServiceB.say("hello"));

        Assert.assertTrue(classLoaders.add(testServiceA.getClass().getClassLoader()));
        Assert.assertTrue(classLoaders.add(testServiceB.getClass().getClassLoader()));

        Map<String, Iterator<OtherTestService>> otherPluginIteratorMap = pluginManager.load(OtherTestService.class);
        List<OtherTestService> otherTestServiceListA = Lists.newArrayList(otherPluginIteratorMap.get(PLUGIN_A));
        List<OtherTestService> otherTestServiceListB = Lists.newArrayList(otherPluginIteratorMap.get(PLUGIN_B));

        Assert.assertEquals(0, otherTestServiceListA.size());
        Assert.assertEquals(1, otherTestServiceListB.size());

        OtherTestService otherTestServiceB = otherTestServiceListB.get(0);

        Assert.assertEquals("Other-B-hello", otherTestServiceB.otherSay("hello"));
        Assert.assertTrue(classLoaders.add(otherTestServiceB.getClass().getClassLoader()));
    }
}