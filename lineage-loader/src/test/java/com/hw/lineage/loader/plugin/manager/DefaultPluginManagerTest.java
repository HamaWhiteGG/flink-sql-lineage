package com.hw.lineage.loader.plugin.manager;

import com.google.common.collect.Lists;
import com.hw.lineage.loader.PluginTestBase;
import com.hw.lineage.loader.plugin.PluginDescriptor;
import com.hw.lineage.loader.plugin.finder.DirectoryBasedPluginFinder;
import com.hw.lineage.loader.plugin.finder.PluginFinder;
import com.hw.lineage.loader.service.OtherTestService;
import com.hw.lineage.loader.service.TestService;
import com.hw.lineage.util.Preconditions;
import junit.framework.TestCase;
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
 * @version: 1.0.0
 * @date: 2023/1/17 12:23 AM
 */
public class DefaultPluginManagerTest extends PluginTestBase {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private Collection<PluginDescriptor> descriptors;

    @Before
    public void setup() throws Exception {
        /*
         * We setup a plugin directory hierarchy and utilize DirectoryBasedPluginFinder to create the
         * descriptors:
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
        File pluginRootFolder = temporaryFolder.newFolder();
        Path pluginRootFolderPath = pluginRootFolder.toPath();
        File pluginAFolder = new File(pluginRootFolder, "plugin-a");
        File pluginBFolder = new File(pluginRootFolder, "plugin-b");
        Preconditions.checkState(pluginAFolder.mkdirs());
        Preconditions.checkState(pluginBFolder.mkdirs());
        Files.copy(locateJarFile(PLUGIN_A).toPath(), Paths.get(pluginAFolder.toString(), PLUGIN_A));
        Files.copy(locateJarFile(PLUGIN_B).toPath(), Paths.get(pluginBFolder.toString(), PLUGIN_B));
        PluginFinder descriptorsFactory =
                new DirectoryBasedPluginFinder(pluginRootFolderPath);
        descriptors = descriptorsFactory.findPlugins();
        Preconditions.checkState(descriptors.size() == 2);
    }

    @Test
    public void testPluginLoading() {

        String[] parentPatterns = {TestService.class.getName(), OtherTestService.class.getName()};
        final PluginManager pluginManager =
                new DefaultPluginManager(descriptors, PARENT_CLASS_LOADER, parentPatterns);
        Map<String, Iterator<TestService>> pluginIteratorMap = pluginManager.load(TestService.class);

        Assert.assertEquals(2, pluginIteratorMap.size());

        // check that all impl have unique classloader
        final Set<ClassLoader> classLoaders = Collections.newSetFromMap(new IdentityHashMap<>(3));
        classLoaders.add(PARENT_CLASS_LOADER);
//        for (TestService service : Lists.newArrayList(pluginIteratorMap.values())) {
//            Assert.assertNotNull(service.say("hello"));
//            Assert.assertTrue(classLoaders.add(service.getClass().getClassLoader()));
//        }

        Map<String, Iterator<OtherTestService>> otherPluginIteratorMap = pluginManager.load(OtherTestService.class);
//        Assert.assertEquals(1, otherServiceImplList.size());
//        for (OtherTestService service : otherServiceImplList) {
//            Assert.assertNotNull(service.otherSay("hello"));
//            Assert.assertTrue(classLoaders.add(service.getClass().getClassLoader()));
//        }
        System.out.println("end");
    }
}