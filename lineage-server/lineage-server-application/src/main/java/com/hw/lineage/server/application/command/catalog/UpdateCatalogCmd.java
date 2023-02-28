package com.hw.lineage.server.application.command.catalog;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: UpdateCatalogCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UpdateCatalogCmd {

    @NotNull
    private Long catalogId;

    private String catalogName;

    private String defaultDatabase;

    private String descr;

    private JSONObject catalogProperties;

}
