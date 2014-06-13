/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : clothes_ms

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2014-06-13 23:38:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `flag` int(11) NOT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'username1', 'password1', 'name1', '1', 'introduce1');
INSERT INTO `t_admin` VALUES ('2', 'username2', '000', 'bin', '1', 'update');
INSERT INTO `t_admin` VALUES ('3', 'username3', 'password3', 'name3', '1', 'introduce3');
INSERT INTO `t_admin` VALUES ('4', 'username4', 'password4', 'name4', '1', 'introduce4');
INSERT INTO `t_admin` VALUES ('5', 'username5', 'password5', 'name5', '1', 'introduce5');
INSERT INTO `t_admin` VALUES ('6', 'username6', 'password6', 'name6', '1', 'introduce6');
INSERT INTO `t_admin` VALUES ('7', 'username7', 'password7', 'name7', '1', 'introduce7');
INSERT INTO `t_admin` VALUES ('8', 'username8', 'password8', 'name8', '1', 'introduce8');
INSERT INTO `t_admin` VALUES ('9', 'username9', 'password9', 'name9', '1', 'introduce9');
INSERT INTO `t_admin` VALUES ('10', 'username10', 'password10', 'name10', '1', 'introduce10');
INSERT INTO `t_admin` VALUES ('11', 'username11', 'password11', 'name11', '1', 'introduce11');
INSERT INTO `t_admin` VALUES ('12', 'username12', 'password12', 'name12', '1', 'introduce12');
INSERT INTO `t_admin` VALUES ('13', 'username13', 'password13', 'name13', '1', 'introduce13');
INSERT INTO `t_admin` VALUES ('14', 'username14', 'password14', 'name14', '1', 'introduce14');
INSERT INTO `t_admin` VALUES ('15', 'username15', 'password15', 'name15', '1', 'introduce15');
INSERT INTO `t_admin` VALUES ('16', 'username16', 'password16', 'name16', '1', 'introduce16');
INSERT INTO `t_admin` VALUES ('17', 'username17', 'password17', 'name17', '1', 'introduce17');
INSERT INTO `t_admin` VALUES ('18', 'username18', 'password18', 'name18', '1', 'introduce18');
INSERT INTO `t_admin` VALUES ('19', 'username19', 'password19', 'name19', '1', 'introduce19');
INSERT INTO `t_admin` VALUES ('20', 'hong', '312132321313', 'bin', '1', 'haha');
INSERT INTO `t_admin` VALUES ('21', 'bin', '312132321313', 'bin', '1', 'haha');
INSERT INTO `t_admin` VALUES ('22', 'xiaolin', '312132321313', 'xiaolin', '1', 'haha');

