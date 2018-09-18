/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tcharge
-- ----------------------------
DROP TABLE IF EXISTS `tcharge`;
CREATE TABLE `tcharge` (
  `Charge_Code` char(1) NOT NULL,
  `Charge_Name` varchar(10) DEFAULT NULL,
  `Charge` double DEFAULT NULL,
  PRIMARY KEY (`Charge_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcharge
-- ----------------------------
INSERT INTO `tcharge` VALUES ('A', '开户费', '15');
INSERT INTO `tcharge` VALUES ('C', '押金', '10');
INSERT INTO `tcharge` VALUES ('D', '入网费', '10');
INSERT INTO `tcharge` VALUES ('E', '选号费', '5');
