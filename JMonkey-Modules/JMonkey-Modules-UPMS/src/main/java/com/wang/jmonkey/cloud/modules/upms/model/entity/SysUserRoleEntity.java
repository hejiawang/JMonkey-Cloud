package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 用户角色关联信息
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity<SysUserRoleEntity> {

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    /**
     * 角色ID
     */
    @TableId(type = IdType.INPUT)
    private String roleId;

    @Override
    protected Serializable pkVal() {
        return this.userId + this.roleId;
    }
}
