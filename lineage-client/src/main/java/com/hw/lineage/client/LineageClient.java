package com.hw.lineage.client;

import com.google.common.collect.Lists;
import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.result.LineageResult;
import com.hw.lineage.common.service.LineageService;
import com.hw.lineage.common.util.Preconditions;
import com.hw.lineage.loader.classloading.TemporaryClassLoaderContext;
import com.hw.lineage.loader.plugin.PluginDescriptor;
import com.hw.lineage.loader.plugin.finder.DirectoryBasedPluginFinder;
import com.hw.lineage.loader.plugin.finder.PluginFinder;
import com.hw.lineage.loader.plugin.manager.DefaultPluginManager;
import com.hw.lineage.loader.plugin.manager.PluginManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hw.lineage.common.util.Preconditions.checkArgument;

/**
 * @description: LineageClient
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/17 9:06 PM
 */
public class LineageClient {
    private final Map<String, LineageService> lineageServiceMap;

    public LineageClient(String path) {
        Map<String, Iterator<LineageService>> pluginIteratorMap = loadPlugins(path);

        this.lineageServiceMap = pluginIteratorMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> {
                    List<LineageService> lineageServiceList = Lists.newArrayList(entry.getValue());
                    checkArgument(lineageServiceList.size() == 1,
                            "%s plugin no implementation of LineageService or greater than 1", entry.getKey());
                    return lineageServiceList.get(0);
                }
        ));
    }

    private Map<String, Iterator<LineageService>> loadPlugins(String path) {
        File pluginRootFolder = new File(path);
        Path pluginRootFolderPath = pluginRootFolder.toPath();

        PluginFinder descriptorsFactory = new DirectoryBasedPluginFinder(pluginRootFolderPath);
        Collection<PluginDescriptor> descriptors;
        try {
            descriptors = descriptorsFactory.findPlugins();
        } catch (IOException e) {
            throw new LineageException("Exception when trying to initialize plugin system.", e);
        }

        // use AppClassLoader to load
        // String[] parentPatterns = {LineageService.class.getName(), LineageResult.class.getName()};
        String[] parentPatterns = {"com.hw.lineage.common"};

        PluginManager pluginManager =
                new DefaultPluginManager(descriptors, LineageService.class.getClassLoader(), parentPatterns);

        return pluginManager.load(LineageService.class);
    }

    /**
     * Set the catalog information, the flink plugin defaults to GenericInMemoryCatalog
     */
    public void setCatalog(String pluginId, CatalogType catalogType, String catalogName
            , String defaultDatabase, String... args) {
        LineageService service = getLineageService(pluginId);
        service.setCatalog(catalogType, catalogName, defaultDatabase, args);
    }

    /**
     * Parse the field blood relationship of the input SQL
     */
    public List<LineageResult> parseFieldLineage(String pluginId, String singleSql) {
        LineageService service = getLineageService(pluginId);
        try (TemporaryClassLoaderContext ignored = TemporaryClassLoaderContext.of(service.getClassLoader())) {
            return service.parseFieldLineage(singleSql);
        }
    }

    /**
     * Execute the single sql
     */
    public void execute(String pluginId, String singleSql) {
        LineageService service = getLineageService(pluginId);
        try (TemporaryClassLoaderContext ignored = TemporaryClassLoaderContext.of(service.getClassLoader())) {
            service.execute(singleSql);
        }
    }

    private LineageService getLineageService(String pluginId) {
        LineageService lineageService = lineageServiceMap.get(pluginId);
        Preconditions.checkNotNull(lineageService, "This plugin %s is not supported.", pluginId);
        return lineageService;
    }
}
