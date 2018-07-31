package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * 部门信息
 * @author HeJiawang
 * @since 2018-07-24
 */
@Data
@Accessors(chain = true)
@TableName("sys_dept")
public class SysDeptEntity extends BaseEntity<SysDeptEntity> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 上级部门ID,null为顶级部门
     */
    private String parentId;

    /**
     * 部门名称
     */
    @NotEmpty(message = "部门名称不能为空")
    @Length(max = 20, message = "部门名称长度不能超过20")
    private String name;

    /**
     * 部门编码
     */
    @NotEmpty(message = "部门编码不能为空")
    @Length(max = 20, message = "部门编码长度不能超过20")
    private String code;

    /**
     * 排序值
     */
    @Range(min = 1, max = 10000, message = "排序值从1-10000")
    private Integer sort;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
