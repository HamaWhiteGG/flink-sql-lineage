package com.hw.lineage.server.infrastructure.persistence.mapper;

import com.hw.lineage.server.infrastructure.persistence.dos.CatalogDO;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.PropertyListTypeHandler;
import com.hw.lineage.server.infrastructure.persistence.mybatis.handler.impl.CatalogTypeHandler;
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

import static com.hw.lineage.server.infrastructure.persistence.mapper.CatalogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CatalogMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    BasicColumn[] selectList = BasicColumn.columnList(catalogId, pluginId, catalogName, catalogType, defaultDatabase, descr, defaultCatalog, createUserId, modifyUserId, createTime, modifyTime, invalid, propertyList);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "row.catalogId", before = false, resultType = Long.class)
    int insert(InsertStatementProvider<CatalogDO> insertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "CatalogDOResult", value = {
            @Result(column = "catalog_id", property = "catalogId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "plugin_id", property = "pluginId", jdbcType = JdbcType.BIGINT),
            @Result(column = "catalog_name", property = "catalogName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "catalog_type", property = "catalogType", typeHandler = CatalogTypeHandler.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "default_database", property = "defaultDatabase", jdbcType = JdbcType.VARCHAR),
            @Result(column = "descr", property = "descr", jdbcType = JdbcType.VARCHAR),
            @Result(column = "default_catalog", property = "defaultCatalog", jdbcType = JdbcType.BIT),
            @Result(column = "create_user_id", property = "createUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "modify_user_id", property = "modifyUserId", jdbcType = JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.BIGINT),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.BIT),
            @Result(column = "properties", property = "propertyList", typeHandler = PropertyListTypeHandler.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    List<CatalogDO> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogDOResult")
    Optional<CatalogDO> selectOne(SelectStatementProvider selectStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalog, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalog, completer);
    }

    default int deleteByPrimaryKey(Long catalogId_) {
        return delete(c -> 
            c.where(catalogId, isEqualTo(catalogId_))
        );
    }

    default int insert(CatalogDO row) {
        return MyBatis3Utils.insert(this::insert, row, catalog, c ->
                c.map(pluginId).toProperty("pluginId")
                        .map(catalogName).toProperty("catalogName")
                        .map(catalogType).toProperty("catalogType")
                        .map(defaultDatabase).toProperty("defaultDatabase")
                        .map(descr).toProperty("descr")
                        .map(defaultCatalog).toProperty("defaultCatalog")
                        .map(createUserId).toProperty("createUserId")
                        .map(modifyUserId).toProperty("modifyUserId")
                        .map(createTime).toProperty("createTime")
                        .map(modifyTime).toProperty("modifyTime")
                        .map(invalid).toProperty("invalid")
                        .map(propertyList).toProperty("propertyList")
        );
    }

    default int insertSelective(CatalogDO row) {
        return MyBatis3Utils.insert(this::insert, row, catalog, c ->
                c.map(pluginId).toPropertyWhenPresent("pluginId", row::getPluginId)
                        .map(catalogName).toPropertyWhenPresent("catalogName", row::getCatalogName)
                        .map(catalogType).toPropertyWhenPresent("catalogType", row::getCatalogType)
                        .map(defaultDatabase).toPropertyWhenPresent("defaultDatabase", row::getDefaultDatabase)
                        .map(descr).toPropertyWhenPresent("descr", row::getDescr)
                        .map(defaultCatalog).toPropertyWhenPresent("defaultCatalog", row::getDefaultCatalog)
                        .map(createUserId).toPropertyWhenPresent("createUserId", row::getCreateUserId)
                        .map(modifyUserId).toPropertyWhenPresent("modifyUserId", row::getModifyUserId)
                        .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
                        .map(modifyTime).toPropertyWhenPresent("modifyTime", row::getModifyTime)
                        .map(invalid).toPropertyWhenPresent("invalid", row::getInvalid)
                        .map(propertyList).toPropertyWhenPresent("propertyList", row::getPropertyList)
        );
    }

    default Optional<CatalogDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalog, completer);
    }

    default List<CatalogDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalog, completer);
    }

    default List<CatalogDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalog, completer);
    }

    default Optional<CatalogDO> selectByPrimaryKey(Long catalogId_) {
        return selectOne(c ->
            c.where(catalogId, isEqualTo(catalogId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalog, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(CatalogDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pluginId).equalTo(row::getPluginId)
                .set(catalogName).equalTo(row::getCatalogName)
                .set(catalogType).equalTo(row::getCatalogType)
                .set(defaultDatabase).equalTo(row::getDefaultDatabase)
                .set(descr).equalTo(row::getDescr)
                .set(defaultCatalog).equalTo(row::getDefaultCatalog)
                .set(createUserId).equalTo(row::getCreateUserId)
                .set(modifyUserId).equalTo(row::getModifyUserId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(modifyTime).equalTo(row::getModifyTime)
                .set(invalid).equalTo(row::getInvalid)
                .set(propertyList).equalTo(row::getPropertyList);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pluginId).equalToWhenPresent(row::getPluginId)
                .set(catalogName).equalToWhenPresent(row::getCatalogName)
                .set(catalogType).equalToWhenPresent(row::getCatalogType)
                .set(defaultDatabase).equalToWhenPresent(row::getDefaultDatabase)
                .set(descr).equalToWhenPresent(row::getDescr)
                .set(defaultCatalog).equalToWhenPresent(row::getDefaultCatalog)
                .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(modifyTime).equalToWhenPresent(row::getModifyTime)
                .set(invalid).equalToWhenPresent(row::getInvalid)
                .set(propertyList).equalToWhenPresent(row::getPropertyList);
    }

    default int updateByPrimaryKey(CatalogDO row) {
        return update(c ->
                c.set(pluginId).equalTo(row::getPluginId)
                        .set(catalogName).equalTo(row::getCatalogName)
                        .set(catalogType).equalTo(row::getCatalogType)
                        .set(defaultDatabase).equalTo(row::getDefaultDatabase)
                        .set(descr).equalTo(row::getDescr)
                        .set(defaultCatalog).equalTo(row::getDefaultCatalog)
                        .set(createUserId).equalTo(row::getCreateUserId)
                        .set(modifyUserId).equalTo(row::getModifyUserId)
                        .set(createTime).equalTo(row::getCreateTime)
                        .set(modifyTime).equalTo(row::getModifyTime)
                        .set(invalid).equalTo(row::getInvalid)
                        .set(propertyList).equalTo(row::getPropertyList)
            .where(catalogId, isEqualTo(row::getCatalogId))
        );
    }

    default int updateByPrimaryKeySelective(CatalogDO row) {
        return update(c ->
                c.set(pluginId).equalToWhenPresent(row::getPluginId)
                        .set(catalogName).equalToWhenPresent(row::getCatalogName)
                        .set(catalogType).equalToWhenPresent(row::getCatalogType)
                        .set(defaultDatabase).equalToWhenPresent(row::getDefaultDatabase)
                        .set(descr).equalToWhenPresent(row::getDescr)
                        .set(defaultCatalog).equalToWhenPresent(row::getDefaultCatalog)
                        .set(createUserId).equalToWhenPresent(row::getCreateUserId)
                        .set(modifyUserId).equalToWhenPresent(row::getModifyUserId)
                        .set(createTime).equalToWhenPresent(row::getCreateTime)
                        .set(modifyTime).equalToWhenPresent(row::getModifyTime)
                        .set(invalid).equalToWhenPresent(row::getInvalid)
                        .set(propertyList).equalToWhenPresent(row::getPropertyList)
            .where(catalogId, isEqualTo(row::getCatalogId))
        );
    }
}