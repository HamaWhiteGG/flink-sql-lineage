/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.infrastructure.persistence.dos;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.model.Property;

import java.util.List;

/**
 * @description: This class corresponds to the database table bas_catalog
 * @author: HamaWhite
 *
 * @mbg.generated
 */
public class CatalogDO {
    private Long catalogId;

    private Long pluginId;

    private String catalogName;

    private CatalogType catalogType;

    private String defaultDatabase;

    private String descr;

    private Boolean defaultCatalog;

    private Long createUserId;

    private Long modifyUserId;

    private Long createTime;

    private Long modifyTime;

    private Boolean invalid;

    private List<Property> propertyList;

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getPluginId() {
        return pluginId;
    }

    public void setPluginId(Long pluginId) {
        this.pluginId = pluginId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public CatalogType getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(CatalogType catalogType) {
        this.catalogType = catalogType;
    }

    public String getDefaultDatabase() {
        return defaultDatabase;
    }

    public void setDefaultDatabase(String defaultDatabase) {
        this.defaultDatabase = defaultDatabase;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Boolean getDefaultCatalog() {
        return defaultCatalog;
    }

    public void setDefaultCatalog(Boolean defaultCatalog) {
        this.defaultCatalog = defaultCatalog;
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
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
        CatalogDO other = (CatalogDO) that;
        return (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
                && (this.getPluginId() == null ? other.getPluginId() == null : this.getPluginId().equals(other.getPluginId()))
                && (this.getCatalogName() == null ? other.getCatalogName() == null : this.getCatalogName().equals(other.getCatalogName()))
                && (this.getCatalogType() == null ? other.getCatalogType() == null : this.getCatalogType().equals(other.getCatalogType()))
                && (this.getDefaultDatabase() == null ? other.getDefaultDatabase() == null : this.getDefaultDatabase().equals(other.getDefaultDatabase()))
                && (this.getDescr() == null ? other.getDescr() == null : this.getDescr().equals(other.getDescr()))
                && (this.getDefaultCatalog() == null ? other.getDefaultCatalog() == null : this.getDefaultCatalog().equals(other.getDefaultCatalog()))
                && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
                && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
                && (this.getInvalid() == null ? other.getInvalid() == null : this.getInvalid().equals(other.getInvalid()))
                && (this.getPropertyList() == null ? other.getPropertyList() == null : this.getPropertyList().equals(other.getPropertyList()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getPluginId() == null) ? 0 : getPluginId().hashCode());
        result = prime * result + ((getCatalogName() == null) ? 0 : getCatalogName().hashCode());
        result = prime * result + ((getCatalogType() == null) ? 0 : getCatalogType().hashCode());
        result = prime * result + ((getDefaultDatabase() == null) ? 0 : getDefaultDatabase().hashCode());
        result = prime * result + ((getDescr() == null) ? 0 : getDescr().hashCode());
        result = prime * result + ((getDefaultCatalog() == null) ? 0 : getDefaultCatalog().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getInvalid() == null) ? 0 : getInvalid().hashCode());
        result = prime * result + ((getPropertyList() == null) ? 0 : getPropertyList().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", catalogId=").append(catalogId);
        sb.append(", pluginId=").append(pluginId);
        sb.append(", catalogName=").append(catalogName);
        sb.append(", catalogType=").append(catalogType);
        sb.append(", defaultDatabase=").append(defaultDatabase);
        sb.append(", descr=").append(descr);
        sb.append(", defaultCatalog=").append(defaultCatalog);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", invalid=").append(invalid);
        sb.append(", propertyList=").append(propertyList);
        sb.append("]");
        return sb.toString();
    }
}