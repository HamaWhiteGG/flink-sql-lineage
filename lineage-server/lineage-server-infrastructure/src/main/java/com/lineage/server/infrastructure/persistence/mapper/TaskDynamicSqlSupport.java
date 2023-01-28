package com.lineage.server.infrastructure.persistence.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TaskDynamicSqlSupport {
    public static final Task task = new Task();

    public static final SqlColumn<Long> taskId = task.taskId;

    public static final SqlColumn<String> taskName = task.taskName;

    public static final SqlColumn<String> descr = task.descr;

    public static final SqlColumn<Long> pluginId = task.pluginId;

    public static final SqlColumn<Long> catalogId = task.catalogId;

    public static final SqlColumn<Long> createUserId = task.createUserId;

    public static final SqlColumn<Long> modifyUserId = task.modifyUserId;

    public static final SqlColumn<Long> ctime = task.ctime;

    public static final SqlColumn<Long> mtime = task.mtime;

    public static final SqlColumn<Integer> invalid = task.invalid;

    /**
     * Base64 encode
     */
    public static final SqlColumn<String> source = task.source;

    /**
     * @description: This class corresponds to the database table bas_task
     * @author: HamaWhite
     * @version: 1.0.0
     * @date: 2023/01/28 23:03:46
     *
     * @mbg.generated
     */
    public static final class Task extends AliasableSqlTable<Task> {
        public final SqlColumn<Long> taskId = column("task_id", JDBCType.BIGINT);

        public final SqlColumn<String> taskName = column("task_name", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

        public final SqlColumn<Long> pluginId = column("plugin_id", JDBCType.BIGINT);

        public final SqlColumn<Long> catalogId = column("catalog_id", JDBCType.BIGINT);

        public final SqlColumn<Long> createUserId = column("create_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("modify_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ctime = column("ctime", JDBCType.BIGINT);

        public final SqlColumn<Long> mtime = column("mtime", JDBCType.BIGINT);

        public final SqlColumn<Integer> invalid = column("invalid", JDBCType.INTEGER);

        public final SqlColumn<String> source = column("source", JDBCType.LONGVARCHAR);

        public Task() {
            super("bas_task", Task::new);
        }
    }
}