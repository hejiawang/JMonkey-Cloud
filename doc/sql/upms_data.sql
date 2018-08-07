/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : hjw_test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-06 14:30:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `parent_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级部门ID,null为顶级部门',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '部门名称',
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '部门编码',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='部门信息';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('26097ba1e4f146bf88cbaf809d06af1a', 'a556dad16add40f69716245cfa2ef637', '财务', 'A002', '1', '2018-07-31 16:01:58', 'admin', null, null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('a556dad16add40f69716245cfa2ef637', '', '啥啥啥机构', 'A001', '1', '2018-07-31 16:01:45', 'admin', null, null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('bdd5e05378044ae29f4f75ce896cfbb5', 'a556dad16add40f69716245cfa2ef637', '人资', 'A003', '1', '2018-07-31 16:02:14', 'admin', null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `type` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='字典类型';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('8528601eead24db78904fc0f3c1bad73', 'sys_test', '2018-08-06 10:01:38', 'admin', '2018-08-06 10:07:26', null, '测试类型', 'Used');
INSERT INTO `sys_dict_type` VALUES ('dc046539325d4df3ba4b6778d3a27c4a', 'sys_user_sex', '2018-08-06 09:55:35', 'admin', '2018-08-06 10:01:19', 'admin', '用户性别1', 'Used');

-- ----------------------------
-- Table structure for sys_dict_value
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_value`;
CREATE TABLE `sys_dict_value` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `type_id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型ID',
  `lable` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '字典标签',
  `value` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '字典键值',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='字典值';

-- ----------------------------
-- Records of sys_dict_value
-- ----------------------------
INSERT INTO `sys_dict_value` VALUES ('1e7f173bde9346599d8a98dbe8ce6ad2', 'dc046539325d4df3ba4b6778d3a27c4a', '男', 'man', '1', '2018-08-06 10:05:06', 'admin', null, null, null, 'Used');
INSERT INTO `sys_dict_value` VALUES ('8dac728afe8c4f3fa80bd9cfe2667bb1', 'dc046539325d4df3ba4b6778d3a27c4a', '女', 'woman', '2', '2018-08-06 10:05:23', 'admin', null, null, null, 'Used');
INSERT INTO `sys_dict_value` VALUES ('b5af2665e8df4ef0ab4a150c61c748b1', 'dc046539325d4df3ba4b6778d3a27c4a', '其他', 'other', '3', '2018-08-06 10:05:41', 'admin', '2018-08-06 10:07:58', 'admin', null, 'Used');
INSERT INTO `sys_dict_value` VALUES ('f7019fc0a5314d25bd4506925d3d07a2', 'dc046539325d4df3ba4b6778d3a27c4a', '其他', 'other1', '3', '2018-08-06 10:05:33', 'admin', '2018-08-06 10:05:53', 'admin', null, 'Delete');

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
INSERT INTO `sys_menu` VALUES ('00626eab9be44170b004300450f1bbaa', '字典值', 'sys_dict_type_value', '', '/upms/dict/value/listAll', 'Get', '9b63e1df382a48f7bec5964b058de040', '', '', '5', 'Button', '2018-08-06 09:16:43', 'admin', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('01279c73a7934ba68da681bca7d7da49', '新增', 'sys_dept_save', '', '/upms/dept/**', 'Post', 'c41a29b667154d0aa1f86434a4ab31a5', '', '', '1', 'Button', '2018-07-25 14:39:35', 'admin', '2018-07-25 14:40:28', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('018990e163714e5bb2055f6fb313b30f', '新增', 'sys_dict_type_save', '', '/upms/dict/type/**', 'Post', '9b63e1df382a48f7bec5964b058de040', '', '', '1', 'Button', '2018-08-06 09:06:39', 'admin', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('08eb98349be74fa78e0f1f5ea8a8c7eb', '查看用户', 'sys_user_find', null, '/upms/user/findDto/*', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '1', 'Button', '2018-07-10 20:05:02', null, '2018-07-10 20:54:44', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('0cf19ac6a3b44e659ae7a66a9d07fe92', '新增菜单', 'sys_menu_save', null, '/upms/menu/save', 'Post', '3ac69836b6e34c2282f22044c388877a', null, null, '1', 'Button', '2018-07-10 12:59:47', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('11244d99e8eb4a91b1e6a4e2e1613bc4', '密码重置', 'sys_user_restPasswsord', null, '/upms/user/restPasswsord/*', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '4', 'Button', '2018-07-10 20:04:19', null, '2018-07-10 20:54:35', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('15eb0bd66e274a04aa6606756d08ae1b', '用户管理', null, '/sys/user', '/upms/user/list', 'Get', '90ee8324659141d19f355e11c91158c4', '', '/sys/user/user', '1', 'Menu', '2018-07-10 12:53:26', null, '2018-07-13 09:34:47', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('248094a4cdcb43f097aacf31fec5343b', '导出用户', 'sys_user_export', '', '/upms/user/listAll', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', '', '', '10', 'Button', '2018-07-26 13:50:59', 'admin', '2018-07-26 13:51:09', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('25d6fdee896c4787a9e10aa4ab408362', '查看', 'sys_role_find', null, '/upms/role/find/*', 'Get', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '4', 'Button', '2018-07-10 20:33:21', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('315b00c6fb2d4eb999ab52e5ce282216', '删除字典值', 'sys_dict_value_delete', '', '/upms/dict/value/**', 'Delete', '9b63e1df382a48f7bec5964b058de040', '', '', '8', 'Button', '2018-08-06 09:23:26', 'admin', '2018-08-06 09:23:55', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('3ac69836b6e34c2282f22044c388877a', '菜单管理', null, '/sys/menu', '/upms/menu/treeList', 'Get', '90ee8324659141d19f355e11c91158c4', null, '/sys/menu/menu', '3', 'Menu', '2018-07-10 12:55:46', null, '2018-07-13 09:34:59', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('5f89ba0de2fd4fad8ee1774896079e76', '选择角色', null, null, '/upms/role/listAll', 'Get', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '7', 'Button', '2018-07-10 20:30:11', null, '2018-07-10 20:32:40', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('5fe71c7fecf94a7b872be462a9d101c3', '角色管理', null, '/sys/role', '/upms/role/list', 'Get', '90ee8324659141d19f355e11c91158c4', null, '/sys/role/role', '2', 'Menu', '2018-07-10 12:54:09', null, '2018-07-13 09:35:06', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('628d7bd579ff4abaaf72ac8db84732c2', '删除', 'sys_dept_delete', '', '/upms/dept/**', 'Delete', 'c41a29b667154d0aa1f86434a4ab31a5', '', '', '1', 'Button', '2018-07-25 14:41:36', 'admin', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('63570d04419e468f829005c5c5c0ba31', '修改', 'sys_dept_modify', '', '/upms/dept/**', 'Put', 'c41a29b667154d0aa1f86434a4ab31a5', '', '', '1', 'Button', '2018-07-25 14:40:07', 'admin', '2018-07-25 14:40:18', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('6f1ed330fdde436b9dcfc56040b0cbbc', '查找', 'sys_dept_find', '', '/upms/dept/**', 'Get', 'c41a29b667154d0aa1f86434a4ab31a5', '', '', '1', 'Button', '2018-07-25 14:40:55', 'admin', '2018-07-25 14:41:02', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('709a439428834e16a48eff60a08e5bf1', '删除', 'sys_role_delete', null, '/upms/role/delete/*', 'Delete', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '3', 'Button', '2018-07-10 20:32:26', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('70ed5fd046a0497488b331bb0094840a', '测试菜单', '', '/homeTest', '', 'Get', '', 'icon iconfont icon-main', '/home/home', '3', 'Menu', '2018-07-20 13:54:02', null, '2018-07-20 13:55:20', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('74c73b6d090b4599953cb30643c6695a', '新增角色', 'sys_role_save', null, '/upms/role/save', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '1', 'Button', '2018-07-10 20:25:41', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('7ebd22562715417cb14b652baa3d482f', '删除', 'sys_menu_delete', null, '/upms/menu/delete/*', 'Delete', '3ac69836b6e34c2282f22044c388877a', null, null, '3', 'Button', '2018-07-10 13:02:08', null, '2018-07-10 20:02:19', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('809d6fc909454e4abbaeaae07f454b72', '检验name', null, null, '/upms/role/checkName', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '6', 'Button', '2018-07-10 20:34:48', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('81059eb947b04cd6a01bc28a96809718', '编辑', 'sys_menu_modify', null, '/upms/menu/modify', 'Put', '3ac69836b6e34c2282f22044c388877a', null, null, '2', 'Button', '2018-07-10 13:01:36', null, '2018-07-10 20:02:22', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('8fb6fd527f734c439d9600a3fddd4b7d', '上传头像', null, null, '/upms/user/uploadPhoto', 'Post', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '9', 'Button', '2018-07-19 10:40:20', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('90ee8324659141d19f355e11c91158c4', '系统设置', null, null, null, 'Get', null, 'icon iconfont icon-set', null, '2', 'Menu', '2018-07-10 12:48:51', null, '2018-07-20 13:16:05', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('95d7be59a0ba42dca662d9bb3f048524', '编辑', 'sys_user_modify', null, '/upms/user/modify', 'Put', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '2', 'Button', '2018-07-10 20:01:02', null, '2018-07-10 20:01:55', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('9b63e1df382a48f7bec5964b058de040', '字典管理', '', '/sys/dict', '/upms/dict/type/list', 'Get', '90ee8324659141d19f355e11c91158c4', '', '/sys/dict/dict', '5', 'Menu', '2018-08-06 09:03:00', 'admin', '2018-08-06 09:05:02', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('9e65ad51116247e8965c1102a9aac01c', '编辑', 'sys_role_modify', null, '/upms/role/mofidy', 'Put', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '2', 'Button', '2018-07-10 20:26:39', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('a0d2940731aa45cea23c47a86f4e90e1', '授权菜单', 'sys_role_menu', null, '/upms/roleMenu/**', 'Post', '5fe71c7fecf94a7b872be462a9d101c3', null, null, '8', 'Button', '2018-07-10 20:36:56', null, '2018-07-12 10:56:39', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('aeb8703b44754eac9594eb1ba7e6bd48', '删除', 'sys_dict_type_delete', '', '/upms/dict/type/**', 'Delete', '9b63e1df382a48f7bec5964b058de040', '', '', '3', 'Button', '2018-08-06 09:08:53', 'admin', '2018-08-06 09:09:27', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('b1c065676592432ea98064b6260561fe', '查看', 'sys_meun_find', null, '/upms/menu/find/*', 'Get', '3ac69836b6e34c2282f22044c388877a', null, null, '4', 'Button', '2018-07-10 13:03:17', null, '2018-07-10 20:02:25', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('c41a29b667154d0aa1f86434a4ab31a5', '部门管理', '', '/sys/dept', '/upms/dept/treeList ', 'Get', '90ee8324659141d19f355e11c91158c4', '', '/sys/dept/dept', '4', 'Menu', '2018-07-24 15:45:59', 'admin', '2018-07-24 15:48:17', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('d06509ce824048cea93ddad5cf37be50', '查看', '', '', '/upms/dict/type/**', 'Get', '9b63e1df382a48f7bec5964b058de040', '', '', '4', 'Button', '2018-08-06 09:09:19', 'admin', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('d791fb3858ce432682f3b128ff89b807', '校验用户名', null, null, '/upms/user/checkUserName', 'Post', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '6', 'Button', '2018-07-10 20:08:04', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('db110f05884246dbaffaae42b42e04e6', '修改', 'sys_dict_type_modify', '', '/upms/dict/type/**', 'Put', '9b63e1df382a48f7bec5964b058de040', '', '', '2', 'Button', '2018-08-06 09:08:06', 'admin', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('dbc76edde1d74224b21c8ce5f2bbdbf2', '修改字典值', 'sys_dict_value_modify', '', '/upms/dict/value/**', 'Put', '9b63e1df382a48f7bec5964b058de040', '', '', '7', 'Button', '2018-08-06 09:22:52', 'admin', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('e98f0d35cdd948d5a1f0a82a2c4ef38a', '新增字典值', 'sys_dict_value_save', '', '/upms/dict/value/**', 'Post', '9b63e1df382a48f7bec5964b058de040', '', '', '6', 'Button', '2018-08-06 09:21:43', 'admin', '2018-08-06 09:22:00', 'admin', null, 'Used');
INSERT INTO `sys_menu` VALUES ('e99c9dc0eaaa41a7a0bd6511d37fd9fe', '删除', 'sys_user_delete', null, '/upms/user/delete/*', 'Delete', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '3', 'Button', '2018-07-10 20:03:08', null, '2018-07-10 20:03:33', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('e9df6455bfbf42c9b65806c7f4517a33', '新增用户', 'sys_user_save', null, '/upms/user/save', 'Post', '15eb0bd66e274a04aa6606756d08ae1b', null, null, '1', 'Button', '2018-07-10 20:00:16', null, '2018-07-10 20:00:34', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('ef8dcc18db5248cfacd880083ad2adf8', '查看字典值', '', '', '/upms/dict/value/**', 'Get', '9b63e1df382a48f7bec5964b058de040', '', '', '9', 'Button', '2018-08-06 09:23:49', 'admin', '2018-08-06 09:24:14', 'admin', null, 'Used');
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
INSERT INTO `sys_role` VALUES ('312f310d564242bfb7c6796e46b48eb7', '测试用户', 'test', '2018-07-31 16:03:20', 'admin', null, null, '', 'Used');
INSERT INTO `sys_role` VALUES ('34e0749f68e348dabd7ea7577f816657', '管理员', 'sys', '2018-07-06 14:28:06', null, null, null, '拥有部分权限', 'Used');
INSERT INTO `sys_role` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '超级管理员', 'admin', '2018-07-06 14:26:37', null, null, null, '拥有所有权限', 'Used');
INSERT INTO `sys_role` VALUES ('d2991a6e448143a589e6b7c084fa40ff', '普通用户', 'common', '2018-07-06 14:28:24', null, '2018-07-19 16:08:29', null, 'common 前台控制表单提交', 'Used');

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
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '00626eab9be44170b004300450f1bbaa', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '01279c73a7934ba68da681bca7d7da49', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '018990e163714e5bb2055f6fb313b30f', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '08eb98349be74fa78e0f1f5ea8a8c7eb', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '0cf19ac6a3b44e659ae7a66a9d07fe92', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '11244d99e8eb4a91b1e6a4e2e1613bc4', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '15eb0bd66e274a04aa6606756d08ae1b', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '248094a4cdcb43f097aacf31fec5343b', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '25d6fdee896c4787a9e10aa4ab408362', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '315b00c6fb2d4eb999ab52e5ce282216', '2018-08-06 09:51:30', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '3ac69836b6e34c2282f22044c388877a', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '5f89ba0de2fd4fad8ee1774896079e76', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '5fe71c7fecf94a7b872be462a9d101c3', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '628d7bd579ff4abaaf72ac8db84732c2', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '63570d04419e468f829005c5c5c0ba31', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '6f1ed330fdde436b9dcfc56040b0cbbc', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '709a439428834e16a48eff60a08e5bf1', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '70ed5fd046a0497488b331bb0094840a', '2018-08-06 09:51:30', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '74c73b6d090b4599953cb30643c6695a', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '7ebd22562715417cb14b652baa3d482f', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '809d6fc909454e4abbaeaae07f454b72', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '81059eb947b04cd6a01bc28a96809718', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '8fb6fd527f734c439d9600a3fddd4b7d', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '90ee8324659141d19f355e11c91158c4', '2018-08-06 09:51:27', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '95d7be59a0ba42dca662d9bb3f048524', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '9b63e1df382a48f7bec5964b058de040', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', '9e65ad51116247e8965c1102a9aac01c', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'a0d2940731aa45cea23c47a86f4e90e1', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'aeb8703b44754eac9594eb1ba7e6bd48', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'b1c065676592432ea98064b6260561fe', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'c41a29b667154d0aa1f86434a4ab31a5', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'd06509ce824048cea93ddad5cf37be50', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'd791fb3858ce432682f3b128ff89b807', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'db110f05884246dbaffaae42b42e04e6', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'dbc76edde1d74224b21c8ce5f2bbdbf2', '2018-08-06 09:51:30', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'e98f0d35cdd948d5a1f0a82a2c4ef38a', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'e99c9dc0eaaa41a7a0bd6511d37fd9fe', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'e9df6455bfbf42c9b65806c7f4517a33', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'ef8dcc18db5248cfacd880083ad2adf8', '2018-08-06 09:51:30', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'efd33a5733324c08b0ae75b8b3a41e6f', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'f57ff19855304530a51ea874768f11e8', '2018-08-06 09:51:28', 'admin', null, null, null, 'Used');
INSERT INTO `sys_role_menu` VALUES ('af045b96b3464049ac6c885c4b2c96a8', 'f58e05206e2f40f3a684237594cc5cd9', '2018-08-06 09:51:29', 'admin', null, null, null, 'Used');

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
  `photo` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户头像',
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
INSERT INTO `sys_user` VALUES ('25edbaf722584f5ca4ca4674eb586e39', 'sys', '$2a$10$oJsPW9G71ZBypppM9ouGnOJI2qmEr5m./g7aCGyy19oWGVY2./Aga', null, '13333333333', '管理员', '2018-07-02', 'Man', null, '2018-07-13 13:28:45', null, '2018-07-26 14:25:23', 'admin', null, 'Used');
INSERT INTO `sys_user` VALUES ('491db94d6e484fd8831cdf89688b5004', 'userTest', '', 'salt', '13333333333', '测试用户', null, 'Man', 'user/photo/e391a075ceae48a7b53b8d912f6ebb08_16f351735c21400024da7bb264c4f8c2.jpg', '2018-07-17 16:45:36', null, '2018-07-19 16:12:59', 'admin', null, 'Used');
INSERT INTO `sys_user` VALUES ('4d2f751fc5874ad6b812bfb0101674a5', 'tx1', '$2a$10$2Yb41fD1cGJ2mY9WzZF1muHo6FOJ7hVhzsMAtNYaZeWdGiCN3TUl2', null, '18898888888', '头像1', '2018-07-31', 'Man', 'user/photo/3283b019b4644c85afc927367003da1e_1.jpg', '2018-07-19 15:58:55', null, '2018-07-20 15:14:04', null, null, 'Used');
INSERT INTO `sys_user` VALUES ('6e71bac4a331414bb5c155a26cdef0d4', 'common6', '$2a$10$9RWIYDZaAr23uGlhMWnnXerSuQKzJ2va85/jgOS4sIKjy1uX9zW72', null, '13225252564', '测试6', '2018-07-03', 'Man', 'user/photo/f69a7f542ac3419cb1e59c9982bc50eb_2.jpg', '2018-07-26 14:30:51', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('6ed1e72307d64f82bbaaba6b22c92579', 'common7', '$2a$10$MA7Y8XtvcobOvGZ7Q.qAG.MJNiOHpskIzvMVc5z.hqDBkApoRiFvu', null, '13888888888', '部门1', null, 'Man', '', '2018-08-06 14:08:18', 'admin', '2018-08-06 14:23:40', 'admin', null, 'Used');
INSERT INTO `sys_user` VALUES ('a4a3e66329864dadae6d2d1de86fecb9', 'common3', '$2a$10$kxaXZrRfoWIp3q/EGmpGUe2.E7Uhbj8./QViOrYL7TROWaAQl2cke', null, '13555555656', '测试三', null, 'Other', 'user/photo/d0d4bca5b92c4eb490f46614af774559_3.jpg', '2018-07-26 14:29:02', 'admin', '2018-07-26 14:29:48', 'admin', null, 'Used');
INSERT INTO `sys_user` VALUES ('b3ef996bd3714e6dbcea8c89a4e86d88', 'common', '$2a$10$JvF1hlSej9XUWoctd0INBOeC2UBeQYX1s5qA37vZvUdJs5pQuE1PO', null, '18999999999', '普通用户', '2018-07-11', 'Man', null, '2018-07-17 15:17:31', null, null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('c744c9ee9f6a4734b246c83d5a790fac', 'common2', '$2a$10$ZpmWqBRRYKGVZ6kjSeH08uCdzfiLwUK0cIaO/vb9b.HyehuTh2Oo2', null, '13999999956', '测试2', null, 'Woman', 'user/photo/2b064d88c3274e2ca9d3ea71198b80ac_2.jpg', '2018-07-26 14:28:20', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('ccd8ebff8b5d4a389c43d95a9592f44f', 'common5', '$2a$10$LziZPEMfIHD4uIIsz3NVkOSI4o/aBA/s5PygKDtg8VMsQRTDJeaP6', null, '13556569694', '测试5', null, 'Other', 'user/photo/0a3b60a365894bafa734a81587002d91_16f351735c21400024da7bb264c4f8c2.jpg', '2018-07-26 14:30:22', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('d985e03a14ed4a7d991bcd8e12519091', 'common4', '$2a$10$yJ9bRPJ9XiGHixT60r/16.IqwPR3IyFf6xtPpAbOhZkEKsga6Oqci', null, '13555656565', '测试4', null, 'Man', 'user/photo/2ae2787776894912830fa9f6c57b7c7f_12.jpg', '2018-07-26 14:29:34', 'admin', '2018-07-26 14:29:58', 'admin', null, 'Used');
INSERT INTO `sys_user` VALUES ('ecafad4f16344031bd82202b660c9dd0', 'common1', '$2a$10$ynLQ7gYS0ON2BOQiikYglObawgDFruanlx1OPK3uSntfitVtu6U/y', null, '13666666666', '测试1', '2018-07-04', 'Woman', 'user/photo/98facc4e37144888933bf5dfe30d90e4_1.jpg', '2018-07-26 14:27:49', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('f09f3be336c24b8cb651dff39a418a92', 'admin', '$2a$10$Ni0mYwPi7Jdi9n5deQTQl.0/ai5RL75JVb.73/vgvPRp.Pm8n7.rS', null, '13888888888', '超级管理员', '2018-07-17', 'Other', 'user/photo/49459d8432914af1b0296a61a57bc177_2.jpg', '2018-07-10 12:46:28', null, '2018-07-19 16:19:46', null, null, 'Used');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `dept_id` varchar(64) NOT NULL COMMENT '部门ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`user_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户部门表';

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------
INSERT INTO `sys_user_dept` VALUES ('6ed1e72307d64f82bbaaba6b22c92579', '26097ba1e4f146bf88cbaf809d06af1a', '2018-08-06 14:16:57', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_dept` VALUES ('6ed1e72307d64f82bbaaba6b22c92579', 'a556dad16add40f69716245cfa2ef637', '2018-08-06 14:16:57', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_dept` VALUES ('6ed1e72307d64f82bbaaba6b22c92579', 'bdd5e05378044ae29f4f75ce896cfbb5', '2018-08-06 14:16:57', 'admin', null, null, null, 'Used');

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
INSERT INTO `sys_user_role` VALUES ('25edbaf722584f5ca4ca4674eb586e39', '34e0749f68e348dabd7ea7577f816657', '2018-07-26 14:25:23', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('6e71bac4a331414bb5c155a26cdef0d4', 'd2991a6e448143a589e6b7c084fa40ff', '2018-07-26 14:30:51', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('6ed1e72307d64f82bbaaba6b22c92579', '312f310d564242bfb7c6796e46b48eb7', '2018-08-06 14:16:57', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('a4a3e66329864dadae6d2d1de86fecb9', 'd2991a6e448143a589e6b7c084fa40ff', '2018-07-26 14:29:48', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('b3ef996bd3714e6dbcea8c89a4e86d88', '34e0749f68e348dabd7ea7577f816657', '2018-07-13 13:28:45', null, '2018-07-26 11:22:38', null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('b3ef996bd3714e6dbcea8c89a4e86d88', 'd2991a6e448143a589e6b7c084fa40ff', '2018-07-17 15:17:31', null, null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('c744c9ee9f6a4734b246c83d5a790fac', 'd2991a6e448143a589e6b7c084fa40ff', '2018-07-26 14:28:20', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('d985e03a14ed4a7d991bcd8e12519091', 'd2991a6e448143a589e6b7c084fa40ff', '2018-07-26 14:29:59', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('ecafad4f16344031bd82202b660c9dd0', 'd2991a6e448143a589e6b7c084fa40ff', '2018-07-26 14:27:49', 'admin', null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('f09f3be336c24b8cb651dff39a418a92', 'af045b96b3464049ac6c885c4b2c96a8', '2018-07-21 13:11:25', null, '2018-07-26 11:21:43', null, null, 'Used');
