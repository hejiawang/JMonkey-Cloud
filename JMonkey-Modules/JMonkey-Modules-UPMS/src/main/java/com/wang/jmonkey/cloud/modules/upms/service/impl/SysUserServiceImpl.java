package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    /**
     * 分页查询用户列表数据
     * @param page page
     * @param userEntity 用户信息
     * @return 用户分页信息
     */
    @Override
    public Page<SysUserEntity> selectPage(Page<SysUserEntity> page, SysUserEntity userEntity){
        EntityWrapper<SysUserEntity> userWrapper = new EntityWrapper<>();
        userWrapper.setEntity(userEntity);
        userWrapper.orderBy( "create_date", false );

        return this.selectPage(page, userWrapper);
    }

}
