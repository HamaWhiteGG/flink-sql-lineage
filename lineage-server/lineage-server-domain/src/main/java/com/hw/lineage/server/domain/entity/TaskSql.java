package com.hw.lineage.server.domain.entity;

import com.hw.lineage.common.enums.SqlStatus;
import com.hw.lineage.common.enums.SqlType;
import com.hw.lineage.server.domain.vo.SqlId;
import com.hw.lineage.server.domain.vo.TaskId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: TaskSql
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class TaskSql {

    private TaskId taskId;

    private SqlId sqlId;

    private SqlStatus parseStatus;

    private Long parseTime;

    private Boolean invalid;

    /**
     * Base64 encode
     */
    private String sqlCode;

    private SqlType sqlType;

    private String parseLog;
}
