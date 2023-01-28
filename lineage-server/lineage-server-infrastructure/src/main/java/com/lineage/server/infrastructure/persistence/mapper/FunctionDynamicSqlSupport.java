package com.lineage.server.infrastructure.persistence.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class FunctionDynamicSqlSupport {
    public static final Function function = new Function();

    public static final SqlColumn<Long> functionId = function.functionId;

    public static final SqlColumn<String> functionName = function.functionName;

    public static final SqlColumn<String> functionFormat = function.functionFormat;

    public static final SqlColumn<String> functionPath = function.functionPath;

    public static final SqlColumn<String> functionClass = function.functionClass;

    public static final SqlColumn<String> descr = function.descr;

    public static final SqlColumn<Long> createUserId = function.createUserId;

    public static final SqlColumn<Long> modifyUserId = function.modifyUserId;

    public static final SqlColumn<Long> ctime = function.ctime;

    public static final SqlColumn<Long> mtime = function.mtime;

    public static final SqlColumn<Integer> invalid = function.invalid;

    /**
     * @description: This class corresponds to the database table bas_function
     * @author: HamaWhite
     * @version: 1.0.0
     * @date: 2023/01/28 23:03:46
     *
     * @mbg.generated
     */
    public static final class Function extends AliasableSqlTable<Function> {
        public final SqlColumn<Long> functionId = column("function_id", JDBCType.BIGINT);

        public final SqlColumn<String> functionName = column("function_name", JDBCType.VARCHAR);

        public final SqlColumn<String> functionFormat = column("function_format", JDBCType.VARCHAR);

        public final SqlColumn<String> functionPath = column("function_path", JDBCType.VARCHAR);

        public final SqlColumn<String> functionClass = column("function_class", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

        public final SqlColumn<Long> createUserId = column("create_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("modify_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ctime = column("ctime", JDBCType.BIGINT);

        public final SqlColumn<Long> mtime = column("mtime", JDBCType.BIGINT);

        public final SqlColumn<Integer> invalid = column("invalid", JDBCType.INTEGER);

        public Function() {
            super("bas_function", Function::new);
        }
    }
}