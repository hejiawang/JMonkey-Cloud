package com.wang.jmonkey.cloud.modules.upms;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonTest {

    @Test
    public void strTest(){

        String str = "";
        System.out.println(null == str || StringUtils.equals("", str));
    }
}