-- ----------------------------
-- Table structure for t_clothes
-- ----------------------------
DROP TABLE IF EXISTS `t_clothes`;
CREATE TABLE `t_clothes` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `docu_number` char(6) NOT NULL,
  `color` varchar(14) NOT NULL,
  `size` int(11) NOT NULL,
  `commodity_name` varchar(14) NOT NULL,
  `ex_factory_price` int(11) NOT NULL,
  `operator` int(11) NOT NULL,
  `retail_price` int(11) NOT NULL,
  `out_material` varchar(20) NOT NULL COMMENT '外料',
  `in_material` varchar(20) NOT NULL COMMENT '里料',
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_T_clothes_T_admin_1` (`operator`),
  CONSTRAINT `fk_T_clothes_T_admin_1` FOREIGN KEY (`operator`) REFERENCES `t_admin` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clothes
-- ----------------------------
INSERT INTO `t_clothes` VALUES ('2', 'docu2', 'color2', '150', 'commodiry2', '200', '1', '500', 'out_mater2', 'in_mart2', '1');
INSERT INTO `t_clothes` VALUES ('3', 'docu3', 'color3', '150', 'commodiry3', '200', '1', '500', 'out_mater3', 'in_mart3', '1');
INSERT INTO `t_clothes` VALUES ('4', 'docu4', 'color4', '150', 'commodiry4', '200', '1', '500', 'out_mater4', 'in_mart4', '1');
INSERT INTO `t_clothes` VALUES ('5', 'docu5', 'color5', '150', 'commodiry5', '200', '1', '500', 'out_mater5', 'in_mart5', '1');
INSERT INTO `t_clothes` VALUES ('6', 'docu6', 'color6', '150', 'commodiry6', '200', '1', '500', 'out_mater6', 'in_mart6', '1');
INSERT INTO `t_clothes` VALUES ('7', 'docu7', 'color7', '150', 'commodiry7', '200', '1', '500', 'out_mater7', 'in_mart7', '1');
INSERT INTO `t_clothes` VALUES ('8', 'docu8', 'color8', '150', 'commodiry8', '200', '1', '500', 'out_mater8', 'in_mart8', '1');
INSERT INTO `t_clothes` VALUES ('9', 'docu9', 'color9', '150', 'commodiry9', '200', '1', '500', 'out_mater9', 'in_mart9', '1');
INSERT INTO `t_clothes` VALUES ('10', 'docu10', 'color10', '150', 'commodiry10', '200', '1', '500', 'out_mater10', 'in_mart10', '1');
INSERT INTO `t_clothes` VALUES ('11', 'docu11', 'color11', '150', 'commodiry11', '200', '1', '500', 'out_mater11', 'in_mart11', '1');
INSERT INTO `t_clothes` VALUES ('12', 'docu12', 'color12', '150', 'commodiry12', '200', '1', '500', 'out_mater12', 'in_mart12', '1');
INSERT INTO `t_clothes` VALUES ('13', 'docu13', 'color13', '150', 'commodiry13', '200', '1', '500', 'out_mater13', 'in_mart13', '1');
INSERT INTO `t_clothes` VALUES ('14', 'docu14', 'color14', '150', 'commodiry14', '200', '1', '500', 'out_mater14', 'in_mart14', '1');
INSERT INTO `t_clothes` VALUES ('15', 'docu15', 'color15', '150', 'commodiry15', '200', '1', '500', 'out_mater15', 'in_mart15', '1');
INSERT INTO `t_clothes` VALUES ('16', 'docu16', 'color16', '150', 'commodiry16', '200', '1', '500', 'out_mater16', 'in_mart16', '1');
INSERT INTO `t_clothes` VALUES ('17', 'docu17', 'color17', '150', 'commodiry17', '200', '1', '500', 'out_mater17', 'in_mart17', '1');
INSERT INTO `t_clothes` VALUES ('18', 'docu18', 'color18', '150', 'commodiry18', '200', '1', '500', 'out_mater18', 'in_mart18', '1');
INSERT INTO `t_clothes` VALUES ('19', 'docu19', 'color19', '150', 'commodiry19', '200', '1', '500', 'out_mater19', 'in_mart19', '1');
INSERT INTO `t_clothes` VALUES ('20', 'docu20', 'color20', '150', 'commodiry20', '200', '1', '500', 'out_mater20', 'in_mart20', '1');
INSERT INTO `t_clothes` VALUES ('23', 'BR1703', '黑色', '200', '中款大衣', '500', '1', '1000', '丝绸', '尼龙', '0');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `log` varchar(50) NOT NULL,
  `saveTime` datetime NOT NULL,
  `adminId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_T_log_T_admin_1` (`adminId`),
  CONSTRAINT `fk_T_log_T_admin_1` FOREIGN KEY (`adminId`) REFERENCES `t_admin` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('2', '成功删除仓库>>>>>>>>>', '2014-05-30 11:29:31', '1');
INSERT INTO `t_log` VALUES ('3', '成功添加货号>>>>>>>>BR1703', '2014-06-01 10:50:34', '1');
INSERT INTO `t_log` VALUES ('4', '成功添加货号>>>>>>>>BR1703', '2014-06-01 12:07:36', '1');
INSERT INTO `t_log` VALUES ('5', '成功修改货号>>>>>>>>BR1703', '2014-06-10 10:49:21', '1');
INSERT INTO `t_log` VALUES ('6', '成功修改货号>>>>>>>>BR1703', '2014-06-10 10:50:44', '1');
INSERT INTO `t_log` VALUES ('7', '成功删除货号>>>>>>>>>BR1703', '2014-06-10 11:05:34', '1');
INSERT INTO `t_log` VALUES ('8', '成功添加货号>>>>>>>>BR1703', '2014-06-10 11:11:49', '1');
INSERT INTO `t_log` VALUES ('10', '成功修改货号>>>>>>>>BR1703', '2014-06-10 11:15:49', '1');
INSERT INTO `t_log` VALUES ('17', '成功删除货号>>>>>>>>>BR1703', '2014-06-10 11:59:39', '1');

-- ----------------------------
-- Table structure for t_orderin
-- ----------------------------
DROP TABLE IF EXISTS `t_orderin`;
CREATE TABLE `t_orderin` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `docu_number` char(15) NOT NULL,
  `warehouseId` int(11) NOT NULL,
  `in_time` date NOT NULL,
  `manager` int(11) NOT NULL,
  `source` varchar(50) NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_OrderIn_Admin_1` (`manager`),
  KEY `fk_T_orderIn_T_wareHouse_1` (`warehouseId`),
  CONSTRAINT `fk_T_orderIn_T_wareHouse_1` FOREIGN KEY (`warehouseId`) REFERENCES `t_warehouse` (`Id`),
  CONSTRAINT `fk_OrderIn_Admin_1` FOREIGN KEY (`manager`) REFERENCES `t_admin` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderin
