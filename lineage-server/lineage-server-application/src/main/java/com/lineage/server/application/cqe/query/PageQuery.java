package com.lineage.server.application.cqe.query;

import lombok.Data;

/**
 * @description: PageQuery
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/1 10:47 AM
 */
@Data
public class PageQuery {
    private Integer pageNum;
    private Integer pageSize;
}
