/*
 Navicat Premium Data Transfer

 Source Server         : 本机（root）
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 12/03/2019 18:02:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(4) NULL DEFAULT NULL,
  `month` int(2) NULL DEFAULT NULL,
  `day` int(2) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `week` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
