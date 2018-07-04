package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 角色菜单测试
 * @Auther: HeJiawang
 * @Date: 2018/7/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
public class RoleMenuTest extends TestCase {

    @Resource
    private ISysRoleMenuService roleMenuService;

    @Test
    public void findMenuByRoleTest(){
        List<String> menuIds = roleMenuService.findMenuByRole("1");

        System.out.println(menuIds.size());
    }
}
