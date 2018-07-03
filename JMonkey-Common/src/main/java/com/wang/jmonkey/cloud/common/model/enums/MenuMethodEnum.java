package com.wang.jmonkey.cloud.common.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: 菜单请求方法枚举
 * @Auther: HeJiawang
 * @Date: 2018/7/3
 */
public enum MenuMethodEnum implements IEnum {

    Get("Get", "Get"),
    Post("Post", "Post"),
    Put("Put", "Put"),
    Delete("Delete", "Delete");

    private String value;
    private String desc;

    MenuMethodEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }
}
