package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Description: 用户信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 新增用户
     * @param userEntity 用户信息
     * @return 是否成功
     */
    @Override
    public boolean insert(SysUserEntity userEntity) {
        String password = new BCryptPasswordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(password);

        return super.insert(userEntity);
    }

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

    /**
     * 校验用户名称是否存在
     * @param userEntity 用户信息
     * @return true or false
     */
    @Override
    public Boolean checkUserName(SysUserEntity userEntity) {
        return userMapper.checkUserName(userEntity) > 0;
    }

    /**
     * 根据用户名称获取用户信息
     * @param username 用户名称
     * @return
     */
    @Override
    public SysUserEntity findByUsername(String username) {
        EntityWrapper wrapper = new EntityWrapper( new SysUserEntity().setUsername(username) );
        return this.selectOne(wrapper);
    }

}
