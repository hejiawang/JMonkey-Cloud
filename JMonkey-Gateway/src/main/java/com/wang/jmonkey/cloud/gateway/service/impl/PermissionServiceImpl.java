package com.wang.jmonkey.cloud.gateway.service.impl;

import com.wang.jmonkey.cloud.gateway.service.PermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 权限 service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) {
                return hasPermission;
            }


            grantedAuthorityList.forEach( authority -> {
                System.out.println(authority.getAuthority());
            } );

            System.out.println(request.getRequestURI());
            System.out.println(request.getMethod());

            hasPermission = true;
        }

        return hasPermission;
    }
}
