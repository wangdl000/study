/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql数据库
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : springmvc

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-11-18 19:47:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `aid` int(10) DEFAULT NULL,
  `aname` varchar(60) DEFAULT NULL,
  `money` double(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('10001', 'a', '9500.00');
INSERT INTO `account` VALUES ('10002', 'b', '10500.00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` int(11) DEFAULT NULL,
  `sname` varchar(60) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` int(3) DEFAULT NULL,
  `grade` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1001', '111', '21', '1', '67');
INSERT INTO `student` VALUES ('1002', '222', '22', '2', '68');
INSERT INTO `student` VALUES ('1003', '333', '34', '3', '69');
INSERT INTO `student` VALUES ('1004', '444', '23', '4', '89');
