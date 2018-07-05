package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 用户角色关联mapper
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

    /**
     * 根据用户ID获取用户角色ID list
     * @param userId 用户ID
     * @return
     */
    List<String> findRoleIdByUserId( @Param("userId")String userId );

    /**
     * 根据角色ID获取用户ID list
     * @param roleId 角色ID
     * @return
     */
    List<String> findUserIdByRoleId( @Param("roleId")String roleId );

    /**
     * 删除用户的所有角色
     * @param userId 用户ID
     */
    void deleteAllByUserId( @Param("userId")String userId );

    /**
     * 删除拥有该角色的所有用户
     * @param roleId 角色ID
     */
    void deleteAllByRoleId( @Param("roleId")String roleId );
}
