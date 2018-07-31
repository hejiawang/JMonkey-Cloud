package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据用户名称获取用户vo信息
     * @param username 用户名称
     * @return 用户vo
     */
    UserVo findUserVoByUsername(@Param("username") String username);

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserDto> selectAll();

    UserDto findDtoById(@Param("userId")String userId);
}
