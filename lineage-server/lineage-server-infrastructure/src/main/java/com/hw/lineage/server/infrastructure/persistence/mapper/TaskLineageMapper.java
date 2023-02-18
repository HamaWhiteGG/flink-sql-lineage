package com.hw.lineage.server.infrastructure.persistence.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.hw.lineage.server.infrastructure.persistence.dos.TaskLineageDO;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
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
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TaskLineageMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TaskLineageDO>, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(TaskLineageDynamicSqlSupport.rid, TaskLineageDynamicSqlSupport.taskId, TaskLineageDynamicSqlSupport.sqlId, TaskLineageDynamicSqlSupport.sourceCatalog, TaskLineageDynamicSqlSupport.sourceDatabase, TaskLineageDynamicSqlSupport.sourceTable, TaskLineageDynamicSqlSupport.sourceColumn, TaskLineageDynamicSqlSupport.targetCatalog, TaskLineageDynamicSqlSupport.targetDatabase, TaskLineageDynamicSqlSupport.targetTable, TaskLineageDynamicSqlSupport.targetColumn, TaskLineageDynamicSqlSupport.transform, TaskLineageDynamicSqlSupport.invalid);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TaskLineageDOResult", value = {
        @Result(column="rid", property="rid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="sql_id", property="sqlId", jdbcType=JdbcType.INTEGER),
        @Result(column="source_catalog", property="sourceCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_database", property="sourceDatabase", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_table", property="sourceTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_column", property="sourceColumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_catalog", property="targetCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_database", property="targetDatabase", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_table", property="targetTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_column", property="targetColumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="transform", property="transform", jdbcType=JdbcType.VARCHAR),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT)
    })
    List<TaskLineageDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TaskLineageDOResult")
    Optional<TaskLineageDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, TaskLineageDynamicSqlSupport.taskLineage, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, TaskLineageDynamicSqlSupport.taskLineage, completer);
    }

    default int deleteByPrimaryKey(Long rid_) {
        return delete(c -> 
            c.where(TaskLineageDynamicSqlSupport.rid, isEqualTo(rid_))
        );
    }

    default int insert(TaskLineageDO row) {
        return MyBatis3Utils.insert(this::insert, row, TaskLineageDynamicSqlSupport.taskLineage, c ->
            c.map(TaskLineageDynamicSqlSupport.rid).toProperty("rid")
            .map(TaskLineageDynamicSqlSupport.taskId).toProperty("taskId")
            .map(TaskLineageDynamicSqlSupport.sqlId).toProperty("sqlId")
            .map(TaskLineageDynamicSqlSupport.sourceCatalog).toProperty("sourceCatalog")
            .map(TaskLineageDynamicSqlSupport.sourceDatabase).toProperty("sourceDatabase")
            .map(TaskLineageDynamicSqlSupport.sourceTable).toProperty("sourceTable")
            .map(TaskLineageDynamicSqlSupport.sourceColumn).toProperty("sourceColumn")
            .map(TaskLineageDynamicSqlSupport.targetCatalog).toProperty("targetCatalog")
            .map(TaskLineageDynamicSqlSupport.targetDatabase).toProperty("targetDatabase")
            .map(TaskLineageDynamicSqlSupport.targetTable).toProperty("targetTable")
            .map(TaskLineageDynamicSqlSupport.targetColumn).toProperty("targetColumn")
            .map(TaskLineageDynamicSqlSupport.transform).toProperty("transform")
            .map(TaskLineageDynamicSqlSupport.invalid).toProperty("invalid")
        );
    }

    default int insertMultiple(Collection<TaskLineageDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, TaskLineageDynamicSqlSupport.taskLineage, c ->
            c.map(TaskLineageDynamicSqlSupport.rid).toProperty("rid")
            .map(TaskLineageDynamicSqlSupport.taskId).toProperty("taskId")
            .map(TaskLineageDynamicSqlSupport.sqlId).toProperty("sqlId")
            .map(TaskLineageDynamicSqlSupport.sourceCatalog).toProperty("sourceCatalog")
            .map(TaskLineageDynamicSqlSupport.sourceDatabase).toProperty("sourceDatabase")
            .map(TaskLineageDynamicSqlSupport.sourceTable).toProperty("sourceTable")
            .map(TaskLineageDynamicSqlSupport.sourceColumn).toProperty("sourceColumn")
            .map(TaskLineageDynamicSqlSupport.targetCatalog).toProperty("targetCatalog")
            .map(TaskLineageDynamicSqlSupport.targetDatabase).toProperty("targetDatabase")
            .map(TaskLineageDynamicSqlSupport.targetTable).toProperty("targetTable")
            .map(TaskLineageDynamicSqlSupport.targetColumn).toProperty("targetColumn")
            .map(TaskLineageDynamicSqlSupport.transform).toProperty("transform")
            .map(TaskLineageDynamicSqlSupport.invalid).toProperty("invalid")
        );
    }

    default int insertSelective(TaskLineageDO row) {
        return MyBatis3Utils.insert(this::insert, row, TaskLineageDynamicSqlSupport.taskLineage, c ->
            c.map(TaskLineageDynamicSqlSupport.rid).toPropertyWhenPresent("rid", row::getRid)
            .map(TaskLineageDynamicSqlSupport.taskId).toPropertyWhenPresent("taskId", row::getTaskId)
            .map(TaskLineageDynamicSqlSupport.sqlId).toPropertyWhenPresent("sqlId", row::getSqlId)
            .map(TaskLineageDynamicSqlSupport.sourceCatalog).toPropertyWhenPresent("sourceCatalog", row::getSourceCatalog)
            .map(TaskLineageDynamicSqlSupport.sourceDatabase).toPropertyWhenPresent("sourceDatabase", row::getSourceDatabase)
            .map(TaskLineageDynamicSqlSupport.sourceTable).toPropertyWhenPresent("sourceTable", row::getSourceTable)
            .map(TaskLineageDynamicSqlSupport.sourceColumn).toPropertyWhenPresent("sourceColumn", row::getSourceColumn)
            .map(TaskLineageDynamicSqlSupport.targetCatalog).toPropertyWhenPresent("targetCatalog", row::getTargetCatalog)
            .map(TaskLineageDynamicSqlSupport.targetDatabase).toPropertyWhenPresent("targetDatabase", row::getTargetDatabase)
            .map(TaskLineageDynamicSqlSupport.targetTable).toPropertyWhenPresent("targetTable", row::getTargetTable)
            .map(TaskLineageDynamicSqlSupport.targetColumn).toPropertyWhenPresent("targetColumn", row::getTargetColumn)
            .map(TaskLineageDynamicSqlSupport.transform).toPropertyWhenPresent("transform", row::getTransform)
            .map(TaskLineageDynamicSqlSupport.invalid).toPropertyWhenPresent("invalid", row::getInvalid)
        );
    }

    default Optional<TaskLineageDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, TaskLineageDynamicSqlSupport.taskLineage, completer);
    }

    default List<TaskLineageDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, TaskLineageDynamicSqlSupport.taskLineage, completer);
    }

    default List<TaskLineageDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, TaskLineageDynamicSqlSupport.taskLineage, completer);
    }

    default Optional<TaskLineageDO> selectByPrimaryKey(Long rid_) {
        return selectOne(c ->
            c.where(TaskLineageDynamicSqlSupport.rid, isEqualTo(rid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, TaskLineageDynamicSqlSupport.taskLineage, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TaskLineageDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(TaskLineageDynamicSqlSupport.rid).equalTo(row::getRid)
                .set(TaskLineageDynamicSqlSupport.taskId).equalTo(row::getTaskId)
                .set(TaskLineageDynamicSqlSupport.sqlId).equalTo(row::getSqlId)
                .set(TaskLineageDynamicSqlSupport.sourceCatalog).equalTo(row::getSourceCatalog)
                .set(TaskLineageDynamicSqlSupport.sourceDatabase).equalTo(row::getSourceDatabase)
                .set(TaskLineageDynamicSqlSupport.sourceTable).equalTo(row::getSourceTable)
                .set(TaskLineageDynamicSqlSupport.sourceColumn).equalTo(row::getSourceColumn)
                .set(TaskLineageDynamicSqlSupport.targetCatalog).equalTo(row::getTargetCatalog)
                .set(TaskLineageDynamicSqlSupport.targetDatabase).equalTo(row::getTargetDatabase)
                .set(TaskLineageDynamicSqlSupport.targetTable).equalTo(row::getTargetTable)
                .set(TaskLineageDynamicSqlSupport.targetColumn).equalTo(row::getTargetColumn)
                .set(TaskLineageDynamicSqlSupport.transform).equalTo(row::getTransform)
                .set(TaskLineageDynamicSqlSupport.invalid).equalTo(row::getInvalid);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TaskLineageDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(TaskLineageDynamicSqlSupport.rid).equalToWhenPresent(row::getRid)
                .set(TaskLineageDynamicSqlSupport.taskId).equalToWhenPresent(row::getTaskId)
                .set(TaskLineageDynamicSqlSupport.sqlId).equalToWhenPresent(row::getSqlId)
                .set(TaskLineageDynamicSqlSupport.sourceCatalog).equalToWhenPresent(row::getSourceCatalog)
                .set(TaskLineageDynamicSqlSupport.sourceDatabase).equalToWhenPresent(row::getSourceDatabase)
                .set(TaskLineageDynamicSqlSupport.sourceTable).equalToWhenPresent(row::getSourceTable)
                .set(TaskLineageDynamicSqlSupport.sourceColumn).equalToWhenPresent(row::getSourceColumn)
                .set(TaskLineageDynamicSqlSupport.targetCatalog).equalToWhenPresent(row::getTargetCatalog)
                .set(TaskLineageDynamicSqlSupport.targetDatabase).equalToWhenPresent(row::getTargetDatabase)
                .set(TaskLineageDynamicSqlSupport.targetTable).equalToWhenPresent(row::getTargetTable)
                .set(TaskLineageDynamicSqlSupport.targetColumn).equalToWhenPresent(row::getTargetColumn)
                .set(TaskLineageDynamicSqlSupport.transform).equalToWhenPresent(row::getTransform)
                .set(TaskLineageDynamicSqlSupport.invalid).equalToWhenPresent(row::getInvalid);
    }

    default int updateByPrimaryKey(TaskLineageDO row) {
        return update(c ->
            c.set(TaskLineageDynamicSqlSupport.taskId).equalTo(row::getTaskId)
            .set(TaskLineageDynamicSqlSupport.sqlId).equalTo(row::getSqlId)
            .set(TaskLineageDynamicSqlSupport.sourceCatalog).equalTo(row::getSourceCatalog)
            .set(TaskLineageDynamicSqlSupport.sourceDatabase).equalTo(row::getSourceDatabase)
            .set(TaskLineageDynamicSqlSupport.sourceTable).equalTo(row::getSourceTable)
            .set(TaskLineageDynamicSqlSupport.sourceColumn).equalTo(row::getSourceColumn)
            .set(TaskLineageDynamicSqlSupport.targetCatalog).equalTo(row::getTargetCatalog)
            .set(TaskLineageDynamicSqlSupport.targetDatabase).equalTo(row::getTargetDatabase)
            .set(TaskLineageDynamicSqlSupport.targetTable).equalTo(row::getTargetTable)
            .set(TaskLineageDynamicSqlSupport.targetColumn).equalTo(row::getTargetColumn)
            .set(TaskLineageDynamicSqlSupport.transform).equalTo(row::getTransform)
            .set(TaskLineageDynamicSqlSupport.invalid).equalTo(row::getInvalid)
            .where(TaskLineageDynamicSqlSupport.rid, isEqualTo(row::getRid))
        );
    }

    default int updateByPrimaryKeySelective(TaskLineageDO row) {
        return update(c ->
            c.set(TaskLineageDynamicSqlSupport.taskId).equalToWhenPresent(row::getTaskId)
            .set(TaskLineageDynamicSqlSupport.sqlId).equalToWhenPresent(row::getSqlId)
            .set(TaskLineageDynamicSqlSupport.sourceCatalog).equalToWhenPresent(row::getSourceCatalog)
            .set(TaskLineageDynamicSqlSupport.sourceDatabase).equalToWhenPresent(row::getSourceDatabase)
            .set(TaskLineageDynamicSqlSupport.sourceTable).equalToWhenPresent(row::getSourceTable)
            .set(TaskLineageDynamicSqlSupport.sourceColumn).equalToWhenPresent(row::getSourceColumn)
            .set(TaskLineageDynamicSqlSupport.targetCatalog).equalToWhenPresent(row::getTargetCatalog)
            .set(TaskLineageDynamicSqlSupport.targetDatabase).equalToWhenPresent(row::getTargetDatabase)
            .set(TaskLineageDynamicSqlSupport.targetTable).equalToWhenPresent(row::getTargetTable)
            .set(TaskLineageDynamicSqlSupport.targetColumn).equalToWhenPresent(row::getTargetColumn)
            .set(TaskLineageDynamicSqlSupport.transform).equalToWhenPresent(row::getTransform)
            .set(TaskLineageDynamicSqlSupport.invalid).equalToWhenPresent(row::getInvalid)
            .where(TaskLineageDynamicSqlSupport.rid, isEqualTo(row::getRid))
        );
    }
}