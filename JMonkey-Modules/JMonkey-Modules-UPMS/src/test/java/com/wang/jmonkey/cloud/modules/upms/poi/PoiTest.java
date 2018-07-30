package com.wang.jmonkey.cloud.modules.upms.poi;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Description: poi 测试
 * @Auther: HeJiawang
 * @Date: 2018/7/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PoiTest  {

    @Test
    public void test() throws Exception {
        File excelFile = new File("D:/poitest.xlsx");
        InputStream is = new FileInputStream(excelFile);

        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);
        int headerNum = 1;


    }
}
