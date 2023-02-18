package com.hw.lineage.server.domain.entity;

import com.hw.lineage.server.domain.entity.basic.BasicEntity;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import com.hw.lineage.server.domain.vo.TaskId;
import com.hw.lineage.server.domain.vo.TaskSource;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Task
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Task extends BasicEntity implements Entity {
    private TaskId taskId;

    private String taskName;

    private String descr;

    private PluginId pluginId;

    private CatalogId catalogId;

    private TaskSource taskSource;

    private List<TaskSql> taskSqlList;

    private List<TaskLineage> taskLineageList;

    public Task() {
        this.taskSqlList = new ArrayList<>();
        this.taskLineageList = new ArrayList<>();
    }

    public boolean addTaskSql(TaskSql taskSql) {
        return this.taskSqlList.add(taskSql);
    }

    public boolean addTaskLineage(TaskLineage taskLineage) {
        return this.taskLineageList.add(taskLineage);
    }
}
