/*
 Navicat Premium Data Transfer

 Source Server         : locla-docker-mysql
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:13306
 Source Schema         : big_market

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 15/04/2024 16:35:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `award_id` int NOT NULL COMMENT '抽奖奖品ID - 内部流转使用',
  `award_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '奖品对接标识 - 每一个都是一个对应的发奖策略',
  `award_config` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '奖品配置信息',
  `award_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '奖品内容描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of award
-- ----------------------------
INSERT INTO `award` VALUES (1, 101, 'user_credit_random', '1,100', '用户积分【优先透彻规则范围，如果没有则走配置】', '2023-12-09 11:07:06', '2023-12-09 11:21:31');
INSERT INTO `award` VALUES (2, 102, 'openai_use_count', '2', '增加提问次数', '2023-12-09 11:07:06', '2024-04-15 16:34:18');
INSERT INTO `award` VALUES (3, 103, 'openai_use_count', '5', '增加提问次数', '2023-12-09 11:07:06', '2024-04-15 16:34:24');
INSERT INTO `award` VALUES (4, 104, 'openai_use_count', '8', '增加提问次数', '2023-12-09 11:07:06', '2024-04-15 16:34:30');
INSERT INTO `award` VALUES (5, 105, 'openai_model', '手机支架', '实物奖励', '2023-12-09 11:07:06', '2024-04-09 15:39:11');
INSERT INTO `award` VALUES (6, 106, 'openai_model', '摄像头', '实物奖励', '2023-12-09 11:07:06', '2024-04-15 16:35:23');
INSERT INTO `award` VALUES (7, 107, 'openai_model', '手表', '实物奖励', '2023-12-09 11:07:06', '2024-04-09 15:39:24');
INSERT INTO `award` VALUES (8, 108, 'openai_use_count', '耳机', '实物奖励', '2023-12-09 11:07:06', '2024-04-09 15:39:27');
INSERT INTO `award` VALUES (9, 109, 'openai_model', '手机', '实物奖励', '2023-12-09 11:07:06', '2024-04-09 15:39:33');

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `strategy_id` int NOT NULL COMMENT '抽奖策略ID',
  `strategy_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '抽奖策略描述',
  `rule_models` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模型策略',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES (1, 10001, '抽奖策略', NULL, '2024-04-08 21:38:25', '2024-04-08 21:38:25');

-- ----------------------------
-- Table structure for strategy_award
-- ----------------------------
DROP TABLE IF EXISTS `strategy_award`;
CREATE TABLE `strategy_award`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `strategy_id` int NOT NULL COMMENT '抽奖策略ID',
  `award_id` int NOT NULL COMMENT '抽奖奖品ID',
  `award_title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '抽奖奖品标题',
  `award_subtitle` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '抽奖奖品副标题',
  `award_count` int NOT NULL COMMENT '奖品库存总量',
  `award_count_surplus` int NOT NULL COMMENT '奖品库存剩余',
  `award_rate` decimal(6, 4) NOT NULL COMMENT '奖品中奖概率',
  `rule_models` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规则模型，rule规则记录',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of strategy_award
-- ----------------------------
INSERT INTO `strategy_award` VALUES (1, 10001, 101, '随机积分', NULL, 80000, 80000, 80.0000, 'rule_random', 1, '2024-04-08 21:39:37', '2024-04-08 21:54:10');
INSERT INTO `strategy_award` VALUES (2, 10001, 102, '2次提问机会', NULL, 10000, 10000, 10.0000, NULL, 2, '2024-04-08 21:40:27', '2024-04-15 16:34:42');
INSERT INTO `strategy_award` VALUES (3, 10001, 103, '5次提问机会', NULL, 5000, 5000, 5.0000, NULL, 3, '2024-04-08 21:41:33', '2024-04-15 16:34:45');
INSERT INTO `strategy_award` VALUES (4, 10001, 104, '8次提问机会', NULL, 4000, 4000, 4.0000, NULL, 4, '2024-04-08 21:42:21', '2024-04-15 16:34:49');
INSERT INTO `strategy_award` VALUES (5, 10001, 105, '手机支架', NULL, 600, 600, 0.6000, NULL, 5, '2024-04-08 21:43:14', '2024-04-08 22:11:45');
INSERT INTO `strategy_award` VALUES (6, 10001, 106, '摄像头', '', 200, 200, 0.2000, NULL, 6, '2024-04-08 21:43:43', '2024-04-15 16:35:21');
INSERT INTO `strategy_award` VALUES (7, 10001, 107, '手表', '抽奖10次后解锁', 100, 100, 0.1000, 'rule_lock,rule_luck_award', 7, '2024-04-08 21:44:12', '2024-04-08 22:13:12');
INSERT INTO `strategy_award` VALUES (8, 10001, 108, '耳机', '抽奖20次后解锁', 99, 99, 0.0999, 'rule_lock,rule_luck_award', 8, '2024-04-08 21:44:45', '2024-04-08 22:14:03');
INSERT INTO `strategy_award` VALUES (9, 10001, 109, '手机', '抽奖50次后解锁', 1, 1, 0.0001, 'rule_lock,rule_luck_award', 9, '2024-04-08 22:08:57', '2024-04-08 22:14:26');

-- ----------------------------
-- Table structure for strategy_rule
-- ----------------------------
DROP TABLE IF EXISTS `strategy_rule`;
CREATE TABLE `strategy_rule`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `strategy_id` int NOT NULL COMMENT '抽奖策略ID',
  `award_id` int NULL DEFAULT NULL COMMENT '抽奖奖品ID',
  `rule_type` int NOT NULL DEFAULT 0 COMMENT '抽奖规则类型【1-策略规则，2-奖品规则】',
  `rule_model` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '筹建规则类型【rule_lock]',
  `rule_value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT ' 抽奖规则比值',
  `rule_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '抽奖规则描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of strategy_rule
-- ----------------------------
INSERT INTO `strategy_rule` VALUES (1, 10001, 101, 2, 'rule_random', '1,1000', '随机积分策略', '2024-04-08 21:55:32', '2024-04-08 21:55:32');
INSERT INTO `strategy_rule` VALUES (2, 10001, 107, 2, 'rule_rock', '10', '抽奖10次后解锁', '2024-04-08 21:56:43', '2024-04-08 21:56:43');
INSERT INTO `strategy_rule` VALUES (3, 10001, 108, 2, 'rule_rock', '20', '抽奖20次后解锁', '2024-04-08 21:57:12', '2024-04-08 21:57:12');
INSERT INTO `strategy_rule` VALUES (4, 10001, 109, 2, 'rule_rock', '50', '抽奖50次后解锁', '2024-04-08 21:57:40', '2024-04-08 21:58:38');
INSERT INTO `strategy_rule` VALUES (5, 10001, 107, 2, 'rule_luck_award', '1,100', '随机100积分内兜底', '2024-04-08 21:58:23', '2024-04-09 14:23:46');
INSERT INTO `strategy_rule` VALUES (6, 10001, NULL, 1, 'rule_weight', '6000:102,103,104,105,106,107,108,109', '随机积分兜底', '2024-04-08 22:01:43', '2024-04-08 22:04:39');
INSERT INTO `strategy_rule` VALUES (7, 10001, NULL, 1, 'rule_blacklist', '1', '黑名单用户，1积分兜底', '2024-04-08 22:04:26', '2024-04-08 22:04:26');
INSERT INTO `strategy_rule` VALUES (8, 10001, 108, 2, 'rule_luck_award', '1,100', '随机100积分内兜底', '2024-04-09 14:23:21', '2024-04-09 14:23:52');
INSERT INTO `strategy_rule` VALUES (9, 10001, 101, 2, 'rule_luck_award', '1,20', '随机10积分内兜底', '2024-04-09 14:24:49', '2024-04-09 14:24:49');
INSERT INTO `strategy_rule` VALUES (10, 10001, 102, 2, 'rule_luck_award', '1,20', '随机20积分内兜底', '2024-04-09 14:26:04', '2024-04-09 14:26:04');
INSERT INTO `strategy_rule` VALUES (11, 10001, 103, 2, 'rule_luck_award', '1,30', '随机30积分内兜底', '2024-04-09 14:26:39', '2024-04-09 14:26:39');
INSERT INTO `strategy_rule` VALUES (12, 10001, 104, 2, 'rule_luck_award', '1,40', '随机40积分内兜底', '2024-04-09 14:27:06', '2024-04-09 14:27:06');
INSERT INTO `strategy_rule` VALUES (13, 10001, 105, 2, 'rule_luck_award', '1,50', '随机50积分内兜底', '2024-04-09 14:27:41', '2024-04-09 14:27:41');
INSERT INTO `strategy_rule` VALUES (14, 10001, 106, 2, 'rule_luck_award', '1,60', '随机60积分内兜底', '2024-04-09 14:28:08', '2024-04-09 14:28:08');


# 转储表 raffle_activity
# ------------------------------------------------------------

DROP TABLE IF EXISTS `raffle_activity`;

CREATE TABLE `raffle_activity` (
                                   `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                   `activity_id` bigint(12) NOT NULL COMMENT '活动ID',
                                   `activity_name` varchar(64) NOT NULL COMMENT '活动名称',
                                   `activity_desc` varchar(128) NOT NULL COMMENT '活动描述',
                                   `begin_date_time` datetime NOT NULL COMMENT '开始时间',
                                   `end_date_time` datetime NOT NULL COMMENT '结束时间',
                                   `stock_count` int(11) NOT NULL COMMENT '库存总量',
                                   `stock_count_surplus` int(11) NOT NULL COMMENT '剩余库存',
                                   `activity_count_id` bigint(12) NOT NULL COMMENT '活动参与次数配置',
                                   `strategy_id` bigint(8) NOT NULL COMMENT '抽奖策略ID',
                                   `state` varchar(8) NOT NULL COMMENT '活动状态',
                                   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `uq_activity_id` (`activity_id`),
                                   KEY `idx_begin_date_time` (`begin_date_time`),
                                   KEY `idx_end_date_time` (`end_date_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='抽奖活动表';



# 转储表 raffle_activity_count
# ------------------------------------------------------------

DROP TABLE IF EXISTS `raffle_activity_count`;

CREATE TABLE `raffle_activity_count` (
                                         `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
                                         `activity_count_id` bigint(12) NOT NULL COMMENT '活动次数编号',
                                         `total_count` int(8) NOT NULL COMMENT '总次数',
                                         `day_count` int(8) NOT NULL COMMENT '日次数',
                                         `month_count` int(8) NOT NULL COMMENT '月次数',
                                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `uq_activity_count_id` (`activity_count_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='抽奖活动次数配置表';




SET FOREIGN_KEY_CHECKS = 1;
