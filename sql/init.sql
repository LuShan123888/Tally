/*
 Navicat Premium Data Transfer

 Source Server         : test@cloud
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : Tally

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 25/06/2020 14:12:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Feedback
-- ----------------------------
DROP TABLE IF EXISTS `Feedback`;
CREATE TABLE `Feedback` (
  `FeedbackID` int NOT NULL AUTO_INCREMENT,
  `UserID` int DEFAULT NULL,
  `Nickname` varchar(30) CHARACTER SET utf8mb4  DEFAULT NULL,
  `Email` varchar(30) CHARACTER SET utf8mb4  DEFAULT NULL,
  `Rates` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Suggestion` varchar(2000) CHARACTER SET utf8mb4  DEFAULT NULL,
  PRIMARY KEY (`FeedbackID`),
  KEY `Feedback_User_UserID_fk` (`UserID`),
  CONSTRAINT `Feedback_User_UserID_fk` FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000061 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of Feedback
-- ----------------------------
BEGIN;
INSERT INTO `Feedback` VALUES (1000000001, 100000001, 'Cian', '1074544350@qq.com', '10', 'good');
INSERT INTO `Feedback` VALUES (1000000002, 100000001, 'LuShan', '21dfdsfd@qq.com', '10', 'great');
COMMIT;

-- ----------------------------
-- Table structure for Transaction
-- ----------------------------
DROP TABLE IF EXISTS `Transaction`;
CREATE TABLE `Transaction` (
  `TransactionID` int NOT NULL AUTO_INCREMENT,
  `UserID` int NOT NULL,
  `Flow` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Type` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Amount` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Remark` varchar(30) CHARACTER SET utf8mb4  DEFAULT NULL,
  `Date` date NOT NULL,
  `Note` varchar(2000) CHARACTER SET utf8mb4  DEFAULT NULL,
  PRIMARY KEY (`TransactionID`),
  KEY `Transaction_User_UserID_fk` (`UserID`),
  CONSTRAINT `Transaction_User_UserID_fk` FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000059 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of Transaction
-- ----------------------------
BEGIN;
INSERT INTO `Transaction` VALUES (1000000001, 100000001, 'outflow', '餐饮', '12', '晚餐', '2020-06-22', '无');
INSERT INTO `Transaction` VALUES (1000000002, 100000001, 'outflow', '学习', '5', '打印试卷', '2020-01-01', '无');
INSERT INTO `Transaction` VALUES (1000000003, 100000002, 'outflow', '餐饮', '10', '午餐', '2020-06-23', '无');
INSERT INTO `Transaction` VALUES (1000000057, 100000001, 'inflow', '工资', '10000', '6月工资', '2020-06-15', '无');
INSERT INTO `Transaction` VALUES (1000000058, 100000001, 'outflow', '医疗', '60', '医院挂号', '2020-06-24', '无');
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Password` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Email` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  `Type` varchar(30) CHARACTER SET utf8mb4  NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=100000053 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES (100000001, 'Cian', '123456', '1074544350@qq.com', 'normal');
INSERT INTO `User` VALUES (100000002, 'admin', '111111', '23132121@q.com', 'admin');
INSERT INTO `User` VALUES (100000003, 'Liutao', '0808', 'sdfkdsfkdjkl@qq.com', 'normal');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
