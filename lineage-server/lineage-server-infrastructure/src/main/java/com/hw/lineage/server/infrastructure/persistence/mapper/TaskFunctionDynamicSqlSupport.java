package com.hw.lineage.server.infrastructure.persistence.mapper;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;

public final class TaskFunctionDynamicSqlSupport {
    public static final TaskFunction taskFunction = new TaskFunction();

    public static final SqlColumn<Long> rid = taskFunction.rid;

    public static final SqlColumn<Long> taskId = taskFunction.taskId;

    public static final SqlColumn<Long> sqlId = taskFunction.sqlId;

    public static final SqlColumn<Long> functionId = taskFunction.functionId;

    public static final SqlColumn<String> catalogName = taskFunction.catalogName;

    public static final SqlColumn<String> database = taskFunction.database;

    public static final SqlColumn<String> functionName = taskFunction.functionName;

    public static final SqlColumn<Long> createTime = taskFunction.createTime;

    public static final SqlColumn<Boolean> invalid = taskFunction.invalid;

    public static final class TaskFunction extends AliasableSqlTable<TaskFunction> {
        public final SqlColumn<Long> rid = column("`rid`", JDBCType.BIGINT);

        public final SqlColumn<Long> taskId = column("`task_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> sqlId = column("`sql_id`", JDBCType.BIGINT);

        public final SqlColumn<Long> functionId = column("`function_id`", JDBCType.BIGINT);

        public final SqlColumn<String> catalogName = column("`catalog_name`", JDBCType.VARCHAR);

        public final SqlColumn<String> database = column("`database`", JDBCType.VARCHAR);

        public final SqlColumn<String> functionName = column("`function_name`", JDBCType.VARCHAR);

        public final SqlColumn<Long> createTime = column("`create_time`", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("`invalid`", JDBCType.BIT);

        public TaskFunction() {
            super("rel_task_function", TaskFunction::new);
        }
    }
}