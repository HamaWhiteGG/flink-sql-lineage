package com.hw.lineage.server.domain.query;

import lombok.Data;
import lombok.ToString;

/**
 * @description: PageOrderCriteria
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class PageOrderCriteria extends OrderCriteria {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