-- ----------------------------

-- ----------------------------
-- Table structure for t_orderout
-- ----------------------------
DROP TABLE IF EXISTS `t_orderout`;
CREATE TABLE `t_orderout` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `d_number` char(15) NOT NULL,
  `warehouse` int(11) NOT NULL,
  `out_time` date NOT NULL,
  `manager` int(11) NOT NULL,
  `send` varchar(50) NOT NULL COMMENT '发往地',
  `flat` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_T_orderOut_T_admin_1` (`manager`),
  CONSTRAINT `fk_T_orderOut_T_admin_1` FOREIGN KEY (`manager`) REFERENCES `t_admin` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderout
-- ----------------------------

-- ----------------------------
-- Table structure for t_stage
-- ----------------------------
DROP TABLE IF EXISTS `t_stage`;
CREATE TABLE `t_stage` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `clothes_id` int(11) NOT NULL,
  `stage_number` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `clothes_id` (`clothes_id`,`warehouse_id`),
  KEY `fk_T_stage_T_wareHouse_1` (`warehouse_id`),
  CONSTRAINT `fk_T_stage_T_wareHouse_1` FOREIGN KEY (`warehouse_id`) REFERENCES `t_warehouse` (`Id`),
  CONSTRAINT `fk_T_stage_T_clothes_1` FOREIGN KEY (`clothes_id`) REFERENCES `t_clothes` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stage
-- ----------------------------

-- ----------------------------
-- Table structure for t_superadmin
-- ----------------------------
DROP TABLE IF EXISTS `t_superadmin`;
CREATE TABLE `t_superadmin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_superadmin
-- ----------------------------
INSERT INTO `t_superadmin` VALUES ('1', 'superAdmin', '123', 'lin', '1');
INSERT INTO `t_superadmin` VALUES ('2', 'superadmin2', '123', 'lin', '1');
INSERT INTO `t_superadmin` VALUES ('3', 'lin', 'lin', 'lin', '1');

-- ----------------------------
-- Table structure for t_super_log
-- ----------------------------
DROP TABLE IF EXISTS `t_super_log`;
CREATE TABLE `t_super_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log` varchar(50) NOT NULL,
  `saveTime` datetime NOT NULL,
  `superAdminId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_T_supser_log_T_superAdmin_1` (`superAdminId`),
  CONSTRAINT `fk_T_supser_log_T_superAdmin_1` FOREIGN KEY (`superAdminId`) REFERENCES `t_superadmin` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_super_log
