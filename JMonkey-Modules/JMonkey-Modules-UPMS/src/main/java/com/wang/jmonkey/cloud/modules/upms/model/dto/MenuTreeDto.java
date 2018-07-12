package com.wang.jmonkey.cloud.modules.upms.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.cloud.common.model.BaseTreeNode;
import com.wang.jmonkey.cloud.common.model.enums.MenuMethodEnum;
import com.wang.jmonkey.cloud.common.model.enums.MenuTypeEnum;
import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树形菜单dto
 * @Auther: HeJiawang
 * @Date: 2018/7/3
 */
@Data
@Accessors(chain = true)
public class MenuTreeDto extends BaseTreeNode {

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

    /**
     * 将entity list装换为dto list
     * @param menuEntityList
     * @return
     */
    public static List<MenuTreeDto> converFromEntity(List<SysMenuEntity> menuEntityList){
        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();
        menuEntityList.forEach(menuEntity -> menuTreeDtoList.add(converFromEntity(menuEntity)) );
        return menuTreeDtoList;
    }

    /**
     * 将entity装换为dto
     * @param menuEntity
     * @return
     */
    public static MenuTreeDto converFromEntity( SysMenuEntity menuEntity ){
        MenuTreeDto menuTreeDto = new MenuTreeDto();
        BeanUtils.copyProperties(menuEntity, menuTreeDto);
        return menuTreeDto;
    }

    /**
     * 将vo list装换为dto list
     * @param menuVoList
     * @return
     */
    public static List<MenuTreeDto> converFromVo(List<MenuVo> menuVoList){
        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();
        menuVoList.forEach(menuVo -> menuTreeDtoList.add(converFromVo(menuVo)) );
        return menuTreeDtoList;
    }

    /**
     * vo
     * @param menuVo
     * @return
     */
    public static MenuTreeDto converFromVo(MenuVo menuVo){
        MenuTreeDto menuTreeDto = new MenuTreeDto();
        BeanUtils.copyProperties(menuVo, menuTreeDto);
        return menuTreeDto;
    }
}
