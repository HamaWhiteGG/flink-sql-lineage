DROP TABLE IF EXISTS `bas_task`;
CREATE TABLE `bas_task`
(
    `task_id`        bigint(20) AUTO_INCREMENT,
    `task_name`      varchar(128) NOT NULL,
    `descr`          varchar(255),
    `plugin_id`      bigint(20)   NOT NULL,
    `catalog_id`     bigint(20)   NOT NULL,
    `source`         longtext COMMENT 'Base64 encode',
    `create_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `modify_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `ctime`          bigint(20)   NOT NULL,
    `mtime`          bigint(20)   NOT NULL,
    `invalid`        tinyint(3)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`task_id`),
    KEY `task_name_idx` (`task_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `rel_task_sql`;
CREATE TABLE `rel_task_sql`
(
    `sql_id`       bigint(20) AUTO_INCREMENT,
    `task_id`      bigint(20) NOT NULL,
    `sql`          text COMMENT 'Base64 encode',
    `parse_status` tinyint(3) NOT NULL,
    `parse_log`    text,
    `parse_time`   bigint(20) NOT NULL,
    `invalid`      tinyint(3) NOT NULL DEFAULT '0',
    PRIMARY KEY (`sql_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `rel_task_lineage`;
CREATE TABLE `rel_task_lineage`
(
    `rid`             bigint(20) AUTO_INCREMENT,
    `task_id`         bigint(20)   NOT NULL,
    `sql_id`          bigint(20)   NOT NULL,
    `source_catalog`  varchar(128) NOT NULL,
    `source_database` varchar(128) NOT NULL,
    `source_table`    varchar(128) NOT NULL,
    `source_column`   varchar(128) NOT NULL,
    `target_catalog`  varchar(128) NOT NULL,
    `target_database` varchar(128) NOT NULL,
    `target_table`    varchar(128) NOT NULL,
    `target_column`   varchar(128) NOT NULL,
    `transform`       varchar(128) NOT NULL,
    `invalid`         tinyint(3)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`rid`),
    KEY `task_id_idx` (`task_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `bas_plugin`;
CREATE TABLE `bas_plugin`
(
    `plugin_id`      bigint(20) AUTO_INCREMENT,
    `plugin_name`    varchar(128) NOT NULL,
    `descr`          varchar(255),
    `create_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `modify_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `ctime`          bigint(20)   NOT NULL,
    `mtime`          bigint(20)   NOT NULL,
    `invalid`        tinyint(3)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`plugin_id`),
    KEY `plugin_name_idx` (`plugin_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `bas_catalog`;
CREATE TABLE `bas_catalog`
(
    `catalog_id`       bigint(20) AUTO_INCREMENT,
    `catalog_name`     varchar(128) NOT NULL,
    `catalog_type`     tinyint(3)   NOT NULL DEFAULT '0',
    `default_database` varchar(128) NOT NULL DEFAULT '',
    `descr`            varchar(255),
    `create_user_id`   bigint(20)   NOT NULL DEFAULT '0',
    `modify_user_id`   bigint(20)   NOT NULL DEFAULT '0',
    `ctime`            bigint(20)   NOT NULL,
    `mtime`            bigint(20)   NOT NULL,
    `invalid`          tinyint(3)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`catalog_id`),
    KEY `catalog_name_idx` (`catalog_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `bas_function`;
CREATE TABLE `bas_function`
(
    `function_id`     bigint(20) AUTO_INCREMENT,
    `function_name`   varchar(128)        NOT NULL,
    `function_format` varchar(128)        NOT NULL,
    `function_path`   varchar(1024)       NOT NULL,
    `function_class`  varchar(128)        NOT NULL,
    `descr`           varchar(255),
    `create_user_id`  bigint(20)          NOT NULL DEFAULT '0',
    `modify_user_id`  bigint(20)          NOT NULL DEFAULT '0',
    `ctime`           bigint(20)          NOT NULL,
    `mtime`           bigint(20)          NOT NULL,
    `invalid`         tinyint(3) unsigned NOT NULL DEFAULT '0',
    PRIMARY KEY (`function_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;