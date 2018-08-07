package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDictValueEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 字典值 Mapper
 * @Auther: HeJiawang
 * @Date: 2018/8/1
 */
public interface SysDictValueMapper extends BaseMapper<SysDictValueEntity> {

    /**
     * 根据字典类型获取该类型的字典值
     * @param type 字典类型
     * @return
     */
    List<SysDictValueEntity> findDictValueByType(@Param("type") String type);
}
