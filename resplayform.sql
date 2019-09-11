/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : 192.168.162.27:3306
 Source Schema         : resplayform

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 19/08/2019 16:29:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES (1, '陈国', 'unit', '刘某人', '2019-07-31', 'type', '审核前');

-- ----------------------------
-- Table structure for ameeting
-- ----------------------------
DROP TABLE IF EXISTS `ameeting`;
CREATE TABLE `ameeting`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `participant` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_s` date NULL DEFAULT NULL,
  `time_e` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ameeting
-- ----------------------------
INSERT INTO `ameeting` VALUES (1, 'scau-cs研讨会', '张某，李某，苏某', 'scau', '研讨会', '2019-08-14', '审核前', '2019-08-14', NULL);

-- ----------------------------
-- Table structure for artwork
-- ----------------------------
DROP TABLE IF EXISTS `artwork`;
CREATE TABLE `artwork`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of artwork
-- ----------------------------
INSERT INTO `artwork` VALUES (1, '断臂维纳斯', '苏宇泉家的后院', 'Syq', '2019-08-14', '雕像', '审核前');
INSERT INTO `artwork` VALUES (2, '计算机图形学的美化艺术', 'scau', '刘某人', '2019-08-07', '科技类', '审核通过');

-- ----------------------------
-- Table structure for closure
-- ----------------------------
DROP TABLE IF EXISTS `closure`;
CREATE TABLE `closure`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `pid` int(32) NULL DEFAULT NULL,
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` date NULL DEFAULT NULL,
  `endTime` date NULL DEFAULT NULL,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileUrl` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of closure
-- ----------------------------
INSERT INTO `closure` VALUES (2, 16, '结项中', '2019-08-07', '2019-08-17', '99999', 'C:\\rpf\\\\123456_closure\\项目开发计划.doc');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `leader` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plantype` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `effective_date` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '132', 3, 'zs', '服务', '国家、部门计划', '2019-08-08', '变更学校审核通过');
INSERT INTO `contract` VALUES (2, '231', 1, 'ls', '开发', '地、市、县计划', '2019-08-09', '变更待审核');
INSERT INTO `contract` VALUES (3, '132', 2, 'll', '开发', '国家、部门计划', '2019-08-10', '变更学院审核通过');
INSERT INTO `contract` VALUES (4, '231', 4, 'ww', '开发', '地、市、县计划', '2019-08-10', '立项学校审核通过');
INSERT INTO `contract` VALUES (5, '132', 5, '4444', '服务', '地、市、县计划', '2019-08-09', '立项待审核');
INSERT INTO `contract` VALUES (7, '231', 6, 'zq', '服务', '省、自治区、直辖市及计划单列市计划', '2019-08-12', '立项学院审核通过');
INSERT INTO `contract` VALUES (8, '高校科研创新服务平台', 6, 'fry', '服务', '地、市、县计划', '2019-08-13', '学院审核未通过');

-- ----------------------------
-- Table structure for copyright
-- ----------------------------
DROP TABLE IF EXISTS `copyright`;
CREATE TABLE `copyright`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `number` int(32) NOT NULL DEFAULT 0,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of copyright
-- ----------------------------
INSERT INTO `copyright` VALUES (1, 20190606, '计算机图形学艺术', '书籍', 'scau', 'pdd', '2019-08-08', '审核前');

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '到款',
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '预算登记、预算审核、预算批理处理、预算监控、预算科目管理',
  `money` int(32) NULL DEFAULT NULL,
  `pid` int(32) NOT NULL,
  `total_money` int(32) NULL DEFAULT NULL,
  `payment_unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fund
-- ----------------------------
INSERT INTO `fund` VALUES (9, '0', 5, 4, NULL, 'scau', '2019-08-12');
INSERT INTO `fund` VALUES (10, '0', 0, 19, NULL, 'scau', '2019-08-13');
INSERT INTO `fund` VALUES (11, '0', 10, 1, NULL, 'company', '2019-08-14');
INSERT INTO `fund` VALUES (12, '0', 20, 1, NULL, 'company', '2019-08-14');
INSERT INTO `fund` VALUES (13, '0', 20, 42, NULL, 'scau', '2019-08-19');

-- ----------------------------
-- Table structure for identification
-- ----------------------------
DROP TABLE IF EXISTS `identification`;
CREATE TABLE `identification`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of identification
-- ----------------------------
INSERT INTO `identification` VALUES (1, 'scau——cs研究成果', 'scau', '刘加锐', '2019-08-13', NULL, '审核通过');

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `fid` int(11) NULL DEFAULT NULL,
  `payment_unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `operator` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES (1, 1, 1, 'scau', 2, 'syq', '2019-08-7');
