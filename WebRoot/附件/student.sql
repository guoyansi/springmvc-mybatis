/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : springmvc-mybatis

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-08-24 22:36:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gd` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '24', '1');
INSERT INTO `student` VALUES ('2', '李四', '23', '2');
