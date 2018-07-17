package com.wang.jmonkey.cloud.common.utils.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: FTP操作文件工具类
 * @Auther: HeJiawang
 * @Date: 2018/7/16
 */
@Slf4j
@Component
public class FtpFileUtil {

    @Value("${JMonkey.ftp.host}")
    private static String host;

    @Value("${JMonkey.ftp.post}")
    private static int post;

    @Value("${JMonkey.ftp.userName}")
    private static String userName;

    @Value("${JMonkey.ftp.password}")
    private static String password;

    /**
     * 初始化ftp连接信息
     * @return
     */
    public static FTPClient initFtp(){
        System.out.println(host);

        FTPClient ftp;
        try {
            ftp = new FTPClient();
            ftp.setControlEncoding("UTF-8");
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.connect(host, post);// 连接FTP服务器
            ftp.login(userName, password);// 登录

            if ( !FTPReply.isPositiveCompletion( ftp.getReplyCode() ) ){
                ftp.disconnect();
                ftp = null;
            }
        } catch (IOException e) {
            log.error("ftp init error : ", e);
            ftp = null;
        }
        return ftp;
    }

    /**
     * 上传文件
     * @return
     */
    public static boolean uploadFile( String ftpFilePath, String ftpFileName, InputStream input ) {
        boolean result = false;

        FTPClient ftp = FtpFileUtil.initFtp();
        if( null == ftp ) return result;

        try {
            ftp.makeDirectory(ftpFilePath);
            ftp.changeWorkingDirectory(ftpFilePath);
            ftp.storeFile(ftpFileName, input);
            input.close();
            ftp.logout();
        } catch (IOException e) {
            log.error("ftp init uploadFile : ", e);
        }  finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    log.error("ftp init uploadFile disconnect : ", ioe);
                }
            }
        }

        return result;
    }

}
