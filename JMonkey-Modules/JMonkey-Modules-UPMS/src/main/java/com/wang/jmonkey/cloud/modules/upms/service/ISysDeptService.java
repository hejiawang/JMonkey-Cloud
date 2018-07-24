package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.dto.DeptTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;

import java.util.List;

/**
 * 部门信息 服务类
 * @author HeJiawang
 * @since 2018-07-24
 */
public interface ISysDeptService extends IService<SysDeptEntity> {

    /**
     * 获取树形部门信息数据
     * @return
     */
    List<DeptTreeDto> treeList();
}
