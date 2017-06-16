/*
Navicat MySQL Data Transfer

Source Server         : community
Source Server Version : 50633
Source Host           : 192.168.1.101:3306
Source Database       : edu_community_weixin

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-06-15 09:06:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id\r\n',
  `dict_desc` varchar(128) DEFAULT NULL,
  `dict_code` varchar(20) DEFAULT NULL,
  `dict_name` varchar(128) DEFAULT NULL,
  `dict_value` varchar(20) DEFAULT NULL,
  `is_valid` int(11) DEFAULT '1',
  `sort` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1093 DEFAULT CHARSET=utf8;
