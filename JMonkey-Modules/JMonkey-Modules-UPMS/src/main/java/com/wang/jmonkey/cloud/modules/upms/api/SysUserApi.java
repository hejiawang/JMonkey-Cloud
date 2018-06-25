package com.wang.jmonkey.cloud.modules.upms.api;

import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.common.utils.UserUtils;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Description: 用户管理 api
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@RestController
@RequestMapping("/user")
public class SysUserApi extends BaseHttp {

    @Resource
    private ISysUserService sysUserService;

    /**
     * 保存用户信息
     * @param userEntity 用户信息
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HttpResult<Boolean> save(SysUserEntity userEntity){
        return new HttpResult<>(sysUserService.insert(userEntity));
    }

    /**
     * 修改用户信息
     * @param userEntity 用户信息
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public HttpResult<Boolean> modify( SysUserEntity userEntity ){
        return new HttpResult<>(sysUserService.updateById(userEntity));
    }

    /**
     * 删除用户信息
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(sysUserService.deleteById(id));
    }

    /**
     * 查找用户信息
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public HttpResult<SysUserEntity> findById( @PathVariable Serializable id ){
        String userName = UserUtils.getUserName(request);
        System.out.println(userName);

        return new HttpResult<>(sysUserService.selectById(id));
    }
}
