package com.lineage.server.infrastructure.persistence.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CatalogDynamicSqlSupport {
    public static final Catalog catalog = new Catalog();

    public static final SqlColumn<Long> catalogId = catalog.catalogId;

    public static final SqlColumn<String> catalogName = catalog.catalogName;

    public static final SqlColumn<Byte> catalogType = catalog.catalogType;

    public static final SqlColumn<String> defaultDatabase = catalog.defaultDatabase;

    public static final SqlColumn<String> descr = catalog.descr;

    public static final SqlColumn<Long> createUserId = catalog.createUserId;

    public static final SqlColumn<Long> modifyUserId = catalog.modifyUserId;

    public static final SqlColumn<Long> ctime = catalog.ctime;

    public static final SqlColumn<Long> mtime = catalog.mtime;

    public static final SqlColumn<Integer> invalid = catalog.invalid;

    /**
     * @description: This class corresponds to the database table bas_catalog
     * @author: HamaWhite
     * @version: 1.0.0
     * @date: 2023/01/28 23:03:46
     *
     * @mbg.generated
     */
    public static final class Catalog extends AliasableSqlTable<Catalog> {
        public final SqlColumn<Long> catalogId = column("catalog_id", JDBCType.BIGINT);

        public final SqlColumn<String> catalogName = column("catalog_name", JDBCType.VARCHAR);

        public final SqlColumn<Byte> catalogType = column("catalog_type", JDBCType.TINYINT);

        public final SqlColumn<String> defaultDatabase = column("default_database", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

        public final SqlColumn<Long> createUserId = column("create_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("modify_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ctime = column("ctime", JDBCType.BIGINT);

        public final SqlColumn<Long> mtime = column("mtime", JDBCType.BIGINT);

        public final SqlColumn<Integer> invalid = column("invalid", JDBCType.INTEGER);

        public Catalog() {
            super("bas_catalog", Catalog::new);
        }
    }
}