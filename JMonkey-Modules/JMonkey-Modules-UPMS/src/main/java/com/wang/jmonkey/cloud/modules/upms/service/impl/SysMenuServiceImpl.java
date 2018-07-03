package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.common.utils.TreeUtil;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysMenuMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 菜单信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysMenuServiceImpl  extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements ISysMenuService {

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
}
