package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserRoleMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserRoleEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description: 用户角色关联service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    /**
     * 根据用户ID获取用户角色ID list
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<String> findRoleIdByUserId(String userId) {
        return userRoleMapper.findRoleIdByUserId(userId);
    }

    /**
     * 根据角色ID获取用户ID list
     * @param roleId 角色ID
     * @return
     */
    @Override
    public List<String> findUserIdByRoleId(String roleId) {
        return userRoleMapper.findUserIdByRoleId(roleId);
    }

    /**
     * 删除用户的角色
     * @param userId
     */
    @Override
    public void deleteAllByUserId( String userId ){
        userRoleMapper.deleteAllByUserId(userId);
    }

    /**
     * 删除拥有该角色的用户
     * @param roleId
     */
    @Override
    public void deleteAllByRoleId( String roleId ){
        userRoleMapper.deleteAllByRoleId(roleId);
    }

    /**
     * 设置用户角色
     * @param userId 用户ID
     * @param roleIds 角色list
     * @return
     */
    @Override
    public Boolean saveRoles(String userId, List<String> roleIds) {
        userRoleMapper.deleteAllByUserId(userId);
        if(!CollectionUtils.isEmpty(roleIds))
            roleIds.forEach( roleId -> this.insert(new SysUserRoleEntity().setRoleId(roleId).setUserId(userId)) );
        return true;
    }

    /**
     * 设置拥有该角色的用户
     * @param roleId 角色ID
     * @param userIds 用户list
     * @return
     */
    @Override
    public Boolean saveUsers(String roleId, List<String> userIds) {
        userRoleMapper.deleteAllByRoleId( roleId );
        if(!CollectionUtils.isEmpty(userIds))
            userIds.forEach( userId -> this.insert(new SysUserRoleEntity().setRoleId(roleId).setUserId(userId)) );
        return true;
    }

    /**
     * 获取用户的角色
     * @param userId 用户ID
     * @return 角色list
     */
    @Override
    public List<SysRoleEntity> findRoleByUserId(String userId) {
        return userRoleMapper.findRoleByUserId(userId);
    }
}
