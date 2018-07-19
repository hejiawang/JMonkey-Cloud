package com.wang.jmonkey.cloud.common.utils;

import java.util.UUID;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/19
 */
public class UUIDUtil {

    public static String value(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
