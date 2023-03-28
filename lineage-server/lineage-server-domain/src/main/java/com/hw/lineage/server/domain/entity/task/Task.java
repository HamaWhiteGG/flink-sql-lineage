package com.hw.lineage.server.domain.entity.task;

import com.hw.lineage.common.enums.TaskStatus;
import com.hw.lineage.server.domain.entity.basic.BasicEntity;
import com.hw.lineage.server.domain.graph.column.ColumnGraph;
import com.hw.lineage.server.domain.graph.table.TableGraph;
import com.hw.lineage.server.domain.repository.basic.Entity;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.TaskId;
import com.hw.lineage.server.domain.vo.TaskSource;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Task
 * @author: HamaWhite
 */
@Data
@Accessors(chain = true)
public class Task extends BasicEntity implements Entity {

    private TaskId taskId;

    private CatalogId catalogId;

    private String taskName;

    private String descr;

    private String database;

    private TaskSource taskSource;

    private TaskStatus taskStatus;

    private String taskLog;

    private TableGraph tableGraph;

    private ColumnGraph columnGraph;

    private Long lineageTime;

    private List<TaskSql> taskSqlList;

    private List<TaskLineage> taskLineageList;

    public Task() {
        this.taskSqlList = new ArrayList<>();
        this.taskLineageList = new ArrayList<>();
        this.taskLog = "";
    }

    public void addTaskSql(TaskSql taskSql) {
        taskSqlList.add(taskSql);
    }

    public void addTaskLineage(TaskLineage taskLineage) {
        taskLineageList.add(taskLineage);
    }


    public void appendTaskLog(String log) {
        taskLog += System.lineSeparator() + log;
    }

    public void clearGraph() {
        tableGraph = null;
        columnGraph = null;
    }

    public void clearTaskLog() {
        taskLog = "";
    }
}
