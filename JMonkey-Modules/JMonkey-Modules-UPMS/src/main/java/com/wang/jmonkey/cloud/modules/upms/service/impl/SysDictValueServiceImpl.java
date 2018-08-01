package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysDictValueMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictValueEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDictValueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 字典值 Service Impl
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
@Service
public class SysDictValueServiceImpl extends ServiceImpl<SysDictValueMapper, SysDictValueEntity> implements ISysDictValueService {

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
}
