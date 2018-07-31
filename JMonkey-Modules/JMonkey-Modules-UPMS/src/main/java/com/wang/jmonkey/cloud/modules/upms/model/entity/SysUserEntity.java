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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "用户名长度为3-20")
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
    @NotEmpty(message = "真实姓名不能为空")
    @Length(max = 20, message = "真实姓名长度为不能超过20")
    private String realName;

    /**
     * 手机号码
     */
    @NotEmpty(message = "手机号码不能为空")
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

    /**
     * 用户头像
     */
    private String photo;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
