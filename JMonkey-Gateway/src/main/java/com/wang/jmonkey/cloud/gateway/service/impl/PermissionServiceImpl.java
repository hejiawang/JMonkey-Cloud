package com.wang.jmonkey.cloud.gateway.service.impl;

import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.gateway.service.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 权限 service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) {
                return hasPermission;
            }

            Set<MenuVo> urls = new HashSet<>();
            grantedAuthorityList.forEach( authority -> {
                System.out.println(authority.getAuthority());

                if (!StringUtils.equals(authority.getAuthority(), "ROLE_ANONYMOUS")) {
                    MenuVo menuVo = new MenuVo();

                    menuVo.setMethod("GET").setUrl("/jmonkey/upms/user/find/**");

                    urls.add(menuVo);
                }
            } );

            System.out.println(request.getRequestURI());
            System.out.println(request.getMethod());

            for( MenuVo menuVo : urls ){
                if (StringUtils.isNotEmpty(menuVo.getUrl()) && antPathMatcher.match(menuVo.getUrl(), request.getRequestURI())
                        && request.getMethod().equalsIgnoreCase(menuVo.getMethod())) {
                    hasPermission = true;
                    break;
                }
            }
        }

        return hasPermission;
    }
}
