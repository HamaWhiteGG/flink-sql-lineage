package com.lineage.server.application.cqe.query.task;

import com.lineage.server.application.cqe.query.PageQuery;
import lombok.Data;

/**
 * @description: TaskQuery
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/29 11:50 AM
 */
@Data
public class TaskQuery extends PageQuery {

    private String taskName;
}
