package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;

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
}
