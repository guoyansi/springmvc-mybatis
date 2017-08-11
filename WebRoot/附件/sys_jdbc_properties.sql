/*
Navicat MySQL Data Transfer

Source Server         : community
Source Server Version : 50633
Source Host           : 192.168.1.101:3306
Source Database       : edu_community_weixin

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-08-11 17:24:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_jdbc_properties
-- ----------------------------
DROP TABLE IF EXISTS `sys_jdbc_properties`;
CREATE TABLE `sys_jdbc_properties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(128) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_jdbc_properties
-- ----------------------------
INSERT INTO `sys_jdbc_properties` VALUES ('1', 'driverClassName', 'com.mysql.jdbc.Driver');
INSERT INTO `sys_jdbc_properties` VALUES ('2', 'url', 'jdbc:mysql://192.168.6.234:3306/springmvc-mybatis?zeroDateTimeBehavior=convertToNull&amp;allowMultiQueries=true&amp;useUnicode=true&amp;characterEncoding=UTF-8');
INSERT INTO `sys_jdbc_properties` VALUES ('3', 'username', 'root');
INSERT INTO `sys_jdbc_properties` VALUES ('4', 'password', 'gys');
INSERT INTO `sys_jdbc_properties` VALUES ('5', 'maxIdle', '15');
INSERT INTO `sys_jdbc_properties` VALUES ('6', 'minEvictableIdleTimeMillis', '300000');
INSERT INTO `sys_jdbc_properties` VALUES ('7', 'testOnBorrow', 'false');
INSERT INTO `sys_jdbc_properties` VALUES ('8', 'maxWait', '60000');
INSERT INTO `sys_jdbc_properties` VALUES ('9', 'testWhileIdle', 'true');
INSERT INTO `sys_jdbc_properties` VALUES ('10', 'maxActive', '20');
INSERT INTO `sys_jdbc_properties` VALUES ('11', 'filters', 'stat');
INSERT INTO `sys_jdbc_properties` VALUES ('12', 'maxOpenPreparedStatements', '20');
INSERT INTO `sys_jdbc_properties` VALUES ('13', 'timeBetweenEvictionRunsMillis', '60000');
INSERT INTO `sys_jdbc_properties` VALUES ('14', 'initialSize', '1');
INSERT INTO `sys_jdbc_properties` VALUES ('15', 'testOnReturn', 'false');
INSERT INTO `sys_jdbc_properties` VALUES ('16', 'logAbandoned', 'true');
INSERT INTO `sys_jdbc_properties` VALUES ('17', 'removeAbandonedTimeout', '1800');
INSERT INTO `sys_jdbc_properties` VALUES ('18', 'validationQuery', 'SELECT \'x\'');
INSERT INTO `sys_jdbc_properties` VALUES ('19', 'removeAbandoned', 'true');
INSERT INTO `sys_jdbc_properties` VALUES ('20', 'minIdle', '10');
