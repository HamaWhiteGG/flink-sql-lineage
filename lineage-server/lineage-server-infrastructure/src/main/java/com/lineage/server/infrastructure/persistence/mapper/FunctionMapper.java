package com.lineage.server.infrastructure.persistence.mapper;

import com.lineage.server.infrastructure.persistence.dos.FunctionDO;
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

import static com.lineage.server.infrastructure.persistence.mapper.FunctionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface FunctionMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(functionId, functionName, functionFormat, functionPath, functionClass, descr, createUserId, modifyUserId, createTime, modifyTime, invalid);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "row.functionId", before = false, resultType = Long.class)
    int insert(InsertStatementProvider<FunctionDO> insertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "FunctionDOResult", value = {
            @Result(column = "function_id", property = "functionId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "function_name", property = "functionName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "function_format", property = "functionFormat", jdbcType = JdbcType.VARCHAR),
            @Result(column = "function_path", property = "functionPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "function_class", property = "functionClass", jdbcType = JdbcType.VARCHAR),
            @Result(column = "descr", property = "descr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_user_id", property = "createUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "modify_user_id", property = "modifyUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "invalid", property = "invalid", jdbcType = JdbcType.BIT)
    })
    List<FunctionDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("FunctionDOResult")
    Optional<FunctionDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, function, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, function, completer);
    }

    default int deleteByPrimaryKey(Long functionId_) {
        return delete(c ->
                c.where(functionId, isEqualTo(functionId_))
        );
    }

    default int insert(FunctionDO row) {
        return MyBatis3Utils.insert(this::insert, row, function, c ->
                c.map(functionName).toProperty("functionName")
                        .map(functionFormat).toProperty("functionFormat")
                        .map(functionPath).toProperty("functionPath")
                        .map(functionClass).toProperty("functionClass")
                        .map(descr).toProperty("descr")
                        .map(createUserId).toProperty("createUserId")
                        .map(modifyUserId).toProperty("modifyUserId")
                        .map(createTime).toProperty("createTime")
                        .map(modifyTime).toProperty("modifyTime")
                        .map(invalid).toProperty("invalid")
        );
    }

    default int insertSelective(FunctionDO row) {
        return MyBatis3Utils.insert(this::insert, row, function, c ->
                c.map(functionName).toPropertyWhenPresent("functionName", row::getFunctionName)
                        .map(functionFormat).toPropertyWhenPresent("functionFormat", row::getFunctionFormat)
                        .map(functionPath).toPropertyWhenPresent("functionPath", row::getFunctionPath)
                        .map(functionClass).toPropertyWhenPresent("functionClass", row::getFunctionClass)
                        .map(descr).toPropertyWhenPresent("descr", row::getDescr)
                        .map(createUserId).toPropertyWhenPresent("createUserId", row::getCreateUserId)
                        .map(modifyUserId).toPropertyWhenPresent("modifyUserId", row::getModifyUserId)
                        .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
                        .map(modifyTime).toPropertyWhenPresent("modifyTime", row::getModifyTime)
                        .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
        );
    }

    default Optional<FunctionDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, function, completer);
    }

    default List<FunctionDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, function, completer);
    }

    default List<FunctionDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, function, completer);
    }

    default Optional<FunctionDO> selectByPrimaryKey(Long functionId_) {
        return selectOne(c ->
                c.where(functionId, isEqualTo(functionId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, function, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(FunctionDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(functionName).equalTo(row::getFunctionName)
                .set(functionFormat).equalTo(row::getFunctionFormat)
                .set(functionPath).equalTo(row::getFunctionPath)
                .set(functionClass).equalTo(row::getFunctionClass)
                .set(descr).equalTo(row::getDescr)
                .set(createUserId).equalTo(row::getCreateUserId)
                .set(modifyUserId).equalTo(row::getModifyUserId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(modifyTime).equalTo(row::getModifyTime)
                .set(invalid).equalTo(row::getInvalid);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(FunctionDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(functionName).equalToWhenPresent(row::getFunctionName)
                .set(functionFormat).equalToWhenPresent(row::getFunctionFormat)
                .set(functionPath).equalToWhenPresent(row::getFunctionPath)
                .set(functionClass).equalToWhenPresent(row::getFunctionClass)
                .set(descr).equalToWhenPresent(row::getDescr)
                .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(modifyTime).equalToWhenPresent(row::getModifyTime)
                .set(invalid).equalToWhenPresent(row::getInvalid);
    }

    default int updateByPrimaryKey(FunctionDO row) {
        return update(c ->
                c.set(functionName).equalTo(row::getFunctionName)
                        .set(functionFormat).equalTo(row::getFunctionFormat)
                        .set(functionPath).equalTo(row::getFunctionPath)
                        .set(functionClass).equalTo(row::getFunctionClass)
                        .set(descr).equalTo(row::getDescr)
                        .set(createUserId).equalTo(row::getCreateUserId)
                        .set(modifyUserId).equalTo(row::getModifyUserId)
                        .set(createTime).equalTo(row::getCreateTime)
                        .set(modifyTime).equalTo(row::getModifyTime)
                        .set(invalid).equalTo(row::getInvalid)
                        .where(functionId, isEqualTo(row::getFunctionId))
        );
    }

    default int updateByPrimaryKeySelective(FunctionDO row) {
        return update(c ->
                c.set(functionName).equalToWhenPresent(row::getFunctionName)
                        .set(functionFormat).equalToWhenPresent(row::getFunctionFormat)
                        .set(functionPath).equalToWhenPresent(row::getFunctionPath)
                        .set(functionClass).equalToWhenPresent(row::getFunctionClass)
                        .set(descr).equalToWhenPresent(row::getDescr)
                        .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                        .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                        .set(createTime).equalToWhenPresent(row::getCreateTime)
                        .set(modifyTime).equalToWhenPresent(row::getModifyTime)
                        .set(invalid).equalToWhenPresent(row::getInvalid)
                        .where(functionId, isEqualTo(row::getFunctionId))
        );
    }
}