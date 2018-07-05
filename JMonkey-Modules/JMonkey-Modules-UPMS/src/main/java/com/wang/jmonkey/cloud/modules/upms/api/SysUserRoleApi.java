package com.wang.jmonkey.cloud.modules.upms.api;

import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户角色api
 * @Auther: HeJiawang
 * @Date: 2018/7/5
 */
@RestController
@RequestMapping("/userRole")
public class SysUserRoleApi extends BaseHttp {

    @Resource
    private ISysUserRoleService userRoleService;

    /**
     * 根据用户ID获取用户角色ID list
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/findRoleIdByUserId")
    public HttpResult<List<String>> findRoleIdByUserId( String userId ){
        return new HttpResult<>( userRoleService.findRoleIdByUserId(userId) );
    }

    /**
     * 根据角色ID获取用户ID list
     * @param roleId 角色ID
     * @return
     */
    @GetMapping("/findUserIdByRoleId")
    public HttpResult<List<String>> findUserIdByRoleId( String roleId ){
        return new HttpResult<>( userRoleService.findUserIdByRoleId(roleId) );
    }

    /**
     * 设置用户角色
     * @param userId 用户ID
     * @param roleIds 角色list
     * @return
     */
    @PostMapping(value="/saveRoles")
    public HttpResult<Boolean> saveRoles( String userId, @RequestParam(value = "roleIds[]", required=false )List<String> roleIds ){
        return new HttpResult<>(userRoleService.saveRoles(userId, roleIds));
    }

    /**
     * 设置拥有该角色的用户
     * @param roleId 角色ID
     * @param userIds 用户list
     * @return
     */
    @PostMapping(value="/saveUsers")
    public HttpResult<Boolean> saveUsers( String roleId, @RequestParam(value = "userIds[]", required=false )List<String> userIds ){
        return new HttpResult<>(userRoleService.saveUsers(roleId, userIds));
    }
}
