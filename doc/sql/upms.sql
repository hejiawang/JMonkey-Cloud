DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `salt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '随机盐',
  `real_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真是姓名',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
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

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
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
	`create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
	`remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
	`remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
	`remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

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

DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `dept_id` varchar(64) NOT NULL COMMENT '部门ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
	`remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`user_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户部门表';


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

