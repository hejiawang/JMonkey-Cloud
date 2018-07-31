package com.wang.jmonkey.cloud.modules.upms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserDeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 用户部门关联mapper
 * @Auther: HeJiawang
 * @Date: 2018/7/31
 */
public interface SysUserDeptMapper extends BaseMapper<SysUserDeptEntity> {

    /**
     * 删除用户部门
     * @param userId
     */
    void deleteAllByUserId(@Param("userId")String userId);

    /**
     * 删除用户部门
     * @param deptId 部门ID
     */
    void deleteAllByDeptId(@Param("deptId")String deptId);

    /**
     * 获取用户的部门信息
     * @param userId 用户ID
     * @return
     */
    List<SysDeptEntity> findDeptByUserId(@Param("userId")String userId);
}
