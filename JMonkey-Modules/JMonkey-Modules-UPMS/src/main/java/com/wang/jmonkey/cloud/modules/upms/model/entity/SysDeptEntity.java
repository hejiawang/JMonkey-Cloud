package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;

import lombok.Data;
import lombok.experimental.Accessors;

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
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 排序值
     */
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
