package com.lineage.server.infrastructure.persistence.mapper;

import static com.lineage.server.infrastructure.persistence.mapper.PluginDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.lineage.server.infrastructure.persistence.model.PluginDO;
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
public interface PluginMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PluginDO>, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(pluginId, pluginName, descr, createUserId, modifyUserId, ctime, mtime, invalid);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PluginDOResult", value = {
        @Result(column="plugin_id", property="pluginId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="plugin_name", property="pluginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="descr", property="descr", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_user_id", property="modifyUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.BIGINT),
        @Result(column="mtime", property="mtime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.INTEGER)
    })
    List<PluginDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PluginDOResult")
    Optional<PluginDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, plugin, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, plugin, completer);
    }

    default int deleteByPrimaryKey(Long pluginId_) {
        return delete(c -> 
            c.where(pluginId, isEqualTo(pluginId_))
        );
    }

    default int insert(PluginDO row) {
        return MyBatis3Utils.insert(this::insert, row, plugin, c ->
            c.map(pluginId).toProperty("pluginId")
            .map(pluginName).toProperty("pluginName")
            .map(descr).toProperty("descr")
            .map(createUserId).toProperty("createUserId")
            .map(modifyUserId).toProperty("modifyUserId")
            .map(ctime).toProperty("ctime")
            .map(mtime).toProperty("mtime")
            .map(invalid).toProperty("invalid")
        );
    }

    default int insertMultiple(Collection<PluginDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, plugin, c ->
            c.map(pluginId).toProperty("pluginId")
            .map(pluginName).toProperty("pluginName")
            .map(descr).toProperty("descr")
            .map(createUserId).toProperty("createUserId")
            .map(modifyUserId).toProperty("modifyUserId")
            .map(ctime).toProperty("ctime")
            .map(mtime).toProperty("mtime")
            .map(invalid).toProperty("invalid")
        );
    }

    default int insertSelective(PluginDO row) {
        return MyBatis3Utils.insert(this::insert, row, plugin, c ->
            c.map(pluginId).toPropertyWhenPresent("pluginId", row::getPluginId)
            .map(pluginName).toPropertyWhenPresent("pluginName", row::getPluginName)
            .map(descr).toPropertyWhenPresent("descr", row::getDescr)
            .map(createUserId).toPropertyWhenPresent("createUserId", row::getCreateUserId)
            .map(modifyUserId).toPropertyWhenPresent("modifyUserId", row::getModifyUserId)
            .map(ctime).toPropertyWhenPresent("ctime", row::getCtime)
            .map(mtime).toPropertyWhenPresent("mtime", row::getMtime)
            .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
        );
    }

    default Optional<PluginDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, plugin, completer);
    }

    default List<PluginDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, plugin, completer);
    }

    default List<PluginDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, plugin, completer);
    }

    default Optional<PluginDO> selectByPrimaryKey(Long pluginId_) {
        return selectOne(c ->
            c.where(pluginId, isEqualTo(pluginId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, plugin, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(PluginDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pluginId).equalTo(row::getPluginId)
                .set(pluginName).equalTo(row::getPluginName)
                .set(descr).equalTo(row::getDescr)
                .set(createUserId).equalTo(row::getCreateUserId)
                .set(modifyUserId).equalTo(row::getModifyUserId)
                .set(ctime).equalTo(row::getCtime)
                .set(mtime).equalTo(row::getMtime)
                .set(invalid).equalTo(row::getInvalid);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(PluginDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pluginId).equalToWhenPresent(row::getPluginId)
                .set(pluginName).equalToWhenPresent(row::getPluginName)
                .set(descr).equalToWhenPresent(row::getDescr)
                .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                .set(ctime).equalToWhenPresent(row::getCtime)
                .set(mtime).equalToWhenPresent(row::getMtime)
                .set(invalid).equalToWhenPresent(row::getInvalid);
    }

    default int updateByPrimaryKey(PluginDO row) {
        return update(c ->
            c.set(pluginName).equalTo(row::getPluginName)
            .set(descr).equalTo(row::getDescr)
            .set(createUserId).equalTo(row::getCreateUserId)
            .set(modifyUserId).equalTo(row::getModifyUserId)
            .set(ctime).equalTo(row::getCtime)
            .set(mtime).equalTo(row::getMtime)
            .set(invalid).equalTo(row::getInvalid)
            .where(pluginId, isEqualTo(row::getPluginId))
        );
    }

    default int updateByPrimaryKeySelective(PluginDO row) {
        return update(c ->
            c.set(pluginName).equalToWhenPresent(row::getPluginName)
            .set(descr).equalToWhenPresent(row::getDescr)
            .set(createUserId).equalToWhenPresent(row::getCreateUserId)
            .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
            .set(ctime).equalToWhenPresent(row::getCtime)
            .set(mtime).equalToWhenPresent(row::getMtime)
            .set(invalid).equalToWhenPresent(row::getInvalid)
            .where(pluginId, isEqualTo(row::getPluginId))
        );
    }
}