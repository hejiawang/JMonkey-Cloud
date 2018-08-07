package com.wang.jmonkey.cloud.modules.upms.api;

import com.wang.jmonkey.cloud.common.http.abs.BaseHttp;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictValueEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDictValueService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 字典值 API
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@RestController
@RequestMapping("/dict/value")
public class SysDictValueApi extends BaseHttp {

    @Resource
    private ISysDictValueService dictValueService;

    /**
     * 分页查询字典值
     * @param dictValueEntity
     * @return
     */
    @GetMapping("/listAll")
    public HttpResult<List<SysDictValueEntity>> list(SysDictValueEntity dictValueEntity){
        return new HttpResult<>( dictValueService.selectList( dictValueEntity ) );
    }

    /**
     * 保存字典值
     * @param dictValueEntity 字典值
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save(@RequestBody @Validated SysDictValueEntity dictValueEntity){
        return new HttpResult<>(dictValueService.insert(dictValueEntity));
    }

    /**
     * 修改字典值
     * @param dictValueEntity 字典值
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody @Validated SysDictValueEntity dictValueEntity ){
        return new HttpResult<>(dictValueService.updateById(dictValueEntity));
    }

    /**
     * 删除字典值
     * @param id 字典值ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(dictValueService.deleteById(id));
    }

    /**
     * 查找字典值
     * @param id 字典值ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<SysDictValueEntity> findById(@PathVariable Serializable id ){
        return new HttpResult<>(dictValueService.selectById(id));
    }

    /**
     * 根据字典类型获取该类型的字典值
     * @param type 字典类型
     * @return
     */
    @GetMapping(value = "/findValue/{type}")
    public HttpResult<List<SysDictValueEntity>> findDictValueByType( @PathVariable String type ){
        return new HttpResult<>(dictValueService.findDictValueByType(type));
    }
}
