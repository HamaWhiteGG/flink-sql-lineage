package com.hw.lineage.server.application.command.audit;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;
import com.hw.lineage.server.domain.query.BasicCriteria;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: CreateAuditCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class CreateAuditCmd extends BasicCriteria {

    @NotBlank
    private String username;

    @NotNull
    private ModuleCode moduleCode;

    @NotNull
    private OperationType operationType;

    @NotNull
    private String descr;

    @NotNull
    private Long duration;

    @NotNull
    private OperationStatus operationStatus;

    @NotBlank
    private String ip;

    private String method;

    private JSONObject parameters;

    private String exception;
}
