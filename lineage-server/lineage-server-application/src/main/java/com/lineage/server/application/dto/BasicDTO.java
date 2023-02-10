package com.lineage.server.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: BasicDTO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/5 9:27 PM
 */
@Data
public abstract class BasicDTO implements Serializable {
    private Long createUserId;

    private Long modifyUserId;

    private Long createTime;

    private Long modifyTime;
}
