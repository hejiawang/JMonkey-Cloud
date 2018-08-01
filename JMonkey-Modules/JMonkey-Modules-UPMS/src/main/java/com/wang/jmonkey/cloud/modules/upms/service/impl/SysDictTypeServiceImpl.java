package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysDictTypeMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictTypeEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 字典类型 ServiceImpl
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictTypeEntity> implements ISysDictTypeService {

    @Autowired
    private SysDictTypeMapper dictTypeMapper;

    /**
     * 获取字典类型分页数据
     * @param page
     * @param dictTypeEntity
     * @return
     */
    @Override
    public Page<SysDictTypeEntity> selectPage( Page<SysDictTypeEntity> page, SysDictTypeEntity dictTypeEntity ){
        EntityWrapper<SysDictTypeEntity> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysDictTypeEntity());
        wrapper.like("type", dictTypeEntity.getType(), SqlLike.DEFAULT);
        wrapper.orderBy( "create_date", false );

        return this.selectPage(page, wrapper);
    }

    /**
     * 校验字典类型是否存在
     * @param dictTypeEntity 字典类型
     * @return
     */
    @Override
    public Boolean checkExist(SysDictTypeEntity dictTypeEntity) {
        return dictTypeMapper.checkExist(dictTypeEntity) > 0;
    }
}
