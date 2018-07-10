package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.common.model.vo.MenuVo;
import com.wang.jmonkey.cloud.modules.upms.model.dto.MenuTreeDto;
import com.wang.jmonkey.cloud.modules.upms.service.ISysMenuService;
import com.wang.jmonkey.cloud.modules.upms.service.ISysRoleMenuService;
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

    @Resource
    private ISysRoleMenuService roleMenuService;

    @Test
    public void treeTest(){
        List<MenuTreeDto> menuTreeDtoList = sysMenuService.treeList();
        System.out.println(menuTreeDtoList);
    }

    @Test
    public void findMenuVoByRoleCode(){
        List<MenuVo> menuVoList = roleMenuService.findMenuVoByRoleCode("admin");
        System.out.printf(menuVoList.size() + "");
    }
}
