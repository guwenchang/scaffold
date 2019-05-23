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

 Date: 05/23/2019 12:09:08 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='日志';

SET FOREIGN_KEY_CHECKS = 1;
