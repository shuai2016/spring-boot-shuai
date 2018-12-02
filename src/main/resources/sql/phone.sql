/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云学生专享
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 47.93.222.202:3306
 Source Schema         : shuai

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 01/12/2018 18:35:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for phone
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `type` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
