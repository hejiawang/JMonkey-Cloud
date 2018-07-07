package com.wang.jmonkey.cloud.common.model.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.cloud.common.model.BaseVo;
import com.wang.jmonkey.cloud.common.model.enums.SexEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Data
@Accessors(chain = true)
public class UserVo  extends BaseVo {

    /**
     * id
     */
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

    private List<RoleVo> roleList = new ArrayList<>();

}
