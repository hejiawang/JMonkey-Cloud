package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysRoleMenuMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleMenuEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
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
    public List<String> findMenuIdByRole(String roleId) {
        return roleMenuMapper.findMenuIdByRole(roleId);
    }

    /**
     * 删除角色菜单权限
     * @param roleId
     */
    @Override
    public void deleteAllByRoleId(String roleId) {
        roleMenuMapper.deleteAllByRoleId(roleId);
    }

    /**
     * 更新角色菜单权限
     * @param roleId 角色ID
     * @param menuIds 菜单id list
     * @return
     */
    @Override
    @Transactional
    public Boolean modifyAuth(String roleId, List<String> menuIds) {
        roleMenuMapper.deleteAllByRoleId(roleId);
        if( !CollectionUtils.isEmpty(menuIds) )
            menuIds.forEach( menuId -> this.insert( new SysRoleMenuEntity().setRoleId(roleId).setMenuId(menuId) ) );
        return true;
    }

    /**
     * 获取角色的菜单
     * @param roleCode roleCode
     * @return 菜单list
     */
    @Override
    public List<MenuVo> findMenuVoByRoleCode(String roleCode) {
        return roleMenuMapper.findMenuVoByRoleCode(roleCode);
    }
}
