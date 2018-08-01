package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictTypeEntity;

/**
 * @Description: 字典类型 Mapper
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictTypeEntity> {

    /**
     * 校验字典类型是否存在
     * @param dictTypeEntity 字典类型
     * @return
     */
    Integer checkExist(SysDictTypeEntity dictTypeEntity);
}
