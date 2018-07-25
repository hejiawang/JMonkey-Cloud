package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.DeptDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * 部门信息 Mapper 接口
 * @author HeJiawang
 * @since 2018-07-24
 */
public interface SysDeptMapper extends BaseMapper<SysDeptEntity> {

    /**
     * 根据部门ID获取部门Dto信息
     * @param id 部门ID
     * @return
     */
    DeptDto selectDtoById( @Param("id")Serializable id);
}
