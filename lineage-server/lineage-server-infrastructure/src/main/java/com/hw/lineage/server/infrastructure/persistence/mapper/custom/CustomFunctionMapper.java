package com.hw.lineage.server.infrastructure.persistence.mapper.custom;

import com.hw.lineage.server.domain.query.function.FunctionEntry;
import com.hw.lineage.server.domain.query.function.dto.FunctionTaskDTO;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.LongListTypeHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;
import java.util.Optional;

/**
 * @description: CustomFunctionMapper
 * @author: HamaWhite
 */
@Mapper
public interface CustomFunctionMapper {

    String SQL_IDS = "sql_ids";

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "FunctionEntryResult", value = {
            @Result(column = "plugin_code", property = "pluginCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "catalog_name", property = "catalogName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "database", property = "database", jdbcType = JdbcType.VARCHAR),
            @Result(column = "function_id", property = "functionId", jdbcType = JdbcType.BIGINT),
            @Result(column = "function_name", property = "functionName", jdbcType = JdbcType.VARCHAR)
    })
    Optional<FunctionEntry> selectOne(SelectStatementProvider selectStatement);


    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "FunctionTaskResult", value = {
            @Result(column = "task_id", property = "taskId", jdbcType = JdbcType.BIGINT),
            @Result(column = "task_name", property = "taskName", jdbcType = JdbcType.VARCHAR),
            @Result(column = SQL_IDS, property = "sqlIdList", typeHandler = LongListTypeHandler.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
    })
    List<FunctionTaskDTO> selectMany(SelectStatementProvider selectStatement);
}
