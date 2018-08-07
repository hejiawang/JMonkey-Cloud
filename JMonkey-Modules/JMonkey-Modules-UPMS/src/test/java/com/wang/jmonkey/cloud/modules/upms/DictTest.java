package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.modules.upms.service.ISysDictValueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Description: 字典操作测试
 * @Auther: HeJiawang
 * @Date: 2018/8/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
public class DictTest {

    @Resource
    private ISysDictValueService dictValueService;

    @Test
    public void findValueTest(){
        dictValueService.findDictValueByType("sys_user_sex");
        dictValueService.findDictValueByType("sys_user_sex");
    }
}
