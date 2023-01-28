package com.lineage.server.infrastructure.persistence.model;

/**
 * @description: This class corresponds to the database table bas_task
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/01/28 23:03:46
 *
 * @mbg.generated
 */
public class TaskDO {
    private Long taskId;

    private String taskName;

    private String descr;

    private Long pluginId;

    private Long catalogId;

    private Long createUserId;

    private Long modifyUserId;

    private Long ctime;

    private Long mtime;

    private Integer invalid;

    /**
     * Base64 encode
     */
    private String source;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getPluginId() {
        return pluginId;
    }

    public void setPluginId(Long pluginId) {
        this.pluginId = pluginId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        TaskDO other = (TaskDO) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
            && (this.getPluginId() == null ? other.getPluginId() == null : this.getPluginId().equals(other.getPluginId()))
            && (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
            && (this.getInvalid() == null ? other.getInvalid() == null : this.getInvalid().equals(other.getInvalid()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getPluginId() == null) ? 0 : getPluginId().hashCode());
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        result = prime * result + ((getInvalid() == null) ? 0 : getInvalid().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", taskName=").append(taskName);
        sb.append(", descr=").append(descr);
        sb.append(", pluginId=").append(pluginId);
        sb.append(", catalogId=").append(catalogId);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append(", invalid=").append(invalid);
        sb.append(", source=").append(source);
        sb.append("]");
        return sb.toString();
    }
}