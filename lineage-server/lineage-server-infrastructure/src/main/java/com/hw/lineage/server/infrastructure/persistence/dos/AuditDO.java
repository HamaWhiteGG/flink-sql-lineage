package com.hw.lineage.server.infrastructure.persistence.dos;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.common.enums.audit.OperationType;

/**
 * @description: This class corresponds to the database table bas_audit
 * @author: HamaWhite
 *
 * @mbg.generated
 */
public class AuditDO {
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

    private String method;

    private String ip;

    private Long createTime;

    private Boolean invalid;

    private JSONObject parameters;

    private String exception;

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public JSONObject getParameters() {
        return parameters;
    }

    public void setParameters(JSONObject parameters) {
        this.parameters = parameters;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AuditDO other = (AuditDO) that;
        return (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getModuleCode() == null ? other.getModuleCode() == null : this.getModuleCode().equals(other.getModuleCode()))
            && (this.getOperationType() == null ? other.getOperationType() == null : this.getOperationType().equals(other.getOperationType()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getOperationStatus() == null ? other.getOperationStatus() == null : this.getOperationStatus().equals(other.getOperationStatus()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getInvalid() == null ? other.getInvalid() == null : this.getInvalid().equals(other.getInvalid()))
            && (this.getParameters() == null ? other.getParameters() == null : this.getParameters().equals(other.getParameters()))
            && (this.getException() == null ? other.getException() == null : this.getException().equals(other.getException()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuditId() == null) ? 0 : getAuditId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getModuleCode() == null) ? 0 : getModuleCode().hashCode());
        result = prime * result + ((getOperationType() == null) ? 0 : getOperationType().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getOperationStatus() == null) ? 0 : getOperationStatus().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getInvalid() == null) ? 0 : getInvalid().hashCode());
        result = prime * result + ((getParameters() == null) ? 0 : getParameters().hashCode());
        result = prime * result + ((getException() == null) ? 0 : getException().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", auditId=").append(auditId);
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", moduleCode=").append(moduleCode);
        sb.append(", operationType=").append(operationType);
        sb.append(", descr=").append(descr);
        sb.append(", duration=").append(duration);
        sb.append(", operationStatus=").append(operationStatus);
        sb.append(", method=").append(method);
        sb.append(", ip=").append(ip);
        sb.append(", createTime=").append(createTime);
        sb.append(", invalid=").append(invalid);
        sb.append(", parameters=").append(parameters);
        sb.append(", exception=").append(exception);
        sb.append("]");
        return sb.toString();
    }
}