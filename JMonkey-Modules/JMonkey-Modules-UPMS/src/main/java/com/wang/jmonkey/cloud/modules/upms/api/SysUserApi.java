package com.wang.jmonkey.cloud.modules.upms.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpPageResult;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

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
     * 用户信息列表
     * @param page
     * @param userEntity
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<SysUserEntity> list(Page<SysUserEntity> page, SysUserEntity userEntity) {
        return new HttpPageResult<>( sysUserService.selectPage( page, userEntity ) );
    }

    /**
     * 保存用户信息
     * @param userEntity 用户信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysUserEntity userEntity){
        return new HttpResult<>(sysUserService.insert(userEntity));
    }

    /**
     * 修改用户信息
     * @param userEntity 用户信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysUserEntity userEntity ){
        return new HttpResult<>(sysUserService.updateById(userEntity));
    }

    /**
     * 删除用户信息
     * @param id 用户ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(sysUserService.deleteById(id));
    }

    /**
     * 查找用户信息
     * @param id 用户ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<SysUserEntity> findById( @PathVariable Serializable id ){
        return new HttpResult<>(sysUserService.selectById(id));
    }
}
