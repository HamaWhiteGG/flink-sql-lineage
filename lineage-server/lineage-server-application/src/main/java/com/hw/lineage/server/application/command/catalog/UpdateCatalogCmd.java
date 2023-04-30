package com.hw.lineage.server.application.command.catalog;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.server.domain.query.BasicCriteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @description: UpdateCatalogCmd
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class UpdateCatalogCmd extends BasicCriteria {

    @ApiModelProperty(hidden = true)
    private Long catalogId;

    private String catalogName;

    private String defaultDatabase;

    private String descr;

    private JSONObject catalogProperties;

}
