package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;

/**
 * @Description: 用户信息service
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface ISysUserService extends IService<SysUserEntity> {

    /**
     * 分页查询用户列表数据
     * @param page page
     * @param userEntity 用户信息
     * @return 用户分页信息
     */
    Page<SysUserEntity> selectPage(Page<SysUserEntity> page, SysUserEntity userEntity);

    /**
     * 校验用户名称是否存在
     * @param userEntity 用户信息
     * @return true or false
     */
    Boolean checkUserName(SysUserEntity userEntity);
}
