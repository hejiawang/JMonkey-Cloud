package com.wang.jmonkey.cloud.modules.upms.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpPageResult;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysRoleEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 角色管理api
 * @Auther: HeJiawang
 * @Date: 2018/6/25
 */
@RestController
@RequestMapping("/role")
public class SysRoleApi extends BaseHttp {

    @Resource
    private ISysRoleService sysRoleService;

    /**
     * 分页查询角色信息
     * @param page page
     * @param roleEntity 角色信息
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<SysRoleEntity> list(Page<SysRoleEntity> page, SysRoleEntity roleEntity) {
        return new HttpPageResult<>( sysRoleService.selectPage( page, roleEntity ) );
    }

    /**
     * 获取所有角色信息
     * @return
     */
    @GetMapping(value = "/listAll")
    public HttpResult<List<SysRoleEntity>> listAll(){
        return new HttpResult<>( sysRoleService.selectList( new EntityWrapper<>( new SysRoleEntity() ) ) );
    }

    /**
     * 保存角色信息
     * @param roleEntity 角色信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysRoleEntity roleEntity ){
        return new HttpResult<>(sysRoleService.insert(roleEntity));
    }

    /**
     * 修改角色信息
     * @param roleEntity 角色信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysRoleEntity roleEntity ){
        return new HttpResult<>(sysRoleService.updateById(roleEntity));
    }

    /**
     * 删除角色信息
     * @param id 角色ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(sysRoleService.deleteById(id));
    }

    /**
     * 查找角色信息
     * @param id 角色ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<SysRoleEntity> findById(@PathVariable Serializable id ){
        return new HttpResult<>(sysRoleService.selectById(id));
    }

    /**
     * 校验角色code是否存在
     * @param roleEntity 角色信息
     * @return
     */
    @PostMapping(value = "/checkCode")
    public HttpResult<Boolean> checkCode( @RequestBody SysRoleEntity roleEntity ){
        return new HttpResult<>(sysRoleService.checkCode(roleEntity));
    }

    /**
     * 校验角色名称是否存在
     * @param roleEntity 角色信息
     * @return
     */
    @PostMapping(value = "/checkName")
    public HttpResult<Boolean> checkName( @RequestBody SysRoleEntity roleEntity ){
        return new HttpResult<>(sysRoleService.checkName(roleEntity));
    }
}
