package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @Description: 菜单信息mapper
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    /**
     * 获取菜单信息
     * @param id 菜单ID
     * @return 菜单dto
     */
    MenuDto selectDtoById( @Param("id")Serializable id );
}
