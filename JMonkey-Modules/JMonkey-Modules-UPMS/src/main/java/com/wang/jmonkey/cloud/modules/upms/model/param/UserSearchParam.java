package com.wang.jmonkey.cloud.modules.upms.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 查询用户信息列表的查询参数
 * @Auther: HeJiawang
 * @Date: 2018/8/7
 */
@Data
@Accessors(chain = true)
public class UserSearchParam implements Serializable {

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户角色ID
     */
    private String roleId;

    /**
     * 用户部门ID
     */
    private String deptId;

}
