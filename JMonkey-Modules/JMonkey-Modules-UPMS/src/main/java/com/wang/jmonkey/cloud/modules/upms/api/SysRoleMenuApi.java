package com.wang.jmonkey.cloud.modules.upms.api;

import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 角色菜单api
 * @Auther: HeJiawang
 * @Date: 2018/7/4
 */
@RestController
@RequestMapping("/roleMenu")
public class SysRoleMenuApi extends BaseHttp {

    @Resource
    private ISysRoleMenuService roleMenuService;

    /**
     * 获取角色授权的菜单
     * @param roleId 角色ID
     * @return 菜单ID list
     */
    @GetMapping(value = "/findMenuByRole/{roleId}")
    public HttpResult<List<String>> findMenuByRole( @PathVariable String roleId ){
        return new HttpResult<>( roleMenuService.findMenuByRole(roleId) );
    }

    /**
     * 更新角色菜单权限
     * @param roleId 角色ID
     * @param menuIds 菜单id list
     * @return
     */
    @PostMapping(value="/modifyAuth")
    public HttpResult<Boolean> modifyAuth(String roleId, @RequestParam(value = "menuIds[]", required=false )List<String> menuIds ){
        return new HttpResult<>( roleMenuService.modifyAuth(roleId, menuIds) );
    }
}
