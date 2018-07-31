package com.wang.jmonkey.cloud.modules.upms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.cloud.modules.upms.mapper.SysUserDeptMapper;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description: 用户部门关联service impl
 * @Auther: HeJiawang
 * @Date: 2018/7/31
 */
@Service
public class SysUserDeptServiceImpl extends ServiceImpl<SysUserDeptMapper, SysUserDeptEntity> implements ISysUserDeptService {

    @Autowired
    private SysUserDeptMapper userDeptMapper;

    /**
     * 设置用户部门
     * @param userId 用户ID
     * @param deptIdList 部门ID s
     * @return
     */
    @Override
    public Boolean saveDepts(String userId, List<String> deptIdList) {
        userDeptMapper.deleteAllByUserId(userId);
        if(!CollectionUtils.isEmpty(deptIdList))
            deptIdList.forEach( deptId -> this.insert(new SysUserDeptEntity().setDeptId(deptId).setUserId(userId)) );
        return true;
    }

    /**
     * 删除用户部门
     * @param userId 用户ID
     */
    @Override
    public void deleteAllByUserId(String userId) {
        userDeptMapper.deleteAllByUserId(userId);
    }

    /**
     * 删除用户部门
     * @param deptId 部门ID
     */
    @Override
    public void deleteAllByDeptId(String deptId) {
        userDeptMapper.deleteAllByDeptId(deptId);
    }

    /**
     * 获取用户的部门信息
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<SysDeptEntity> findDeptByUserId(String userId) {
        return userDeptMapper.findDeptByUserId(userId);
    }
}
