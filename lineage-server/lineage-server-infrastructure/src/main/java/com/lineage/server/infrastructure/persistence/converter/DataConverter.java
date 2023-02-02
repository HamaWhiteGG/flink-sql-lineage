package com.lineage.server.infrastructure.persistence.converter;

import com.lineage.server.domain.entity.Task;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description: DataConverter
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/31 2:33 PM
 */
@Mapper
public interface DataConverter {
    DataConverter INSTANCE = Mappers.getMapper(DataConverter.class);

    @Mapping(source = "taskId", target = "taskId.value")
    Task toTask(TaskDO taskDO);

    @Mapping(source = "taskId.value", target = "taskId")
    TaskDO fromTask(Task task);

    List<Task> toTaskList(List<TaskDO> taskDOList);

}
