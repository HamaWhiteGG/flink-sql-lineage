package com.hw.lineage.server.domain.entity.basic;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: RootEntity
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
public abstract class RootEntity {

    private Long createTime;

    private Long modifyTime;

    private Boolean invalid;
}
