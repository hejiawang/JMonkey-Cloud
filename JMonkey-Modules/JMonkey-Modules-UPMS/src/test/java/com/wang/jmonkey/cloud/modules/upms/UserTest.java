package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.modules.upms.common.enums.SexEnum;
import com.wang.jmonkey.cloud.modules.upms.model.entity.SysUserEntity;
import com.wang.jmonkey.cloud.modules.upms.service.IUserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
//@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
//@MapperScan(basePackages = {"com.wang.jmonkey.cloud.modules.*.mapper"})
public class UserTest extends TestCase {

    @Autowired
    private IUserService userService;

    @Test
    public void saveTest(){
        SysUserEntity userEntity = new SysUserEntity().setUsername("userTest").setPassword("123456")
                .setPhone("13333333333").setSalt("salt").setSex(SexEnum.Man);
        userEntity.insert();
    }

}
