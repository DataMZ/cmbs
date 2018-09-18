/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tcustomer
-- ----------------------------
DROP TABLE IF EXISTS `tcustomer`;
CREATE TABLE `tcustomer` (
  `Customer_ID` int(8) NOT NULL AUTO_INCREMENT,
  `ID_Type` char(1) DEFAULT NULL,
  `ID_Number` varchar(20) DEFAULT NULL,
  `Customer_Name` varchar(20) DEFAULT NULL,
  `Customer_Birthday` date DEFAULT NULL,
  `Customer_Sex` char(2) DEFAULT NULL,
  `Customer_Address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Customer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcustomer
-- ----------------------------
INSERT INTO `tcustomer` VALUES ('3', '0', '330023232', 'zwc', '2018-02-02', '男', '232');
INSERT INTO `tcustomer` VALUES ('7', '0', '330683199307252415', 'zwc3', '2018-09-05', '男', '123');
INSERT INTO `tcustomer` VALUES ('8', '0', '111111111111111', 'zwc22', '2018-09-11', '女', 'admin');
