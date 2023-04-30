package com.hw.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.hw.lineage.common.result.TableInfo;
import com.hw.lineage.server.application.command.catalog.CreateCatalogCmd;
import com.hw.lineage.server.application.command.catalog.CreateDatabaseCmd;
import com.hw.lineage.server.application.command.catalog.CreateTableCmd;
import com.hw.lineage.server.application.command.catalog.UpdateCatalogCmd;
import com.hw.lineage.server.application.command.function.CreateFunctionCmd;
import com.hw.lineage.server.application.command.function.UpdateFunctionCmd;
import com.hw.lineage.server.application.dto.CatalogDTO;
import com.hw.lineage.server.application.dto.FunctionDTO;
import com.hw.lineage.server.application.dto.TableDTO;
import com.hw.lineage.server.application.dto.graph.LineageGraph;
import com.hw.lineage.server.application.service.CatalogService;
import com.hw.lineage.server.application.service.FunctionService;
import com.hw.lineage.server.domain.query.catalog.CatalogCheck;
import com.hw.lineage.server.domain.query.catalog.CatalogQuery;
import com.hw.lineage.server.domain.query.function.FunctionCheck;
import com.hw.lineage.server.domain.query.function.FunctionQuery;
import com.hw.lineage.server.domain.query.function.FunctionTaskQuery;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;
import com.hw.lineage.server.interfaces.aspect.AuditLog;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.hw.lineage.common.enums.audit.ModuleCode.*;
import static com.hw.lineage.common.enums.audit.OperationType.*;

/**
 * @description: CatalogController
 * @author: HamaWhite
 */
@Validated
@RestController
@Api(tags = "Catalogs API")
@RequestMapping("/catalogs")
public class CatalogController {

    @Resource
    private CatalogService catalogService;

    @Resource
    private FunctionService functionService;

    @GetMapping("/{catalogId}")
    @AuditLog(module = CATALOG, type = QUERY, descr = "'Query Catalog: ' + @catalogService.queryCatalog(#catalogId).catalogName")
    public Result<CatalogDTO> queryCatalog(@PathVariable("catalogId") Long catalogId) {
        CatalogDTO catalogDTO = catalogService.queryCatalog(catalogId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, catalogDTO);
    }

