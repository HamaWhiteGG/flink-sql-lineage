package com.lineage.server.infrastructure.persistence.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PluginDynamicSqlSupport {
    public static final Plugin plugin = new Plugin();

    public static final SqlColumn<Long> pluginId = plugin.pluginId;

    public static final SqlColumn<String> pluginName = plugin.pluginName;

    public static final SqlColumn<String> descr = plugin.descr;

    public static final SqlColumn<Long> createUserId = plugin.createUserId;

    public static final SqlColumn<Long> modifyUserId = plugin.modifyUserId;

    public static final SqlColumn<Long> ctime = plugin.ctime;

    public static final SqlColumn<Long> mtime = plugin.mtime;

    public static final SqlColumn<Integer> invalid = plugin.invalid;

    /**
     * @description: This class corresponds to the database table bas_plugin
     * @author: HamaWhite
     * @version: 1.0.0
     * @date: 2023/01/28 23:03:46
     *
     * @mbg.generated
     */
    public static final class Plugin extends AliasableSqlTable<Plugin> {
        public final SqlColumn<Long> pluginId = column("plugin_id", JDBCType.BIGINT);

        public final SqlColumn<String> pluginName = column("plugin_name", JDBCType.VARCHAR);

        public final SqlColumn<String> descr = column("descr", JDBCType.VARCHAR);

        public final SqlColumn<Long> createUserId = column("create_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> modifyUserId = column("modify_user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> ctime = column("ctime", JDBCType.BIGINT);

        public final SqlColumn<Long> mtime = column("mtime", JDBCType.BIGINT);

        public final SqlColumn<Integer> invalid = column("invalid", JDBCType.INTEGER);

        public Plugin() {
            super("bas_plugin", Plugin::new);
        }
    }
}