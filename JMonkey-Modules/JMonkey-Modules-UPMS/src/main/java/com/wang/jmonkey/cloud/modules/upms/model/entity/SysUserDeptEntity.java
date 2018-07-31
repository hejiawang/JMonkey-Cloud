package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 用户部门关联
 * @Auther: HeJiawang
 * @Date: 2018/7/31
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_dept")
public class SysUserDeptEntity extends BaseEntity<SysUserDeptEntity> {

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    /**
     * 部门ID
     */
    @TableId(type = IdType.INPUT)
    private String deptId;

    @Override
    protected Serializable pkVal() {
        return userId + deptId;
    }
}
