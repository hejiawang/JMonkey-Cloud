package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface ISysRoleService extends IService<SysRoleEntity> {

    /**
     * 分页查询角色信息列表
     * @param page page
     * @param roleEntity 角色信息
     * @return 角色分页信息
     */
    Page<SysRoleEntity> selectPage(Page<SysRoleEntity> page, SysRoleEntity roleEntity );

    /**
     * 校验角色code是否存在
     * @param roleEntity 角色信息
     * @return
     */
    Boolean checkCode(SysRoleEntity roleEntity);

    /**
     * 校验角色名称是否存在
     * @param roleEntity 角色信息
     * @return
     */
    Boolean checkName(SysRoleEntity roleEntity);
}
