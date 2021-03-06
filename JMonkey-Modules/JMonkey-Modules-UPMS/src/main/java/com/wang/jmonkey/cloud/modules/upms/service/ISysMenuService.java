package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuDto;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 菜单信息service
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface ISysMenuService extends IService<SysMenuEntity> {

    /**
     * 获取树形菜单数据
     * @return
     */
    List<MenuTreeDto> treeList();

    /**
     * 获取菜单信息
     * @param id 菜单ID
     * @return 菜单dto
     */
    MenuDto selectDtoById(Serializable id);

    /**
     * 修改菜单
     * @param menuEntity 菜单信息
     * @return
     */
    boolean modifyById(SysMenuEntity menuEntity);

    /**
     * 删除菜单
     * 递归删除子菜单并删除拥有菜单权限的角色
     * @param id 菜单ID
     * @return
     */
    boolean deleteMenuById(Serializable id);

    /**
     * 角色list 拥有的菜单
     * @param roleCodeList
     * @return
     */
    List<MenuTreeDto> userMenu(List<String> roleCodeList);
}
