/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.infrastructure.persistence.mapper;

import static com.hw.lineage.server.infrastructure.persistence.mapper.TableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.hw.lineage.server.infrastructure.persistence.dos.TableDO;
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
public interface TableMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(tableId, catalogId, database, tableName, descr, createUserId, modifyUserId, createTime, modifyTime, invalid, ddl);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.tableId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<TableDO> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TableDOResult", value = {
        @Result(column="table_id", property="tableId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="catalog_id", property="catalogId", jdbcType=JdbcType.BIGINT),
        @Result(column="database", property="database", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="descr", property="descr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_user_id", property="modifyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT),
        @Result(column="ddl", property="ddl", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TableDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TableDOResult")
    Optional<TableDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, table, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, table, completer);
    }

    default int deleteByPrimaryKey(Long tableId_) {
        return delete(c -> 
            c.where(tableId, isEqualTo(tableId_))
        );
    }

    default int insert(TableDO row) {
        return MyBatis3Utils.insert(this::insert, row, table, c ->
            c.map(catalogId).toProperty("catalogId")
            .map(database).toProperty("database")
            .map(tableName).toProperty("tableName")
            .map(descr).toProperty("descr")
            .map(createUserId).toProperty("createUserId")
            .map(modifyUserId).toProperty("modifyUserId")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
            .map(invalid).toProperty("invalid")
            .map(ddl).toProperty("ddl")
        );
    }

    default int insertSelective(TableDO row) {
        return MyBatis3Utils.insert(this::insert, row, table, c ->
            c.map(catalogId).toPropertyWhenPresent("catalogId", row::getCatalogId)
            .map(database).toPropertyWhenPresent("database", row::getDatabase)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(descr).toPropertyWhenPresent("descr", row::getDescr)
            .map(createUserId).toPropertyWhenPresent("createUserId", row::getCreateUserId)
            .map(modifyUserId).toPropertyWhenPresent("modifyUserId", row::getModifyUserId)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(modifyTime).toPropertyWhenPresent("modifyTime", row::getModifyTime)
            .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
            .map(ddl).toPropertyWhenPresent("ddl", row::getDdl)
        );
    }

    default Optional<TableDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, table, completer);
    }

    default List<TableDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, table, completer);
    }

    default List<TableDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, table, completer);
    }

    default Optional<TableDO> selectByPrimaryKey(Long tableId_) {
        return selectOne(c ->
            c.where(tableId, isEqualTo(tableId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, table, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TableDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(catalogId).equalTo(row::getCatalogId)
                .set(database).equalTo(row::getDatabase)
                .set(tableName).equalTo(row::getTableName)
                .set(descr).equalTo(row::getDescr)
                .set(createUserId).equalTo(row::getCreateUserId)
                .set(modifyUserId).equalTo(row::getModifyUserId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(modifyTime).equalTo(row::getModifyTime)
                .set(invalid).equalTo(row::getInvalid)
                .set(ddl).equalTo(row::getDdl);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TableDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(catalogId).equalToWhenPresent(row::getCatalogId)
                .set(database).equalToWhenPresent(row::getDatabase)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(descr).equalToWhenPresent(row::getDescr)
                .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(modifyTime).equalToWhenPresent(row::getModifyTime)
                .set(invalid).equalToWhenPresent(row::getInvalid)
                .set(ddl).equalToWhenPresent(row::getDdl);
    }

    default int updateByPrimaryKey(TableDO row) {
        return update(c ->
            c.set(catalogId).equalTo(row::getCatalogId)
            .set(database).equalTo(row::getDatabase)
            .set(tableName).equalTo(row::getTableName)
            .set(descr).equalTo(row::getDescr)
            .set(createUserId).equalTo(row::getCreateUserId)
            .set(modifyUserId).equalTo(row::getModifyUserId)
            .set(createTime).equalTo(row::getCreateTime)
            .set(modifyTime).equalTo(row::getModifyTime)
            .set(invalid).equalTo(row::getInvalid)
            .set(ddl).equalTo(row::getDdl)
            .where(tableId, isEqualTo(row::getTableId))
        );
    }

    default int updateByPrimaryKeySelective(TableDO row) {
        return update(c ->
            c.set(catalogId).equalToWhenPresent(row::getCatalogId)
            .set(database).equalToWhenPresent(row::getDatabase)
            .set(tableName).equalToWhenPresent(row::getTableName)
            .set(descr).equalToWhenPresent(row::getDescr)
            .set(createUserId).equalToWhenPresent(row::getCreateUserId)
            .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(modifyTime).equalToWhenPresent(row::getModifyTime)
            .set(invalid).equalToWhenPresent(row::getInvalid)
            .set(ddl).equalToWhenPresent(row::getDdl)
            .where(tableId, isEqualTo(row::getTableId))
        );
    }
}