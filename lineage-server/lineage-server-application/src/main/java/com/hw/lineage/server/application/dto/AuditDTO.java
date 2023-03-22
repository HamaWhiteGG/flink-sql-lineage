package com.hw.lineage.server.application.dto;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import lombok.Data;

/**
 * @description: AuditDTO
 * @author: HamaWhite
 */
@Data
public class AuditDTO {

    private Long auditId;

    private Long userId;

    private String username;

    private ModuleCode moduleCode;

    private OperationType operationType;

    private String descr;

    /**
     * Request duration
     */
    private Long duration;

    private OperationStatus operationStatus;

    private String ip;

    private Long createTime;

    private String method;

    private JSONObject parameters;

    private String exception;
}
