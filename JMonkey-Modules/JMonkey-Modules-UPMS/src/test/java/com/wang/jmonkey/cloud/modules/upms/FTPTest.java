package com.wang.jmonkey.cloud.modules.upms;

import com.wang.jmonkey.cloud.common.utils.file.FtpFileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JMonkeyUPMSApplication.class)
public class FTPTest {

    @Test
    public void treeTest(){
        try {
            InputStream input = new FileInputStream( new File("D:\\nihao.txt"));
            FtpFileUtil.uploadFile("/text", "nihao123.txt", input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
