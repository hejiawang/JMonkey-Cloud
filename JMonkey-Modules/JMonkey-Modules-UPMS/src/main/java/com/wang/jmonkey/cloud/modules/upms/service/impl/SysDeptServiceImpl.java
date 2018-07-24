package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.common.utils.TreeUtil;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysDeptMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.DeptTreeDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门信息 服务实现类
 * @author HeJiawang
 * @since 2018-07-24
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements ISysDeptService {

    /**
     * 获取树形部门信息数据
     * @return
     */
    @Override
    public List<DeptTreeDto> treeList() {

        EntityWrapper<SysDeptEntity> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysDeptEntity());
        wrapper.orderBy( "sort", true );

        return TreeUtil.bulid( DeptTreeDto.converFromEntity( this.selectList( wrapper ) ), null );
    }
}
