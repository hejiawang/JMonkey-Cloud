package com.wang.jmonkey.cloud.modules.upms.model.dto;

import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 部门dto信息
 * @Auther: HeJiawang
 * @Date: 2018/7/25
 */
@Data
@Accessors(chain = true)
public class DeptDto extends SysDeptEntity {

    /**
     * 上级部门名称
     */
    private String parentName;
}
