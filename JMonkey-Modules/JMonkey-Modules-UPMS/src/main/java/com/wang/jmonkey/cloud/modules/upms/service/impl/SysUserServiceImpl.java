package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserRoleService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
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

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

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
        String password = ENCODER.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        super.insert(userEntity);

        return userRoleService.saveRoles(userEntity.getId(), userDto.getRoleIdList());
    }

    /**
     * 重置用户密码为123456
     * @param id 用户id
     * @return
     */
    @Override
    public Boolean restPasswsord(String id) {
        String pw = ENCODER.encode( "123456" );
        return this.updateById( new SysUserEntity().setId(id).setPassword(pw) );
    }

    /**
     * 分页查询用户列表数据
     * @param page page
     * @param userEntity 用户信息
     * @return 用户分页信息
     */
    @Override
    public Page<UserDto> selectPage(Page<SysUserEntity> page, SysUserEntity userEntity){
        EntityWrapper<SysUserEntity> userWrapper = new EntityWrapper<>(new SysUserEntity());
        userWrapper.like("username", userEntity.getUsername(), SqlLike.DEFAULT)
                .like("phone", userEntity.getPhone(), SqlLike.DEFAULT)
                .orderBy( "create_date", false );
        return this.converPage(this.selectPage(page, userWrapper));
    }

    private Page<UserDto> converPage( Page<SysUserEntity> userPage ){
        List<UserDto> userDtoList = new ArrayList<>();

        List<SysUserEntity> userEntityList = userPage.getRecords();
        userEntityList.forEach( user -> {
            UserDto userDto = UserDto.converFromEntity(user).setRoleList(userRoleService.findRoleByUserId(user.getId()));
            userDtoList.add(userDto);
        });

        Page<UserDto> userDtoPage = new Page<>();
        userDtoPage.setRecords(userDtoList).setTotal(userPage.getTotal()).setCurrent(userPage.getCurrent()).setSize(userPage.getSize());
        return userDtoPage;
    }

    /**
     * 删除用户信息，并删除用户的角色信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(Serializable id) {
        userRoleService.deleteAllByUserId(String.valueOf(id));
        return super.deleteById(id);
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

    /**
     * 根据用户名称获取用户vo信息
     * @param username 用户名称
     * @return 用户vo
     */
    @Override
    public UserVo findUserVoByUsername(String username) {
        return userMapper.findUserVoByUsername(username);
    }

}
