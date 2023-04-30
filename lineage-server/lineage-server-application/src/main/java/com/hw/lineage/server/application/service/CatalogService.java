package com.hw.lineage.server.application.service;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.result.TableInfo;
import com.hw.lineage.server.application.command.catalog.CreateCatalogCmd;
import com.hw.lineage.server.application.command.catalog.CreateDatabaseCmd;
import com.hw.lineage.server.application.command.catalog.CreateTableCmd;
import com.hw.lineage.server.application.command.catalog.UpdateCatalogCmd;
import com.hw.lineage.server.application.dto.CatalogDTO;
import com.hw.lineage.server.application.dto.TableDTO;
import com.hw.lineage.server.application.dto.graph.LineageGraph;
import com.hw.lineage.server.domain.query.catalog.CatalogCheck;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;

import java.util.List;


/**
 * @description: CatalogService
 * @author: HamaWhite
 */
public interface CatalogService {

    Long createCatalog(CreateCatalogCmd command);

    CatalogDTO queryCatalog(Long catalogId);

    Boolean checkCatalogExist(CatalogCheck catalogCheck);

    PageInfo<CatalogDTO> queryCatalogs(CatalogQuery catalogQuery);

    void deleteCatalog(Long catalogId);

    void updateCatalog(UpdateCatalogCmd command);

    void defaultCatalog(Long catalogId);

    void createDatabase(CreateDatabaseCmd command);

    void deleteDatabase(Long catalogId, String database);

    void defaultDatabase(Long catalogId, String database);

    List<String> queryDatabases(Long catalogId);

    void createTable(CreateTableCmd command);

    void deleteTable(Long catalogId, String database, String tableName) throws Exception;

    TableInfo getTable(Long catalogId, String database, String tableName);

    LineageGraph getTableLineage(Long catalogId, String database, String tableName);

    /**
     * Return the base64 encrypted ddl
     */
    String getTableDdl(Long catalogId, String database, String tableName) throws Exception;

    List<TableDTO> queryTables(Long catalogId, String database) throws Exception;

    /**
     * Create the memory type catalog to flink when the application start
     */
    void createMemoryCatalogs();

}
