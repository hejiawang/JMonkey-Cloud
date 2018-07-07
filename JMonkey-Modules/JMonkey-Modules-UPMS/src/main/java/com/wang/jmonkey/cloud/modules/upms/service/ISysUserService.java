package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;

/**
 * @Description: 用户信息service
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface ISysUserService extends IService<SysUserEntity> {

    /**
     * 修改用户信息
     * @param userDto 用户信息
     * @return
     */
    boolean updateById(UserDto userDto);

    /**
     * 新增用户
     * @param userDto 用户信息
     * @return 是否成功
     */
    boolean insert(UserDto userDto);

    /**
     * 重置用户密码为123456
     * @param id 用户id
     * @return
     */
    Boolean restPasswsord(String id);

    /**
     * 分页查询用户列表数据
     * @param page page
     * @param userEntity 用户信息
     * @return 用户分页信息
     */
    Page<SysUserEntity> selectPage(Page<SysUserEntity> page, SysUserEntity userEntity);

    /**
     * 查找用户信息
     * @param id 用户ID
     * @return 用户dto
     */
    UserDto findDtoById(String id);

    /**
     * 校验用户名称是否存在
     * @param userEntity 用户信息
     * @return true or false
     */
    Boolean checkUserName(SysUserEntity userEntity);

    /**
     * 根据用户名称获取用户信息
     * @param username 用户名称
     * @return
     */
    SysUserEntity findByUsername(String username);
}
