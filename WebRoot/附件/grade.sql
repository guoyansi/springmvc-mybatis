/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : springmvc-mybatis

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-08-24 22:36:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_idd` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`grade_idd`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '一（1）班');
INSERT INTO `grade` VALUES ('2', '一（2）班');
