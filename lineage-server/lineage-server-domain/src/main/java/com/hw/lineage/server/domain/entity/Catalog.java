package com.hw.lineage.server.domain.entity;

import com.hw.lineage.common.enums.CatalogType;
import com.hw.lineage.common.model.Property;
import com.hw.lineage.server.domain.entity.basic.BasicEntity;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hw.lineage.common.util.Constant.INITIAL_CAPACITY;
import static java.util.stream.Collectors.toMap;

/**
 * @description: Catalog
 * @author: HamaWhite
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

    private List<Property> propertyList;

    private Boolean defaultCatalog;

    public Map<String, String> getPropertiesMap() {
        Map<String, String> propertiesMap = propertyList == null
                ? new HashMap<>(INITIAL_CAPACITY)
                : propertyList.stream().collect(toMap(Property::getName, Property::getValue));

        propertiesMap.put("type", catalogType.value());
        propertiesMap.put("default-database", defaultDatabase);
        return propertiesMap;
    }
}
