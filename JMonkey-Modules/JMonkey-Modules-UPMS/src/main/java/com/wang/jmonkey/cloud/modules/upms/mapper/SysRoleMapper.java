package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;

/**
 * @Description: 角色信息mapper
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    /**
     * 校验角色code是否存在
     * @param roleEntity 角色信息
     * @return
     */
    Integer checkCode(SysRoleEntity roleEntity);

    /**
     * 校验角色名称是否存在
     * @param roleEntity 角色信息
     * @return
     */
    Integer checkName(SysRoleEntity roleEntity);
}
