package com.lineage.server.infrastructure.repository.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.common.util.PageUtils;
import com.lineage.server.domain.entity.Task;
import com.lineage.server.domain.entity.TaskLineage;
import com.lineage.server.domain.entity.TaskSql;
import com.lineage.server.domain.query.task.TaskQuery;
import com.lineage.server.domain.repository.TaskRepository;
import com.lineage.server.domain.vo.TaskId;
import com.lineage.server.infrastructure.persistence.converter.DataConverter;
import com.lineage.server.infrastructure.persistence.dos.TaskDO;
import com.lineage.server.infrastructure.persistence.dos.TaskLineageDO;
import com.lineage.server.infrastructure.persistence.dos.TaskSqlDO;
import com.lineage.server.infrastructure.persistence.mapper.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.lineage.server.infrastructure.persistence.mapper.TaskDynamicSqlSupport.taskName;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @description: TaskRepositoryImpl
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/1/23 10:27 PM
 */
@Repository
public class TaskRepositoryImpl extends AbstractBasicRepository implements TaskRepository {
    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskSqlMapper taskSqlMapper;

    @Resource
    private TaskLineageMapper taskLineageMapper;

    @Resource
    private DataConverter converter;

    @Override
    public Task find(TaskId taskId) {
        TaskDO taskDO = taskMapper.selectByPrimaryKey(taskId.getValue())
                .orElseThrow(() ->
                        new LineageException(String.format("taskId [%s] is not existed", taskId.getValue()))
                );
        return converter.toTask(taskDO);
    }


    @Override
    public boolean find(String name) {
        return !taskMapper.select(completer -> completer.where(taskName, isEqualTo(name))).isEmpty();
    }

    @Override
    public Task save(Task task) {
        TaskDO taskDO = converter.fromTask(task);
        if (taskDO.getTaskId() == null) {
            taskMapper.insertSelective(taskDO);
        } else {
            taskMapper.updateByPrimaryKeySelective(taskDO);
        }
        return converter.toTask(taskDO);
    }

    @Override
    public void saveTaskSql(Task task) {
        List<TaskSql> taskSqlList = task.getTaskSqlList().stream().map(taskSql -> {
                    TaskSqlDO taskSqlDO = converter.fromTaskSql(taskSql);
                    taskSqlMapper.insertSelective(taskSqlDO);
                    return converter.toTaskSql(taskSqlDO);
                }
        ).collect(Collectors.toList());
        task.setTaskSqlList(taskSqlList);
    }


    @Override
    public void saveTaskLineage(Task task) {
        List<TaskLineage> taskLineageList = task.getTaskLineageList().stream().map(taskLineage -> {
                    TaskLineageDO taskLineageDO = converter.fromTaskLineage(taskLineage);
                    taskLineageMapper.insertSelective(taskLineageDO);
                    return converter.toTaskLineage(taskLineageDO);
                }
        ).collect(Collectors.toList());
        task.setTaskLineageList(taskLineageList);
    }

    @Override
    public void removeTaskSql(TaskId taskId) {
        taskSqlMapper.delete(completer ->
                completer.where(TaskSqlDynamicSqlSupport.taskId, isEqualTo(taskId.getValue()))
        );
    }

    @Override
    public void removeTaskLineage(TaskId taskId) {
        taskLineageMapper.delete(completer ->
                completer.where(TaskLineageDynamicSqlSupport.taskId, isEqualTo(taskId.getValue()))
        );
    }

    @Override
    public void remove(TaskId taskId) {
        taskMapper.deleteByPrimaryKey(taskId.getValue());
    }

    @Override
    public PageInfo<Task> findAll(TaskQuery taskQuery) {
        try (Page<TaskDO> page = PageMethod.startPage(taskQuery.getPageNum(), taskQuery.getPageSize())) {
            PageInfo<TaskDO> pageInfo = page.doSelectPageInfo(() ->
                    taskMapper.select(completer ->
                            completer.where(taskName, isLike(buildLikeValue(taskQuery.getTaskName())))
                                    .orderBy(buildSortSpecification(taskQuery))
                    )
            );
            return PageUtils.convertPage(pageInfo, converter::toTask);
        }
    }
}
