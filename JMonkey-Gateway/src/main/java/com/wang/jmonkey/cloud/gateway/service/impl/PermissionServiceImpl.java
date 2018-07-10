package com.wang.jmonkey.cloud.gateway.service.impl;

import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.gateway.feign.MenuService;
import com.wang.jmonkey.cloud.gateway.service.PermissionService;
import com.xiaoleilu.hutool.collection.CollUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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

    @Value("${JMonkey.baseUrl}")
    private String BASE_URL;

    @Resource
    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断登录者是否拥有访问路径的权限
     * @param request HttpServletRequest 请求路径信息
     * @param authentication 认证信息
     * @return true/false
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) return hasPermission;

            Set<MenuVo> urls = permissionMenu(grantedAuthorityList);
            for( MenuVo menuVo : urls ){
                if (StringUtils.isNotEmpty(menuVo.getUrl()) && antPathMatcher.match(BASE_URL + menuVo.getUrl(), request.getRequestURI())
                        && request.getMethod().equalsIgnoreCase(menuVo.getMethod().getValue())) {
                    hasPermission = true;
                    break;
                }
            }
        }

        return true;
    }

    private Set<MenuVo> permissionMenu( List<SimpleGrantedAuthority> grantedAuthorityList ){
        Set<MenuVo> urls = new HashSet<>();
        grantedAuthorityList.forEach( authority -> {
            if ( !StringUtils.equals(authority.getAuthority(), SecurityConstants.BASE_ROLE) ) {
                Set<MenuVo> menuVOSet = menuService.findMenuVoByRoleCode(authority.getAuthority());
                if (CollUtil.isNotEmpty(menuVOSet)) CollUtil.addAll(urls, menuVOSet);
            }
        });

        return urls;
    }
}
