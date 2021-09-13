-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.33 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 seckill 的数据库结构
DROP DATABASE IF EXISTS `seckill`;
CREATE DATABASE IF NOT EXISTS `seckill` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `seckill`;

-- 导出  表 seckill.t_goods 结构
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE IF NOT EXISTS `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_title` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `goods_img` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `goods_detail` varchar(255) DEFAULT NULL COMMENT '商品详情',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_stock` int(11) DEFAULT NULL COMMENT '商品库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  seckill.t_goods 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;
INSERT INTO `t_goods` (`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`) VALUES
	(1, '商品名称', '商品标题', 'null', '商品详情', 50000.00, 100);
/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;

-- 导出  表 seckill.t_order 结构
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE IF NOT EXISTS `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `deliver_addr_id` int(11) DEFAULT NULL COMMENT '收获地址ID',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `order_channel` int(11) DEFAULT NULL COMMENT '设备信息',
  `status` int(11) DEFAULT NULL COMMENT '订单状态',
  `create_date` datetime DEFAULT NULL COMMENT '订单创建时间',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  seckill.t_order 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` (`id`, `user_id`, `goods_id`, `deliver_addr_id`, `goods_name`, `goods_count`, `goods_price`, `order_channel`, `status`, `create_date`, `pay_date`) VALUES
	(1, 13911111110, 1, 1, '商品名称', 1, 0.00, 1, 0, '2021-09-13 15:06:21', NULL),
	(2, 13911111110, 1, 1, '商品名称', 1, 0.00, 1, 0, '2021-09-13 15:07:34', NULL),
	(3, 13911111110, 1, 1, '商品名称', 1, 0.00, 1, 0, '2021-09-13 15:11:19', NULL);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;

-- 导出  表 seckill.t_seckill_goods 结构
DROP TABLE IF EXISTS `t_seckill_goods`;
CREATE TABLE IF NOT EXISTS `t_seckill_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '秒杀商品ID',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `seckill_price` decimal(10,2) DEFAULT NULL COMMENT '秒杀价',
  `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
  `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  seckill.t_seckill_goods 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seckill_goods` DISABLE KEYS */;
INSERT INTO `t_seckill_goods` (`id`, `goods_id`, `seckill_price`, `stock_count`, `start_date`, `end_date`) VALUES
	(1, 1, 0.00, 98, '2021-09-13 12:30:00', '2030-01-01 00:00:00');
/*!40000 ALTER TABLE `t_seckill_goods` ENABLE KEYS */;

-- 导出  表 seckill.t_seckill_order 结构
DROP TABLE IF EXISTS `t_seckill_order`;
CREATE TABLE IF NOT EXISTS `t_seckill_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  seckill.t_seckill_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_seckill_order` DISABLE KEYS */;
INSERT INTO `t_seckill_order` (`id`, `user_id`, `order_id`, `goods_id`) VALUES
	(3, 13911111110, 3, 1);
/*!40000 ALTER TABLE `t_seckill_order` ENABLE KEYS */;

-- 导出  表 seckill.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '手机号码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '盐',
  `head` varchar(255) DEFAULT NULL COMMENT '头像',
  `register_date` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `login_count` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 正在导出表  seckill.t_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `nickname`, `password`, `salt`, `head`, `register_date`, `last_login_date`, `login_count`) VALUES
	(18811111111, '王二', 'b7797cce01b4b131b433b6acf4add449', '1a2b3c4d', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
