package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;

/**
 * @Description: 用户信息mapper
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 校验用户名称是否存在
     * @param userEntity 用户信息
     * @return true or false
     */
    Integer checkUserName(SysUserEntity userEntity);
}
