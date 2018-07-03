package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.service.ISysMenuService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 菜单测试
 * @Auther: HeJiawang
 * @Date: 2018/7/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
public class MenuTest extends TestCase {

    @Resource
    private ISysMenuService sysMenuService;

    @Test
    public void treeTest(){
        List<MenuTreeDto> menuTreeDtoList = sysMenuService.treeList();
        System.out.println(menuTreeDtoList);
    }
}
