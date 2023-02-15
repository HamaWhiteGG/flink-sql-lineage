package com.lineage.server.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: BasicDTO
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public abstract class BasicDTO implements Serializable {
    private Long createUserId;

    private Long modifyUserId;

    private Long createTime;

    private Long modifyTime;
}
