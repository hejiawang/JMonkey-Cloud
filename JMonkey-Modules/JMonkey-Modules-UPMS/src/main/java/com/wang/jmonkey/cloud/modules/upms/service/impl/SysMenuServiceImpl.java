package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.common.utils.TreeUtil;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysMenuMapper;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysRoleMenuMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuDto;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysMenuService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 菜单信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Resource
    private ISysRoleMenuService roleMenuService;

    /**
     * 获取树形菜单数据
     * @return
     */
    @Override
    public List<MenuTreeDto> treeList() {
        EntityWrapper<SysMenuEntity> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysMenuEntity());
        wrapper.orderBy( "sort", false );

        return TreeUtil.bulid( MenuTreeDto.converFromEntity( this.selectList( wrapper ) ), null );
    }

    /**
     * 获取菜单信息
     * @param id 菜单ID
     * @return 菜单dto
     */
    @Override
    public MenuDto selectDtoById(Serializable id) {
        return menuMapper.selectDtoById(id);
    }

    @Override
    @CacheEvict(value = "auth_menu", allEntries = true)
    public boolean modifyById( SysMenuEntity menuEntity ){
        return this.updateById(menuEntity);
    }

    /**
     * 删除菜单
     * 递归删除子菜单并删除拥有菜单权限的角色
     * @param id 菜单ID
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "auth_menu", allEntries = true)
    public boolean deleteMenuById(Serializable id) {
        List<SysMenuEntity> menuList = this.selectList(new EntityWrapper<>(new SysMenuEntity().setParentId(String.valueOf(id))));
        if( !CollectionUtils.isEmpty(menuList) )  menuList.forEach( menuEntity -> this.deleteMenuById( menuEntity.getId() ) );

        roleMenuService.deleteAllByMenuId( String.valueOf(id) );
        return this.deleteById(id);
    }
}
