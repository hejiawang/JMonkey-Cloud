package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * @Description: 角色菜单关联信息service
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface ISysRoleMenuService extends IService<SysRoleMenuEntity> {

    /**
     * 获取角色授权的菜单
     * @param roleId 角色ID
     * @return 菜单ID list
     */
    List<String> findMenuByRole(String roleId);

    /**
     * 删除角色菜单权限
     * @param roleId
     */
    void deleteAllByRoleId(String roleId);

    /**
     * 更新角色菜单权限
     * @param roleId 角色ID
     * @param menuIds 菜单id list
     * @return
     */
    Boolean modifyAuth(String roleId, List<String> menuIds);
}
