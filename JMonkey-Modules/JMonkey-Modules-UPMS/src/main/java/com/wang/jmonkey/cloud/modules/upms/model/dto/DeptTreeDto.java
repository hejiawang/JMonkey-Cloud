package com.wang.jmonkey.cloud.modules.upms.model.dto;

import com.wang.jmonkey.cloud.common.model.BaseTreeNode;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树形部门信息dto
 * @Auther: HeJiawang
 * @Date: 2018/7/24
 */
@Data
@Accessors(chain = true)
public class DeptTreeDto extends BaseTreeNode {

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 将entity list装换为dto list
     * @param sysDeptEntityList
     * @return
     */
    public static  List<DeptTreeDto> converFromEntity(List<SysDeptEntity> sysDeptEntityList) {
        List<DeptTreeDto> deptTreeDtoList = new ArrayList<>();
        sysDeptEntityList.forEach(deptEntity -> deptTreeDtoList.add(converFromEntity(deptEntity)) );
        return deptTreeDtoList;
    }

    /**
     * 将entity装换为dto
     * @param deptEntity
     * @return
     */
    public static DeptTreeDto converFromEntity( SysDeptEntity deptEntity ){
        DeptTreeDto deptTreeDto = new DeptTreeDto();
        BeanUtils.copyProperties(deptEntity, deptTreeDto);
        return deptTreeDto;
    }
}
