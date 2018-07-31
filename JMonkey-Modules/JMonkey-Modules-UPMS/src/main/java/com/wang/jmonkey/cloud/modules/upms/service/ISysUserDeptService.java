package com.wang.jmonkey.cloud.modules.upms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserDeptEntity;

import java.util.List;

/**
 * @Description: 用户部门关联 service
 * @Auther: HeJiawang
 * @Date: 2018/7/31
 */
public interface ISysUserDeptService extends IService<SysUserDeptEntity> {

    /**
     * 设置用户部门
     * @param userId 用户ID
     * @param deptIdList 部门ID s
     * @return
     */
    Boolean saveDepts(String userId, List<String> deptIdList);

    /**
     * 删除用户部门
     * @param userId 用户ID
     */
    void deleteAllByUserId(String userId);

    /**
     * 删除用户部门
     * @param deptId 部门ID
     */
    void deleteAllByDeptId( String deptId );

    /**
     * 获取用户的部门信息
     * @param userId 用户ID
     * @return
     */
    List<SysDeptEntity> findDeptByUserId(String userId);
}
