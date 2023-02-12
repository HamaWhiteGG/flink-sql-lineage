package com.lineage.server.domain.query;

import lombok.Data;

/**
 * @description: OrderCriteria
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 10:52 AM
 */
@Data
public class OrderCriteria {

    /**
     * sort field, default createTime
     */
    private String sortColumn = "createTime";

    private boolean descending = false;
}
