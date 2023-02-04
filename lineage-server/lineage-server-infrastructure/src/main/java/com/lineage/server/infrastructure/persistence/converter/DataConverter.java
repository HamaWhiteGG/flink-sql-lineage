package com.lineage.server.infrastructure.persistence.converter;

import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.entity.TaskLineage;
import com.lineage.server.domain.entity.TaskSql;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
import com.lineage.server.infrastructure.persistence.dos.TaskLineageDO;
import com.lineage.server.infrastructure.persistence.dos.TaskSqlDO;
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
    @Mapping(source = "taskSource", target = "taskSource.value")
    Task toTask(TaskDO taskDO);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "taskSource.value", target = "taskSource")
    TaskDO fromTask(Task task);

    List<Task> toTaskList(List<TaskDO> taskDOList);

    @Mapping(source = "taskId", target = "taskId.value")
    @Mapping(source = "sqlId", target = "sqlId.value")
    TaskSql toTaskSql(TaskSqlDO taskSqlDO);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    TaskSqlDO fromTaskSql(TaskSql taskSql);


    @Mapping(source = "taskId", target = "taskId.value")
    @Mapping(source = "sqlId", target = "sqlId.value")
    TaskLineage toTaskLineage(TaskLineageDO taskLineageDO);

    @Mapping(source = "taskId.value", target = "taskId")
    @Mapping(source = "sqlId.value", target = "sqlId")
    TaskLineageDO fromTaskLineage(TaskLineage taskLineage);

}
