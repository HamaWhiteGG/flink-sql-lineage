package com.lineage.server.domain.query.function;

import com.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;

/**
 * @description: FunctionQuery
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/10 8:51 PM
 */
@Data
public class FunctionQuery extends PageOrderCriteria {

    private String functionName;
}