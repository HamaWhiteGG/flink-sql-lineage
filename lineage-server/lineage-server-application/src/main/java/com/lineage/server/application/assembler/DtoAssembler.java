package com.lineage.server.application.assembler;

import com.lineage.server.application.dto.TaskDTO;
import com.lineage.server.domain.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @description: TaskAssembler
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 5:06 PM
 */
@Mapper
public interface DtoAssembler {
    DtoAssembler INSTANCE = Mappers.getMapper(DtoAssembler.class);

    @Mapping(target = "taskId", source = "taskId.value")
    TaskDTO fromTask(Task task);
}
