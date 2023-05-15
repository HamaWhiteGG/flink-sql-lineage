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

import static com.hw.lineage.server.infrastructure.persistence.mapper.AuditDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.hw.lineage.server.infrastructure.persistence.dos.AuditDO;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.JsonTypeHandler;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.ModuleCodeHandler;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.OperationStatusTypeHandler;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.OperationTypeHandler;
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
public interface AuditMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(auditId, userId, username, moduleCode, operationType, descr, duration, operationStatus, method, ip, createTime, invalid, parameters, exception);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="row.auditId", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<AuditDO> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AuditDOResult", value = {
        @Result(column="audit_id", property="auditId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_code", property="moduleCode", typeHandler=ModuleCodeHandler.class, jdbcType=JdbcType.VARCHAR),
        @Result(column="operation_type", property="operationType", typeHandler=OperationTypeHandler.class, jdbcType=JdbcType.VARCHAR),
        @Result(column="descr", property="descr", jdbcType=JdbcType.VARCHAR),
        @Result(column="duration", property="duration", jdbcType=JdbcType.BIGINT),
        @Result(column="operation_status", property="operationStatus", typeHandler=OperationStatusTypeHandler.class, jdbcType=JdbcType.TINYINT),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT),
        @Result(column="parameters", property="parameters", typeHandler=JsonTypeHandler.class, jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="exception", property="exception", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AuditDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AuditDOResult")
    Optional<AuditDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, audit, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, audit, completer);
    }

    default int deleteByPrimaryKey(Long auditId_) {
        return delete(c -> 
            c.where(auditId, isEqualTo(auditId_))
        );
    }

    default int insert(AuditDO row) {
        return MyBatis3Utils.insert(this::insert, row, audit, c ->
            c.map(userId).toProperty("userId")
            .map(username).toProperty("username")
            .map(moduleCode).toProperty("moduleCode")
            .map(operationType).toProperty("operationType")
            .map(descr).toProperty("descr")
            .map(duration).toProperty("duration")
            .map(operationStatus).toProperty("operationStatus")
            .map(method).toProperty("method")
            .map(ip).toProperty("ip")
            .map(createTime).toProperty("createTime")
            .map(invalid).toProperty("invalid")
            .map(parameters).toProperty("parameters")
            .map(exception).toProperty("exception")
        );
    }

    default int insertSelective(AuditDO row) {
        return MyBatis3Utils.insert(this::insert, row, audit, c ->
            c.map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(username).toPropertyWhenPresent("username", row::getUsername)
            .map(moduleCode).toPropertyWhenPresent("moduleCode", row::getModuleCode)
            .map(operationType).toPropertyWhenPresent("operationType", row::getOperationType)
            .map(descr).toPropertyWhenPresent("descr", row::getDescr)
            .map(duration).toPropertyWhenPresent("duration", row::getDuration)
            .map(operationStatus).toPropertyWhenPresent("operationStatus", row::getOperationStatus)
            .map(method).toPropertyWhenPresent("method", row::getMethod)
            .map(ip).toPropertyWhenPresent("ip", row::getIp)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
            .map(parameters).toPropertyWhenPresent("parameters", row::getParameters)
            .map(exception).toPropertyWhenPresent("exception", row::getException)
        );
    }

    default Optional<AuditDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, audit, completer);
    }

    default List<AuditDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, audit, completer);
    }

    default List<AuditDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, audit, completer);
    }

    default Optional<AuditDO> selectByPrimaryKey(Long auditId_) {
        return selectOne(c ->
            c.where(auditId, isEqualTo(auditId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, audit, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(AuditDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(row::getUserId)
                .set(username).equalTo(row::getUsername)
                .set(moduleCode).equalTo(row::getModuleCode)
                .set(operationType).equalTo(row::getOperationType)
                .set(descr).equalTo(row::getDescr)
                .set(duration).equalTo(row::getDuration)
                .set(operationStatus).equalTo(row::getOperationStatus)
                .set(method).equalTo(row::getMethod)
                .set(ip).equalTo(row::getIp)
                .set(createTime).equalTo(row::getCreateTime)
                .set(invalid).equalTo(row::getInvalid)
                .set(parameters).equalTo(row::getParameters)
                .set(exception).equalTo(row::getException);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(AuditDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(row::getUserId)
                .set(username).equalToWhenPresent(row::getUsername)
                .set(moduleCode).equalToWhenPresent(row::getModuleCode)
                .set(operationType).equalToWhenPresent(row::getOperationType)
                .set(descr).equalToWhenPresent(row::getDescr)
                .set(duration).equalToWhenPresent(row::getDuration)
                .set(operationStatus).equalToWhenPresent(row::getOperationStatus)
                .set(method).equalToWhenPresent(row::getMethod)
                .set(ip).equalToWhenPresent(row::getIp)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(invalid).equalToWhenPresent(row::getInvalid)
                .set(parameters).equalToWhenPresent(row::getParameters)
                .set(exception).equalToWhenPresent(row::getException);
    }

    default int updateByPrimaryKey(AuditDO row) {
        return update(c ->
            c.set(userId).equalTo(row::getUserId)
            .set(username).equalTo(row::getUsername)
            .set(moduleCode).equalTo(row::getModuleCode)
            .set(operationType).equalTo(row::getOperationType)
            .set(descr).equalTo(row::getDescr)
            .set(duration).equalTo(row::getDuration)
            .set(operationStatus).equalTo(row::getOperationStatus)
            .set(method).equalTo(row::getMethod)
            .set(ip).equalTo(row::getIp)
            .set(createTime).equalTo(row::getCreateTime)
            .set(invalid).equalTo(row::getInvalid)
            .set(parameters).equalTo(row::getParameters)
            .set(exception).equalTo(row::getException)
            .where(auditId, isEqualTo(row::getAuditId))
        );
    }

    default int updateByPrimaryKeySelective(AuditDO row) {
        return update(c ->
            c.set(userId).equalToWhenPresent(row::getUserId)
            .set(username).equalToWhenPresent(row::getUsername)
            .set(moduleCode).equalToWhenPresent(row::getModuleCode)
            .set(operationType).equalToWhenPresent(row::getOperationType)
            .set(descr).equalToWhenPresent(row::getDescr)
            .set(duration).equalToWhenPresent(row::getDuration)
            .set(operationStatus).equalToWhenPresent(row::getOperationStatus)
            .set(method).equalToWhenPresent(row::getMethod)
            .set(ip).equalToWhenPresent(row::getIp)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(invalid).equalToWhenPresent(row::getInvalid)
            .set(parameters).equalToWhenPresent(row::getParameters)
            .set(exception).equalToWhenPresent(row::getException)
            .where(auditId, isEqualTo(row::getAuditId))
        );
    }
}