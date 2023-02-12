package com.lineage.server.domain.query.task;

import com.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;

/**
 * @description: TaskQuery
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 11:50 AM
 */
@Data
public class TaskQuery extends PageOrderCriteria {

    private String taskName;
}
