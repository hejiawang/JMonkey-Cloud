package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @Description: 角色信息
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Data
@Accessors(chain = true)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity<SysRoleEntity> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 角色名
     */
    @NotEmpty(message = "角色名不能为空")
    @Length(max = 20, message = "角色名长度不能超过20")
    private String name;

    /**
     * 角色编号
     */
    @NotEmpty(message = "角色编号不能为空")
    @Length(max = 20, message = "角色编号长度不能超过20")
    private String code;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
