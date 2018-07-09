package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
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
    List<String> findMenuIdByRole(String roleId);

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

    /**
     * 获取角色的菜单
     * @param roleCode roleCode
     * @return 菜单list
     */
    List<MenuVo> findMenuVoByRoleCode(String roleCode);
}
