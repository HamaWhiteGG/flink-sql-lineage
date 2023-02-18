package com.hw.lineage.server.application.dto;

import com.hw.lineage.common.enums.ParseStatus;
import com.hw.lineage.common.enums.SqlType;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: TaskSqlDTO
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class TaskSqlDTO implements Serializable {
    private Long taskId;

    private Integer sqlId;

    private ParseStatus parseStatus;

    private Long parseTime;

    /**
     * Base64 encode
     */
    private String sqlCode;

    private SqlType sqlType;

    private String parseLog;
}
