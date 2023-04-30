package com.hw.lineage.server.application.service.impl;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.enums.TableKind;
import com.hw.lineage.common.result.TableInfo;
import com.hw.lineage.common.util.PageUtils;
import com.hw.lineage.server.application.assembler.DtoAssembler;
import com.hw.lineage.server.application.command.catalog.CreateCatalogCmd;
import com.hw.lineage.server.application.command.catalog.CreateDatabaseCmd;
import com.hw.lineage.server.application.command.catalog.CreateTableCmd;
import com.hw.lineage.server.application.command.catalog.UpdateCatalogCmd;
import com.hw.lineage.server.application.dto.CatalogDTO;
import com.hw.lineage.server.application.dto.TableDTO;
import com.hw.lineage.server.application.dto.graph.LineageGraph;
import com.hw.lineage.server.application.service.CatalogService;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.entity.Plugin;
import com.hw.lineage.server.domain.entity.task.TaskLineage;
import com.hw.lineage.server.domain.entity.task.TaskSql;
import com.hw.lineage.server.domain.facade.LineageFacade;
import com.hw.lineage.server.domain.facade.StorageFacade;
import com.hw.lineage.server.domain.graph.GraphHelper;
import com.hw.lineage.server.domain.graph.column.ColumnGraph;
import com.hw.lineage.server.domain.graph.table.TableGraph;
import com.hw.lineage.server.domain.query.catalog.CatalogCheck;
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;
import com.hw.lineage.server.domain.repository.CatalogRepository;
import com.hw.lineage.server.domain.repository.PluginRepository;
import com.hw.lineage.server.domain.repository.TaskRepository;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import com.hw.lineage.server.infrastructure.graph.GraphFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hw.lineage.common.enums.CatalogType.HIVE;
import static com.hw.lineage.common.util.Constant.DELIMITER;

/**
 * @description: CatalogServiceImpl
 * @author: HamaWhite
 */
