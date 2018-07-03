package com.wang.jmonkey.cloud.modules.upms.model.dto;

import com.wang.jmonkey.cloud.modules.upms.model.entity.SysMenuEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/3
 */
@Data
@Accessors(chain = true)
public class MenuDto extends SysMenuEntity {

    private String parentName;
}
