package com.wang.jmonkey.cloud.common.component.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.wang.jmonkey.cloud.common.utils.UserUtils;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @Description: mybatis 自动填充字段
 * @Auther: HeJiawang
 * @Date: 2018/7/24
 */
public class DataMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createBy = getFieldValByName("createBy", metaObject);
        if ( createBy == null ) setFieldValByName("createBy", UserUtils.getUser(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateBy = getFieldValByName("updateBy", metaObject);
        if ( updateBy == null ) setFieldValByName("updateBy", UserUtils.getUser(), metaObject);
    }
}
