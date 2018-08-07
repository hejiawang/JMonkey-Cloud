package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysDictValueMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictValueEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 字典值 Service Impl
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@Service
public class SysDictValueServiceImpl extends ServiceImpl<SysDictValueMapper, SysDictValueEntity> implements ISysDictValueService {

    @Autowired
    private SysDictValueMapper dictValueMapper;

    /**
     * 获取字典值
     * @param dictValueEntity 字典信息
     * @return
     */
    @Override
    public List<SysDictValueEntity> selectList(SysDictValueEntity dictValueEntity) {
        EntityWrapper<SysDictValueEntity> wrapper = new EntityWrapper<>();
        wrapper.setEntity(dictValueEntity);
        wrapper.orderBy( "sort", true );
        return this.selectList( wrapper );
    }

    /**
     * 新增字典值
     * @param entity
     * @return
     */
    @CacheEvict(value = "sys_dict", allEntries = true)
    @Override
    public boolean insert(SysDictValueEntity entity) {
        return super.insert(entity);
    }

    /**
     * 删除字典值
     * @param id
     * @return
     */
    @CacheEvict(value = "sys_dict", allEntries = true)
    @Override
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }

    /**
     * 修改字典值
     * @param entity
     * @return
     */
    @CacheEvict(value = "sys_dict", allEntries = true)
    @Override
    public boolean updateById(SysDictValueEntity entity) {
        return super.updateById(entity);
    }

    /**
     * 根据字典类型获取该类型的字典值
     * @param type 字典类型
     * @return
     */
    @Override
    @Cacheable(value = "sys_dict", key = "#type  + '_sys_dict'")
    public List<SysDictValueEntity> findDictValueByType(String type) {
        return dictValueMapper.findDictValueByType(type);
    }
}
