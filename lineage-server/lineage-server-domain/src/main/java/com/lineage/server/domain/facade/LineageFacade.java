package com.lineage.server.domain.facade;

import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Task;

/**
 * @description: LineageService
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:52 PM
 */
public interface LineageFacade {

    void parseLineage(Task task, String pluginName, Catalog catalog);

}