-- ----------------------------
INSERT INTO `t_super_log` VALUES ('2', '成功添加管理员', '2014-05-25 14:05:49', '1');
INSERT INTO `t_super_log` VALUES ('3', '成功添加管理员', '2014-05-25 14:12:52', '1');
INSERT INTO `t_super_log` VALUES ('4', '成功删除管理员', '2014-05-25 14:14:38', '1');
INSERT INTO `t_super_log` VALUES ('5', '成功删除管理员hong', '2014-05-25 14:15:56', '1');
INSERT INTO `t_super_log` VALUES ('6', '成功删除管理员>>>>>>>>>hong', '2014-05-25 14:17:06', '1');
INSERT INTO `t_super_log` VALUES ('7', '成功删除管理员>>>>>>>>>hong', '2014-05-25 14:33:55', '1');
INSERT INTO `t_super_log` VALUES ('8', '成功添加管理员>>>>>>>>hong', '2014-05-31 15:26:55', '1');
INSERT INTO `t_super_log` VALUES ('9', '成功添加管理员>>>>>>>>bin', '2014-05-31 15:28:59', '1');
INSERT INTO `t_super_log` VALUES ('10', '成功添加管理员>>>>>>>>xiaolin', '2014-05-31 15:31:36', '1');
INSERT INTO `t_super_log` VALUES ('11', '成功修改管理员>>>>>>>>username2', '2014-06-10 10:37:32', '1');

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `docu_number` char(5) NOT NULL,
  `contact_phone` char(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `total_storage` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
INSERT INTO `t_warehouse` VALUES ('1', 'do1', 'contact_phone1', 'name1', 'contact1', '800', '1');
INSERT INTO `t_warehouse` VALUES ('2', 'do2', 'contact_phone2', 'name2', 'contact2', '800', '1');
INSERT INTO `t_warehouse` VALUES ('3', 'do3', 'contact_phone3', 'name3', 'contact3', '800', '1');
INSERT INTO `t_warehouse` VALUES ('4', 'do4', 'contact_phone4', 'name4', 'contact4', '800', '1');
INSERT INTO `t_warehouse` VALUES ('5', 'do5', 'contact_phone5', 'name5', 'contact5', '800', '1');
INSERT INTO `t_warehouse` VALUES ('6', 'do6', 'contact_phone6', 'name6', 'contact6', '800', '1');
INSERT INTO `t_warehouse` VALUES ('7', 'do7', 'contact_phone7', 'name7', 'contact7', '800', '1');
INSERT INTO `t_warehouse` VALUES ('8', 'do8', 'contact_phone8', 'name8', 'contact8', '800', '1');
INSERT INTO `t_warehouse` VALUES ('9', 'do9', 'contact_phone9', 'name9', 'contact9', '800', '1');
INSERT INTO `t_warehouse` VALUES ('10', 'do10', 'contact_phone10', 'name10', 'contact10', '800', '1');
INSERT INTO `t_warehouse` VALUES ('11', 'do11', 'contact_phone11', 'name11', 'contact11', '800', '1');
INSERT INTO `t_warehouse` VALUES ('12', 'do12', 'contact_phone12', 'name12', 'contact12', '800', '1');
INSERT INTO `t_warehouse` VALUES ('13', 'do13', 'contact_phone13', 'name13', 'contact13', '800', '1');
INSERT INTO `t_warehouse` VALUES ('14', 'do14', 'contact_phone14', 'name14', 'contact14', '800', '1');
INSERT INTO `t_warehouse` VALUES ('15', 'do15', 'contact_phone15', 'name15', 'contact15', '800', '1');
INSERT INTO `t_warehouse` VALUES ('16', 'do16', 'contact_phone16', 'name16', 'contact16', '800', '1');
INSERT INTO `t_warehouse` VALUES ('17', 'do17', 'contact_phone17', 'name17', 'contact17', '800', '1');
INSERT INTO `t_warehouse` VALUES ('18', 'do18', 'contact_phone18', 'name18', 'contact18', '800', '1');
INSERT INTO `t_warehouse` VALUES ('19', 'do19', 'contact_phone19', 'name19', 'contact19', '800', '1');
INSERT INTO `t_warehouse` VALUES ('20', 'do20', 'contact_phone20', 'name20', 'contact20', '800', '1');
