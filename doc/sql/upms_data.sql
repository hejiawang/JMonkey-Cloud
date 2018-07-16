/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : hjw_test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-16 14:52:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `url` varchar(128) DEFAULT NULL COMMENT '请求链接',
  `method` varchar(32) DEFAULT NULL COMMENT '请求方法',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `type` varchar(10) DEFAULT NULL COMMENT '菜单类型 （menu菜单 button按钮）',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('08eb98349be74fa78e0f1f5ea8a8c7eb', '查看用户', 'sys_user_find', null, '/upms/user/findDto/*', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '1', 'Button', '2018-07-10 20:05:02', null, '2018-07-10 20:54:44', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('0cf19ac6a3b44e659ae7a66a9d07fe92', '新增菜单', 'sys_menu_save', null, '/upms/menu/save', 'Post', '3ac69836b6e34c2282f22044c388877a', null, null, '1', 'Button', '2018-07-10 12:59:47', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('11244d99e8eb4a91b1e6a4e2e1613bc4', '密码重置', 'sys_user_restPasswsord', null, '/upms/user/restPasswsord/*', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '4', 'Button', '2018-07-10 20:04:19', null, '2018-07-10 20:54:35', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('15eb0bd66e274a04aa6606756d08ae1b', '用户管理', null, '/sys/user', '/upms/user/list', 'Get', '90ee8324659141d19f355e11c91158c4', '', '/sys/user/user', '1', 'Menu', '2018-07-10 12:53:26', null, '2018-07-13 09:34:47', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('25d6fdee896c4787a9e10aa4ab408362', '查看', 'sys_role_find', null, '/upms/role/find/*', 'Get', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '4', 'Button', '2018-07-10 20:33:21', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('3ac69836b6e34c2282f22044c388877a', '菜单管理', null, '/sys/menu', '/upms/menu/treeList', 'Get', '90ee8324659141d19f355e11c91158c4', null, '/sys/menu/menu', '3', 'Menu', '2018-07-10 12:55:46', null, '2018-07-13 09:34:59', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('5f89ba0de2fd4fad8ee1774896079e76', '选择角色', null, null, '/upms/role/listAll', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '7', 'Button', '2018-07-10 20:30:11', null, '2018-07-10 20:32:40', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('5fe71c7fecf94a7b872be462a9d101c3', '角色管理', null, '/sys/role', '/upms/role/list', 'Get', '90ee8324659141d19f355e11c91158c4', null, '/sys/role/role', '2', 'Menu', '2018-07-10 12:54:09', null, '2018-07-13 09:35:06', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('709a439428834e16a48eff60a08e5bf1', '删除', 'sys_role_delete', null, '/upms/role/delete/*', 'Delete', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '3', 'Button', '2018-07-10 20:32:26', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('74c73b6d090b4599953cb30643c6695a', '新增角色', 'sys_role_save', null, '/upms/role/save', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '1', 'Button', '2018-07-10 20:25:41', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('7ebd22562715417cb14b652baa3d482f', '删除', 'sys_menu_delete', null, '/upms/menu/delete/*', 'Delete', '3ac69836b6e34c2282f22044c388877a', null, null, '3', 'Button', '2018-07-10 13:02:08', null, '2018-07-10 20:02:19', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('809d6fc909454e4abbaeaae07f454b72', '检验name', null, null, '/upms/role/checkName', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '6', 'Button', '2018-07-10 20:34:48', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('81059eb947b04cd6a01bc28a96809718', '编辑', 'sys_menu_modify', null, '/upms/menu/modify', 'Put', '3ac69836b6e34c2282f22044c388877a', null, null, '2', 'Button', '2018-07-10 13:01:36', null, '2018-07-10 20:02:22', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('90ee8324659141d19f355e11c91158c4', '系统设置', null, null, null, 'Get', null, 'icon iconfont icon-set', null, '1', 'Menu', '2018-07-10 12:48:51', null, '2018-07-12 16:05:53', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('95d7be59a0ba42dca662d9bb3f048524', '编辑', 'sys_user_modify', null, '/upms/user/modify', 'Put', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '2', 'Button', '2018-07-10 20:01:02', null, '2018-07-10 20:01:55', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('9e65ad51116247e8965c1102a9aac01c', '编辑', 'sys_role_modify', null, '/upms/role/mofidy', 'Put', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '2', 'Button', '2018-07-10 20:26:39', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('a0d2940731aa45cea23c47a86f4e90e1', '授权菜单', 'sys_role_menu', null, '/upms/roleMenu/**', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '8', 'Button', '2018-07-10 20:36:56', null, '2018-07-12 10:56:39', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('b1c065676592432ea98064b6260561fe', '查看', 'sys_meun_find', null, '/upms/menu/find/*', 'Get', '3ac69836b6e34c2282f22044c388877a', null, null, '4', 'Button', '2018-07-10 13:03:17', null, '2018-07-10 20:02:25', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('d791fb3858ce432682f3b128ff89b807', '校验用户名', null, null, '/upms/user/checkUserName', 'Post', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '6', 'Button', '2018-07-10 20:08:04', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('e99c9dc0eaaa41a7a0bd6511d37fd9fe', '删除', 'sys_user_delete', null, '/upms/user/delete/*', 'Delete', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '3', 'Button', '2018-07-10 20:03:08', null, '2018-07-10 20:03:33', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('e9df6455bfbf42c9b65806c7f4517a33', '新增用户', 'sys_user_save', null, '/upms/user/save', 'Post', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '1', 'Button', '2018-07-10 20:00:16', null, '2018-07-10 20:00:34', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('efd33a5733324c08b0ae75b8b3a41e6f', '校验code', null, null, '/upms/role/checkCode', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '5', 'Button', '2018-07-10 20:34:14', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('f57ff19855304530a51ea874768f11e8', '修改角色', 'sys_user_role', null, '/upms/userRole/saveRoles', 'Post', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '8', 'Button', '2018-07-12 10:35:40', null, '2018-07-12 10:45:12', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('f58e05206e2f40f3a684237594cc5cd9', '授权菜单', null, null, '/upms/roleMenu/**', 'Get', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '7', 'Button', '2018-07-10 20:36:22', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('29989dcab60d493991309ca2c8bf80f0', '普通用户2', 'common2', '2018-07-06 15:17:08', null, '2018-07-06 15:17:15', null, 'common2', 'Used');
INSERT INTO `sys_role` VALUES ('34e0749f68e348dabd7ea7577f816657', '管理员', 'sys', '2018-07-06 14:28:06', null, null, null, '拥有部分权限', 'Used');
INSERT INTO `sys_role` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '超级管理员', 'admin', '2018-07-06 14:26:37', null, null, null, '拥有所有权限', 'Used');
INSERT INTO `sys_role` VALUES ('d2991a6e448143a589e6b7c084fa40ff', '普通用户', 'common', '2018-07-06 14:28:24', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('34e0749f68e348dabd7ea7577f816657', '5fe71c7fecf94a7b872be462a9d101c3', '2018-07-13 10:26:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('34e0749f68e348dabd7ea7577f816657', '74c73b6d090b4599953cb30643c6695a', '2018-07-13 10:26:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('34e0749f68e348dabd7ea7577f816657', '809d6fc909454e4abbaeaae07f454b72', '2018-07-13 10:26:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('34e0749f68e348dabd7ea7577f816657', '90ee8324659141d19f355e11c91158c4', '2018-07-13 10:26:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('34e0749f68e348dabd7ea7577f816657', 'efd33a5733324c08b0ae75b8b3a41e6f', '2018-07-13 10:26:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '08eb98349be74fa78e0f1f5ea8a8c7eb', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '0cf19ac6a3b44e659ae7a66a9d07fe92', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '11244d99e8eb4a91b1e6a4e2e1613bc4', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '15eb0bd66e274a04aa6606756d08ae1b', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '25d6fdee896c4787a9e10aa4ab408362', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '3ac69836b6e34c2282f22044c388877a', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '5f89ba0de2fd4fad8ee1774896079e76', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '5fe71c7fecf94a7b872be462a9d101c3', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '709a439428834e16a48eff60a08e5bf1', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '74c73b6d090b4599953cb30643c6695a', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '7ebd22562715417cb14b652baa3d482f', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '809d6fc909454e4abbaeaae07f454b72', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '81059eb947b04cd6a01bc28a96809718', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '90ee8324659141d19f355e11c91158c4', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '95d7be59a0ba42dca662d9bb3f048524', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '9e65ad51116247e8965c1102a9aac01c', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'a0d2940731aa45cea23c47a86f4e90e1', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'b1c065676592432ea98064b6260561fe', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'd791fb3858ce432682f3b128ff89b807', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'e99c9dc0eaaa41a7a0bd6511d37fd9fe', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'e9df6455bfbf42c9b65806c7f4517a33', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'efd33a5733324c08b0ae75b8b3a41e6f', '2018-07-12 16:59:11', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'f57ff19855304530a51ea874768f11e8', '2018-07-12 16:59:10', null, null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'f58e05206e2f40f3a684237594cc5cd9', '2018-07-12 16:59:11', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `salt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '随机盐',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `real_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真是姓名',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别 man男 woman女 other其他',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('25edbaf722584f5ca4ca4674eb586e39', 'sys', '$2a$10$oJsPW9G71ZBypppM9ouGnOJI2qmEr5m./g7aCGyy19oWGVY2./Aga', null, '13333333333', '管理员', '2018-07-02', 'Man', '2018-07-13 13:28:45', null, null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('f09f3be336c24b8cb651dff39a418a92', 'admin', '$2a$10$Ni0mYwPi7Jdi9n5deQTQl.0/ai5RL75JVb.73/vgvPRp.Pm8n7.rS', null, '13888888888', '超级管理员', null, 'Other', '2018-07-10 12:46:28', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('25edbaf722584f5ca4ca4674eb586e39', '34e0749f68e348dabd7ea7577f816657', '2018-07-13 13:28:45', null, null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('f09f3be336c24b8cb651dff39a418a92', 'af045b96b3464049ac6c885c4b2c96a8', '2018-07-10 12:46:28', null, null, null, null, 'Used');
