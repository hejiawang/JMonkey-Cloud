package com.wang.jmonkey.cloud.common.model.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.cloud.common.model.BaseVo;
import com.wang.jmonkey.cloud.common.model.enums.MenuMethodEnum;
import com.wang.jmonkey.cloud.common.model.enums.MenuTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Data
@Accessors(chain = true)
public class MenuVo extends BaseVo {

    /**
     * id
     */
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
    private Integer sort;

    /**
     * 菜单类型 （menu菜单 button按钮）
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private MenuTypeEnum type;
}
