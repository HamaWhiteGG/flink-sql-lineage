package com.hw.lineage.server.domain.query.audit;

import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: AuditQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class AuditQuery extends PageOrderCriteria {

    private String username;

    private ModuleCode moduleCode;

    private OperationType operationType;

    private OperationStatus operationStatus;

    private String ip;

    private Long createTime;
}