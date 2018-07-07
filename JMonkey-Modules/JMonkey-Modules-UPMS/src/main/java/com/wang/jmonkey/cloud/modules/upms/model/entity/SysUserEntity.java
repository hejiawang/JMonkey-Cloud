package com.wang.jmonkey.cloud.modules.upms.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.cloud.common.model.BaseEntity;
import com.wang.jmonkey.cloud.common.model.enums.SexEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户信息
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserEntity extends BaseEntity<SysUserEntity> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 用户真是姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SexEnum sex;

    /**
     * 出生日期
     */
    private Date birthday;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
