package com.hw.lineage.server.infrastructure.persistence.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TableDynamicSqlSupport {
    public static final Table table = new Table();

    public static final SqlColumn<Long> tableId = table.tableId;

    public static final SqlColumn<Long> catalogId = table.catalogId;

    public static final SqlColumn<String> database = table.database;

    public static final SqlColumn<String> tableName = table.tableName;

    public static final SqlColumn<String> descr = table.descr;

    public static final SqlColumn<Long> createUserId = table.createUserId;

    public static final SqlColumn<Long> modifyUserId = table.modifyUserId;

    public static final SqlColumn<Long> createTime = table.createTime;

    public static final SqlColumn<Long> modifyTime = table.modifyTime;

    public static final SqlColumn<Boolean> invalid = table.invalid;

    /**
     * Base64 encode
     */
    public static final SqlColumn<String> ddl = table.ddl;

    public static final class Table extends AliasableSqlTable<Table> {
        public final SqlColumn<Long> tableId = column("`table_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> catalogId = column("`catalog_id`", JDBCType.BIGINT);

        public final SqlColumn<String> database = column("`database`", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("`table_name`", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("`descr`", JDBCType.VARCHAR);

        public final SqlColumn<Long> createUserId = column("`create_user_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("`modify_user_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyTime = column("`modify_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public final SqlColumn<String> ddl = column("`ddl`", JDBCType.LONGVARCHAR);

        public Table() {
            super("bas_table", Table::new);
        }
    }
}