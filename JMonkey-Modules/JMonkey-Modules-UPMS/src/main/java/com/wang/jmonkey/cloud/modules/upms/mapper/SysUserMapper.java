package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.model.param.UserSearchParam;
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

    /**
     * 根据用户ID获取用户dto信息
     * @param userId 用户ID
     * @return
     */
    UserDto findDtoById(@Param("userId")String userId);

    /**
     * 分页查询用户信息
     * @param userSearchParam 查询用户条件
     * @return
     */
    List<UserDto> selectPageData(UserSearchParam userSearchParam);

}
