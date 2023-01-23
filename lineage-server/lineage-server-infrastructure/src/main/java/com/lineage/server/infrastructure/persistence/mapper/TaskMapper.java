package com.lineage.server.infrastructure.persistence.mapper;

import com.lineage.server.infrastructure.persistence.TaskDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: TaskMapper
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:37 PM
 */
@Mapper
public interface TaskMapper {

    long insert(TaskDO taskDO);

    long update(TaskDO taskDO);

    TaskDO selectByTaskId(Long taskId);
}
