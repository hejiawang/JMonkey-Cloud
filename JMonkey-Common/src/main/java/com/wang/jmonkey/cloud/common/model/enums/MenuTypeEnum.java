package com.wang.jmonkey.cloud.common.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: 菜单类型枚举
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public enum MenuTypeEnum implements IEnum {

    Menu("menu", "男"),
    Button("button", "其他");

    private String value;
    private String desc;

    MenuTypeEnum(final String value, final String desc) {
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
