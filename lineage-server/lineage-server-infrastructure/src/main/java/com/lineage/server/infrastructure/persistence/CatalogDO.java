package com.lineage.server.infrastructure.persistence;

/**
 * @description: CatalogDO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 4:19 PM
 */
public class CatalogDO extends BasicDO{
    private Long catalogId;

    private String catalogName;

    /**
     * TODO change to enum
     */
    private String catalogType;

    private String defaultDatabase;

    private String descr;
}
