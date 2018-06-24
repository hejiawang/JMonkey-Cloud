package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends BaseEntity<SysRoleMenuEntity> {

    /**
     * 角色ID
     */
    @TableId(type = IdType.INPUT)
    private String roleId;

    /**
     * 菜单ID
     */
    @TableId(type = IdType.INPUT)
    private String menuId;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
