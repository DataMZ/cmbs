/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for toperator
-- ----------------------------
DROP TABLE IF EXISTS `toperator`;
CREATE TABLE `toperator` (
  `Operator_ID` char(10) NOT NULL,
  `Operator_Name` varchar(20) DEFAULT NULL,
  `Operator_Pwd` varchar(20) DEFAULT NULL,
  `Is_Admin` char(1) DEFAULT NULL,
  PRIMARY KEY (`Operator_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of toperator
-- ----------------------------
INSERT INTO `toperator` VALUES ('root', 'root', 'root', 'Y');
INSERT INTO `toperator` VALUES ('zwc', '章伟', '123', 'N');
INSERT INTO `toperator` VALUES ('zwc123', 'zwc', '123456', 'N');
INSERT INTO `toperator` VALUES ('zwc12312', '1231', '123456', 'N');
INSERT INTO `toperator` VALUES ('zwc2432', 'zwc', '123456', 'N');
INSERT INTO `toperator` VALUES ('zwc3123213', '1321', '123456', 'N');
