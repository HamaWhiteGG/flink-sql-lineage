package com.lineage.server.interfaces.controller;

import com.lineage.server.application.cqe.command.catalog.CreateCatalogCmd;
import com.lineage.server.application.cqe.command.catalog.UpdateCatalogCmd;
import com.lineage.server.application.dto.CatalogDTO;
import com.lineage.server.application.service.CatalogService;
import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @description: CatalogController
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 12:29 PM
 */
@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    @Resource
    private CatalogService catalogService;


    @GetMapping("/{catalogId}")
    public Result<CatalogDTO> queryCatalog(@PathVariable("catalogId") Long catalogId) {
        CatalogDTO catalogDTO = catalogService.queryCatalog(catalogId);
        return Result.success(ResultMessage.DETAIL_SUCCESS, catalogDTO);
    }

    @PostMapping("")
    public Result<Long> createCatalog(@Valid @RequestBody CreateCatalogCmd createCatalogCmd) {
        Long catalogId = catalogService.createCatalog(createCatalogCmd);
        return Result.success(ResultMessage.CREATE_SUCCESS, catalogId);
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
