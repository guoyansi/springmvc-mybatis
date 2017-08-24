/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : springmvc-mybatis

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-08-24 22:37:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gys`
-- ----------------------------
DROP TABLE IF EXISTS `gys`;
CREATE TABLE `gys` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `note` text COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gys
-- ----------------------------
INSERT INTO `gys` VALUES ('1', 'roleName12', 0x4E6F746533343233);
INSERT INTO `gys` VALUES ('2', 'roleName12', 0x4E6F746533343233);
