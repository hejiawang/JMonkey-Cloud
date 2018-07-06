package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserRoleService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户信息service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Resource
    private ISysUserRoleService userRoleService;

    /**
     * 修改用户信息
     * @param userDto 用户信息
     * @return
     */
    @Override
    public boolean updateById(UserDto userDto) {
        SysUserEntity userEntity = UserDto.converToEntity(userDto);
        super.updateById(userEntity);

        return userRoleService.saveRoles(userEntity.getId(), userDto.getRoleIdList());
    }

    /**
     * 新增用户
     * @param userDto 用户信息
     * @return 是否成功
     */
    @Override
    public boolean insert(UserDto userDto) {
        SysUserEntity userEntity = UserDto.converToEntity(userDto);
        String password = new BCryptPasswordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(password);
        super.insert(userEntity);

        return userRoleService.saveRoles(userEntity.getId(), userDto.getRoleIdList());
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
     * 查找用户信息
     * @param id 用户ID
     * @return 用户dto
     */
    @Override
    public UserDto findDtoById(String id) {
        SysUserEntity userEntity = this.selectById(id);
        List<String> roleIdList = userRoleService.findRoleIdByUserId(id);

        return UserDto.converFromEntity(userEntity).setRoleIdList(roleIdList);
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
