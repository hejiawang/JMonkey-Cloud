package com.wang.jmonkey.cloud.gateway.feign;

import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.gateway.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @Description: 菜单信息服务
 * @Auther: HeJiawang
 * @Date: 2018/7/9
 */
@FeignClient(name = "JMonkey-Modules-UPMS", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {

    /**
     * 获取角色的菜单权限
     * @param roleCode 角色Code
     * @return 菜单信息
     */
    @GetMapping(value = "/roleMenu/findMenuVoByRoleCode/{roleCode}")
    Set<MenuVo> findMenuVoByRoleCode( @PathVariable("roleCode") String roleCode );
}
