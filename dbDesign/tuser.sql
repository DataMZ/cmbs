/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `User_ID` int(8) NOT NULL AUTO_INCREMENT,
  `Mobile_Number` varchar(11) NOT NULL,
  `Roaming_Status` char(1) DEFAULT NULL,
  `Com_Level` char(1) DEFAULT NULL,
  `Customer_ID` int(8) NOT NULL,
  `Account_ID` int(8) NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `fk_TMobile_Mobile_Number` (`Mobile_Number`),
  KEY `fk_TCustomer_Customer_ID` (`Customer_ID`),
  KEY `fk_TAccount_Account_ID` (`Account_ID`),
  CONSTRAINT `fk_TAccount_Account_ID` FOREIGN KEY (`Account_ID`) REFERENCES `taccount` (`Account_ID`),
  CONSTRAINT `fk_TCustomer_Customer_ID` FOREIGN KEY (`Customer_ID`) REFERENCES `tcustomer` (`Customer_ID`),
  CONSTRAINT `fk_TMobile_Mobile_Number` FOREIGN KEY (`Mobile_Number`) REFERENCES `tmobiles` (`Mobile_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('2', '18810423684', '0', '0', '7', '12345678');
INSERT INTO `tuser` VALUES ('3', '18810423684', '0', '0', '7', '12345683');
INSERT INTO `tuser` VALUES ('4', '18810423684', '0', '0', '7', '12345684');
INSERT INTO `tuser` VALUES ('5', '18810423684', '0', '0', '7', '12345678');
INSERT INTO `tuser` VALUES ('6', '18810423684', '0', '0', '7', '12345678');
INSERT INTO `tuser` VALUES ('7', '18810423684', '0', '0', '7', '12345678');
