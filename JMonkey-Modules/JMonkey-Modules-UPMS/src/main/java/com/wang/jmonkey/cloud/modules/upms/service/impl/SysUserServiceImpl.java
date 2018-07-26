package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.common.model.vo.RoleVo;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserInfo;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserRoleService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Resource
    private ISysRoleMenuService roleMenuService;

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    /**
     * 修改用户信息
     * @param userDto 用户信息
     * @return
     */
    @Override
    @Transactional
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
    @Transactional
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
     * @param password 新密码
     * @return
     */
    @Override
    public Boolean restPasswsord(String id, String password) {
        String pw = ENCODER.encode( password );
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
     * 获取所有用户信息
     * @return
     */
    @Override
    public List<UserDto> selectAll() {
        return userMapper.selectAll();
    }

    /**
     * 删除用户信息，并删除用户的角色信息
     * @param id
     * @return
     */
    @Override
    @Transactional
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
     * 校验用户原始密码是否正确
     * @param userEntity userEntity
     * @return
     */
    @Override
    public Boolean checkPassword(SysUserEntity userEntity) {
        String pw = ENCODER.encode( userEntity.getPassword() );
        EntityWrapper wrapper = new EntityWrapper( userEntity.setPassword(pw) );
        SysUserEntity sysUserEntity = this.selectOne(wrapper);
        return sysUserEntity  == null;
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

    /**
     * 获取用户登录信息
     * @param userVo 用户vo
     * @return 用户登录信息
     */
    @Override
    public UserInfo info(UserVo userVo) {
        List<String> roleCodeList = this.infoRoleCode(userVo);
        List<String> permissionList = this.infoPermission(roleCodeList);

        return new UserInfo().setUser(this.findByUsername(userVo.getUsername()))
                .setRoleCodeList(roleCodeList).setPermissionList(permissionList);
    }



    private List<String> infoRoleCode( UserVo userVo ){
        List<String> roleCodeList = new ArrayList<>();

        List<RoleVo> roleVoList = userVo.getRoleList();
        if( CollectionUtil.isNotEmpty(roleVoList) ) {
            roleVoList.forEach( roleVo -> {
                if( !StrUtil.equals(SecurityConstants.BASE_ROLE, roleVo.getCode()) ) roleCodeList.add(roleVo.getCode());
            });
        }

        return roleCodeList;
    }

    private List<String> infoPermission( List<String> roleCodeList ){
        List<String> permissionList = new ArrayList<>();

        Set<MenuVo> menuVoSet = new HashSet<>();
        roleCodeList.forEach( roleCode -> menuVoSet.addAll(roleMenuService.findMenuVoByRoleCode(roleCode)) );

        menuVoSet.forEach( menuVo -> {
            if (StringUtils.isNotEmpty(menuVo.getPermission())) permissionList.add(menuVo.getPermission());
        });

        return permissionList;
    }

}
