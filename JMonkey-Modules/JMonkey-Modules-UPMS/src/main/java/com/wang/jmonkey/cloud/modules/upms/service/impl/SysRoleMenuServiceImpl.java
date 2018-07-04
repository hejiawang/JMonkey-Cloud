package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysRoleMenuMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleMenuEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 角色菜单关联信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity> implements ISysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    /**
     * 获取角色授权的菜单
     * @param roleId 角色ID
     * @return 菜单ID list
     */
    @Override
    public List<String> findMenuByRole(String roleId) {
        return roleMenuMapper.findMenuByRole(roleId);
    }

    /**
     * 更新角色菜单权限
     * @param roleId 角色ID
     * @param menuIds 菜单id list
     * @return
     */
    @Override
    public Boolean modifyAuth(String roleId, List<String> menuIds) {
        roleMenuMapper.deleteAll(roleId);
        menuIds.forEach( menuId -> this.insert( new SysRoleMenuEntity().setRoleId(roleId).setMenuId(menuId) ) );

        return true;
    }
}
