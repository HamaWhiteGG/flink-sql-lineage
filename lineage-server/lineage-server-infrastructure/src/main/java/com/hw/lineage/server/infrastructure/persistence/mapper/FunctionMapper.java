package com.hw.lineage.server.infrastructure.persistence.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.hw.lineage.server.infrastructure.persistence.dos.FunctionDO;
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
public interface FunctionMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(FunctionDynamicSqlSupport.functionId, FunctionDynamicSqlSupport.functionName, FunctionDynamicSqlSupport.functionFormat, FunctionDynamicSqlSupport.functionPath, FunctionDynamicSqlSupport.functionClass, FunctionDynamicSqlSupport.descr, FunctionDynamicSqlSupport.createUserId, FunctionDynamicSqlSupport.modifyUserId, FunctionDynamicSqlSupport.createTime, FunctionDynamicSqlSupport.modifyTime, FunctionDynamicSqlSupport.invalid);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.functionId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<FunctionDO> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FunctionDOResult", value = {
        @Result(column="function_id", property="functionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="function_name", property="functionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="function_format", property="functionFormat", jdbcType=JdbcType.VARCHAR),
        @Result(column="function_path", property="functionPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="function_class", property="functionClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="descr", property="descr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_user_id", property="modifyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT)
    })
    List<FunctionDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FunctionDOResult")
    Optional<FunctionDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, FunctionDynamicSqlSupport.function, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, FunctionDynamicSqlSupport.function, completer);
    }

    default int deleteByPrimaryKey(Long functionId_) {
        return delete(c -> 
            c.where(FunctionDynamicSqlSupport.functionId, isEqualTo(functionId_))
        );
    }

    default int insert(FunctionDO row) {
        return MyBatis3Utils.insert(this::insert, row, FunctionDynamicSqlSupport.function, c ->
            c.map(FunctionDynamicSqlSupport.functionName).toProperty("functionName")
            .map(FunctionDynamicSqlSupport.functionFormat).toProperty("functionFormat")
            .map(FunctionDynamicSqlSupport.functionPath).toProperty("functionPath")
            .map(FunctionDynamicSqlSupport.functionClass).toProperty("functionClass")
            .map(FunctionDynamicSqlSupport.descr).toProperty("descr")
            .map(FunctionDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(FunctionDynamicSqlSupport.modifyUserId).toProperty("modifyUserId")
            .map(FunctionDynamicSqlSupport.createTime).toProperty("createTime")
            .map(FunctionDynamicSqlSupport.modifyTime).toProperty("modifyTime")
            .map(FunctionDynamicSqlSupport.invalid).toProperty("invalid")
        );
    }

    default int insertSelective(FunctionDO row) {
        return MyBatis3Utils.insert(this::insert, row, FunctionDynamicSqlSupport.function, c ->
            c.map(FunctionDynamicSqlSupport.functionName).toPropertyWhenPresent("functionName", row::getFunctionName)
            .map(FunctionDynamicSqlSupport.functionFormat).toPropertyWhenPresent("functionFormat", row::getFunctionFormat)
            .map(FunctionDynamicSqlSupport.functionPath).toPropertyWhenPresent("functionPath", row::getFunctionPath)
            .map(FunctionDynamicSqlSupport.functionClass).toPropertyWhenPresent("functionClass", row::getFunctionClass)
            .map(FunctionDynamicSqlSupport.descr).toPropertyWhenPresent("descr", row::getDescr)
            .map(FunctionDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", row::getCreateUserId)
            .map(FunctionDynamicSqlSupport.modifyUserId).toPropertyWhenPresent("modifyUserId", row::getModifyUserId)
            .map(FunctionDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(FunctionDynamicSqlSupport.modifyTime).toPropertyWhenPresent("modifyTime", row::getModifyTime)
            .map(FunctionDynamicSqlSupport.invalid).toPropertyWhenPresent("invalid", row::getInvalid)
        );
    }

    default Optional<FunctionDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, FunctionDynamicSqlSupport.function, completer);
    }

    default List<FunctionDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, FunctionDynamicSqlSupport.function, completer);
    }

    default List<FunctionDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, FunctionDynamicSqlSupport.function, completer);
    }

    default Optional<FunctionDO> selectByPrimaryKey(Long functionId_) {
        return selectOne(c ->
            c.where(FunctionDynamicSqlSupport.functionId, isEqualTo(functionId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, FunctionDynamicSqlSupport.function, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(FunctionDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(FunctionDynamicSqlSupport.functionName).equalTo(row::getFunctionName)
                .set(FunctionDynamicSqlSupport.functionFormat).equalTo(row::getFunctionFormat)
                .set(FunctionDynamicSqlSupport.functionPath).equalTo(row::getFunctionPath)
                .set(FunctionDynamicSqlSupport.functionClass).equalTo(row::getFunctionClass)
                .set(FunctionDynamicSqlSupport.descr).equalTo(row::getDescr)
                .set(FunctionDynamicSqlSupport.createUserId).equalTo(row::getCreateUserId)
                .set(FunctionDynamicSqlSupport.modifyUserId).equalTo(row::getModifyUserId)
                .set(FunctionDynamicSqlSupport.createTime).equalTo(row::getCreateTime)
                .set(FunctionDynamicSqlSupport.modifyTime).equalTo(row::getModifyTime)
                .set(FunctionDynamicSqlSupport.invalid).equalTo(row::getInvalid);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(FunctionDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(FunctionDynamicSqlSupport.functionName).equalToWhenPresent(row::getFunctionName)
                .set(FunctionDynamicSqlSupport.functionFormat).equalToWhenPresent(row::getFunctionFormat)
                .set(FunctionDynamicSqlSupport.functionPath).equalToWhenPresent(row::getFunctionPath)
                .set(FunctionDynamicSqlSupport.functionClass).equalToWhenPresent(row::getFunctionClass)
                .set(FunctionDynamicSqlSupport.descr).equalToWhenPresent(row::getDescr)
                .set(FunctionDynamicSqlSupport.createUserId).equalToWhenPresent(row::getCreateUserId)
                .set(FunctionDynamicSqlSupport.modifyUserId).equalToWhenPresent(row::getModifyUserId)
                .set(FunctionDynamicSqlSupport.createTime).equalToWhenPresent(row::getCreateTime)
                .set(FunctionDynamicSqlSupport.modifyTime).equalToWhenPresent(row::getModifyTime)
                .set(FunctionDynamicSqlSupport.invalid).equalToWhenPresent(row::getInvalid);
    }

    default int updateByPrimaryKey(FunctionDO row) {
        return update(c ->
            c.set(FunctionDynamicSqlSupport.functionName).equalTo(row::getFunctionName)
            .set(FunctionDynamicSqlSupport.functionFormat).equalTo(row::getFunctionFormat)
            .set(FunctionDynamicSqlSupport.functionPath).equalTo(row::getFunctionPath)
            .set(FunctionDynamicSqlSupport.functionClass).equalTo(row::getFunctionClass)
            .set(FunctionDynamicSqlSupport.descr).equalTo(row::getDescr)
            .set(FunctionDynamicSqlSupport.createUserId).equalTo(row::getCreateUserId)
            .set(FunctionDynamicSqlSupport.modifyUserId).equalTo(row::getModifyUserId)
            .set(FunctionDynamicSqlSupport.createTime).equalTo(row::getCreateTime)
            .set(FunctionDynamicSqlSupport.modifyTime).equalTo(row::getModifyTime)
            .set(FunctionDynamicSqlSupport.invalid).equalTo(row::getInvalid)
            .where(FunctionDynamicSqlSupport.functionId, isEqualTo(row::getFunctionId))
        );
    }

    default int updateByPrimaryKeySelective(FunctionDO row) {
        return update(c ->
            c.set(FunctionDynamicSqlSupport.functionName).equalToWhenPresent(row::getFunctionName)
            .set(FunctionDynamicSqlSupport.functionFormat).equalToWhenPresent(row::getFunctionFormat)
            .set(FunctionDynamicSqlSupport.functionPath).equalToWhenPresent(row::getFunctionPath)
            .set(FunctionDynamicSqlSupport.functionClass).equalToWhenPresent(row::getFunctionClass)
            .set(FunctionDynamicSqlSupport.descr).equalToWhenPresent(row::getDescr)
            .set(FunctionDynamicSqlSupport.createUserId).equalToWhenPresent(row::getCreateUserId)
            .set(FunctionDynamicSqlSupport.modifyUserId).equalToWhenPresent(row::getModifyUserId)
            .set(FunctionDynamicSqlSupport.createTime).equalToWhenPresent(row::getCreateTime)
            .set(FunctionDynamicSqlSupport.modifyTime).equalToWhenPresent(row::getModifyTime)
            .set(FunctionDynamicSqlSupport.invalid).equalToWhenPresent(row::getInvalid)
            .where(FunctionDynamicSqlSupport.functionId, isEqualTo(row::getFunctionId))
        );
    }
}