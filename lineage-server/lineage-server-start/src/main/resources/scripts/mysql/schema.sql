DROP TABLE IF EXISTS `bas_user`;
CREATE TABLE `bas_user`
(
    `user_id`     bigint(20) AUTO_INCREMENT,
    `username`    varchar(32) NOT NULL,
    `password`    varchar(32) NOT NULL,
    `locked`      tinyint(1)   NOT NULL DEFAULT '0',
    `create_time` bigint(20)   NOT NULL,
    `modify_time` bigint(20)   NOT NULL,
    `invalid`     tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `bas_role`;
CREATE TABLE `bas_role`
(
    `role_id`     bigint(20) AUTO_INCREMENT,
    `role_name`   varchar(32) NOT NULL,
    `create_time` bigint(20)   NOT NULL,
    `modify_time` bigint(20)   NOT NULL,
    `invalid`     tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`role_id`),
    KEY `role_name_idx` (`role_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `rel_role_user`;
CREATE TABLE `rel_role_user`
(
    `rid`     bigint(20) AUTO_INCREMENT,
    `role_id` bigint(20) NOT NULL,
    `user_id` bigint(20) NOT NULL,
    `invalid` tinyint(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`rid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `bas_permission`;
CREATE TABLE `bas_permission`
(
    `permission_id`   bigint(20) AUTO_INCREMENT,
    `permission_group` varchar(32) NOT NULL,
    `permission_name` varchar(32) NOT NULL,
    `permission_code` varchar(32) NOT NULL,
    `create_time`     bigint(20)   NOT NULL,
    `modify_time`     bigint(20)   NOT NULL,
    `invalid`         tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`permission_id`),
    KEY `permission_name_idx` (`permission_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `rel_role_permission`;
CREATE TABLE `rel_role_permission`
(
    `rid`           bigint(20) AUTO_INCREMENT,
    `role_id`       bigint(20) NOT NULL,
    `permission_id` bigint(20) NOT NULL,
    `invalid`       tinyint(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`rid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `bas_task`;
CREATE TABLE `bas_task`
(
    `task_id`        bigint(20) AUTO_INCREMENT,
    `task_name`      varchar(32) NOT NULL,
    `descr`          varchar(256),
    `plugin_id`      bigint(20)   NOT NULL,
    `catalog_id`     bigint(20)   NOT NULL,
    `task_source`    longtext COMMENT 'Base64 encode',
    `create_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `modify_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `create_time`    bigint(20)   NOT NULL,
    `modify_time`    bigint(20)   NOT NULL,
    `invalid`        tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`task_id`),
    KEY `task_name_idx` (`task_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `rel_task_sql`;
CREATE TABLE `rel_task_sql`
(
    `sql_id`       bigint(20) AUTO_INCREMENT,
    `task_id`      bigint(20)  NOT NULL,
    `sql_code`     text COMMENT 'Base64 encode',
    `sql_type`     varchar(16) NOT NULL,
    `parse_status` tinyint(8)  NOT NULL,
    `parse_log`    text,
    `parse_time`   bigint(20)  NOT NULL,
    `invalid`      tinyint(1)  NOT NULL DEFAULT '0',
    PRIMARY KEY (`sql_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `rel_task_lineage`;
CREATE TABLE `rel_task_lineage`
(
    `rid`             bigint(20) AUTO_INCREMENT,
    `task_id`         bigint(20)   NOT NULL,
    `sql_id`          bigint(10)   NOT NULL,
    `source_catalog`  varchar(32) NOT NULL,
    `source_database` varchar(32) NOT NULL,
    `source_table`    varchar(32) NOT NULL,
    `source_column`   varchar(32) NOT NULL,
    `target_catalog`  varchar(32) NOT NULL,
    `target_database` varchar(32) NOT NULL,
    `target_table`    varchar(32) NOT NULL,
    `target_column`   varchar(32) NOT NULL,
    `transform`       varchar(32),
    `invalid`         tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`rid`),
    KEY `task_id_idx` (`task_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `bas_plugin`;
CREATE TABLE `bas_plugin`
(
    `plugin_id`      bigint(20) AUTO_INCREMENT,
    `plugin_name`    varchar(32) NOT NULL,
    `descr`          varchar(256),
    `create_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `modify_user_id` bigint(20)   NOT NULL DEFAULT '0',
    `create_time`    bigint(20)   NOT NULL,
    `modify_time`    bigint(20)   NOT NULL,
    `invalid`        tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`plugin_id`),
    KEY `plugin_name_idx` (`plugin_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `bas_catalog`;
CREATE TABLE `bas_catalog`
(
    `catalog_id`       bigint(20) AUTO_INCREMENT,
    `catalog_name`     varchar(32) NOT NULL,
    `catalog_type`     tinyint(8)   NOT NULL DEFAULT '0',
    `default_database` varchar(32) NOT NULL DEFAULT '',
    `descr`            varchar(256),
    `create_user_id`   bigint(20)   NOT NULL DEFAULT '0',
    `modify_user_id`   bigint(20)   NOT NULL DEFAULT '0',
    `create_time`      bigint(20)   NOT NULL,
    `modify_time`      bigint(20)   NOT NULL,
    `invalid`          tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (`catalog_id`),
    KEY `catalog_name_idx` (`catalog_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `bas_function`;
CREATE TABLE `bas_function`
(
    `function_id`     bigint(20) AUTO_INCREMENT,
    `function_name`   varchar(32)  NOT NULL,
    `function_format` varchar(32)  NOT NULL,
    `function_path`   varchar(1024) NOT NULL,
    `function_class`  varchar(32)  NOT NULL,
    `descr`           varchar(256),
    `create_user_id`  bigint(20)    NOT NULL DEFAULT '0',
    `modify_user_id`  bigint(20)    NOT NULL DEFAULT '0',
    `create_time`     bigint(20)    NOT NULL,
    `modify_time`     bigint(20)    NOT NULL,
    `invalid`         tinyint(1)    NOT NULL DEFAULT '0',
    PRIMARY KEY (`function_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;





