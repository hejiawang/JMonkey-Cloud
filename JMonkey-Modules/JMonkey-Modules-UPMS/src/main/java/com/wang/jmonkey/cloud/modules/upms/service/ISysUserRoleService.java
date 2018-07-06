package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserRoleEntity;

import java.util.List;

/**
 * @Description: 用户角色关联service
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface ISysUserRoleService extends IService<SysUserRoleEntity> {

    /**
     * 根据用户ID获取用户角色ID list
     * @param userId 用户ID
     * @return
     */
    List<String> findRoleIdByUserId(String userId);

    /**
     * 根据角色ID获取用户ID list
     * @param roleId 角色ID
     * @return
     */
    List<String> findUserIdByRoleId(String roleId);

    /**
     * 删除用户的角色
     * @param userId
     */
    void deleteAllByUserId( String userId );

    /**
     * 删除拥有该角色的用户
     * @param roleId
     */
    void deleteAllByRoleId( String roleId );

    /**
     * 设置用户角色
     * @param userId 用户ID
     * @param roleIds 角色list
     * @return
     */
    Boolean saveRoles(String userId, List<String> roleIds);

    /**
     * 设置拥有该角色的用户
     * @param roleId 角色ID
     * @param userIds 用户list
     * @return
     */
    Boolean saveUsers(String roleId, List<String> userIds);

    /**
     * 获取用户的角色
     * @param userId 用户ID
     * @return 角色list
     */
    List<SysRoleEntity> findRoleByUserId(String userId);
}
