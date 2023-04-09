package com.hw.lineage.server.domain.query.task;

import com.hw.lineage.server.domain.query.PageOrderCriteria;
import lombok.Data;
import lombok.ToString;

/**
 * @description: TaskQuery
 * @author: HamaWhite
 */
@Data
@ToString(callSuper = true)
public class TaskQuery extends PageOrderCriteria {

    private String taskName;
}
