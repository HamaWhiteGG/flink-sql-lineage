package com.lineage.server.infrastructure.facede.impl;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.result.LineageResult;
import com.lineage.server.domain.facade.LineageFacade;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: LineageFacadeImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:52 PM
 */
@Service
public class LineageFacadeImpl implements LineageFacade {
    @Override
    public void setCatalog(String pluginId, CatalogType catalogType, String catalogName) {

    }

    @Override
    public List<LineageResult> parseFieldLineage(String pluginId, String singleSql) {
        return null;
    }

    @Override
    public void execute(String pluginId, String singleSql) {

    }
}
