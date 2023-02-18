package com.hw.lineage.server.infrastructure.persistence.mapper;

import static com.hw.lineage.server.infrastructure.persistence.mapper.TaskDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.hw.lineage.server.infrastructure.persistence.dos.TaskDO;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TaskMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(taskId, taskName, descr, pluginId, catalogId, createUserId, modifyUserId, createTime, modifyTime, invalid, taskSource);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.taskId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<TaskDO> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TaskDOResult", value = {
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_name", property="taskName", jdbcType=JdbcType.VARCHAR),
        @Result(column="descr", property="descr", jdbcType=JdbcType.VARCHAR),
        @Result(column="plugin_id", property="pluginId", jdbcType=JdbcType.BIGINT),
        @Result(column="catalog_id", property="catalogId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_user_id", property="modifyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT),
        @Result(column="task_source", property="taskSource", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TaskDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TaskDOResult")
    Optional<TaskDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, task, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, task, completer);
    }

    default int deleteByPrimaryKey(Long taskId_) {
        return delete(c -> 
            c.where(taskId, isEqualTo(taskId_))
        );
    }

    default int insert(TaskDO row) {
        return MyBatis3Utils.insert(this::insert, row, task, c ->
            c.map(taskName).toProperty("taskName")
            .map(descr).toProperty("descr")
            .map(pluginId).toProperty("pluginId")
            .map(catalogId).toProperty("catalogId")
            .map(createUserId).toProperty("createUserId")
            .map(modifyUserId).toProperty("modifyUserId")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
            .map(invalid).toProperty("invalid")
            .map(taskSource).toProperty("taskSource")
        );
    }

    default int insertSelective(TaskDO row) {
        return MyBatis3Utils.insert(this::insert, row, task, c ->
            c.map(taskName).toPropertyWhenPresent("taskName", row::getTaskName)
            .map(descr).toPropertyWhenPresent("descr", row::getDescr)
            .map(pluginId).toPropertyWhenPresent("pluginId", row::getPluginId)
            .map(catalogId).toPropertyWhenPresent("catalogId", row::getCatalogId)
            .map(createUserId).toPropertyWhenPresent("createUserId", row::getCreateUserId)
            .map(modifyUserId).toPropertyWhenPresent("modifyUserId", row::getModifyUserId)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(modifyTime).toPropertyWhenPresent("modifyTime", row::getModifyTime)
            .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
            .map(taskSource).toPropertyWhenPresent("taskSource", row::getTaskSource)
        );
    }

    default Optional<TaskDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, task, completer);
    }

    default List<TaskDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, task, completer);
    }

    default List<TaskDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, task, completer);
    }

    default Optional<TaskDO> selectByPrimaryKey(Long taskId_) {
        return selectOne(c ->
            c.where(taskId, isEqualTo(taskId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, task, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TaskDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(taskName).equalTo(row::getTaskName)
                .set(descr).equalTo(row::getDescr)
                .set(pluginId).equalTo(row::getPluginId)
                .set(catalogId).equalTo(row::getCatalogId)
                .set(createUserId).equalTo(row::getCreateUserId)
                .set(modifyUserId).equalTo(row::getModifyUserId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(modifyTime).equalTo(row::getModifyTime)
                .set(invalid).equalTo(row::getInvalid)
                .set(taskSource).equalTo(row::getTaskSource);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TaskDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(taskName).equalToWhenPresent(row::getTaskName)
                .set(descr).equalToWhenPresent(row::getDescr)
                .set(pluginId).equalToWhenPresent(row::getPluginId)
                .set(catalogId).equalToWhenPresent(row::getCatalogId)
                .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(modifyTime).equalToWhenPresent(row::getModifyTime)
                .set(invalid).equalToWhenPresent(row::getInvalid)
                .set(taskSource).equalToWhenPresent(row::getTaskSource);
    }

    default int updateByPrimaryKey(TaskDO row) {
        return update(c ->
            c.set(taskName).equalTo(row::getTaskName)
            .set(descr).equalTo(row::getDescr)
            .set(pluginId).equalTo(row::getPluginId)
            .set(catalogId).equalTo(row::getCatalogId)
            .set(createUserId).equalTo(row::getCreateUserId)
            .set(modifyUserId).equalTo(row::getModifyUserId)
            .set(createTime).equalTo(row::getCreateTime)
            .set(modifyTime).equalTo(row::getModifyTime)
            .set(invalid).equalTo(row::getInvalid)
            .set(taskSource).equalTo(row::getTaskSource)
            .where(taskId, isEqualTo(row::getTaskId))
        );
    }

    default int updateByPrimaryKeySelective(TaskDO row) {
        return update(c ->
            c.set(taskName).equalToWhenPresent(row::getTaskName)
            .set(descr).equalToWhenPresent(row::getDescr)
            .set(pluginId).equalToWhenPresent(row::getPluginId)
            .set(catalogId).equalToWhenPresent(row::getCatalogId)
            .set(createUserId).equalToWhenPresent(row::getCreateUserId)
            .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(modifyTime).equalToWhenPresent(row::getModifyTime)
            .set(invalid).equalToWhenPresent(row::getInvalid)
            .set(taskSource).equalToWhenPresent(row::getTaskSource)
            .where(taskId, isEqualTo(row::getTaskId))
        );
    }
}