package com.wang.jmonkey.cloud.gateway.service.impl;

import com.wang.jmonkey.cloud.common.model.enums.RecordStatusEnum;
import com.wang.jmonkey.cloud.common.model.vo.RoleVo;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 授权服务UserDetailService
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String finalPassword = bCryptPasswordEncoder.encode("123456");

        List<RoleVo> roleList = new ArrayList<>();
        roleList.add(new RoleVo().setName("name_1").setCode("code_1"));
        roleList.add(new RoleVo().setName("name_2").setCode("code_2"));

        UserVo userVo = new UserVo();
        userVo.setRoleList(roleList).setUsername("admin").setPassword(finalPassword).setDeleteFlag(RecordStatusEnum.Used);

        return new UserDetailsImpl(userVo);
    }
}
