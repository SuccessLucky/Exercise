/*
 Navicat MySQL Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 01/11/2019 15:17:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL COMMENT '编号',
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `money` double NULL DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_8`(`uid`) USING BTREE,
  CONSTRAINT `FK_Reference` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 46, 1000);
INSERT INTO `account` VALUES (2, 45, 1000);
INSERT INTO `account` VALUES (3, 45, 2000);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dep_locationion` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (2, '研发部', '广州');
INSERT INTO `department` VALUES (3, '销售部', '深圳');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '开发部');
INSERT INTO `dept` VALUES (2, '市场部');
INSERT INTO `dept` VALUES (3, '财务部');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `salary` double NULL DEFAULT NULL,
  `join_date` date NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '孙悟空', '男', 7200, '2013-02-24', 1);
INSERT INTO `emp` VALUES (2, '猪八戒', '男', 3000, '2013-02-24', 2);
INSERT INTO `emp` VALUES (3, '唐三藏', '男', 5000, '2013-02-24', 1);
INSERT INTO `emp` VALUES (4, '沙悟净', '男', 4000, '2013-02-24', 3);
INSERT INTO `emp` VALUES (5, '如来佛', '男', 8000, '2013-02-24', 2);
INSERT INTO `emp` VALUES (6, '观世音', '女', 7200, '2013-02-24', 2);
INSERT INTO `emp` VALUES (7, '玉皇大帝', '男', 10000, '2013-02-24', 3);
INSERT INTO `emp` VALUES (8, '小白龙', '男', 5000, NULL, NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `dep_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `emp_dept_fk`(`dep_id`) USING BTREE,
  CONSTRAINT `emp_dept_fk` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张三', 18, 3);
INSERT INTO `employee` VALUES (2, '李四', 21, 3);
INSERT INTO `employee` VALUES (3, '王五', 20, 3);
INSERT INTO `employee` VALUES (4, '老王', 20, 2);
INSERT INTO `employee` VALUES (5, '大王', 22, 2);
INSERT INTO `employee` VALUES (6, '小王', 18, 2);
INSERT INTO `employee` VALUES (7, '王炸', 20, 3);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_desc` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '院长', '管理整个学院');
INSERT INTO `role` VALUES (2, '总裁', '管理整个公司');
INSERT INTO `role` VALUES (3, '校长', '管理整个学校');

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, 'aaaaa');
INSERT INTO `stu` VALUES (2, 'bbbb');
INSERT INTO `stu` VALUES (3, 'ccccc');
INSERT INTO `stu` VALUES (4, 'dddd');
INSERT INTO `stu` VALUES (5, 'eeee');
INSERT INTO `stu` VALUES (10, 'ffff');
INSERT INTO `stu` VALUES (11, 'gggg');
INSERT INTO `stu` VALUES (12, 'hhhh');
INSERT INTO `stu` VALUES (13, 'iiii');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(20) NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `math` int(100) NULL DEFAULT NULL,
  `english` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '马云', 55, '男', '杭州', 66, '78');
INSERT INTO `student` VALUES (2, '马化腾', 45, '女', '深圳', 98, '87');
INSERT INTO `student` VALUES (4, '刘岩', 20, '女', '湖南', 95, '87');
INSERT INTO `student` VALUES (5, '马云飞', 30, '男', '南阳', 94, '65');
INSERT INTO `student` VALUES (6, '张楚', 60, '女', '湖北', 89, '98');
INSERT INTO `student` VALUES (7, '联名', 45, '女', '周口', 78, NULL);
INSERT INTO `student` VALUES (8, '马冬梅', 60, '女', '安徽', 93, '87');
INSERT INTO `student` VALUES (9, NULL, 21, ' ', '西安', NULL, NULL);

-- ----------------------------
-- Table structure for tab_category
-- ----------------------------
DROP TABLE IF EXISTS `tab_category`;
CREATE TABLE `tab_category`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE INDEX `cname`(`cname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tab_route
-- ----------------------------
DROP TABLE IF EXISTS `tab_route`;
CREATE TABLE `tab_route`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` double NULL DEFAULT NULL,
  `rdate` date NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE,
  UNIQUE INDEX `rname`(`rname`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `tab_route_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `tab_category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (41, '老王', '2018-02-09 00:00:00', '男', '北京');
INSERT INTO `user` VALUES (42, '小二王', '2018-03-05 00:00:00', '女', '北京金燕龙');
INSERT INTO `user` VALUES (45, '传智播客', '2018-03-06 00:00:00', '男', '北京金燕龙');
INSERT INTO `user` VALUES (46, '老王', '2018-03-06 00:00:00', '女', '北京');
INSERT INTO `user` VALUES (48, '小马', '2019-10-08 10:22:46', '女', '北京市朝阳区');
INSERT INTO `user` VALUES (58, '小刚', '2019-09-29 11:48:54', '男', '北京市朝阳区');
INSERT INTO `user` VALUES (59, '小红', '2019-09-29 11:28:45', '女', '北京市海淀区');
INSERT INTO `user` VALUES (60, '小兰', '2019-06-09 00:00:00', '女', '上海市');
INSERT INTO `user` VALUES (64, '小明', '2019-10-08 10:16:19', '男', '河南省周口市');
INSERT INTO `user` VALUES (66, '小姜', '2019-10-28 11:48:59', '男', '上海市红砖区');
INSERT INTO `user` VALUES (69, '小梦', '2019-10-28 12:01:18', '女', '上海市徐汇区');
INSERT INTO `user` VALUES (71, '小明', '2019-10-28 17:02:22', '男', '河南省周口市');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`, `rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (41, 1);
INSERT INTO `user_role` VALUES (41, 2);
INSERT INTO `user_role` VALUES (45, 1);

SET FOREIGN_KEY_CHECKS = 1;
