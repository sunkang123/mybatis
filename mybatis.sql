/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-25 15:08:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
`id`  int(11) NOT NULL ,
`name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品名称' ,
`price`  float(10,0) NOT NULL COMMENT '商品定价' ,
`detail`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述' ,
`pic`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片' ,
`createtime`  datetime NULL DEFAULT NULL COMMENT '生产日期' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of items
-- ----------------------------
BEGIN;
INSERT INTO `items` VALUES ('1', '算法导论', '90', '算法导论的结论', '89880339-7021-4940-b258-b8a6d4b88323.png', '2018-10-21 12:12:12'), ('2', 'java编程思想', '100', '', '282f4424-bd48-450e-b7b8-20e0c3c4c653.png', '2018-10-07 21:55:16'), ('3', '深入理解java虚拟机', '80', null, null, '2018-10-07 21:55:18'), ('4', '大话设计模式', '50', null, null, '2018-10-07 21:55:50');
COMMIT;

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`orders_id`  int(11) NOT NULL COMMENT '订单id' ,
`items_id`  int(11) NOT NULL COMMENT '商品id' ,
`items_num`  int(11) NULL DEFAULT NULL COMMENT '商品购买数量' ,
PRIMARY KEY (`id`),
FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`items_id`) REFERENCES `items` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `orders_id` (`orders_id`) USING BTREE ,
INDEX `items_id` (`items_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
BEGIN;
INSERT INTO `orderdetail` VALUES ('1', '1', '1', '1'), ('2', '1', '2', '1'), ('3', '2', '3', '1'), ('4', '2', '4', '1');
COMMIT;

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`user_id`  int(11) NOT NULL DEFAULT 0 COMMENT '下单用户id' ,
`number`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单号' ,
`createtime`  datetime NOT NULL COMMENT '创建订单时间' ,
`note`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注' ,
PRIMARY KEY (`id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES ('1', '1', '1000010', '2018-10-07 20:15:04', ''), ('2', '1', '1000011', '2018-10-07 20:15:23', ''), ('3', '2', '1000012', '2018-10-07 20:15:38', '');
COMMIT;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '用户名称' ,
`birthday`  date NULL DEFAULT NULL COMMENT '用户生日' ,
`sex`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别' ,
`address`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=54

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'sunkang', '2018-10-07', '1', '杭州:update:update:update:update:update'), ('2', '陈王五', '2018-10-07', '1', '北京:update:update:update:update'), ('3', 'wangzhezhi', '2018-10-07', '3', '温州:update:update:update:update'), ('9', 'wangzhezhi', null, null, 'hangzhoubingjiang:update:update:update:update'), ('14', 'sunkang2', '2018-10-14', '1', 'hanghzou:update:update'), ('15', 'sunkang3', '2018-10-14', '1', 'hanghzou:update:update'), ('16', 'sunkang4', '2018-10-14', '1', 'hanghzou:update:update'), ('17', 'sunkang5', '2018-10-14', '1', 'hanghzou:update:update'), ('18', 'sunkang6', '2018-10-14', '1', 'hanghzou:update:update'), ('19', 'sunkang7', '2018-10-14', '1', 'hanghzou:update:update'), ('20', 'sunkang8', '2018-10-14', '1', 'hanghzou:update:update'), ('21', 'sunkang9', '2018-10-14', '1', 'hanghzou:update:update'), ('22', 'sunkang0', '2018-10-14', '1', 'hanghzou:update:update'), ('23', 'sunkang1', '2018-10-14', '1', 'hanghzou:update:update'), ('24', 'sunkang2', '2018-10-14', '1', 'hanghzou:update:update'), ('25', 'sunkang3', '2018-10-14', '1', 'hanghzou:update:update'), ('26', 'sunkang4', '2018-10-14', '1', 'hanghzou:update:update'), ('27', 'sunkang5', '2018-10-14', '1', 'hanghzou:update:update'), ('28', 'sunkang6', '2018-10-14', '1', 'hanghzou:update:update'), ('29', 'sunkang7', '2018-10-14', '1', 'hanghzou:update:update'), ('30', 'sunkang8', '2018-10-14', '1', 'hanghzou:update:update'), ('31', 'sunkang9', '2018-10-14', '1', 'hanghzou:update:update'), ('42', 'sunkang0', '2018-10-14', '1', 'hanghzou:update:update'), ('43', 'sunkang1', '2018-10-14', '1', 'hanghzou:update:update'), ('44', 'sunkang2', '2018-10-14', '1', 'hanghzou:update:update'), ('45', 'sunkang3', '2018-10-14', '1', 'hanghzou:update:update'), ('46', 'sunkang4', '2018-10-14', '1', 'hanghzou:update:update'), ('47', 'sunkang5', '2018-10-14', '1', 'hanghzou:update:update'), ('48', 'sunkang6', '2018-10-14', '1', 'hanghzou:update:update'), ('49', 'sunkang7', '2018-10-14', '1', 'hanghzou:update:update'), ('50', 'sunkang8', '2018-10-14', '1', 'hanghzou:update:update'), ('51', 'sunkang9', '2018-10-14', '1', 'hanghzou:update:update'), ('52', 'sunkang10', '2018-10-14', '1', 'hanghzou:update:update'), ('53', 'sunkang11', '2018-10-14', '1', 'hanghzou:update:update');
COMMIT;

-- ----------------------------
-- Auto increment value for `orderdetail`
-- ----------------------------
ALTER TABLE `orderdetail` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `orders`
-- ----------------------------
ALTER TABLE `orders` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `user`
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=54;
