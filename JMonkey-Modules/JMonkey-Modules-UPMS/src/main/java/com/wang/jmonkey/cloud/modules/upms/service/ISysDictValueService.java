package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictValueEntity;

import java.util.List;

/**
 * @Description: 字典值Service
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
public interface ISysDictValueService extends IService<SysDictValueEntity> {

    /**
     * 获取字典值
     * @param dictValueEntity 字典信息
     * @return
     */
    List<SysDictValueEntity> selectList(SysDictValueEntity dictValueEntity);

    /**
     * 根据字典类型获取该类型的字典值
     * @param type 字典类型
     * @return
     */
    List<SysDictValueEntity> findDictValueByType(String type);
}
