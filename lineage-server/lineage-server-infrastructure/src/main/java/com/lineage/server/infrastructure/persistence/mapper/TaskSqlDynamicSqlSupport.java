package com.lineage.server.infrastructure.persistence.mapper;

import com.hw.lineage.common.enums.ParseStatus;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TaskSqlDynamicSqlSupport {
    public static final TaskSql taskSql = new TaskSql();

    public static final SqlColumn<Long> sqlId = taskSql.sqlId;

    public static final SqlColumn<Long> taskId = taskSql.taskId;

    public static final SqlColumn<ParseStatus> parseStatus = taskSql.parseStatus;

    public static final SqlColumn<Long> parseTime = taskSql.parseTime;

    public static final SqlColumn<Boolean> invalid = taskSql.invalid;

    /**
     * Base64 encode
     */
    public static final SqlColumn<String> sqlCode = taskSql.sqlCode;

    public static final SqlColumn<String> parseLog = taskSql.parseLog;

    public static final class TaskSql extends AliasableSqlTable<TaskSql> {
        public final SqlColumn<Long> sqlId = column("sql_id", JDBCType.BIGINT);

        public final SqlColumn<Long> taskId = column("task_id", JDBCType.BIGINT);

        public final SqlColumn<ParseStatus> parseStatus = column("parse_status", JDBCType.TINYINT, "com.lineage.server.infrastructure.persistence.mybatis.handler.impl.ParseStatusTypeHandler");

        public final SqlColumn<Long> parseTime = column("parse_time", JDBCType.BIGINT);

        public final SqlColumn<Boolean> invalid = column("invalid", JDBCType.BIT);

        public final SqlColumn<String> sqlCode = column("sql_code", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> parseLog = column("parse_log", JDBCType.LONGVARCHAR);

        public TaskSql() {
            super("rel_task_sql", TaskSql::new);
        }
    }
}