package com.lineage.server.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: BasicDO
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 3:48 PM
 */
@Data
@Accessors(chain = true)
public class BasicDO {

    private Long createUserId;

    private Long modifyUserId;

    private Long createTime;

    private Long modifyTime;

    private Boolean invalid;
}
