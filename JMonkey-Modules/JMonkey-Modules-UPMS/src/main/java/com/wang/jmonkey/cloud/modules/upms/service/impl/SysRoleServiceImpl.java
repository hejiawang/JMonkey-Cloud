package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysRoleMapper;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysRoleMenuMapper;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserRoleMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Description: 角色信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements ISysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Resource
    private ISysUserRoleService userRoleService;

    @Autowired
    private ISysRoleMenuService roleMenuService;

    /**
     * 分页查询角色信息列表
     * @param page page
     * @param roleEntity 角色信息
     * @return 角色分页信息
     */
    @Override
    public Page<SysRoleEntity> selectPage(Page<SysRoleEntity> page, SysRoleEntity roleEntity) {
        EntityWrapper<SysRoleEntity> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysRoleEntity());
        wrapper.like("name", roleEntity.getName(), SqlLike.DEFAULT);
        wrapper.like("code", roleEntity.getCode(), SqlLike.DEFAULT);
        wrapper.orderBy( "create_date", false );

        return this.selectPage(page, wrapper);
    }

    @Override
    public boolean deleteById(Serializable id) {
        userRoleService.deleteAllByRoleId(String.valueOf(id));
        roleMenuService.deleteAllByRoleId(String.valueOf(id));
        return super.deleteById(id);
    }

    /**
     * 校验角色code是否存在
     * @param roleEntity 角色信息
     * @return
     */
    @Override
    public Boolean checkCode(SysRoleEntity roleEntity) {
        return roleMapper.checkCode(roleEntity) > 0;
    }

    /**
     * 校验角色名称是否存在
     * @param roleEntity 角色信息
     * @return
     */
    @Override
    public Boolean checkName(SysRoleEntity roleEntity) {
        return roleMapper.checkName(roleEntity) > 0;
    }

}
