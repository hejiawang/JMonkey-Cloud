package com.wang.jmonkey.cloud.auth.service.impl;

import com.wang.jmonkey.cloud.auth.feign.UserService;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 授权服务UserDetailService
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userService.findUserVoByUsername(username);
        return new UserDetailsImpl( userVo );
    }
}
