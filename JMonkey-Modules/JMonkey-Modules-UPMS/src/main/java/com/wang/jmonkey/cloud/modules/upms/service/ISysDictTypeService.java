package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictTypeEntity;

/**
 * @Description: 字典类型Service
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
public interface ISysDictTypeService extends IService<SysDictTypeEntity> {

    /**
     * 获取字典类型分页数据
     * @param page
     * @param dictTypeEntity
     * @return
     */
    Page<SysDictTypeEntity> selectPage(Page<SysDictTypeEntity> page, SysDictTypeEntity dictTypeEntity );

    /**
     * 校验字典类型是否存在
     * @param dictTypeEntity 字典类型
     * @return
     */
    Boolean checkExist(SysDictTypeEntity dictTypeEntity);
}
