package com.lineage.server.infrastructure.persistence.model;

/**
 * @description: This class corresponds to the database table bas_function
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/01/28 23:03:46
 *
 * @mbg.generated
 */
public class FunctionDO {
    private Long functionId;

    private String functionName;

    private String functionFormat;

    private String functionPath;

    private String functionClass;

    private String descr;

    private Long createUserId;

    private Long modifyUserId;

    private Long ctime;

    private Long mtime;

    private Integer invalid;

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionFormat() {
        return functionFormat;
    }

    public void setFunctionFormat(String functionFormat) {
        this.functionFormat = functionFormat;
    }

    public String getFunctionPath() {
        return functionPath;
    }

    public void setFunctionPath(String functionPath) {
        this.functionPath = functionPath;
    }

    public String getFunctionClass() {
        return functionClass;
    }

    public void setFunctionClass(String functionClass) {
        this.functionClass = functionClass;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public Integer getInvalid() {
        return invalid;
    }

    public void setInvalid(Integer invalid) {
        this.invalid = invalid;
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
        FunctionDO other = (FunctionDO) that;
        return (this.getFunctionId() == null ? other.getFunctionId() == null : this.getFunctionId().equals(other.getFunctionId()))
            && (this.getFunctionName() == null ? other.getFunctionName() == null : this.getFunctionName().equals(other.getFunctionName()))
            && (this.getFunctionFormat() == null ? other.getFunctionFormat() == null : this.getFunctionFormat().equals(other.getFunctionFormat()))
            && (this.getFunctionPath() == null ? other.getFunctionPath() == null : this.getFunctionPath().equals(other.getFunctionPath()))
            && (this.getFunctionClass() == null ? other.getFunctionClass() == null : this.getFunctionClass().equals(other.getFunctionClass()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
            && (this.getInvalid() == null ? other.getInvalid() == null : this.getInvalid().equals(other.getInvalid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFunctionId() == null) ? 0 : getFunctionId().hashCode());
        result = prime * result + ((getFunctionName() == null) ? 0 : getFunctionName().hashCode());
        result = prime * result + ((getFunctionFormat() == null) ? 0 : getFunctionFormat().hashCode());
        result = prime * result + ((getFunctionPath() == null) ? 0 : getFunctionPath().hashCode());
        result = prime * result + ((getFunctionClass() == null) ? 0 : getFunctionClass().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        result = prime * result + ((getInvalid() == null) ? 0 : getInvalid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", functionId=").append(functionId);
        sb.append(", functionName=").append(functionName);
        sb.append(", functionFormat=").append(functionFormat);
        sb.append(", functionPath=").append(functionPath);
        sb.append(", functionClass=").append(functionClass);
        sb.append(", descr=").append(descr);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append(", invalid=").append(invalid);
        sb.append("]");
        return sb.toString();
    }
}