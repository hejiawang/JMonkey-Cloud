package com.wang.jmonkey.cloud.modules.upms.model.dto;

import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 用户的基本信息以及角色信息、权限信息
 * @Auther: HeJiawang
 * @Date: 2018/7/10
 */
@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {

    /**
     * 用户基本信息
     */
    private SysUserEntity user;

    /**
     * 用户角色名称集合
     */
    private List<String> roleCodeList;

    /**
     * 用户权限集合
     */
    private List<String> permissionList;
}
