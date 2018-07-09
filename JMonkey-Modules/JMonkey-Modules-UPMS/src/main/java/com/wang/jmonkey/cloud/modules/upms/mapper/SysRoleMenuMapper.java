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
     * 获取uese已授权菜单ID list
     * @param roleId
     * @return
     */
    List<String> findMenuIdByRole(@Param("roleId")String roleId);

    /**
     * 获取角色的菜单
     * @param roleId 角色ID
     * @return 菜单list
     */
    List<MenuVo> findMenuVoByRoleId(@Param("roleId")String roleId);
}
