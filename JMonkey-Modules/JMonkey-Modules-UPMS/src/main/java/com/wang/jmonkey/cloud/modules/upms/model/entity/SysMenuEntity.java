package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import com.wang.jmonkey.cloud.common.model.enums.MenuMethodEnum;
import com.wang.jmonkey.cloud.common.model.enums.MenuTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @Description: 菜单信息
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Data
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity<SysMenuEntity> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 菜单名称
     */
    @NotEmpty(message = "菜单名称不能为空")
    @Length(max = 6, message = "菜单名称长度不能超过6")
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 前端URL
     */
    private String path;

    /**
     * 请求链接
     */
    private String url;

    /**
     * 请求方法
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private MenuMethodEnum method;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * VUE页面
     */
    private String component;

    /**
     * 排序值
     */
    @Range(min = 1, max = 10000, message = "排序值从1-10000")
    private Integer sort;

    /**
     * 菜单类型 （menu菜单 button按钮）
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private MenuTypeEnum type;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
