package com.hw.lineage.client;

import com.google.common.collect.Lists;
import com.hw.lineage.LineageResult;
import com.hw.lineage.LineageService;
import com.hw.lineage.exception.LineageRuntimeException;
import com.hw.lineage.loader.classloading.TemporaryClassLoaderContext;
import com.hw.lineage.loader.plugin.PluginDescriptor;
import com.hw.lineage.loader.plugin.finder.DirectoryBasedPluginFinder;
import com.hw.lineage.loader.plugin.finder.PluginFinder;
import com.hw.lineage.loader.plugin.manager.DefaultPluginManager;
import com.hw.lineage.loader.plugin.manager.PluginManager;
import com.hw.lineage.util.Preconditions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hw.lineage.util.Preconditions.checkArgument;
import static com.hw.lineage.util.Preconditions.checkNotNull;

/**
 * @description: LineageClient
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 9:06 PM
 */
public class LineageClient {
    private final Map<String, LineageService> lineageServiceMap;

    public LineageClient(String path) {
        File pluginRootFolder = new File(path);
        Path pluginRootFolderPath = pluginRootFolder.toPath();

        PluginFinder descriptorsFactory = new DirectoryBasedPluginFinder(pluginRootFolderPath);
        Collection<PluginDescriptor> descriptors;
        try {
            descriptors = descriptorsFactory.findPlugins();
        } catch (IOException e) {
            throw new LineageRuntimeException("Exception when trying to initialize plugin system.", e);
        }

        // use AppClassLoader to load
        String[] parentPatterns = {LineageService.class.getName(), LineageResult.class.getName()};
        PluginManager pluginManager =
                new DefaultPluginManager(descriptors, LineageService.class.getClassLoader(), parentPatterns);

        Map<String, Iterator<LineageService>> pluginIteratorMap = pluginManager.load(LineageService.class);

        lineageServiceMap = pluginIteratorMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> {
                    List<LineageService> lineageServiceList = Lists.newArrayList(entry.getValue());
                    checkArgument(lineageServiceList.size() == 1,
                            "%s plugin no implementation of LineageService or greater than 1", entry.getKey());
                    return lineageServiceList.get(0);
                }
        ));
    }

    /**
     * Parse the field blood relationship of the input SQL
     */
    public List<LineageResult> parseFieldLineage(String pluginId, String singleSql) {
        LineageService lineageService = lineageServiceMap.get(pluginId);
        Preconditions.checkNotNull(lineageService, "This plugin %s is not supported.", pluginId);
        ClassLoader classloader = lineageService.getClassLoader();

        try (TemporaryClassLoaderContext ignored = TemporaryClassLoaderContext.of(classloader)) {
            return lineageService.parseFieldLineage(singleSql);
        }
    }

    /**
     * Execute the single sql
     */
    public void execute(String pluginId, String singleSql) {
        LineageService lineageService = lineageServiceMap.get(pluginId);
        Preconditions.checkNotNull(lineageService, "This plugin %s is not supported.", pluginId);
        ClassLoader classloader = lineageService.getClassLoader();
        try (TemporaryClassLoaderContext ignored = TemporaryClassLoaderContext.of(classloader)) {
             lineageService.execute(singleSql);
        }
    }
}
