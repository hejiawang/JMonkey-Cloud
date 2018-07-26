package com.wang.jmonkey.cloud.modules.upms;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.cloud.common.model.enums.SexEnum;
import com.wang.jmonkey.cloud.modules.upms.model.dto.UserDto;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.ISysUserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
public class UserTest extends TestCase {

    @Autowired
    private ISysUserService userService;

    @Test
    public void saveTest(){
        SysUserEntity userEntity = new SysUserEntity().setUsername("userTest").setPassword("123456")
                .setPhone("13333333333").setSalt("salt").setSex(SexEnum.Man);
        userEntity.insert();
    }

    @Test
    public void checkUserName(){
        Boolean isHave = userService.checkUserName( new SysUserEntity().setUsername("test1") );
        System.out.printf( isHave.toString() );
    }

    @Test
    public void selectAllTest(){
        List<UserDto> userDtoList = userService.selectAll();
        System.out.println(userDtoList.size());
    }

}
