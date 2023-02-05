package com.lineage.server.application.assembler;

import com.lineage.server.application.dto.CatalogDTO;
import com.lineage.server.application.dto.FunctionDTO;
import com.lineage.server.application.dto.PluginDTO;
import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.domain.entity.Catalog;
import com.lineage.server.domain.entity.Function;
import com.lineage.server.domain.entity.Plugin;
import com.lineage.server.domain.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description: TaskAssembler
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 5:06 PM
 */
@Mapper
public interface DtoAssembler {
    DtoAssembler INSTANCE = Mappers.getMapper(DtoAssembler.class);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "pluginId.value", target = "pluginId")
    @Mapping(source = "catalogId.value", target = "catalogId")
    @Mapping(source = "taskSource.value", target = "taskSource")
    TaskDTO fromTask(Task task);

    @Mapping(source = "catalogId.value", target = "catalogId")
    CatalogDTO fromCatalog(Catalog catalog);

    @Mapping(source = "functionId.value", target = "functionId")
    FunctionDTO fromFunction(Function function);

    @Mapping(source = "pluginId.value", target = "pluginId")
    PluginDTO fromPlugin(Plugin plugin);

    List<TaskDTO> fromTaskList(List<Task> task);
}
