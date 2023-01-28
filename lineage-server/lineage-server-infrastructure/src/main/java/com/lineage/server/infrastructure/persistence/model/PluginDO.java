package com.lineage.server.infrastructure.persistence.model;

/**
 * @description: This class corresponds to the database table bas_plugin
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/01/28 23:03:46
 *
 * @mbg.generated
 */
public class PluginDO {
    private Long pluginId;

    private String pluginName;

    private String descr;

    private Long createUserId;

    private Long modifyUserId;

    private Long ctime;

    private Long mtime;

    private Integer invalid;

    public Long getPluginId() {
        return pluginId;
    }

    public void setPluginId(Long pluginId) {
        this.pluginId = pluginId;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
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
        PluginDO other = (PluginDO) that;
        return (this.getPluginId() == null ? other.getPluginId() == null : this.getPluginId().equals(other.getPluginId()))
            && (this.getPluginName() == null ? other.getPluginName() == null : this.getPluginName().equals(other.getPluginName()))
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
        result = prime * result + ((getPluginId() == null) ? 0 : getPluginId().hashCode());
        result = prime * result + ((getPluginName() == null) ? 0 : getPluginName().hashCode());
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
        sb.append(", pluginId=").append(pluginId);
        sb.append(", pluginName=").append(pluginName);
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