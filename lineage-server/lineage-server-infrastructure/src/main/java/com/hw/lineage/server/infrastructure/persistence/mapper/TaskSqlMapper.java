package com.hw.lineage.server.infrastructure.persistence.mapper;

import com.hw.lineage.server.infrastructure.persistence.dos.TaskSqlDO;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.ParseStatusTypeHandler;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.SqlTypeHandler;
import org.apache.ibatis.annotations.*;
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

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TaskSqlMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(TaskSqlDynamicSqlSupport.sqlId, TaskSqlDynamicSqlSupport.taskId, TaskSqlDynamicSqlSupport.sqlType, TaskSqlDynamicSqlSupport.parseStatus, TaskSqlDynamicSqlSupport.parseTime, TaskSqlDynamicSqlSupport.invalid, TaskSqlDynamicSqlSupport.sqlCode, TaskSqlDynamicSqlSupport.parseLog);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.sqlId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<TaskSqlDO> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TaskSqlDOResult", value = {
        @Result(column="sql_id", property="sqlId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="sql_type", property="sqlType", typeHandler= SqlTypeHandler.class, jdbcType=JdbcType.VARCHAR),
        @Result(column="parse_status", property="parseStatus", typeHandler= ParseStatusTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Result(column="parse_time", property="parseTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT),
        @Result(column="sql_code", property="sqlCode", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="parse_log", property="parseLog", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TaskSqlDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TaskSqlDOResult")
    Optional<TaskSqlDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, TaskSqlDynamicSqlSupport.taskSql, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, TaskSqlDynamicSqlSupport.taskSql, completer);
    }

    default int deleteByPrimaryKey(Long sqlId_) {
        return delete(c -> 
            c.where(TaskSqlDynamicSqlSupport.sqlId, isEqualTo(sqlId_))
        );
    }

    default int insert(TaskSqlDO row) {
        return MyBatis3Utils.insert(this::insert, row, TaskSqlDynamicSqlSupport.taskSql, c ->
            c.map(TaskSqlDynamicSqlSupport.taskId).toProperty("taskId")
            .map(TaskSqlDynamicSqlSupport.sqlType).toProperty("sqlType")
            .map(TaskSqlDynamicSqlSupport.parseStatus).toProperty("parseStatus")
            .map(TaskSqlDynamicSqlSupport.parseTime).toProperty("parseTime")
            .map(TaskSqlDynamicSqlSupport.invalid).toProperty("invalid")
            .map(TaskSqlDynamicSqlSupport.sqlCode).toProperty("sqlCode")
            .map(TaskSqlDynamicSqlSupport.parseLog).toProperty("parseLog")
        );
    }

    default int insertSelective(TaskSqlDO row) {
        return MyBatis3Utils.insert(this::insert, row, TaskSqlDynamicSqlSupport.taskSql, c ->
            c.map(TaskSqlDynamicSqlSupport.taskId).toPropertyWhenPresent("taskId", row::getTaskId)
            .map(TaskSqlDynamicSqlSupport.sqlType).toPropertyWhenPresent("sqlType", row::getSqlType)
            .map(TaskSqlDynamicSqlSupport.parseStatus).toPropertyWhenPresent("parseStatus", row::getParseStatus)
            .map(TaskSqlDynamicSqlSupport.parseTime).toPropertyWhenPresent("parseTime", row::getParseTime)
            .map(TaskSqlDynamicSqlSupport.invalid).toPropertyWhenPresent("invalid", row::getInvalid)
            .map(TaskSqlDynamicSqlSupport.sqlCode).toPropertyWhenPresent("sqlCode", row::getSqlCode)
            .map(TaskSqlDynamicSqlSupport.parseLog).toPropertyWhenPresent("parseLog", row::getParseLog)
        );
    }

    default Optional<TaskSqlDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, TaskSqlDynamicSqlSupport.taskSql, completer);
    }

    default List<TaskSqlDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, TaskSqlDynamicSqlSupport.taskSql, completer);
    }

    default List<TaskSqlDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, TaskSqlDynamicSqlSupport.taskSql, completer);
    }

    default Optional<TaskSqlDO> selectByPrimaryKey(Long sqlId_) {
        return selectOne(c ->
            c.where(TaskSqlDynamicSqlSupport.sqlId, isEqualTo(sqlId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, TaskSqlDynamicSqlSupport.taskSql, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TaskSqlDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(TaskSqlDynamicSqlSupport.taskId).equalTo(row::getTaskId)
                .set(TaskSqlDynamicSqlSupport.sqlType).equalTo(row::getSqlType)
                .set(TaskSqlDynamicSqlSupport.parseStatus).equalTo(row::getParseStatus)
                .set(TaskSqlDynamicSqlSupport.parseTime).equalTo(row::getParseTime)
                .set(TaskSqlDynamicSqlSupport.invalid).equalTo(row::getInvalid)
                .set(TaskSqlDynamicSqlSupport.sqlCode).equalTo(row::getSqlCode)
                .set(TaskSqlDynamicSqlSupport.parseLog).equalTo(row::getParseLog);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TaskSqlDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(TaskSqlDynamicSqlSupport.taskId).equalToWhenPresent(row::getTaskId)
                .set(TaskSqlDynamicSqlSupport.sqlType).equalToWhenPresent(row::getSqlType)
                .set(TaskSqlDynamicSqlSupport.parseStatus).equalToWhenPresent(row::getParseStatus)
                .set(TaskSqlDynamicSqlSupport.parseTime).equalToWhenPresent(row::getParseTime)
                .set(TaskSqlDynamicSqlSupport.invalid).equalToWhenPresent(row::getInvalid)
                .set(TaskSqlDynamicSqlSupport.sqlCode).equalToWhenPresent(row::getSqlCode)
                .set(TaskSqlDynamicSqlSupport.parseLog).equalToWhenPresent(row::getParseLog);
    }

    default int updateByPrimaryKey(TaskSqlDO row) {
        return update(c ->
            c.set(TaskSqlDynamicSqlSupport.taskId).equalTo(row::getTaskId)
            .set(TaskSqlDynamicSqlSupport.sqlType).equalTo(row::getSqlType)
            .set(TaskSqlDynamicSqlSupport.parseStatus).equalTo(row::getParseStatus)
            .set(TaskSqlDynamicSqlSupport.parseTime).equalTo(row::getParseTime)
            .set(TaskSqlDynamicSqlSupport.invalid).equalTo(row::getInvalid)
            .set(TaskSqlDynamicSqlSupport.sqlCode).equalTo(row::getSqlCode)
            .set(TaskSqlDynamicSqlSupport.parseLog).equalTo(row::getParseLog)
            .where(TaskSqlDynamicSqlSupport.sqlId, isEqualTo(row::getSqlId))
        );
    }

    default int updateByPrimaryKeySelective(TaskSqlDO row) {
        return update(c ->
            c.set(TaskSqlDynamicSqlSupport.taskId).equalToWhenPresent(row::getTaskId)
            .set(TaskSqlDynamicSqlSupport.sqlType).equalToWhenPresent(row::getSqlType)
            .set(TaskSqlDynamicSqlSupport.parseStatus).equalToWhenPresent(row::getParseStatus)
            .set(TaskSqlDynamicSqlSupport.parseTime).equalToWhenPresent(row::getParseTime)
            .set(TaskSqlDynamicSqlSupport.invalid).equalToWhenPresent(row::getInvalid)
            .set(TaskSqlDynamicSqlSupport.sqlCode).equalToWhenPresent(row::getSqlCode)
            .set(TaskSqlDynamicSqlSupport.parseLog).equalToWhenPresent(row::getParseLog)
            .where(TaskSqlDynamicSqlSupport.sqlId, isEqualTo(row::getSqlId))
        );
    }
}