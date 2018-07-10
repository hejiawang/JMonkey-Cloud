package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {
    /**
     * 删除角色所授权菜单
     * @param roleId 角色ID
     */
    void deleteAllByRoleId(@Param("roleId")String roleId);

    /**
     * 删除拥有该菜单权限的角色
     * @param menuId 菜单角色
     */
    void deleteAllByMenuId(@Param("menuId")String menuId);

    /**
     * 获取uese已授权菜单ID list
     * @param roleId
     * @return
     */
    List<String> findMenuIdByRole(@Param("roleId")String roleId);

    /**
     * 获取角色的菜单
     * @param roleCode roleCode
     * @return 菜单list
     */
    List<MenuVo> findMenuVoByRoleCode(@Param("roleCode")String roleCode);

}
