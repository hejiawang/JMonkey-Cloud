package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.modules.upms.model.entity.SysDeptEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysDeptService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
public class DeptTest extends TestCase {

    @Resource
    private ISysDeptService sysDeptService;

    @Test
    public void saveTest(){
        SysDeptEntity deptEntity = new SysDeptEntity();
        deptEntity.setName("测试123").setCode("test").setSort(1);

        sysDeptService.insert(deptEntity);
    }

    @Test
    public void modifyTest(){
        SysDeptEntity deptEntity = new SysDeptEntity();
        deptEntity.setName("测试modify").setCode("test").setSort(1).setId("7f6785ff495b46df95350dab4a0dcc62");

        sysDeptService.updateById(deptEntity);
    }
}
