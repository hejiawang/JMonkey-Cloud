package com.wang.jmonkey.cloud.common.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: 性别枚举
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public enum  SexEnum implements IEnum {

    Man("man", "男"),
    Woman("woman", "女"),
    Other("other", "其他");

    private String value;
    private String desc;

    SexEnum(final String value, final String desc) {
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
