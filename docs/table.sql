
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biz_binding
-- ----------------------------
DROP TABLE IF EXISTS `biz_binding`;
CREATE TABLE `biz_binding` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `biz_code` varchar(255) NOT NULL DEFAULT '',
  `method_code` varchar(255) NOT NULL DEFAULT '',
  `binding_status` varchar(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `key_method_code` (`method_code`),
  KEY `unique_key_biz_code_method_code` (`biz_code`,`method_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for biz_info
-- ----------------------------
DROP TABLE IF EXISTS `biz_info`;
CREATE TABLE `biz_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `biz_code` varchar(255) NOT NULL DEFAULT '',
  `biz_name` varchar(255) NOT NULL DEFAULT '',
  `biz_status` varchar(3) NOT NULL DEFAULT '0',
  `remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_biz_code` (`biz_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for biz_key
-- ----------------------------
DROP TABLE IF EXISTS `biz_key`;
CREATE TABLE `biz_key` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `biz_code` varchar(255) NOT NULL DEFAULT '',
  `key_group` varchar(255) NOT NULL DEFAULT '',
  `encrypt_type` varchar(255) NOT NULL DEFAULT '',
  `encrypt_key` varchar(4096) NOT NULL DEFAULT '' COMMENT '1. encrypt_type = RSA encrypt_key = my privateKey ',
  `decrypt_key` varchar(4096) NOT NULL DEFAULT '' COMMENT '1. encrypt_type = RSA   encrypt_key = partner’s publicKey ',
  `sign_type` varchar(255) NOT NULL DEFAULT '',
  `sign_key` varchar(2048) NOT NULL DEFAULT '',
  `key_status` varchar(3) NOT NULL DEFAULT '0',
  `remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_key_biz_code` (`biz_code`,`key_group`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for method_info
-- ----------------------------
DROP TABLE IF EXISTS `method_info`;
CREATE TABLE `method_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `method_code` varchar(255) NOT NULL DEFAULT '',
  `method_name` varchar(255) NOT NULL DEFAULT '',
  `rpc_type` varchar(50) NOT NULL DEFAULT '',
  `param_type` varchar(255) NOT NULL DEFAULT '',
  `return_type` varchar(255) NOT NULL DEFAULT '',
  `method_group` varchar(50) NOT NULL DEFAULT '',
  `method_version` varchar(50) NOT NULL DEFAULT '',
  `method_status` varchar(3) NOT NULL DEFAULT '0',
  `remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_service_code` (`method_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
