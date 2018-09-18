/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for taccount
-- ----------------------------
DROP TABLE IF EXISTS `taccount`;
CREATE TABLE `taccount` (
  `Account_ID` int(8) NOT NULL AUTO_INCREMENT,
  `Contact_Person` varchar(10) DEFAULT NULL,
  `Contact_Address` varchar(50) DEFAULT NULL,
  `Contact_Balance` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`Account_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12345685 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taccount
-- ----------------------------
INSERT INTO `taccount` VALUES ('12345678', '章伟聪', '绍兴嵊州', '60.00');
INSERT INTO `taccount` VALUES ('12345683', 'zwc', '123', '100.00');
INSERT INTO `taccount` VALUES ('12345684', '1231', '2123123', '120.00');