@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {

    private static final Logger LOG = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Resource
    private CatalogRepository catalogRepository;

    @Resource
    private PluginRepository pluginRepository;

    @Resource
    private TaskRepository taskRepository;

    @Resource
    private StorageFacade storageFacade;

    @Resource
    private LineageFacade lineageFacade;

    @Resource
    private DtoAssembler assembler;

    @Override
    public Long createCatalog(CreateCatalogCmd command) {
        Catalog catalog = new Catalog()
                .setPluginId(new PluginId(command.getPluginId()))
                .setCatalogName(command.getCatalogName())
                .setCatalogType(command.getCatalogType())
                .setDefaultDatabase(command.getDefaultDatabase())
                .setDescr(command.getDescr())
                .setCatalogProperties(command.getCatalogProperties())
                .setDefaultCatalog(command.getDefaultCatalog());

        catalog.setCreateUserId(command.getUserId())
                .setModifyUserId(command.getUserId());

        catalog.setCreateTime(System.currentTimeMillis())
                .setModifyTime(System.currentTimeMillis())
                .setInvalid(false);

        createCatalogInEngine(catalog);

        catalog = catalogRepository.save(catalog);
        return catalog.getCatalogId().getValue();
    }

    @Override
    public CatalogDTO queryCatalog(Long catalogId) {
        Catalog catalog = catalogRepository.find(new CatalogId(catalogId));
        return assembler.fromCatalog(catalog);
    }

    @Override
    public Boolean checkCatalogExist(CatalogCheck catalogCheck) {
        return catalogRepository.check(catalogCheck.getCatalogName());
    }

    @Override
    public PageInfo<CatalogDTO> queryCatalogs(CatalogQuery catalogQuery) {
        PageInfo<Catalog> pageInfo = catalogRepository.findAll(catalogQuery);
        return PageUtils.convertPage(pageInfo, assembler::fromCatalog);
    }

    @Override
    public void deleteCatalog(Long catalogId) {
        CatalogId id = new CatalogId(catalogId);
        CatalogEntry entry = catalogRepository.findEntry(id);
        lineageFacade.deleteCatalog(entry.getPluginCode(), entry.getCatalogName());
        catalogRepository.remove(id);
    }

    @Override
    public void updateCatalog(UpdateCatalogCmd command) {
        CatalogId id = new CatalogId(command.getCatalogId());

        String database = command.getDefaultDatabase();
        if (StringUtils.isNotBlank(database)) {
            CatalogEntry entry = catalogRepository.findEntry(id);
            lineageFacade.useDatabase(entry.getPluginCode(), entry.getCatalogName(), database);
        }

        Catalog catalog = new Catalog()
                .setCatalogId(id)
                .setCatalogName(command.getCatalogName())
                .setDefaultDatabase(database)
                .setDescr(command.getDescr())
                .setCatalogProperties(command.getCatalogProperties());

        catalog.setModifyUserId(command.getUserId());
        catalog.setModifyTime(System.currentTimeMillis());
        catalogRepository.save(catalog);
    }

    @Override
    public void defaultCatalog(Long catalogId) {
        CatalogId id = new CatalogId(catalogId);
        CatalogEntry entry = catalogRepository.findEntry(id);
        lineageFacade.useCatalog(entry.getPluginCode(), entry.getCatalogName());
        catalogRepository.setDefault(id);
    }

    @Override
    public void createDatabase(CreateDatabaseCmd command) {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(command.getCatalogId()));
        lineageFacade.createDatabase(entry.getPluginCode()
                , entry.getCatalogName()
                , command.getDatabase()
                , command.getComment()
        );
    }

    @Override
    public void deleteDatabase(Long catalogId, String database) {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        lineageFacade.deleteDatabase(entry.getPluginCode(), entry.getCatalogName(), database);
    }

    @Override
    public void defaultDatabase(Long catalogId, String database) {
        UpdateCatalogCmd command = new UpdateCatalogCmd()
                .setCatalogId(catalogId)
                .setDefaultDatabase(database);

        updateCatalog(command);
    }

    @Override
    public List<String> queryDatabases(Long catalogId) {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        return lineageFacade.listDatabases(entry.getPluginCode(), entry.getCatalogName());
    }

    @Override
    public void createTable(CreateTableCmd command) {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(command.getCatalogId()));
        lineageFacade.createTable(entry.getPluginCode(), entry.getCatalogName()
                , command.getDatabase(), command.getDdl()
        );
    }

    @Override
    public void deleteTable(Long catalogId, String database, String tableName) throws Exception {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        lineageFacade.deleteTable(entry.getPluginCode(), entry.getCatalogName(), database, tableName);
    }

    @Override
    public TableInfo getTable(Long catalogId, String database, String tableName) {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        return lineageFacade.getTable(entry.getPluginCode(), entry.getCatalogName(), database, tableName);
    }

    @Override
    public LineageGraph getTableLineage(Long catalogId, String database, String tableName) {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        PluginId pluginId = new PluginId(entry.getPluginId());

        List<TaskLineage> taskLineageList = taskRepository.findTaskLineages(pluginId);
        List<TaskSql> taskSqlList = taskRepository.findTaskSqls(pluginId);

        // create global tableGraph and columnGraph
        GraphFactory factory = new GraphFactory(lineageFacade, taskSqlList);
        factory.createLineageGraph(entry.getPluginCode(), taskLineageList);

        String tableNodeName = String.join(DELIMITER, entry.getCatalogName(), database, tableName);
        GraphHelper graphHelper = new GraphHelper();
        // filter out the parents and children nodes of this table
        TableGraph tableGraph = graphHelper.filter(factory.getTableGraph(), tableNodeName);
        ColumnGraph columnGraph = graphHelper.filter(factory.getColumnGraph(), tableGraph.queryNodeIdSet());

        // calculate the count of all downstream nodes for each node in the graph
        graphHelper.calculateChildrenCnt(tableGraph, columnGraph);

        return assembler.toLineageGraph(tableGraph,
                columnGraph,
                entry.getCatalogName(),
                database
        );
    }

    @Override
    public String getTableDdl(Long catalogId, String database, String tableName) throws Exception {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        return lineageFacade.getTableDdl(entry.getPluginCode(), entry.getCatalogName(), database, tableName);
    }

    @Override
    public List<TableDTO> queryTables(Long catalogId, String database) throws Exception {
        CatalogEntry entry = catalogRepository.findEntry(new CatalogId(catalogId));
        List<String> tableList = lineageFacade.listTables(entry.getPluginCode(), entry.getCatalogName(), database);
        List<String> viewList = lineageFacade.listViews(entry.getPluginCode(), entry.getCatalogName(), database);

        return tableList.stream().map(tableName -> {
            if (viewList.contains(tableName)) {
                return new TableDTO(tableName, TableKind.VIEW);
            }
            return new TableDTO(tableName, TableKind.TABLE);
        }).collect(Collectors.toList());
    }

    @Override
    public void createMemoryCatalogs() {
        CatalogQuery catalogQuery = new CatalogQuery();
        // when the pageSize parameter is equal to 0, query all data
        catalogQuery.setPageSize(0);
        catalogQuery.setCatalogType(CatalogType.MEMORY);
        PageInfo<Catalog> pageInfo = catalogRepository.findAll(catalogQuery);
        // create memory catalog in flink
        pageInfo.getList().forEach(this::createCatalogInEngine);
    }

    private void createCatalogInEngine(Catalog catalog) {
        Plugin plugin = pluginRepository.find(catalog.getPluginId());
        Map<String, String> propertiesMap = catalog.getPropertiesMap();
        if (catalog.getCatalogType().equals(HIVE)) {
            Arrays.asList("hive-conf-dir", "hadoop-conf-dir").forEach(option ->
                    propertiesMap.computeIfPresent(option, (key, value) -> storageFacade.getParentUri(value))
            );
        }
        lineageFacade.createCatalog(plugin.getPluginCode(), catalog.getCatalogName(), propertiesMap);
        LOG.info("created catalog: [{}] in plugin: [{}]", catalog.getCatalogName(), plugin.getPluginName());
    }
}