INSERT INTO `income` VALUES (2, 1, 1, NULL, 12, 'aa', NULL);
INSERT INTO `income` VALUES (3, 1, 1, 'scau', 5, 'syq', '2019-08-02');
INSERT INTO `income` VALUES (4, 1, 1, 'scau', 1, '', '2019-08-02');
INSERT INTO `income` VALUES (7, 3, 7, 'scau', 10, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (8, 3, 2, '', 10, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (9, 1, 5, '12', 3, '33', '2019-08-12');
INSERT INTO `income` VALUES (10, 3, 2, '', 12, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (11, 19, 6, '123', 1, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (12, 19, 6, '123', 1, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (13, 19, 6, '123', 1, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (19, 1, 4, '12', 5, 'zs', '2019-08-12');
INSERT INTO `income` VALUES (23, 4, 9, 'scau', 15, 'ls', '2019-08-12');
INSERT INTO `income` VALUES (25, 4, 9, 'scau', 15, 'ls', '2019-08-12');
INSERT INTO `income` VALUES (26, 4, 9, 'scau', 5, 'zs', '2019-08-13');
INSERT INTO `income` VALUES (27, 4, 9, 'scau', 2, 'zs', '2019-08-13');
INSERT INTO `income` VALUES (28, 4, 9, 'scau', 2, 'zs', '2019-08-13');
INSERT INTO `income` VALUES (29, 19, 10, 'scau', 10, 'zs', '2019-08-13');
INSERT INTO `income` VALUES (30, 4, 9, 'scau', 1, 'zs', '2019-08-13');

-- ----------------------------
-- Table structure for institution
-- ----------------------------
DROP TABLE IF EXISTS `institution`;
CREATE TABLE `institution`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lule` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `device` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `communication` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of institution
-- ----------------------------
INSERT INTO `institution` VALUES (1, '华农科研所', '研究基地', '隶属于华南农业大学的科研所', '遵守学校规章制度', '50', '华迪');
INSERT INTO `institution` VALUES (2, '华迪', '工程中心', '位于四川省成都市郫都区', '遵守学校规章制度', '100', '华南农业大学');
INSERT INTO `institution` VALUES (3, '华工科研所', '研究基地', '隶属于华南理工大学的科研所', '遵守学校规章制度', '75', '华南农业大学');
INSERT INTO `institution` VALUES (6, '华师科研所', '研究基地', '隶属于华南师范大学的科研所', '遵守学校规章制度', '43', '华南农业大学');
INSERT INTO `institution` VALUES (7, '华农工程训练基地', '工程中心', '隶属于华南农业大学的工程中心', '遵守学校规章制度', '65', '华南农业大学');
INSERT INTO `institution` VALUES (8, '华农农事训练基地', '工程中心', '隶属于华南农业大学的工程中心', '遵守学校规章制度', '23', '华南农业大学');
INSERT INTO `institution` VALUES (9, '华农管理训练基地', '工程中心', '隶属于华南农业大学的工程中心', '遵守学校规章制度', '112', '华南农业大学');
INSERT INTO `institution` VALUES (10, '中大科研所', '研究基地', '隶属于中山大学的工程中心', '遵守学校规章制度', '34', '华南农业大学');
INSERT INTO `institution` VALUES (11, '五山科研所', '研究基地', '隶属于华南农业大学的工程中心', '遵守学校规章制度', '76', '华南农业大学');
INSERT INTO `institution` VALUES (12, '华工研究所', '实验室', '隶属于华南理工大学的工程中心', '遵循学校规章制度', '16', '华南农业大学');

-- ----------------------------
-- Table structure for institution_project
-- ----------------------------
DROP TABLE IF EXISTS `institution_project`;
CREATE TABLE `institution_project`  (
  `institution_id` int(32) NOT NULL,
  `project_id` int(32) NOT NULL,
  PRIMARY KEY (`institution_id`, `project_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of institution_project
-- ----------------------------
INSERT INTO `institution_project` VALUES (1, 1);
INSERT INTO `institution_project` VALUES (1, 31);
INSERT INTO `institution_project` VALUES (1, 42);
INSERT INTO `institution_project` VALUES (1, 43);
INSERT INTO `institution_project` VALUES (3, 41);

-- ----------------------------
-- Table structure for institution_user
-- ----------------------------
DROP TABLE IF EXISTS `institution_user`;
CREATE TABLE `institution_user`  (
  `id` int(32) NOT NULL,
  `user_id` int(32) NOT NULL,
  `project_id` int(32) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of institution_user
-- ----------------------------
INSERT INTO `institution_user` VALUES (1, 1, NULL);
INSERT INTO `institution_user` VALUES (1, 12, NULL);
INSERT INTO `institution_user` VALUES (1, 20, NULL);
INSERT INTO `institution_user` VALUES (1, 22, NULL);
INSERT INTO `institution_user` VALUES (1, 23, NULL);
INSERT INTO `institution_user` VALUES (1, 27, NULL);
INSERT INTO `institution_user` VALUES (1, 28, NULL);
INSERT INTO `institution_user` VALUES (1, 29, NULL);
INSERT INTO `institution_user` VALUES (1, 31, NULL);
INSERT INTO `institution_user` VALUES (1, 33, NULL);
INSERT INTO `institution_user` VALUES (1, 37, NULL);
INSERT INTO `institution_user` VALUES (1, 41, NULL);
INSERT INTO `institution_user` VALUES (1, 42, NULL);
INSERT INTO `institution_user` VALUES (1, 44, NULL);
INSERT INTO `institution_user` VALUES (1, 45, NULL);
INSERT INTO `institution_user` VALUES (2, 1, NULL);
INSERT INTO `institution_user` VALUES (2, 3, NULL);
INSERT INTO `institution_user` VALUES (2, 32, NULL);
INSERT INTO `institution_user` VALUES (3, 1, NULL);
INSERT INTO `institution_user` VALUES (3, 2, NULL);
INSERT INTO `institution_user` VALUES (3, 3, NULL);
INSERT INTO `institution_user` VALUES (3, 19, NULL);
INSERT INTO `institution_user` VALUES (3, 21, NULL);
INSERT INTO `institution_user` VALUES (3, 24, NULL);
INSERT INTO `institution_user` VALUES (3, 30, NULL);
INSERT INTO `institution_user` VALUES (3, 43, NULL);
INSERT INTO `institution_user` VALUES (6, 34, NULL);
INSERT INTO `institution_user` VALUES (6, 38, NULL);
INSERT INTO `institution_user` VALUES (7, 39, NULL);
INSERT INTO `institution_user` VALUES (9, 36, NULL);
INSERT INTO `institution_user` VALUES (10, 35, NULL);
INSERT INTO `institution_user` VALUES (11, 40, NULL);

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `time_s` date NULL DEFAULT NULL,
  `time_e` date NULL DEFAULT NULL,
  `position` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `capacity` int(11) NULL DEFAULT NULL,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (2, '2019-07-17', NULL, 'possss', NULL, '1235', 'unit', 'type', '审核前', '2019-07-17');
INSERT INTO `meeting` VALUES (3, '2019-08-15', NULL, '数学与信息学院', NULL, '人脸识别凸包计算算法研讨会', 'scau', '计算机类', '审核前', '2019-08-15');

-- ----------------------------
-- Table structure for meeting_user
-- ----------------------------
DROP TABLE IF EXISTS `meeting_user`;
CREATE TABLE `meeting_user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NULL DEFAULT NULL,
  `id_meeting` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userid` int(32) NULL DEFAULT NULL,
  `time` date NULL DEFAULT NULL,
  `content` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `timeFormat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统消息或者个人消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, '2019-08-06', '2019年8月7日1：30-4：30为系统维护时间，届时系统部分功能将无法正常使用，请各位用户相互通知。', '已阅读', '关于2019年8月7日系统维护的通知', '2019-8-1', 'system');
INSERT INTO `message` VALUES (2, 18, '2019-08-06', '项目变更资料已提交，请尽快审核。', '新消息', '项目变更资料已提交，请尽快处理', '2019-8-1', 'user');
INSERT INTO `message` VALUES (3, 1, '2019-08-06', '项目立项资料已提交，请尽快审核。', '已阅读', '项目立项资料已提交，请尽快处理', '2019-8-1', 'user');
INSERT INTO `message` VALUES (4, 1, '2019-08-08', '2019年8月7日1：30-4：30为系统维护时间，届时系统部分功能将无法正常使用，请各位用户相互通知。', '已阅读', '关于2019年8月9日系统维护的通知', '2019-8-1', 'system');
INSERT INTO `message` VALUES (5, 1, '2019-08-09', '2019年8月7日1：30-4：30为系统维护时间，届时系统部分功能将无法正常使用，请各位用户相互通知。', '新消息', '关于2019年8月10日系统维护的通知', '2019-8-1', 'system');
INSERT INTO `message` VALUES (6, 1, '2019-08-10', '2019年8月7日1：30-4：30为系统维护时间，届时系统部分功能将无法正常使用，请各位用户相互通知。', '新消息', '关于2019年8月11日系统维护的通知', '2019-8-1', 'system');
INSERT INTO `message` VALUES (7, 1, '2019-08-11', '2019年8月7日1：30-4：30为系统维护时间，届时系统部分功能将无法正常使用，请各位用户相互通知。', '已阅读', '关于2019年8月12日系统维护的通知', '2019-8-1', 'system');
INSERT INTO `message` VALUES (8, 1, '2019-08-12', '项目变更资料已提交，请尽快审核。', '新消息', '项目变更资料已提交，请尽快处理', '2019-8-1', 'user');
INSERT INTO `message` VALUES (9, 1, '2019-08-13', '项目变更资料已提交，请尽快审核。', '新消息', '项目变更资料已提交，请尽快处理', '2019-8-1', 'user');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `leader_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `leader_id` int(32) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '工程学院', '院系单位', '卢钢炫', NULL);
INSERT INTO `organization` VALUES (2, '数学与信息学院', '院系单位', '苏宇泉', NULL);
INSERT INTO `organization` VALUES (3, '外国语学院', '院系单位', '李四', NULL);
INSERT INTO `organization` VALUES (4, '软件学院', '院系单位', '范柔莹', NULL);
INSERT INTO `organization` VALUES (5, '电子工程学院', '院系单位', '张培慧', NULL);
INSERT INTO `organization` VALUES (6, '艺术学院', '院系单位', '刘加锐', NULL);
INSERT INTO `organization` VALUES (7, '创新创业学院', '院系单位', '张三', NULL);
INSERT INTO `organization` VALUES (8, '食品学院', '院系单位', '李四', NULL);
INSERT INTO `organization` VALUES (9, '农学院', '院系单位', '王五', NULL);
INSERT INTO `organization` VALUES (10, '水利与土木学院', '院系单位', '刘六', NULL);
INSERT INTO `organization` VALUES (11, '海洋学院', '院系单位', 'test', NULL);
INSERT INTO `organization` VALUES (12, '经济与管理学院', '院系单位', '赵琦', NULL);
INSERT INTO `organization` VALUES (13, '生命与科学学院', '院系单位', '王五', NULL);

-- ----------------------------
-- Table structure for organization_user
-- ----------------------------
DROP TABLE IF EXISTS `organization_user`;
CREATE TABLE `organization_user`  (
  `org_id` int(32) NOT NULL,
  `user_id` int(32) NOT NULL,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`org_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organization_user
-- ----------------------------
INSERT INTO `organization_user` VALUES (1, 6, NULL);
INSERT INTO `organization_user` VALUES (1, 8, NULL);
INSERT INTO `organization_user` VALUES (1, 9, NULL);
INSERT INTO `organization_user` VALUES (1, 22, NULL);
INSERT INTO `organization_user` VALUES (1, 23, '66');
INSERT INTO `organization_user` VALUES (1, 28, '3331');
INSERT INTO `organization_user` VALUES (1, 29, '4321');
INSERT INTO `organization_user` VALUES (1, 33, '苏宇泉');
INSERT INTO `organization_user` VALUES (1, 41, '赵琦');
INSERT INTO `organization_user` VALUES (1, 42, '4444');
INSERT INTO `organization_user` VALUES (1, 44, '赵琦');
INSERT INTO `organization_user` VALUES (1, 45, '苏');
INSERT INTO `organization_user` VALUES (2, 8, NULL);
INSERT INTO `organization_user` VALUES (2, 10, NULL);
INSERT INTO `organization_user` VALUES (2, 11, NULL);
INSERT INTO `organization_user` VALUES (2, 21, NULL);
INSERT INTO `organization_user` VALUES (2, 24, '刘六');
INSERT INTO `organization_user` VALUES (2, 27, '333');
INSERT INTO `organization_user` VALUES (2, 32, '范柔莹');
INSERT INTO `organization_user` VALUES (4, 30, '赵琦');
INSERT INTO `organization_user` VALUES (4, 31, '张培慧');
INSERT INTO `organization_user` VALUES (5, 35, '刘加锐');
INSERT INTO `organization_user` VALUES (6, 34, '卢钢炫');
INSERT INTO `organization_user` VALUES (6, 38, '王五');
INSERT INTO `organization_user` VALUES (6, 43, '赵琦');
INSERT INTO `organization_user` VALUES (9, 39, '刘六');
INSERT INTO `organization_user` VALUES (11, 37, '李四');
INSERT INTO `organization_user` VALUES (12, 36, '张三');
INSERT INTO `organization_user` VALUES (14, 40, '赵琦');

-- ----------------------------
-- Table structure for outcome
-- ----------------------------
DROP TABLE IF EXISTS `outcome`;
CREATE TABLE `outcome`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `pid` int(32) NULL DEFAULT NULL,
  `fid` int(32) NULL DEFAULT NULL,
  `operator` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apply_user` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purpose` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(32) NULL DEFAULT NULL,
  `date` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of outcome
-- ----------------------------
INSERT INTO `outcome` VALUES (1, 1, 1, 'su', 'syq', 'happy', 123, '2019-07-17');
INSERT INTO `outcome` VALUES (2, 1, NULL, NULL, 'su', 'hhh', 5, '2019-08-02');
INSERT INTO `outcome` VALUES (3, 1, NULL, NULL, 'zs', 'rg', 1, '2019-08-02');
INSERT INTO `outcome` VALUES (4, 3, NULL, NULL, 'zs', 'scau', 2, '2019-08-13');
INSERT INTO `outcome` VALUES (5, 3, NULL, NULL, '123', 'scau', 5, '2019-08-13');
INSERT INTO `outcome` VALUES (6, 19, NULL, NULL, 'zs', 'scau', 13, '2019-08-13');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `discipline` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `discipline_f` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `organization` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (2, '基于大数据的计算机信息处理技术研究', '数信学院', '苏小小', '2016-06-09', '应用数学', '应用数学', NULL, '数信学院');
INSERT INTO `paper` VALUES (3, '基于5G车联网的铝箔通行系统研究', '电子学院', '苏轼', '2017-08-06', '物联网', '电子工程', NULL, '电子学院');
INSERT INTO `paper` VALUES (4, '基于深度学习的猪脸识别', '软件学院', '苏够', '2015-06-07', '软件工程', '计算机科学', NULL, '软件学院');
INSERT INTO `paper` VALUES (5, '基于云模型的水环境治理', '软件学院', '苏绿', '2014-08-09', '软件工程', '计算机科学', NULL, '软件学院');
INSERT INTO `paper` VALUES (6, '浅谈大数据技术对管理会计的影响', '软件学院', '苏数', '2015-03-04', '软件工程', '计算机科学', NULL, '软件学院');
INSERT INTO `paper` VALUES (7, '大数据分析挖掘技术及其决策应用研究', '软件学院', '苏大', '2019-08-16', '软件工程', '计算机科学', NULL, '软件学院');
INSERT INTO `paper` VALUES (8, '	大数据时代的人工智能发展的法律思考', '人文与法学院', '苏明辉', '2017-08-18', '法学', '法学', NULL, '人文与法学院');
INSERT INTO `paper` VALUES (10, '	混合现实技术在大数据可视化中的应用', '软件学院', '苏宇泉', '2019-06-19', '软件工程', '计算机科学', NULL, '软件学院');
INSERT INTO `paper` VALUES (11, '	基于大数据处理技术的IT系统实时信息交互判异算法', '软件学院', '苏宇泉', '2018-07-27', '软件工程', '计算机科学', NULL, '软件学院');
INSERT INTO `paper` VALUES (13, '基于“互联网+物流”的大数据应用场景', '软件学院', '苏育群', '2019-08-12', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for paper_organization
-- ----------------------------
DROP TABLE IF EXISTS `paper_organization`;
CREATE TABLE `paper_organization`  (
  `oid` int(32) NOT NULL,
  `paper_id` int(32) NOT NULL,
  PRIMARY KEY (`oid`, `paper_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of paper_organization
-- ----------------------------
INSERT INTO `paper_organization` VALUES (1, 1);
INSERT INTO `paper_organization` VALUES (1, 2);
INSERT INTO `paper_organization` VALUES (1, 3);
INSERT INTO `paper_organization` VALUES (1, 4);
INSERT INTO `paper_organization` VALUES (2, 5);

-- ----------------------------
-- Table structure for patent
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inventor` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state_p` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patent
-- ----------------------------
INSERT INTO `patent` VALUES (1, '人脸识别中图像凸包计算速度', 'scau1', NULL, '计算机类', NULL, '审核前');
INSERT INTO `patent` VALUES (2, '快速识别图像', 'scau', 'pdd', '计算机类', NULL, '审核前');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `fund_id` int(32) NULL DEFAULT 0 COMMENT '资金备用',
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '项目立项、项目变更、项目中检、项目结项、项目结转',
  `lever` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目编号',
  `institution` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'v所属机构',
  `leader` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人（这些应该都是通过关系表或者外键关联，不做了太麻烦）',
  `resultUrl` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(32) NULL DEFAULT 0,
  `budget` int(11) NULL DEFAULT NULL,
  `apply_time` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '132', NULL, '变更待审核', '院级', '002', '1', 'zs', 'get', 19, 555, '2019-08-16', NULL, NULL);
INSERT INTO `project` VALUES (2, '222', 0, '已结转', '院级', '003', '1', '34', NULL, 0, 444, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (3, '123', NULL, '立项学校审核通过', '院级', '1234', '1', '35', 'C:\\rpf\\\\123456\\-124805553.gif', 25, 223, NULL, NULL, NULL);
INSERT INTO `project` VALUES (4, 'change', 0, '已结项', '院级', '333', '1', '36', NULL, 40, 666, '2019-08-02', NULL, NULL);
INSERT INTO `project` VALUES (5, '123', 0, '中检结束', '院级', '122', '1', '37', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (6, '222', 0, '立项学校审核通过', NULL, '424', '1', '38', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (7, '123', 0, '立项学校审核通过', '院级', '1247', '1', '39', NULL, 0, 556, '2019-08-08', NULL, NULL);
INSERT INTO `project` VALUES (8, 'change', 0, '中检中', NULL, '1144', '1', '43', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (9, '123', 0, '已结转', NULL, '114', '1', '41', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (10, '222', 0, '变更学院审核通过', '院级', '565', '1', '42', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (11, '123', 0, '立项学校审核通过', '院级', '558', '1', '43', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (12, 'change', 0, '立项学校审核通过', '校级', '534', '1', '44', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (13, '123', 0, '变更学校审核不通过', '校级', '2344', '1', '45', NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `project` VALUES (14, '53ws', NULL, '立项学校审核通过', '省级', '566', '1', '555', 'C:\\rpf\\\\123456\\21.jpg', 0, 111, '2019-07-23', NULL, NULL);
INSERT INTO `project` VALUES (15, '53ws', NULL, '中检结束', '省级', '566', '1', '555', 'C:\\rpf\\\\1234\\21.jpg', 0, 111, '2019-07-23', NULL, NULL);
INSERT INTO `project` VALUES (16, '53ws', NULL, '中检结束', '省级', '566', '1', '555', 'C:\\rpf\\\\1234\\21.jpg', 0, 111, '2019-07-23', NULL, NULL);
INSERT INTO `project` VALUES (17, '53ws', NULL, '立项学校审核通过', '省级', '566', '1', '555', 'C:\\rpf\\\\1234\\21.jpg', 0, 111, '2019-07-23', NULL, NULL);
INSERT INTO `project` VALUES (18, '321', NULL, '立项学校审核通过', '院级', '001', '1', '4444', NULL, NULL, 10, '2019-08-02', NULL, NULL);
INSERT INTO `project` VALUES (19, '231', 0, '已结转', '院级', '002', '1', 'zs', NULL, 0, 12, '2019-08-02', NULL, NULL);
INSERT INTO `project` VALUES (20, '132', NULL, '立项学校审核通过', '校级', '003', '1', '4444', NULL, NULL, 557, '2019-08-07', NULL, NULL);
INSERT INTO `project` VALUES (21, '11', NULL, '立项学校审核通过', '院级', '1111', '1', '11', NULL, NULL, 11, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (22, '998', NULL, '立项学校审核通过', '院级', '100', '1', 'ls', NULL, NULL, 444, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (23, '22', NULL, '立项学校审核通过', '院级', '22', '1', '22', NULL, NULL, 22, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (24, '22', NULL, '立项学校审核通过', '院级', '22', '3', '22', NULL, NULL, 22, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (27, '555', NULL, '立项学校审核通过', '院级', '12', '1', 'test', 'C:\\rpf\\\\123456\\04(F1).jpg', NULL, 123, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (28, '010', NULL, '立项学校审核通过', '院级', '010', '3', '010', NULL, NULL, 10, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (29, '1111', NULL, '立项学校审核通过', '院级', '1111', '3', '1111', NULL, NULL, 1111, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (30, '1010', NULL, '立项学校审核通过', '院级', '1010', '1', '1010', NULL, NULL, 1010, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (31, '8888', NULL, '学校审核未通过', '院级', '8888', '1', '8888', NULL, NULL, 8888, '2019-08-09', NULL, NULL);
INSERT INTO `project` VALUES (32, '981', NULL, '已结转', '院级', '110', '1', '55', NULL, NULL, 444, '2019-08-10', NULL, NULL);
INSERT INTO `project` VALUES (33, '1212', NULL, '立项学院审核通过', '院级', '1212', '1', '1212', NULL, NULL, 1212, '2019-08-13', NULL, NULL);
INSERT INTO `project` VALUES (41, '34', NULL, '变更学院审核通过', '院级', '34', '3', '34', NULL, NULL, 34, '2019-08-14', NULL, NULL);
INSERT INTO `project` VALUES (42, '高校创新科研服务平台', NULL, '立项学院审核通过', '校级', '050', '1', '范柔莹', 'C:\\rpf\\\\1234\\项目开发计划.doc', NULL, 50, '2019-08-16', NULL, NULL);
INSERT INTO `project` VALUES (43, 'scau项目', NULL, '立项待审核', '院级', '2017', '1', '张培慧', 'C:\\rpf\\\\201601\\项目材料.jpg', NULL, 200000, '2019-08-19', NULL, NULL);

-- ----------------------------
-- Table structure for project_carry_over
-- ----------------------------
DROP TABLE IF EXISTS `project_carry_over`;
CREATE TABLE `project_carry_over`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institution` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `leader` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `l_id` int(11) NULL DEFAULT NULL,
  `s_id` int(11) NULL DEFAULT NULL,
  `date` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(32) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project_carry_over
-- ----------------------------
INSERT INTO `project_carry_over` VALUES (7, '231', '1', 'zs', 123456, 654321, '2019-08-07', 4);
INSERT INTO `project_carry_over` VALUES (8, '123', '1', '4444', 123456, 654321, '2019-08-07', 10);
INSERT INTO `project_carry_over` VALUES (10, '231', '1', 'zs', 123456, 654321, '2019-08-07', 5);
INSERT INTO `project_carry_over` VALUES (11, '231', '1', 'zs', 123456, 654321, '2019-08-07', 1);
INSERT INTO `project_carry_over` VALUES (16, '231', '1', 'zs', 123456, 654321, '2019-08-07', 2);
INSERT INTO `project_carry_over` VALUES (17, '321', '1', 'zs', 123456, 654321, '2019-08-07', 2);
INSERT INTO `project_carry_over` VALUES (18, '23', '1', 'zs', 123456, 654321, '2019-08-06', 10);
INSERT INTO `project_carry_over` VALUES (21, '23', '2', 'zs', 123456, 654321, '2019-08-07', 1);
INSERT INTO `project_carry_over` VALUES (22, '23', '1', 'zs', 123456, 654321, '2019-08-07', 1);
INSERT INTO `project_carry_over` VALUES (36, '123', '1', '41', 123456, 654321, '2019-08-14', 4);

-- ----------------------------
-- Table structure for project_inspection
-- ----------------------------
DROP TABLE IF EXISTS `project_inspection`;
CREATE TABLE `project_inspection`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `pid` int(32) NULL DEFAULT NULL,
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` date NULL DEFAULT NULL,
  `endTime` date NULL DEFAULT NULL,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileUrl` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project_inspection
-- ----------------------------
INSERT INTO `project_inspection` VALUES (9, 6, '中检前', '2019-08-01', '2019-08-01', '222', NULL);
INSERT INTO `project_inspection` VALUES (10, 5, '中检前', '2019-08-02', '2019-08-17', '123', NULL);
INSERT INTO `project_inspection` VALUES (11, 4, '中检前', '2019-08-08', '2019-08-15', 'change', NULL);

-- ----------------------------
-- Table structure for project_organization
-- ----------------------------
DROP TABLE IF EXISTS `project_organization`;
CREATE TABLE `project_organization`  (
  `pid` int(32) NOT NULL,
  `oid` int(32) NOT NULL,
  PRIMARY KEY (`pid`, `oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project_organization
-- ----------------------------
INSERT INTO `project_organization` VALUES (1, 1);
INSERT INTO `project_organization` VALUES (2, 2);
INSERT INTO `project_organization` VALUES (3, 1);
INSERT INTO `project_organization` VALUES (4, 2);
INSERT INTO `project_organization` VALUES (21, 2);
INSERT INTO `project_organization` VALUES (23, 1);
INSERT INTO `project_organization` VALUES (24, 1);
INSERT INTO `project_organization` VALUES (24, 2);
INSERT INTO `project_organization` VALUES (28, 2);
INSERT INTO `project_organization` VALUES (29, 2);
INSERT INTO `project_organization` VALUES (30, 1);
INSERT INTO `project_organization` VALUES (31, 4);
INSERT INTO `project_organization` VALUES (41, 2);
INSERT INTO `project_organization` VALUES (42, 4);
INSERT INTO `project_organization` VALUES (43, 4);

-- ----------------------------
-- Table structure for project_user
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `project_id` int(32) NULL DEFAULT NULL,
  `user_id` int(32) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 144 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project_user
-- ----------------------------
INSERT INTO `project_user` VALUES (14, 17, 6);
INSERT INTO `project_user` VALUES (15, 17, 7);
INSERT INTO `project_user` VALUES (16, 17, 8);
INSERT INTO `project_user` VALUES (31, 18, 6);
INSERT INTO `project_user` VALUES (32, 18, 7);
INSERT INTO `project_user` VALUES (33, 18, 8);
INSERT INTO `project_user` VALUES (34, 18, 9);
INSERT INTO `project_user` VALUES (35, 18, 10);
INSERT INTO `project_user` VALUES (36, 18, 11);
INSERT INTO `project_user` VALUES (37, 18, 18);
INSERT INTO `project_user` VALUES (43, 4, 18);
INSERT INTO `project_user` VALUES (64, 20, 1);
INSERT INTO `project_user` VALUES (65, 20, 17);
INSERT INTO `project_user` VALUES (66, 20, 18);
INSERT INTO `project_user` VALUES (92, 7, 1);
INSERT INTO `project_user` VALUES (93, 7, 14);
INSERT INTO `project_user` VALUES (94, 7, 17);
INSERT INTO `project_user` VALUES (96, 22, 18);
INSERT INTO `project_user` VALUES (97, 22, 19);
INSERT INTO `project_user` VALUES (98, 22, 20);
INSERT INTO `project_user` VALUES (99, 22, 21);
INSERT INTO `project_user` VALUES (100, 23, 6);
INSERT INTO `project_user` VALUES (102, 27, 7);
INSERT INTO `project_user` VALUES (103, 27, 8);
INSERT INTO `project_user` VALUES (104, 27, 9);
INSERT INTO `project_user` VALUES (105, 28, 6);
INSERT INTO `project_user` VALUES (106, 29, 6);
INSERT INTO `project_user` VALUES (108, 30, 6);
INSERT INTO `project_user` VALUES (109, 24, 6);
INSERT INTO `project_user` VALUES (110, 21, 6);
INSERT INTO `project_user` VALUES (116, 2, 19);
INSERT INTO `project_user` VALUES (117, 31, 1);
INSERT INTO `project_user` VALUES (118, 32, 20);
INSERT INTO `project_user` VALUES (119, 32, 21);
INSERT INTO `project_user` VALUES (120, 32, 22);
INSERT INTO `project_user` VALUES (121, 32, 23);
INSERT INTO `project_user` VALUES (122, 33, 1);
INSERT INTO `project_user` VALUES (131, 41, 1);
INSERT INTO `project_user` VALUES (132, 42, 6);
INSERT INTO `project_user` VALUES (133, 42, 7);
INSERT INTO `project_user` VALUES (134, 42, 8);
INSERT INTO `project_user` VALUES (135, 42, 9);
INSERT INTO `project_user` VALUES (136, 42, 10);
INSERT INTO `project_user` VALUES (137, 1, 6);
INSERT INTO `project_user` VALUES (138, 1, 7);
INSERT INTO `project_user` VALUES (139, 1, 8);
INSERT INTO `project_user` VALUES (140, 1, 9);
INSERT INTO `project_user` VALUES (141, 1, 10);
INSERT INTO `project_user` VALUES (142, 43, 2);
INSERT INTO `project_user` VALUES (143, 43, 4);

-- ----------------------------
-- Table structure for pstate
-- ----------------------------
DROP TABLE IF EXISTS `pstate`;
CREATE TABLE `pstate`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `state_ch` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state_en` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pstate
-- ----------------------------
INSERT INTO `pstate` VALUES (0, '立项待审核', NULL);
INSERT INTO `pstate` VALUES (1, '立项学院审核通过', NULL);
INSERT INTO `pstate` VALUES (2, '立项学校审核通过', NULL);
INSERT INTO `pstate` VALUES (3, '变更学院审核通过', NULL);
INSERT INTO `pstate` VALUES (4, '变更学校审核通过', NULL);
INSERT INTO `pstate` VALUES (5, '中检前', NULL);
INSERT INTO `pstate` VALUES (6, '中检中', NULL);
INSERT INTO `pstate` VALUES (7, '中检结束', NULL);

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `id` int(32) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `discipline_f` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (1, '基于大数据在法律的应用场景', '软件学院', '社科国家级', '苏育群', '2016-09-02', '社会学', '省教育厅社科项目', NULL);

-- ----------------------------
-- Table structure for research_result
-- ----------------------------
DROP TABLE IF EXISTS `research_result`;
CREATE TABLE `research_result`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) NULL DEFAULT NULL,
  `result_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果保存路径',
  `project_id` int(32) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for reward
-- ----------------------------
DROP TABLE IF EXISTS `reward`;
CREATE TABLE `reward`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `base_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `base_class` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `base_result` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name_ch` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `name_en` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, '科研人员', 'level1');
INSERT INTO `role` VALUES (2, '科研管理人员', '');
INSERT INTO `role` VALUES (3, '学校领导', '');
INSERT INTO `role` VALUES (4, '学院领导', '');
INSERT INTO `role` VALUES (5, '系统管理员', '');

-- ----------------------------
-- Table structure for sci_statistics
-- ----------------------------
DROP TABLE IF EXISTS `sci_statistics`;
CREATE TABLE `sci_statistics`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `education` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `research` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institution` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sci_statistics
-- ----------------------------
INSERT INTO `sci_statistics` VALUES (1, '硕士研究生', '华南农业大学', '核科学技术', '省部级工程（技术）研究中心', '123', '2019-07-25');
INSERT INTO `sci_statistics` VALUES (2, '硕士研究生', '四川华迪公司', '临床医学', '省部级工程（技术）研究中心', '2234', '2019-07-25');
INSERT INTO `sci_statistics` VALUES (3, '博士研究生', '华南农业大学', '核科学技术', '国家重点实验室', '', '2019-07-30');
INSERT INTO `sci_statistics` VALUES (4, '博士研究生', '华南农业大学', '核科学技术', '国家重点实验室', '', '2019-07-30');
INSERT INTO `sci_statistics` VALUES (5, '博士研究生', '华南农业大学', '核科学技术', '国家重点实验室', '', '2019-08-12');
INSERT INTO `sci_statistics` VALUES (6, '博士研究生', '华南农业大学', '核科学技术', '国家重点实验室', '11', '2019-08-16');

-- ----------------------------
-- Table structure for soc_statistic
-- ----------------------------
DROP TABLE IF EXISTS `soc_statistic`;
CREATE TABLE `soc_statistic`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `education` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institution` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `research` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of soc_statistic
-- ----------------------------
INSERT INTO `soc_statistic` VALUES (1, '硕士研究生', '名誉硕士', '华南农业大学', NULL, 'codeform', '2019-07-29', '变更学校审核不通过', '土木建筑工程');
INSERT INTO `soc_statistic` VALUES (2, '博士研究生', '名誉博士', '华南农业大学', NULL, '123', '2019-07-30', '立项待学院审核', '核科学技术');
INSERT INTO `soc_statistic` VALUES (3, '硕士研究生', '名誉硕士', '华南农业大学', NULL, '', '2019-07-30', '立项待学院审核', '核科学技术');
INSERT INTO `soc_statistic` VALUES (4, '博士研究生', '名誉硕士', '华南农业大学', NULL, '', '2019-08-12', '立项学校审核不通过', '材料科学');
INSERT INTO `soc_statistic` VALUES (5, '博士研究生', '名誉博士', '华南农业大学', NULL, '11', '2019-08-16', '立项待学院审核', '核科学技术');

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of standard
-- ----------------------------
INSERT INTO `standard` VALUES (1, '人脸识别中图像凸包计算速度', 'scau', 'pdd', '计算机类', '审核通过');
INSERT INTO `standard` VALUES (2, '人脸识别最低分辨率', 'scau', '刘佳', 'cs', '审核通过');

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_formular` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `speaker` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time_s` date NULL DEFAULT NULL,
  `time_e` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES (1, '图形解析', 'scau', '计算机类', '2019-08-15', 'pdd', '审核前', '2019-08-15', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `role_id` int(8) NULL DEFAULT 0,
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(32) NULL DEFAULT NULL,
  `sex` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `search_dir` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `politics` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_login` date NULL DEFAULT NULL,
  `state` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态',
  `role` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'test', 0, 'test', '123456', '1213', 20, '男', NULL, NULL, '本科', NULL, NULL, '科研人员');
INSERT INTO `user` VALUES (2, '张培慧', 0, NULL, '201601', 'e10adc3949ba59abbe56e057f20f883e', 18, '女', '', '', '大学', NULL, '已审核', '科研人员');
INSERT INTO `user` VALUES (3, '范柔莹', 0, NULL, '201602', 'e10adc3949ba59abbe56e057f20f883e', 18, '女', '', '', '', NULL, '已审核', '科研人员');
INSERT INTO `user` VALUES (4, '苏宇泉', 1, NULL, '201603', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '单位秘书');
INSERT INTO `user` VALUES (5, '卢钢炫', 2, NULL, '201604', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '科研管理人员');
INSERT INTO `user` VALUES (6, '刘加锐', 4, NULL, '201605', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '学校领导');
INSERT INTO `user` VALUES (7, '张三', 3, NULL, '201606', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '学院领导');
INSERT INTO `user` VALUES (8, '李四', 5, NULL, '201607', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '系统管理员');
INSERT INTO `user` VALUES (9, '王五', 4, NULL, '201608', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '学校领导');
INSERT INTO `user` VALUES (10, '刘六', 4, NULL, '201609', 'e10adc3949ba59abbe56e057f20f883e', 20, '男', '', '', '', NULL, '已审核', '学校领导');
INSERT INTO `user` VALUES (11, '赵琦', 4, NULL, '201610', 'e10adc3949ba59abbe56e057f20f883e', 33, '男', '无', '', '', NULL, '已审核', '学校领导');
INSERT INTO `user` VALUES (45, '苏', 0, NULL, '1581326492', 'f379eaf3c831b04de153469d1bec345e', 12, '男', '', '', '', NULL, '未审核', '科研人员');

-- ----------------------------
-- View structure for cnum_month
-- ----------------------------
DROP VIEW IF EXISTS `cnum_month`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `cnum_month` AS select count(`contract`.`id`) AS `cNum` from `contract` where ((curdate() - interval 30 day) <= cast(`contract`.`effective_date` as date));

-- ----------------------------
-- View structure for cnum_year
-- ----------------------------
DROP VIEW IF EXISTS `cnum_year`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `cnum_year` AS select count(`contract`.`id`) AS `cNumy` from `contract` where ((curdate() - interval 365 day) <= cast(`contract`.`effective_date` as date));

-- ----------------------------
-- View structure for count_month
-- ----------------------------
DROP VIEW IF EXISTS `count_month`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `count_month` AS select `imnum_month`.`imNum` AS `imNum`,`cnum_month`.`cNum` AS `cNum`,`ounum_month`.`omNum` AS `omNum`,`pnum_month`.`pNum` AS `pNum` from (((`cnum_month` join `imnum_month`) join `ounum_month`) join `pnum_month`);

-- ----------------------------
-- View structure for count_year
-- ----------------------------
DROP VIEW IF EXISTS `count_year`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `count_year` AS select `pnum_year`.`pNumy` AS `pNumy`,`ounum_year`.`omNumy` AS `omNumy`,`cnum_year`.`cNumy` AS `cNumy`,`imnum_year`.`imNumy` AS `imNumy` from (((`cnum_year` join `imnum_year`) join `ounum_year`) join `pnum_year`);

-- ----------------------------
-- View structure for imnum_month
-- ----------------------------
DROP VIEW IF EXISTS `imnum_month`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `imnum_month` AS select sum(`income`.`money`) AS `imNum` from `income` where ((curdate() - interval 30 day) <= cast(`income`.`date` as date));

-- ----------------------------
-- View structure for imnum_year
-- ----------------------------
DROP VIEW IF EXISTS `imnum_year`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `imnum_year` AS select sum(`income`.`money`) AS `imNumy` from `income` where ((curdate() - interval 365 day) <= cast(`income`.`date` as date));

-- ----------------------------
-- View structure for ounum_month
-- ----------------------------
DROP VIEW IF EXISTS `ounum_month`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `ounum_month` AS select sum(`outcome`.`money`) AS `omNum` from `outcome` where ((curdate() - interval 30 day) <= cast(`outcome`.`date` as date));

-- ----------------------------
-- View structure for ounum_year
-- ----------------------------
DROP VIEW IF EXISTS `ounum_year`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `ounum_year` AS select sum(`outcome`.`money`) AS `omNumy` from `outcome` where ((curdate() - interval 365 day) <= cast(`outcome`.`date` as date));

-- ----------------------------
-- View structure for pnum_month
-- ----------------------------
DROP VIEW IF EXISTS `pnum_month`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `pnum_month` AS select count(`project`.`id`) AS `pNum` from `project` where ((curdate() - interval 30 day) <= cast(`project`.`apply_time` as date));

-- ----------------------------
-- View structure for pnum_year
-- ----------------------------
DROP VIEW IF EXISTS `pnum_year`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `pnum_year` AS select count(`project`.`id`) AS `pNumy` from `project` where ((curdate() - interval 365 day) <= cast(`project`.`apply_time` as date));

-- ----------------------------
-- View structure for project_fund
-- ----------------------------
DROP VIEW IF EXISTS `project_fund`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `project_fund` AS select `project`.`id` AS `id`,`f`.`id` AS `FId`,`f`.`money` AS `FMoney`,`f`.`total_money` AS `FTotalMoney`,`f`.`payment_unit` AS `FPaymentUnit`,`f`.`date` AS `FDate`,`project`.`name` AS `name`,`project`.`lever` AS `lever`,`project`.`number` AS `number`,`project`.`leader` AS `leader`,`project`.`budget` AS `budget`,`project`.`start_time` AS `start_time`,`project`.`end_time` AS `end_time`,`project`.`apply_time` AS `apply_time`,`project`.`institution` AS `institution`,`project`.`state` AS `state` from (`fund` `f` join `project` on((`f`.`pid` = `project`.`id`)));

-- ----------------------------
-- View structure for project_income
-- ----------------------------
DROP VIEW IF EXISTS `project_income`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `project_income` AS select `income`.`payment_unit` AS `payment_unit`,`income`.`money` AS `money`,`income`.`operator` AS `operator`,`income`.`date` AS `date`,`project`.`leader` AS `leader`,`project`.`name` AS `name`,`project`.`number` AS `number`,`project`.`institution` AS `institution`,`project`.`lever` AS `lever`,`project`.`budget` AS `budget`,`project`.`start_time` AS `start_time`,`project`.`end_time` AS `end_time`,`income`.`id` AS `id` from (`income` join `project` on((`income`.`pid` = `project`.`id`)));

-- ----------------------------
-- View structure for project_outcome
-- ----------------------------
DROP VIEW IF EXISTS `project_outcome`;
CREATE ALGORITHM = UNDEFINED DEFINER = `lgx`@`%` SQL SECURITY DEFINER VIEW `project_outcome` AS select `outcome`.`id` AS `id`,`outcome`.`pid` AS `pid`,`outcome`.`operator` AS `operator`,`outcome`.`apply_user` AS `apply_user`,`outcome`.`purpose` AS `purpose`,`outcome`.`money` AS `money`,`outcome`.`date` AS `date`,`project`.`name` AS `name`,`project`.`leader` AS `leader` from (`project` join `outcome` on((`project`.`id` = `outcome`.`pid`)));

SET FOREIGN_KEY_CHECKS = 1;
