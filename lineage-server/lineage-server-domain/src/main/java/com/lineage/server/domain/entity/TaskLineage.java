package com.lineage.server.domain.entity;

import com.lineage.server.domain.vo.SqlId;
import com.lineage.server.domain.vo.TaskId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: TaskLineage
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 9:48 PM
 */
@Data
@Accessors(chain = true)
public class TaskLineage {

    private TaskId taskId;

    private SqlId sqlId;

    private String sourceCatalog;

    private String sourceDatabase;

    private String sourceTable;

    private String sourceColumn;

    private String targetCatalog;

    private String targetDatabase;

    private String targetTable;

    private String targetColumn;

    private String transform;

    private Boolean invalid;

}
