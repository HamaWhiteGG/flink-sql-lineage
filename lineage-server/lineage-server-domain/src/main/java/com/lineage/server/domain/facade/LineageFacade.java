package com.lineage.server.domain.facade;

import com.hw.lineage.common.result.FunctionResult;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Function;
import com.lineage.server.domain.entity.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description: LineageService
 * @author: HamaWhite
 * @version: 1.0.0
 */
public interface LineageFacade {

    void parseLineage(String pluginName,Task task,Catalog catalog);

    List<FunctionResult> parseFunction(String pluginName, File file) throws IOException, ClassNotFoundException;
}
