package com.wang.jmonkey.cloud.modules.upms.api;

import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.model.dto.DeptTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 部门信息 api
 * @Auther: HeJiawang
 * @Date: 2018-07-24
 */
@RestController
@RequestMapping("/dept")
public class SysDeptApi extends BaseHttp {

    @Resource
    private ISysDeptService service;

    /**
     * 获取树形部门信息数据
     * @return
     */
    @GetMapping(value="/treeList")
    public HttpResult<List<DeptTreeDto>> treeList(){
        return new HttpResult<>(service.treeList());
    }

    /**
     * 保存实体信息
     * @param entity 实体信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysDeptEntity entity ){
        return new HttpResult<>(service.insert(entity));
    }

    /**
     * 修改实体信息
     * @param entity 实体信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysDeptEntity entity ){
        return new HttpResult<>(service.updateById(entity));
    }

    /**
     * 删除实体信息
     * @param id 实体ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(service.deleteById(id));
    }

    /**
     * 查找实体信息
     * @param id 实体ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<SysDeptEntity> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectById(id));
    }

}