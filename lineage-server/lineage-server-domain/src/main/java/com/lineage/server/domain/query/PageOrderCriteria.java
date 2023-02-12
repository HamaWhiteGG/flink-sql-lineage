package com.lineage.server.domain.query;

import lombok.Data;

/**
 * @description: PageOrderCriteria
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/1 10:47 AM
 */
@Data
public class PageOrderCriteria extends OrderCriteria {
    private Integer pageNum;
    private Integer pageSize;
}
