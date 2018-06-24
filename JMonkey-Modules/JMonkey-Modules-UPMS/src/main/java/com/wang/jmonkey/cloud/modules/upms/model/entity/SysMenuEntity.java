package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import com.wang.jmonkey.cloud.common.model.enums.MenuTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

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
    private String method;

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
