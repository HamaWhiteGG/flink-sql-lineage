package com.lineage.server.infrastructure.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.entity.TaskLineage;
import com.lineage.server.domain.entity.TaskSql;
import com.lineage.server.domain.repository.TaskRepository;
import com.lineage.server.domain.vo.TaskId;
import com.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
import com.lineage.server.infrastructure.persistence.dos.TaskLineageDO;
import com.lineage.server.infrastructure.persistence.dos.TaskSqlDO;
import com.lineage.server.infrastructure.persistence.mapper.TaskLineageMapper;
import com.lineage.server.infrastructure.persistence.mapper.TaskMapper;
import com.lineage.server.infrastructure.persistence.mapper.TaskSqlMapper;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description: TaskRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 10:27 PM
 */
@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskSqlMapper taskSqlMapper;

    @Resource
    private TaskLineageMapper taskLineageMapper;

    @Override
    public Task find(TaskId taskId) {
        TaskDO taskDO = taskMapper.selectByPrimaryKey(taskId.getValue())
                .orElseThrow(() -> new LineageException(String.format("taskId [%s] is not existed", taskId.getValue())));
        return DataConverter.INSTANCE.toTask(taskDO);
    }

    @Override
    public Task save(Task task) {
        TaskDO taskDO = DataConverter.INSTANCE.fromTask(task);
        taskMapper.insertSelective(taskDO);
        if (task.getTaskSqlList() != null) {
            task.getTaskSqlList().forEach(this::save);
        }
        if (task.getTaskLineageList() != null) {
            task.getTaskLineageList().forEach(this::save);
        }
        return DataConverter.INSTANCE.toTask(taskDO);
    }

    public TaskSql save(TaskSql taskSql) {
        TaskSqlDO taskSqlDO = DataConverter.INSTANCE.fromTaskSql(taskSql);
        taskSqlMapper.insertSelective(taskSqlDO);
        return DataConverter.INSTANCE.toTaskSql(taskSqlDO);
    }

    public TaskLineage save(TaskLineage taskLineage) {
        TaskLineageDO taskLineageDO = DataConverter.INSTANCE.fromTaskLineage(taskLineage);
        taskLineageMapper.insertSelective(taskLineageDO);
        return DataConverter.INSTANCE.toTaskLineage(taskLineageDO);
    }


    @Override
    public Boolean update(Task task) {
        TaskDO taskDO = DataConverter.INSTANCE.fromTask(task);
        return taskMapper.updateByPrimaryKeySelective(taskDO) > 0;
    }

    @Override
    public Boolean remove(TaskId taskId) {
        return taskMapper.deleteByPrimaryKey(taskId.getValue()) > 0;
    }

    @Override
    public PageInfo<Task> query(Integer pageNum, Integer pageSize) {
        try (Page<TaskDO> page = PageMethod.startPage(pageNum, pageSize)) {
            PageInfo<TaskDO> pageInfo = page.doSelectPageInfo(() -> taskMapper.select(SelectDSLCompleter.allRows()));
            return PageUtils.convertPage(pageInfo, DataConverter.INSTANCE::toTask);
        }
    }
}
