/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : cmbs

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-14 16:15:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tmobiles
-- ----------------------------
DROP TABLE IF EXISTS `tmobiles`;
CREATE TABLE `tmobiles` (
  `Mobile_Number` varchar(11) NOT NULL,
  `Mobile_Type` char(3) DEFAULT NULL,
  `Card_Number` varchar(13) DEFAULT NULL,
  `Is_Available` char(1) DEFAULT NULL,
  PRIMARY KEY (`Mobile_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmobiles
-- ----------------------------
INSERT INTO `tmobiles` VALUES ('13900000000', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000001', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000002', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000003', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000004', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000005', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000006', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000007', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000008', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000009', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000010', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000011', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('13900000012', 'SIM', '', 'Y');
INSERT INTO `tmobiles` VALUES ('18810423684', 'SIM', '0021212212122', 'N');
