/*
Navicat MySQL Data Transfer

Source Server         : wp
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : girl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-09 11:48:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_cargo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cargo`;
CREATE TABLE `tb_cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_number` int(11) DEFAULT NULL COMMENT '货位号',
  `storage_site` varchar(255) DEFAULT NULL COMMENT '存储地点',
  `warehouse_name` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `assortment` varchar(255) DEFAULT NULL COMMENT '品种',
  `storage_mode` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `manager` varchar(255) DEFAULT NULL COMMENT '管理员',
  `is_active` varchar(255) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货位表';

-- ----------------------------
-- Records of tb_cargo
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plant_id` int(11) DEFAULT NULL COMMENT '植物id',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `revier` varchar(255) DEFAULT NULL COMMENT '评论者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_daily`
-- ----------------------------
DROP TABLE IF EXISTS `tb_daily`;
CREATE TABLE `tb_daily` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL,
  `dept` int(11) DEFAULT NULL COMMENT '追求简单，冗余设计',
  `work_result` varchar(255) DEFAULT NULL COMMENT '工作成果',
  `submit_content` varchar(255) DEFAULT NULL COMMENT '提交内容',
  `content_description` varchar(255) DEFAULT NULL COMMENT '内容说明',
  `plan_start_date` varchar(255) DEFAULT NULL COMMENT '计划开始时间',
  `plan_end_date` varchar(255) DEFAULT NULL COMMENT '计划结束时间',
  `work_schedule` varchar(255) DEFAULT NULL COMMENT '工作进度',
  `demo_address` varchar(255) DEFAULT NULL COMMENT '演示地址',
  `claim` int(1) DEFAULT NULL COMMENT '标准和要求(1:合格0:不合格)',
  `plan_b` varchar(255) DEFAULT NULL COMMENT '未完成不就措施',
  `submitter` varchar(255) DEFAULT NULL COMMENT '提交人',
  `look_role` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_daily
-- ----------------------------
INSERT INTO `tb_daily` VALUES ('17', '1', '2', '开发智慧系统', '无', '完成', '2018-08-27', '2018-08-27', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('18', '1', '1', '开发智慧系统', 'svn', '完成', '2018-08-27', '2018-08-27', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('19', '1', '1', '开发智慧系统', 'svn', '进行中', '2018-08-27', '2018-09-10', '100%', '我的电脑', '1', '明天再写', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('20', '1', '1', '开发智慧系统', '无', '完成', '2018-08-29', '2018-08-29', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('21', '73', null, '学习工具', 'svn', '进行中', '2018-08-27', '2018-08-29', '100%', '我的电脑', '0', '无', 'admin', '2', '无', '2018-12-24 20:32:08', '2018-12-24 20:32:08');
INSERT INTO `tb_daily` VALUES ('22', '1', '5', '开发智慧系统', 'SVN', '进行中', '2018-08-27', '2018-08-27', '100', '我的电脑', '0', '无', 'admin', '1', '无', '2018-12-21 22:37:35', '2018-12-21 22:37:35');
INSERT INTO `tb_daily` VALUES ('23', '1', '3', '开发智慧系统', 'svn', '完成', '2018-08-27', '2018-08-27', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('25', '1', '5', '开发智慧系统', '无', '完成', '2018-08-27', '2018-08-27', '90', '我的电脑', '1', '明天再写', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('34', '1', '1', '开发智慧系统', '无', '完成', '2018-08-28', '2018-08-28', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2019-03-09 11:42:54', '2019-03-09 11:42:54');
INSERT INTO `tb_daily` VALUES ('37', '1', '3', '开发智慧系统', '无', '进行中', '2018-08-28', '2018-08-30', '50%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('38', '1', '3', '开发智慧系统', '无', '进行中', '2018-08-28', '2018-08-30', '60%', '我的电脑', '1', '明天再写', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('40', '1', '5', '开发智慧系统', '无', '完成', '2018-08-28', '2018-08-28', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('41', '1', '5', '开发智慧系统', '无', '完成', '2018-08-28', '2018-08-28', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('42', '1', '4', '开发智慧系统', '无', '完成', '2018-08-20', '2018-08-28', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('44', '1', null, '开发智慧系统', '无', '完成111', '2018-08-28', '2018-08-28', '100%', '我的电脑', '1', '无', 'admin', '2', '无', '2019-03-09 11:44:43', null);
INSERT INTO `tb_daily` VALUES ('46', '1', '4', '开发智慧系统', '无', '完成', '2018-08-28', '2018-08-28', '100%', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('47', '1', '2', '开发智慧系统', '无', '已完成', '2018-08-28', '2018-08-28', '100', '我的电脑', '1', '无', 'admin', '1', '无', '2018-12-21 22:36:59', '2018-12-21 22:36:59');
INSERT INTO `tb_daily` VALUES ('48', '1', '2', '开发智慧系统', '无', '进行中', '2018-08-28', '2018-08-31', '10%', '我的电脑', '0', '明天再写', 'admin', '1', '无', '2018-12-24 20:32:35', '2018-12-24 20:32:35');
INSERT INTO `tb_daily` VALUES ('49', '1', '2', '开发智慧系统', 'bug', 'bug记录', '2018-08-28', '2018-08-28', '100%', '我的电脑', '0', '无', 'admin', '1', '无', '2018-12-24 20:32:05', '2018-12-24 20:32:05');
INSERT INTO `tb_daily` VALUES ('50', '1', '4', '开发智慧系统', '无', '已完成', '2018-08-28', '2018-08-28', '100%', '我的电脑', '0', '无', 'admin', '1', '无', '2018-12-24 20:26:28', '2018-12-24 20:26:28');
INSERT INTO `tb_daily` VALUES ('51', '1', null, '搭建layui系统', '111', '21211', '2019-03-09', '2019-03-09', '100%', '111', '1', '111', 'admin', '2', '1111', '2019-03-09 11:44:32', '2019-03-09 11:44:32');

-- ----------------------------
-- Table structure for `tb_dynamic_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_dynamic_info`;
CREATE TABLE `tb_dynamic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plant_no` int(11) DEFAULT NULL COMMENT '粮食编号',
  `basic_state` varchar(255) DEFAULT NULL COMMENT '基本情况',
  `is_ill` varchar(255) DEFAULT NULL COMMENT '是否生病',
  `checker` varchar(255) DEFAULT NULL COMMENT '检查人',
  `is_move` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dynamic_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_exiting`
-- ----------------------------
DROP TABLE IF EXISTS `tb_exiting`;
CREATE TABLE `tb_exiting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grain_number` int(11) DEFAULT NULL COMMENT '粮食编号',
  `out_num` int(255) DEFAULT NULL COMMENT '出库数量',
  `out_Time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `isactive` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='出库表';

-- ----------------------------
-- Records of tb_exiting
-- ----------------------------
INSERT INTO `tb_exiting` VALUES ('23', '1', '60', '2018-12-22 17:47:58', '是', '出库');
INSERT INTO `tb_exiting` VALUES ('24', '1', '50', '2018-12-22 19:39:08', '是', '出库');
INSERT INTO `tb_exiting` VALUES ('25', '4', '20', '2018-12-22 19:39:19', '是', '出库');
INSERT INTO `tb_exiting` VALUES ('26', '1', '40', '2018-12-22 19:39:27', '是', '出库');

-- ----------------------------
-- Table structure for `tb_ining`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ining`;
CREATE TABLE `tb_ining` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `grain_number` varchar(11) DEFAULT NULL COMMENT '粮食编号',
  `in_number` int(255) DEFAULT NULL COMMENT '入库数量',
  `storage_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='入库表';

-- ----------------------------
-- Records of tb_ining
-- ----------------------------
INSERT INTO `tb_ining` VALUES ('18', '1', '50', '2018-12-22 17:47:58', '入库');
INSERT INTO `tb_ining` VALUES ('19', '1', '50', '2018-12-22 19:39:08', '入库');
INSERT INTO `tb_ining` VALUES ('20', '4', '80', '2018-12-22 19:39:19', '入库');
INSERT INTO `tb_ining` VALUES ('21', '1', '80', '2018-12-22 19:39:27', '入库');

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '后台首页', 'icon-computer', 'page/main.html', '2018-11-09 16:23:48');
INSERT INTO `tb_menu` VALUES ('2', '计划列表', 'icon-text', 'news', '2018-12-21 22:30:52');
INSERT INTO `tb_menu` VALUES ('3', '员工管理', 'icon-text', 'userlists', '2018-11-20 10:44:17');
INSERT INTO `tb_menu` VALUES ('4', '友情链接', '&#xe64c;', 'page/links/linksList.html', '2018-11-09 16:23:48');
INSERT INTO `tb_menu` VALUES ('6', '系统参数', '&#xe631;', 'page/systemParameter/systemParameter.html', '2018-12-22 16:48:08');
INSERT INTO `tb_menu` VALUES ('7', '出库管理', '&#xe630;', 'exitings', '2018-12-22 16:47:48');
INSERT INTO `tb_menu` VALUES ('8', '入库管理', '&#xe630;', 'inings', '2018-12-22 16:47:53');
INSERT INTO `tb_menu` VALUES ('9', '存储信息', '&#xe630;', 'quantitys', '2018-12-22 16:48:30');
INSERT INTO `tb_menu` VALUES ('11', '粮食信息', '&#xe630;', 'plantInfos', '2018-12-22 16:50:00');
INSERT INTO `tb_menu` VALUES ('13', '货位信息', '&#xe630;', '', '2018-12-22 16:38:47');
INSERT INTO `tb_menu` VALUES ('14', '检测报告', '&#xe630;', '', '2018-12-22 16:38:52');
INSERT INTO `tb_menu` VALUES ('16', '其他页面', '&#xe630;', '', '2018-12-21 15:40:49');
INSERT INTO `tb_menu` VALUES ('17', '智慧公告', '&#xe630;', '', '2018-12-22 16:47:36');
INSERT INTO `tb_menu` VALUES ('18', '粮食资讯', '&#xe630;', '', '2018-12-22 16:50:34');

-- ----------------------------
-- Table structure for `tb_news`
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `is_top` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `hit` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_notice`
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice` (
  `id` int(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_asses` varchar(255) DEFAULT NULL COMMENT '1审核，2未审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(255) DEFAULT NULL COMMENT '订单号',
  `stuname` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `confirm_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `manager` varchar(255) DEFAULT NULL COMMENT '管理员',
  `isactive` varchar(255) DEFAULT NULL COMMENT '激活状态',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_plant_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_plant_info`;
CREATE TABLE `tb_plant_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plant_no` int(11) DEFAULT NULL COMMENT '粮食编号',
  `plant_name` varchar(255) DEFAULT NULL COMMENT '植物名称',
  `gsno` varchar(111) DEFAULT NULL COMMENT '类别所属',
  `prodarea` varchar(255) DEFAULT NULL COMMENT '产地分布',
  `ecolhabit` varchar(255) DEFAULT NULL COMMENT '生态习性',
  `image_path` varchar(255) DEFAULT NULL,
  `dimen_code` varchar(255) DEFAULT NULL COMMENT '二维码',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_state` varchar(255) DEFAULT NULL COMMENT '是否发布',
  `remark` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_plant_info
-- ----------------------------
INSERT INTO `tb_plant_info` VALUES ('1', '1', '小麦', '单子叶植物', '全国地区', '不详', 'images/xiaomai1.jpg', 'images/xiaomi2.jpg', '2018-12-21 22:04:07', '2018-12-21 22:04:07', '1', '富含淀粉、蛋白质、脂肪', 'admin');
INSERT INTO `tb_plant_info` VALUES ('2', '2', '大米', '生禾本科植物', '南方', '不详', ' images/dami1.jpg', '  images/dami2.jpg', '2018-12-21 22:04:24', '2018-12-21 22:04:27', '1', '叶长而扁，圆锥花序', 'admin');
INSERT INTO `tb_plant_info` VALUES ('3', '3', '棉花', '锦葵科棉属植物', '亚热带', '不详', ' images/mianhua1.jpg', ' images/mianhua2.jpg', '2018-12-21 22:05:36', '2018-12-21 22:05:42', '1', '花朵乳白色', 'admin');
INSERT INTO `tb_plant_info` VALUES ('4', '4', '玉米', '禾本科玉蜀黍族', '北方', '不详', ' images/yumi1.jpg', '  images/yumi2.jpg', '2018-12-21 22:06:39', '2018-12-21 22:06:42', '1', '玉茭、苞米、苞谷', 'admin');
INSERT INTO `tb_plant_info` VALUES ('5', '5', '大豆', '一年生草本植物', '中国', '不详', ' images/dadou1.jpg', '  images/dadou2.jpg', '2018-12-21 22:07:40', '2018-12-21 22:07:42', '1', '重要粮食作物', 'admin');
INSERT INTO `tb_plant_info` VALUES ('6', '6', '青稞', '禾本科', '中国', '不详', ' ', ' ', '2018-12-21 22:08:53', '2018-12-21 22:08:53', '1', '藏族人民的主要粮食', 'admin');
INSERT INTO `tb_plant_info` VALUES ('7', '7', '马铃薯', '茄科茄属', '南方', '不详', ' ', ' ', '2018-12-21 22:09:56', '2018-12-21 22:09:56', '1', '补气恢复体力的功效', 'admin');
INSERT INTO `tb_plant_info` VALUES ('8', '8', '高粱', '禾本科', '东北各地', '不详', ' ', ' ', '2018-12-21 22:10:47', '2018-12-21 22:10:47', '1', '高粱的谷粒主要供食用、酿酒', 'admin');
INSERT INTO `tb_plant_info` VALUES ('9', '9', '谷子', '禾本科', '黄河中上游', '不详', '  ', '  ', '2018-12-21 22:11:19', '2018-12-21 22:11:21', '1', '古称稷、粟，亦称粱', 'admin');
INSERT INTO `tb_plant_info` VALUES ('10', '10', '油菜', '芸薹属植物', '中国', '不详', ' ', ' ', '2018-12-21 22:12:21', '2018-12-21 22:12:24', '1', '维生素C含量很高。', 'admin');

-- ----------------------------
-- Table structure for `tb_quality`
-- ----------------------------
DROP TABLE IF EXISTS `tb_quality`;
CREATE TABLE `tb_quality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grade` int(255) DEFAULT NULL,
  `unit_weight` double DEFAULT NULL COMMENT '容重',
  `moisture` varchar(255) DEFAULT NULL COMMENT '水分',
  `impurity` varchar(255) DEFAULT NULL COMMENT '杂质',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `checker` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_quality
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_quantity`
-- ----------------------------
DROP TABLE IF EXISTS `tb_quantity`;
CREATE TABLE `tb_quantity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plant_id` int(255) DEFAULT NULL,
  `in_quantity` int(255) DEFAULT NULL COMMENT '入库量',
  `out_quantity` int(255) DEFAULT NULL COMMENT '出库量',
  `total_quantity` int(255) DEFAULT NULL COMMENT '总数量',
  `difference` int(255) DEFAULT NULL COMMENT '差数',
  `gradient` int(255) DEFAULT NULL COMMENT '差率',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `checker` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_quantity
-- ----------------------------
INSERT INTO `tb_quantity` VALUES ('1', '1', '380', '250', '130', '0', '0', '2018-12-22 17:47:01', '2018-12-22 17:47:01', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('2', '2', '200', '100', '100', '0', '0', '2018-12-22 13:01:07', '2018-12-22 13:01:07', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('3', '3', '200', '100', '100', '0', '0', '2018-12-22 10:30:33', '2018-12-22 10:30:33', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('4', '4', '280', '120', '160', '0', '0', '2018-12-22 10:30:34', '2018-12-22 10:30:34', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('5', '5', '200', '100', '100', '0', '0', '2018-12-22 10:30:35', '2018-12-22 10:30:35', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('6', '6', '200', '100', '100', '0', '0', '2018-12-22 10:30:35', '2018-12-22 10:30:35', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('7', '7', '200', '100', '100', '0', '0', '2018-12-22 10:30:37', '2018-12-22 10:30:37', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('8', '8', '210', '120', '90', '0', '0', '2018-12-22 10:30:37', '2018-12-22 10:30:37', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('9', '9', '200', '100', '100', '0', '0', '2018-12-22 10:30:39', '2018-12-22 10:30:39', 'admin', '1', '挺好的');
INSERT INTO `tb_quantity` VALUES ('10', '10', '200', '100', '100', '0', '0', '2018-12-22 10:30:41', '2018-12-22 10:30:41', 'admin', '1', '挺好的');

-- ----------------------------
-- Table structure for `tb_reply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) DEFAULT NULL COMMENT '评论id',
  `content` varchar(255) DEFAULT NULL COMMENT '回复',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `replyer` varchar(255) DEFAULT NULL COMMENT '回复者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'admin', '2018-11-09 16:31:01');
INSERT INTO `tb_role` VALUES ('2', 'emp', '2018-11-09 16:31:10');

-- ----------------------------
-- Table structure for `tb_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) DEFAULT NULL,
  `menu_id` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('1', '1', '1', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('2', '1', '2', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('3', '1', '3', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('4', '1', '5', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('5', '1', '6', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('6', '2', '1', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('7', '2', '2', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('8', '2', '5', '2018-11-09 16:34:39');
INSERT INTO `tb_role_menu` VALUES ('9', '2', '6', '2018-11-09 16:34:39');

-- ----------------------------
-- Table structure for `tb_shape`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shape`;
CREATE TABLE `tb_shape` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grain_form` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '粮食形状',
  `longness` double(255,2) DEFAULT NULL COMMENT '长',
  `width` double(255,2) DEFAULT NULL COMMENT '宽',
  `checktime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `checker` varchar(255) DEFAULT NULL,
  `isactive` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='形状表';

-- ----------------------------
-- Records of tb_shape
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_log`;
CREATE TABLE `tb_sys_log` (
  `id` int(255) NOT NULL,
  `module_name` varchar(255) DEFAULT '' COMMENT '操作模块',
  `actionname` varchar(255) DEFAULT NULL COMMENT '操作动作',
  `message` varchar(255) DEFAULT NULL COMMENT '操作信息',
  `username` varchar(255) DEFAULT NULL COMMENT '操作者',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `carete_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) DEFAULT NULL,
  `dept` int(10) DEFAULT '1' COMMENT '1:后台组',
  `rule` int(11) DEFAULT '0' COMMENT '系统角色，1:管理员，2：员工',
  `status` int(11) DEFAULT NULL COMMENT '1：正常使用 0.不能使用',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'gVUXndLQ5n6u4tnpu/6bJw==', '软萌妹', null, '1', '1', '2018-12-21 15:16:59', '2018-12-21 15:16:59', '2222');
INSERT INTO `tb_user` VALUES ('67', '暗室逢灯', 'gVUXndLQ5n6u4tnpu/6bJw==', '纯爷们', null, '1', '1', '2018-12-21 14:58:25', '2018-12-21 14:58:25', null);
INSERT INTO `tb_user` VALUES ('71', 'emp', null, '软萌妹', null, '1', '1', '2018-12-21 23:15:16', null, '22');
INSERT INTO `tb_user` VALUES ('76', '66', 'gVUXndLQ5n6u4tnpu/6bJw==', '软萌妹', null, '2', '1', '2018-12-22 17:36:35', '2018-12-22 17:36:35', '66');

-- ----------------------------
-- Table structure for `tb_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1', '1', '2018-11-09 16:31:36');
INSERT INTO `tb_user_role` VALUES ('2', '2', '2', '2018-11-09 16:31:45');
