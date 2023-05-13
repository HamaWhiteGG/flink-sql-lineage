package com.hw.lineage.server.infrastructure.persistence.mapper;

import com.hw.lineage.server.infrastructure.persistence.dos.TaskFunctionDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.hw.lineage.server.infrastructure.persistence.mapper.TaskFunctionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TaskFunctionMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TaskFunctionDO>, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(rid, taskId, sqlId, functionId, catalogName, database, functionName, createTime, invalid);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TaskFunctionDOResult", value = {
        @Result(column="rid", property="rid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="sql_id", property="sqlId", jdbcType=JdbcType.BIGINT),
        @Result(column="function_id", property="functionId", jdbcType=JdbcType.BIGINT),
        @Result(column="catalog_name", property="catalogName", jdbcType=JdbcType.VARCHAR),
        @Result(column="database", property="database", jdbcType=JdbcType.VARCHAR),
        @Result(column="function_name", property="functionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT)
    })
    List<TaskFunctionDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TaskFunctionDOResult")
    Optional<TaskFunctionDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, taskFunction, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, taskFunction, completer);
    }

    default int deleteByPrimaryKey(Long rid_) {
        return delete(c -> 
            c.where(rid, isEqualTo(rid_))
        );
    }

    default int insert(TaskFunctionDO row) {
        return MyBatis3Utils.insert(this::insert, row, taskFunction, c ->
            c.map(rid).toProperty("rid")
            .map(taskId).toProperty("taskId")
            .map(sqlId).toProperty("sqlId")
            .map(functionId).toProperty("functionId")
            .map(catalogName).toProperty("catalogName")
            .map(database).toProperty("database")
            .map(functionName).toProperty("functionName")
            .map(createTime).toProperty("createTime")
            .map(invalid).toProperty("invalid")
        );
    }

    default int insertMultiple(Collection<TaskFunctionDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, taskFunction, c ->
            c.map(rid).toProperty("rid")
            .map(taskId).toProperty("taskId")
            .map(sqlId).toProperty("sqlId")
            .map(functionId).toProperty("functionId")
            .map(catalogName).toProperty("catalogName")
            .map(database).toProperty("database")
            .map(functionName).toProperty("functionName")
            .map(createTime).toProperty("createTime")
            .map(invalid).toProperty("invalid")
        );
    }

    default int insertSelective(TaskFunctionDO row) {
        return MyBatis3Utils.insert(this::insert, row, taskFunction, c ->
            c.map(rid).toPropertyWhenPresent("rid", row::getRid)
            .map(taskId).toPropertyWhenPresent("taskId", row::getTaskId)
            .map(sqlId).toPropertyWhenPresent("sqlId", row::getSqlId)
            .map(functionId).toPropertyWhenPresent("functionId", row::getFunctionId)
            .map(catalogName).toPropertyWhenPresent("catalogName", row::getCatalogName)
            .map(database).toPropertyWhenPresent("database", row::getDatabase)
            .map(functionName).toPropertyWhenPresent("functionName", row::getFunctionName)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
        );
    }

    default Optional<TaskFunctionDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, taskFunction, completer);
    }

    default List<TaskFunctionDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, taskFunction, completer);
    }

    default List<TaskFunctionDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, taskFunction, completer);
    }

    default Optional<TaskFunctionDO> selectByPrimaryKey(Long rid_) {
        return selectOne(c ->
            c.where(rid, isEqualTo(rid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, taskFunction, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TaskFunctionDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(rid).equalTo(row::getRid)
                .set(taskId).equalTo(row::getTaskId)
                .set(sqlId).equalTo(row::getSqlId)
                .set(functionId).equalTo(row::getFunctionId)
                .set(catalogName).equalTo(row::getCatalogName)
                .set(database).equalTo(row::getDatabase)
                .set(functionName).equalTo(row::getFunctionName)
                .set(createTime).equalTo(row::getCreateTime)
                .set(invalid).equalTo(row::getInvalid);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TaskFunctionDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(rid).equalToWhenPresent(row::getRid)
                .set(taskId).equalToWhenPresent(row::getTaskId)
                .set(sqlId).equalToWhenPresent(row::getSqlId)
                .set(functionId).equalToWhenPresent(row::getFunctionId)
                .set(catalogName).equalToWhenPresent(row::getCatalogName)
                .set(database).equalToWhenPresent(row::getDatabase)
                .set(functionName).equalToWhenPresent(row::getFunctionName)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(invalid).equalToWhenPresent(row::getInvalid);
    }

    default int updateByPrimaryKey(TaskFunctionDO row) {
        return update(c ->
            c.set(taskId).equalTo(row::getTaskId)
            .set(sqlId).equalTo(row::getSqlId)
            .set(functionId).equalTo(row::getFunctionId)
            .set(catalogName).equalTo(row::getCatalogName)
            .set(database).equalTo(row::getDatabase)
            .set(functionName).equalTo(row::getFunctionName)
            .set(createTime).equalTo(row::getCreateTime)
            .set(invalid).equalTo(row::getInvalid)
            .where(rid, isEqualTo(row::getRid))
        );
    }

    default int updateByPrimaryKeySelective(TaskFunctionDO row) {
        return update(c ->
            c.set(taskId).equalToWhenPresent(row::getTaskId)
            .set(sqlId).equalToWhenPresent(row::getSqlId)
            .set(functionId).equalToWhenPresent(row::getFunctionId)
            .set(catalogName).equalToWhenPresent(row::getCatalogName)
            .set(database).equalToWhenPresent(row::getDatabase)
            .set(functionName).equalToWhenPresent(row::getFunctionName)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(invalid).equalToWhenPresent(row::getInvalid)
            .where(rid, isEqualTo(row::getRid))
        );
    }
}