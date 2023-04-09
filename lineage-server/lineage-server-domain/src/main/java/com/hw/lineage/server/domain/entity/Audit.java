package com.hw.lineage.server.domain.entity;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.AuditId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Audit
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
public class Audit implements Entity {

    private AuditId auditId;

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

    private Boolean invalid;

    private String method;

    private JSONObject parameters;

    private String exception;
}
