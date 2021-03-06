package com.wang.jmonkey.cloud.common.xss;

import com.wang.jmonkey.cloud.common.exception.CheckedException;
import org.apache.commons.lang.StringUtils;

/**
 * @Description: SQL过滤
 * https://gitee.com/renrenio/renren-fast/blob/master/src/main/java/io/renren/common/xss/SQLFilter.java
 * @Auther: HeJiawang
 * @Date: 2018/6/26
 */
public class SqlFilter {

    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new CheckedException("包含非法字符");
            }
        }

        return str;
    }
}
