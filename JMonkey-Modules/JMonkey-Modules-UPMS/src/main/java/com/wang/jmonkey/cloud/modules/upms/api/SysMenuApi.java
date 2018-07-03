package com.wang.jmonkey.cloud.modules.upms.api;

import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuDto;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 菜单管理api
 * @Auther: HeJiawang
 * @Date: 2018/6/26
 */
@RestController
@RequestMapping("/menu")
public class SysMenuApi extends BaseHttp {

    @Resource
    private ISysMenuService sysMenuService;

    /**
     * 获取树形菜单数据
     * @return
     */
    @GetMapping(value="/treeList")
    public HttpResult<List<MenuTreeDto>> treeList(){
        return new HttpResult<>(sysMenuService.treeList());
    }

    /**
     * 保存菜单
     * @param menuEntity 菜单信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysMenuEntity menuEntity ){
        return new HttpResult<>( sysMenuService.insert(menuEntity) );
    }

    /**
     * 修改菜单
     * @param menuEntity 菜单信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysMenuEntity menuEntity ){
        return new HttpResult<>( sysMenuService.updateById(menuEntity) );
    }

    /**
     * 删除菜单
     * @param id 菜单ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(sysMenuService.deleteById(id));
    }

    /**
     * 根据ID获取菜单信息
     * @param id 菜单ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<MenuDto> findById(@PathVariable Serializable id ){
        return new HttpResult<>(sysMenuService.selectDtoById(id));
    }
}
