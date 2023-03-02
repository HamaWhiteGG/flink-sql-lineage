package com.hw.lineage.server.domain.entity;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.server.domain.entity.basic.BasicEntity;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @description: Catalog
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Catalog extends BasicEntity implements Entity {

    private CatalogId catalogId;

    private PluginId pluginId;

    private String catalogName;

    private CatalogType catalogType;

    private String defaultDatabase;

    private String descr;

    private JSONObject catalogProperties;

    private Boolean defaultCatalog;


    public Map<String, String> getPropertiesMap() {
        return JSON.parseObject(catalogProperties.toJSONString(), new TypeReference<Map<String, String>>() {});
    }
}
