package com.lineage.server.domain.facade;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.result.LineageResult;

import java.util.List;

/**
 * @description: LineageService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:52 PM
 */
public interface LineageFacade {

    void setCatalog(String pluginId, CatalogType catalogType, String catalogName);

    List<LineageResult> parseFieldLineage(String pluginId, String singleSql);

    void execute(String pluginId, String singleSql);
}
