package com.lineage.server.infrastructure.persistence;

/**
 * @description: BasicDO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 10:05 PM
 */
public abstract class BasicDO {
    private Long createUserId;

    private Long modifyUserId;

    private Long tenantId;

    /**
     * create time
     */
    private Long ctime;

    /**
     * modify time
     */
    private Long mtime;

    private Integer invalid;
}
