package com.hw.lineage.server.domain.entity.task;

import com.hw.lineage.server.domain.vo.FunctionId;
import com.hw.lineage.server.domain.vo.SqlId;
import com.hw.lineage.server.domain.vo.TaskId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: TaskFunction
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
public class TaskFunction {

    private TaskId taskId;

    private SqlId sqlId;

    private FunctionId functionId;

    private String catalogName;

    private String database;

    private String functionName;

    private Long createTime;

    private Boolean invalid;
}
