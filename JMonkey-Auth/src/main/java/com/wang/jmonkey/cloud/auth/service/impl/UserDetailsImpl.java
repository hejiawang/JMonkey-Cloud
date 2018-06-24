package com.wang.jmonkey.cloud.auth.service.impl;

import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import com.wang.jmonkey.cloud.common.model.enums.RecordStatusEnum;
import com.wang.jmonkey.cloud.common.model.vo.RoleVo;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 授权用户
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private RecordStatusEnum status;
    private List<RoleVo> roleList = new ArrayList<>();

    public UserDetailsImpl(UserVo userVo) {
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getDeleteFlag();
        roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleVo role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getCode()));
        }
        authorityList.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return StringUtils.equals(RecordStatusEnum.Disable.getValue(), status.getValue()) ? false : true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(RecordStatusEnum.Used.getValue(), status.getValue()) ? true : false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleVo> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleVo> roleList) {
        this.roleList = roleList;
    }

    public RecordStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RecordStatusEnum status) {
        this.status = status;
    }
}