    @GetMapping("")
    @AuditLog(module = CATALOG, type = QUERY, descr = "'Query Catalogs'")
    public Result<PageInfo<CatalogDTO>> queryCatalogs(CatalogQuery catalogQuery) {
        PageInfo<CatalogDTO> pageInfo = catalogService.queryCatalogs(catalogQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    @AuditLog(module = CATALOG, type = CREATE, descr = "'Create Catalog: ' + #command.catalogName")
    public Result<Long> createCatalog(@Valid @RequestBody CreateCatalogCmd command) {
        Long catalogId = catalogService.createCatalog(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, catalogId);
    }

    @GetMapping("/exist")
    @AuditLog(module = CATALOG, type = QUERY, descr = "'Check Catalog Exist'")
    public Result<Boolean> checkCatalogExist(@Valid CatalogCheck catalogCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, catalogService.checkCatalogExist(catalogCheck));
    }

    @PutMapping("/{catalogId}")
    @AuditLog(module = CATALOG, type = UPDATE, descr = "'Update Catalog: ' + @catalogService.queryCatalog(#catalogId).catalogName")
    public Result<Boolean> updateCatalog(@PathVariable("catalogId") Long catalogId,
                                         @Valid @RequestBody UpdateCatalogCmd command) {
        command.setCatalogId(catalogId);
        catalogService.updateCatalog(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @PutMapping("/{catalogId}/default")
    @AuditLog(module = CATALOG, type = UPDATE, descr = "'Default Catalog: ' + @catalogService.queryCatalog(#catalogId).catalogName")
    public Result<Boolean> defaultCatalog(@PathVariable("catalogId") Long catalogId) {
        catalogService.defaultCatalog(catalogId);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{catalogId}")
    @AuditLog(module = CATALOG, type = DELETE, descr = "'Delete Catalog: ' + @catalogService.queryCatalog(#catalogId).catalogName")
    public Result<Boolean> deleteCatalog(@PathVariable("catalogId") Long catalogId) {
        catalogService.deleteCatalog(catalogId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @PostMapping("/{catalogId}/databases")
    @AuditLog(module = DATABASE, type = CREATE, descr = "'Create Database: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #command.database")
    public Result<Boolean> createDatabase(@PathVariable("catalogId") Long catalogId,
                                          @Valid @RequestBody CreateDatabaseCmd command) {
        command.setCatalogId(catalogId);
        catalogService.createDatabase(command);
        return Result.success(ResultMessage.CREATE_SUCCESS);
    }

    @DeleteMapping("/{catalogId}/databases/{database}")
    @AuditLog(module = DATABASE, type = DELETE, descr = "'Delete Database: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database")
    public Result<Boolean> deleteDatabase(@PathVariable("catalogId") Long catalogId,
                                          @PathVariable("database") String database) {
        catalogService.deleteDatabase(catalogId, database);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @PutMapping("/{catalogId}/databases/{database}/default")
    @AuditLog(module = DATABASE, type = UPDATE, descr = "'Default Database: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database")
    public Result<Boolean> defaultDatabase(@PathVariable("catalogId") Long catalogId,
                                          @PathVariable("database") String database) {
        catalogService.defaultDatabase(catalogId, database);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @GetMapping("/{catalogId}/databases")
    @AuditLog(module = DATABASE, type = QUERY, descr = "'Query Databases In ' + @catalogService.queryCatalog(#catalogId).catalogName")
    public Result<List<String>> queryDatabases(@PathVariable("catalogId") Long catalogId) {
        List<String> databaseList = catalogService.queryDatabases(catalogId);
        return Result.success(ResultMessage.QUERY_SUCCESS, databaseList);
    }

    @PostMapping("/{catalogId}/databases/{database}/tables")
    @AuditLog(module = TABLE, type = CREATE, descr = "'Create Table By DLL In ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database")
    public Result<Boolean> createTable(@PathVariable("catalogId") Long catalogId,
                                       @PathVariable("database") String database,
                                       @Valid @RequestBody CreateTableCmd command) {
        command.setCatalogId(catalogId);
        command.setDatabase(database);
        catalogService.createTable(command);
        return Result.success(ResultMessage.CREATE_SUCCESS);
    }

    @GetMapping("/{catalogId}/databases/{database}/tables/{tableName}")
    @AuditLog(module = TABLE, type = QUERY, descr = "'Query Table: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database+'.' + #tableName")
    public Result<TableInfo> queryTable(@PathVariable("catalogId") Long catalogId,
                                        @PathVariable("database") String database,
                                        @PathVariable("tableName") String tableName) {
        TableInfo tableInfo = catalogService.getTable(catalogId, database, tableName);
        return Result.success(ResultMessage.DETAIL_SUCCESS, tableInfo);
    }

    @GetMapping("/{catalogId}/databases/{database}/tables/{tableName}/lineage")
    @AuditLog(module = TABLE, type = QUERY, descr = "'Query Table Lineage: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database+'.' + #tableName")
    public Result<LineageGraph> queryTableLineage(@PathVariable("catalogId") Long catalogId,
                                                  @PathVariable("database") String database,
                                                  @PathVariable("tableName") String tableName) {
        LineageGraph lineageGraph = catalogService.getTableLineage(catalogId, database, tableName);
        return Result.success(ResultMessage.QUERY_SUCCESS, lineageGraph);
    }

    @GetMapping("/{catalogId}/databases/{database}/tables/{tableName}/ddl")
    @AuditLog(module = TABLE, type = QUERY, descr = "'Query Table DDL: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database+'.' + #tableName")
    public Result<String> queryTableDdl(@PathVariable("catalogId") Long catalogId,
                                        @PathVariable("database") String database,
                                        @PathVariable("tableName") String tableName) throws Exception {
        String tableDdl = catalogService.getTableDdl(catalogId, database, tableName);
        return Result.success(ResultMessage.DETAIL_SUCCESS, tableDdl);
    }


    @GetMapping("/{catalogId}/databases/{database}/tables")
    @AuditLog(module = TABLE, type = QUERY, descr = "'Query Tables In ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database")
    public Result<List<TableDTO>> queryTables(@PathVariable("catalogId") Long catalogId,
                                              @PathVariable("database") String database) throws Exception {
        List<TableDTO> tableDTOList = catalogService.queryTables(catalogId, database);
        return Result.success(ResultMessage.QUERY_SUCCESS, tableDTOList);
    }

    @DeleteMapping("/{catalogId}/databases/{database}/tables/{tableName}")
    @AuditLog(module = TABLE, type = DELETE, descr = "'Delete Table: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database+'.' + #tableName")
    public Result<Boolean> deleteTable(@PathVariable("catalogId") Long catalogId,
                                       @PathVariable("database") String database,
                                       @PathVariable("tableName") String tableName) throws Exception {
        catalogService.deleteTable(catalogId, database, tableName);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }

    @GetMapping("/{catalogId}/databases/{database}/functions/{functionId}")
    @AuditLog(module = FUNCTION, type = QUERY, descr = "'Query Function: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database+'.' + @functionService.queryFunction(#functionId).functionName")
    public Result<FunctionDTO> queryFunction(@PathVariable("catalogId") Long catalogId,
                                             @PathVariable("database") String database,
                                             @PathVariable("functionId") Long functionId) {
        FunctionDTO functionDTO = functionService.queryFunction(functionId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, functionDTO);
    }

    @GetMapping("/{catalogId}/databases/{database}/functions")
    @AuditLog(module = FUNCTION, type = QUERY, descr = "'Query Functions In ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database")
    public Result<PageInfo<FunctionDTO>> queryFunctions(
            @PathVariable("catalogId") Long catalogId,
            @PathVariable("database") String database,
            FunctionQuery functionQuery) {
        functionQuery.setCatalogId(catalogId);
        functionQuery.setDatabase(database);
        PageInfo<FunctionDTO> pageInfo = functionService.queryFunctions(functionQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @GetMapping("/{catalogId}/databases/{database}/functions/{functionId}/tasks")
    @AuditLog(module = FUNCTION, type = QUERY, descr = "'Query Function Tasks: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database+'.' + @functionService.queryFunction(#functionId).functionName")
    public Result<PageInfo<FunctionTaskDTO>> queryFunctionTasks(
            @PathVariable("catalogId") Long catalogId,
            @PathVariable("database") String database,
            @PathVariable("functionId") Long functionId,
            FunctionTaskQuery query) {
        query.setFunctionId(functionId);
        PageInfo<FunctionTaskDTO> pageInfo = functionService.queryFunctionTasks(query);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }


    @PostMapping("/{catalogId}/databases/{database}/functions")
    @AuditLog(module = FUNCTION, type = CREATE, descr = "'Create Function: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database + '.' + #command.functionName")
    public Result<Long> createFunction(
            @PathVariable("catalogId") Long catalogId,
            @PathVariable("database") String database,
            @Valid @RequestBody CreateFunctionCmd command) {
        command.setCatalogId(catalogId);
        command.setDatabase(database);
        Long functionId = functionService.createFunction(command);
        return Result.success(ResultMessage.CREATE_SUCCESS, functionId);
    }

    @GetMapping("/{catalogId}/databases/{database}/functions/exist")
    @AuditLog(module = FUNCTION, type = QUERY, descr = "'Check Function Exist In ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database")
    public Result<Boolean> checkFunctionExist(
            @PathVariable("catalogId") Long catalogId,
            @PathVariable("database") String database,
            @Valid FunctionCheck functionCheck) {
        functionCheck.setCatalogId(catalogId);
        functionCheck.setDatabase(database);
        return Result.success(ResultMessage.CHECK_SUCCESS, functionService.checkFunctionExist(functionCheck));
    }

    @PutMapping("/{catalogId}/databases/{database}/functions/{functionId}")
    @AuditLog(module = FUNCTION, type = UPDATE, descr = "'Update Function: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database + '.' + @functionService.queryFunction(#functionId).functionName")
    public Result<Boolean> updateFunction(@PathVariable("catalogId") Long catalogId,
                                          @PathVariable("database") String database,
                                          @PathVariable("functionId") Long functionId,
                                          @Valid @RequestBody UpdateFunctionCmd command) {
        command.setFunctionId(functionId);
        functionService.updateFunction(command);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{catalogId}/databases/{database}/functions/{functionId}")
    @AuditLog(module = FUNCTION, type = DELETE, descr = "'Delete Function: ' + @catalogService.queryCatalog(#catalogId).catalogName + '.' + #database + '.' + @functionService.queryFunction(#functionId).functionName")
    public Result<Boolean> deleteFunction(@PathVariable("catalogId") Long catalogId,
                                          @PathVariable("database") String database,
                                          @PathVariable("functionId") Long functionId) {
        functionService.deleteFunction(catalogId, database, functionId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }
}
