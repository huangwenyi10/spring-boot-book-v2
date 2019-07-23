-- ----------------------------
-- 用户表
-- Table structure for ay_user
-- ----------------------------
DROP TABLE IF EXISTS `ay_user`;
CREATE TABLE `ay_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(10) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码'
);

INSERT INTO `ay_user` (`id`, `name`, `password`) VALUES ('1', '阿毅', '123456');
INSERT INTO `ay_user` (`id`, `name`, `password`) VALUES ('2', '阿兰', '123456');
