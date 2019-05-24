/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : scaffold

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 05/24/2019 14:47:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_op_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_op_log`;
CREATE TABLE `t_op_log` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `log_type` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '日志类型',
  `title` varchar(200) CHARACTER SET utf8 DEFAULT '' COMMENT '日志标题',
  `app` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '服务名',
  `remote_addr` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '操作方式',
  `params` text CHARACTER SET utf8 COMMENT '操作提交的数据',
  `time` int(11) DEFAULT NULL COMMENT '执行时间',
  `create_by` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建者',
  `exception` text CHARACTER SET utf8 COMMENT '异常信息',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_by` (`create_by`) USING BTREE,
  KEY `idx_request_uri` (`request_uri`) USING BTREE,
  KEY `idx_log_type` (`log_type`) USING BTREE,
  KEY `idx_create_date` (`create_time`) USING BTREE,
  KEY `idx_app` (`app`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='日志';

-- ----------------------------
--  Records of `t_op_log`
-- ----------------------------
BEGIN;
INSERT INTO `t_op_log` VALUES ('12', 'op', '用户登录', 'scaffold-admin-center', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36', '/auth/login', 'POST', '[{\"password\":\"123456\",\"username\":\"admin\"}]', '547', null, null, '2019-05-24 11:02:01'), ('13', 'op', '用户登录', 'scaffold-admin-center', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36', '/auth/login', 'POST', '[{\"password\":\"123456\",\"username\":\"admin\"}]', '439', null, null, '2019-05-24 14:26:29'), ('14', 'op', '用户登录', 'scaffold-admin-center', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36', '/auth/login', 'POST', '[{\"password\":\"123456\",\"username\":\"admin\"}]', '459', null, null, '2019-05-24 14:41:21');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dept`;
CREATE TABLE `t_sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `code` varchar(20) NOT NULL COMMENT '部门编码',
  `parent_code` varchar(20) NOT NULL DEFAULT '' COMMENT '父部门编码',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0 正常，1 删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='部门';

-- ----------------------------
--  Records of `t_sys_dept`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_dept` VALUES ('1', 'admin', '', '董事会1', '1', '2018-01-22 19:00:23', '2019-05-24 14:37:13', b'0'), ('13', 'test', '', '测试部门', '2', '2019-05-24 14:30:16', '2019-05-24 14:31:06', b'0'), ('14', 'test1', 'test', '测试部门1', '1', '2019-05-24 14:32:10', '2019-05-24 14:38:16', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` int(10) NOT NULL COMMENT '排序（升序）',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '字典状态 1 启用，2 禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0 正常，1 删除',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典';

-- ----------------------------
--  Records of `t_sys_dict`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_dict` VALUES ('7', '2', '本科', 'edu_level', '本科', '1', '1', '2018-12-05 16:23:33', '2018-12-05 16:30:50', b'0'), ('8', '2', '硕士', 'edu_level', '硕士', '2', '1', '2018-12-05 16:30:12', '2018-12-05 16:30:57', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` bigint(20) NOT NULL COMMENT '菜单ID',
  `code` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单编码',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) NOT NULL DEFAULT '' COMMENT '菜单权限标识',
  `path` varchar(200) NOT NULL DEFAULT '' COMMENT '前端URL',
  `parent_code` varchar(20) NOT NULL DEFAULT '' COMMENT '父菜单编码',
  `icon` varchar(32) NOT NULL DEFAULT '' COMMENT '图标',
  `component` varchar(64) NOT NULL DEFAULT '' COMMENT '页面名称',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序值',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '菜单类型 1 菜单，2 功能',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0 正常，1 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='菜单权限';

-- ----------------------------
--  Records of `t_sys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_menu` VALUES ('1', '1', '系统管理', 'sys:admin', '/admin', '', 'icon-xitongguanli', 'Layout', '1', '1', '2017-11-07 20:56:00', '2019-05-24 10:20:16', b'0'), ('2', '2', '用户管理', 'sys:user:admin', 'user', '1', 'icon-yonghuguanli', 'views/admin/user/index', '2', '1', '2017-11-02 22:24:37', '2019-05-24 10:20:36', b'0'), ('3', '3', '菜单管理', 'sys:menu:admin', 'menu', '1', 'icon-caidanguanli', 'views/admin/menu/index', '3', '1', '2017-11-08 09:57:27', '2019-05-24 10:20:49', b'0'), ('4', '4', '角色管理', 'sys:role:admin', 'role', '1', 'icon-jiaoseguanli', 'views/admin/role/index', '4', '1', '2017-11-08 10:13:37', '2019-05-24 10:20:53', b'0'), ('5', '5', '日志管理', 'sys:log:admin', 'log', '1', 'icon-rizhiguanli', 'views/admin/log/index', '5', '1', '2017-11-20 14:06:22', '2019-05-24 10:20:59', b'0'), ('6', '6', '字典管理', 'sys:dict:admin', 'dict', '1', 'icon-zygl', 'views/admin/dict/index', '6', '1', '2017-11-29 11:30:52', '2019-05-24 10:21:15', b'0'), ('7', '7', '部门管理', 'sys:dept:admin', 'dept', '1', 'icon-iconbmgl', 'views/admin/dept/index', '7', '1', '2018-01-20 13:17:19', '2019-05-24 10:21:21', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  `role_desc` varchar(255) NOT NULL COMMENT '角色描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0 正常，1 删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='角色';

-- ----------------------------
--  Records of `t_sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_role` VALUES ('1', 'admin', 'ROLE_ADMIN', '超级管理员', '2017-10-29 15:45:51', '2018-11-30 17:16:35', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menu`;
CREATE TABLE `t_sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

-- ----------------------------
--  Records of `t_sys_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_role_menu` VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5'), ('1', '6'), ('1', '7');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `real_name` varchar(20) NOT NULL COMMENT '真实姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `avatar` varchar(200) NOT NULL COMMENT '头像',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0 正常，1 删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_idx1_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='系统用户';

-- ----------------------------
--  Records of `t_sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_user` VALUES ('1', 'admin', 'admin', '{bcrypt}$2a$10$skv/RJ8YRn2/86XvyikopuJ5n4CDGlFSLvVmHhWTe7btQ3dlhplja', '17034642888', '', '2', '2018-04-20 07:15:18', '2019-05-24 10:05:01', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `t_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

-- ----------------------------
--  Records of `t_sys_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_user_role` VALUES ('1', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
