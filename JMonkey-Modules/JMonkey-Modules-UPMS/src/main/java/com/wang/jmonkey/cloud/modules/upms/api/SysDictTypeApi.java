package com.wang.jmonkey.cloud.modules.upms.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpPageResult;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictTypeEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDictTypeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Description: 字典类型API
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@RestController
@RequestMapping("/dict/type")
public class SysDictTypeApi extends BaseHttp {

    @Resource
    private ISysDictTypeService dictTypeService;

    /**
     * 分页查询字典类型
     * @param page
     * @param dictTypeEntity
     * @return
     */
    @GetMapping("/list")
    public HttpPageResult<SysDictTypeEntity> list(Page<SysDictTypeEntity> page, SysDictTypeEntity dictTypeEntity){
        return new HttpPageResult<>( dictTypeService.selectPage( page, dictTypeEntity ) );
    }

    /**
     * 保存字典类型
     * @param dictTypeEntity 字典类型
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save(@RequestBody @Validated SysDictTypeEntity dictTypeEntity){
        return new HttpResult<>(dictTypeService.insert(dictTypeEntity));
    }

    /**
     * 修改字典类型
     * @param dictTypeEntity 字典类型
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody @Validated SysDictTypeEntity dictTypeEntity ){
        return new HttpResult<>(dictTypeService.updateById(dictTypeEntity));
    }

    /**
     * 删除字典类型
     * @param id 字典类型ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(dictTypeService.deleteById(id));
    }

    /**
     * 查找字典类型
     * @param id 字典类型ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<SysDictTypeEntity> findById(@PathVariable Serializable id ){
        return new HttpResult<>(dictTypeService.selectById(id));
    }

    /**
     * 校验字典类型是否存在
     * @param dictTypeEntity 字典类型
     * @return
     */
    @PostMapping(value = "/checkExist")
    public HttpResult<Boolean> checkExist( @RequestBody SysDictTypeEntity dictTypeEntity ){
        return new HttpResult<>(dictTypeService.checkExist(dictTypeEntity));
    }
}
