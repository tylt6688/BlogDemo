/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 28/12/2021 15:51:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for _blogger
-- ----------------------------
DROP TABLE IF EXISTS `_blogger`;
CREATE TABLE `_blogger`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `topicId` int(11) NULL DEFAULT NULL,
  `bloggerTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bloggerContent` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of _blogger
-- ----------------------------
INSERT INTO `_blogger` VALUES (1, 1, 3, '美好', '啊', 1621921882635);
INSERT INTO `_blogger` VALUES (2, 1, 1, 'admin', '测试', 1621921914764);
INSERT INTO `_blogger` VALUES (3, 2, 4, 'Windows推出Win11', '<span style=\"font-family:&quot;font-size:15px;background-color:#FFFFFF;\">Windows&nbsp;11 配备了简单易用的工具，可帮助您优化屏幕空间并最大化工作效率。与 Microsoft&nbsp;365 订阅</span><span style=\"font-size:0.8em;line-height:0;vertical-align:baseline;font-family:&quot;background-color:#FFFFFF;\"><a class=\"c-hyperlink supBLink\"><span class=\"supText\">*</span></a></span><span style=\"font-family:&quot;font-size:15px;background-color:#FFFFFF;\">&nbsp;配合使用，为您扫清工作过程中的阻碍。</span><a target=\"_self\" class=\"c-hyperlink\" href=\"https://www.microsoft.com/zh-cn/windows/features\">了解更多 Windows 11 相关的提示和技巧</a><span style=\"font-family:&quot;font-size:15px;background-color:#FFFFFF;\">。</span>', 1640673413576);

-- ----------------------------
-- Table structure for _topic
-- ----------------------------
DROP TABLE IF EXISTS `_topic`;
CREATE TABLE `_topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `indexed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleted` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of _topic
-- ----------------------------
INSERT INTO `_topic` VALUES (1, 1, 'admin', '1', '0');
INSERT INTO `_topic` VALUES (2, 1, '学校', '2', '0');
INSERT INTO `_topic` VALUES (3, 1, '生活', '2', '0');
INSERT INTO `_topic` VALUES (4, 2, '科技', '1', '0');
INSERT INTO `_topic` VALUES (5, 2, '生活', '2', '0');
INSERT INTO `_topic` VALUES (6, 2, '娱乐', '3', '0');

-- ----------------------------
-- Table structure for _user
-- ----------------------------
DROP TABLE IF EXISTS `_user`;
CREATE TABLE `_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of _user
-- ----------------------------
INSERT INTO `_user` VALUES (1, 'tylt6688', '123', NULL);
INSERT INTO `_user` VALUES (2, '1', '1', NULL);
INSERT INTO `_user` VALUES (3, '123', '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
