package com.hw.lineage.server.application.dto;

import com.hw.lineage.common.enums.TaskStatus;
import lombok.Data;

import java.util.List;

/**
 * @description: TaskSyntaxDTO
 * @author: HamaWhite
 */
@Data
public class TaskSyntaxDTO {

    private Long taskId;

    private String taskName;

    private TaskStatus taskStatus;

    private String taskLog;

    private List<TaskSqlDTO> taskSqlList;
}
