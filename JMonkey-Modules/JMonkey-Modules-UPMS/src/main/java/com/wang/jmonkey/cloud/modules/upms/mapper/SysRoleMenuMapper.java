package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
    List<String> findMenuByRole(@Param("roleId")String roleId);
}
