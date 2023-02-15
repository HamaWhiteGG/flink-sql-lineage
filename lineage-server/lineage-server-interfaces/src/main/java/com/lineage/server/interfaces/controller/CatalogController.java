package com.lineage.server.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.lineage.server.application.command.catalog.CreateCatalogCmd;
import com.lineage.server.application.command.catalog.UpdateCatalogCmd;
import com.lineage.server.application.dto.CatalogDTO;
import com.lineage.server.application.service.CatalogService;
import com.lineage.server.domain.query.catalog.CatalogCheck;
import com.lineage.server.domain.query.catalog.CatalogQuery;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @description: CatalogController
 * @author: HamaWhite
 * @version: 1.0.0
 */
@RestController
@Api(tags = "Catalogs API")
@RequestMapping("/catalogs")
public class CatalogController {

    @Resource
    private CatalogService catalogService;

    @GetMapping("/{catalogId}")
    public Result<CatalogDTO> queryCatalog(@PathVariable("catalogId") Long catalogId) {
        CatalogDTO catalogDTO = catalogService.queryCatalog(catalogId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, catalogDTO);
    }

    @GetMapping("")
    public Result<PageInfo<CatalogDTO>> queryCatalogs(CatalogQuery catalogQuery) {
        PageInfo<CatalogDTO> pageInfo = catalogService.queryCatalogs(catalogQuery);
        return Result.success(ResultMessage.QUERY_SUCCESS, pageInfo);
    }

    @PostMapping("")
    public Result<Long> createCatalog(@Valid @RequestBody CreateCatalogCmd createCatalogCmd) {
        Long catalogId = catalogService.createCatalog(createCatalogCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, catalogId);
    }

    @GetMapping("/exist")
    public Result<Boolean> checkCatalogExist(@Valid CatalogCheck catalogCheck) {
        return Result.success(ResultMessage.CHECK_SUCCESS, catalogService.checkCatalogExist(catalogCheck));
    }

    @PutMapping("/{catalogId}")
    public Result<Boolean> updateCatalog(@PathVariable("catalogId") Long catalogId,
                                         @Valid @RequestBody UpdateCatalogCmd updateCatalogCmd) {
        updateCatalogCmd.setCatalogId(catalogId);
        catalogService.updateCatalog(updateCatalogCmd);
        return Result.success(ResultMessage.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{catalogId}")
    public Result<Boolean> deleteCatalog(@PathVariable("catalogId") Long catalogId) {
        catalogService.deleteCatalog(catalogId);
        return Result.success(ResultMessage.DELETE_SUCCESS);
    }
}
