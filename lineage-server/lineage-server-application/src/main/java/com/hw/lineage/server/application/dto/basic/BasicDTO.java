package com.hw.lineage.server.application.dto.basic;

import lombok.Data;

/**
 * @description: BasicDTO
 * @author: HamaWhite
 */
@Data
public abstract class BasicDTO extends RootDTO {
    private Long createUserId;

    private Long modifyUserId;

}
