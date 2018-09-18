/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tcharge_rule
-- ----------------------------
DROP TABLE IF EXISTS `tcharge_rule`;
CREATE TABLE `tcharge_rule` (
  `Func_ID` char(1) NOT NULL,
  `Func_Name` varchar(10) DEFAULT NULL,
  `Charge_Code` char(1) NOT NULL,
  PRIMARY KEY (`Func_ID`,`Charge_Code`),
  KEY `fk_TCharge_Charge_Code` (`Charge_Code`),
  CONSTRAINT `fk_TCharge_Charge_Code` FOREIGN KEY (`Charge_Code`) REFERENCES `tcharge` (`Charge_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcharge_rule
-- ----------------------------
INSERT INTO `tcharge_rule` VALUES ('0', '开户业务', 'A');
INSERT INTO `tcharge_rule` VALUES ('0', '开户业务', 'C');
INSERT INTO `tcharge_rule` VALUES ('0', '开户业务', 'D');
INSERT INTO `tcharge_rule` VALUES ('0', '开户业务', 'E');
