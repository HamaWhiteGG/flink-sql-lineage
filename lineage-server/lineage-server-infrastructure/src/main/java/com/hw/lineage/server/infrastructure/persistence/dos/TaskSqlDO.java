package com.hw.lineage.server.infrastructure.persistence.dos;

import com.hw.lineage.common.enums.ParseStatus;
import com.hw.lineage.common.enums.SqlType;

/**
 * @description: This class corresponds to the database table rel_task_sql
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/02/11 21:16:44
 *
 * @mbg.generated
 */
public class TaskSqlDO {
    private Long sqlId;

    private Long taskId;

    private SqlType sqlType;

    private ParseStatus parseStatus;

    private Long parseTime;

    private Boolean invalid;

    /**
     * Base64 encode
     */
    private String sqlCode;

    private String parseLog;

    public Long getSqlId() {
        return sqlId;
    }

    public void setSqlId(Long sqlId) {
        this.sqlId = sqlId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public SqlType getSqlType() {
        return sqlType;
    }

    public void setSqlType(SqlType sqlType) {
        this.sqlType = sqlType;
    }

    public ParseStatus getParseStatus() {
        return parseStatus;
    }

    public void setParseStatus(ParseStatus parseStatus) {
        this.parseStatus = parseStatus;
    }

    public Long getParseTime() {
        return parseTime;
    }

    public void setParseTime(Long parseTime) {
        this.parseTime = parseTime;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public String getSqlCode() {
        return sqlCode;
    }

    public void setSqlCode(String sqlCode) {
        this.sqlCode = sqlCode;
    }

    public String getParseLog() {
        return parseLog;
    }

    public void setParseLog(String parseLog) {
        this.parseLog = parseLog;
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
        TaskSqlDO other = (TaskSqlDO) that;
        return (this.getSqlId() == null ? other.getSqlId() == null : this.getSqlId().equals(other.getSqlId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getSqlType() == null ? other.getSqlType() == null : this.getSqlType().equals(other.getSqlType()))
            && (this.getParseStatus() == null ? other.getParseStatus() == null : this.getParseStatus().equals(other.getParseStatus()))
            && (this.getParseTime() == null ? other.getParseTime() == null : this.getParseTime().equals(other.getParseTime()))
            && (this.getInvalid() == null ? other.getInvalid() == null : this.getInvalid().equals(other.getInvalid()))
            && (this.getSqlCode() == null ? other.getSqlCode() == null : this.getSqlCode().equals(other.getSqlCode()))
            && (this.getParseLog() == null ? other.getParseLog() == null : this.getParseLog().equals(other.getParseLog()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSqlId() == null) ? 0 : getSqlId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getSqlType() == null) ? 0 : getSqlType().hashCode());
        result = prime * result + ((getParseStatus() == null) ? 0 : getParseStatus().hashCode());
        result = prime * result + ((getParseTime() == null) ? 0 : getParseTime().hashCode());
        result = prime * result + ((getInvalid() == null) ? 0 : getInvalid().hashCode());
        result = prime * result + ((getSqlCode() == null) ? 0 : getSqlCode().hashCode());
        result = prime * result + ((getParseLog() == null) ? 0 : getParseLog().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sqlId=").append(sqlId);
        sb.append(", taskId=").append(taskId);
        sb.append(", sqlType=").append(sqlType);
        sb.append(", parseStatus=").append(parseStatus);
        sb.append(", parseTime=").append(parseTime);
        sb.append(", invalid=").append(invalid);
        sb.append(", sqlCode=").append(sqlCode);
        sb.append(", parseLog=").append(parseLog);
        sb.append("]");
        return sb.toString();
    }
}