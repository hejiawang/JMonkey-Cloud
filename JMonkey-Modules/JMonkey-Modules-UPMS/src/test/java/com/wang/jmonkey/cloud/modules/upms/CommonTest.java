package com.wang.jmonkey.cloud.modules.upms;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void strFormtTest(){
        String str = String.format("%sApi", "SysDepart");
        System.out.println(str);

    }

    @Test
    public void listSubTest(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("0");

        System.out.println(list.subList(0, 4));


    }
}
