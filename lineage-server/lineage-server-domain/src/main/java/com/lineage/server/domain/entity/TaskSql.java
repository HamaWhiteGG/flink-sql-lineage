package com.lineage.server.domain.entity;

import com.hw.lineage.common.enums.ParseStatus;
import com.hw.lineage.common.enums.SqlType;
import com.lineage.server.domain.vo.SqlId;
import com.lineage.server.domain.vo.TaskId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description: TaskSql
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 9:48 PM
 */
@Data
@Accessors(chain = true)
public class TaskSql {

    private TaskId taskId;

    private SqlId sqlId;

    private ParseStatus parseStatus;

    private Long parseTime;

    private Boolean invalid;

    /**
     * Base64 encode
     */
    private String sqlCode;

    private SqlType sqlType;

    private String parseLog;
}
