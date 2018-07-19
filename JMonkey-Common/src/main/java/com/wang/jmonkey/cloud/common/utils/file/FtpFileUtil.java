package com.wang.jmonkey.cloud.common.utils.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @Description: FTP操作文件工具类
 * @Auther: HeJiawang
 * @Date: 2018/7/16
 */
@Slf4j
@Component
public class FtpFileUtil {

    /**
     * 初始化ftp连接信息
     * @return
     */
    public static FTPClient initFtp(){
        FTPClient ftp;
        try {
            ftp = new FTPClient();
            ftp.setControlEncoding("UTF-8");
            ftp.connect(FTPParam.host, FTPParam.post);// 连接FTP服务器
            ftp.login(FTPParam.userName, FTPParam.password);// 登录

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
     * @param ftpFilePath 存储路径
     * @param ftpFileName 存储文件名
     * @param input 文件输入流
     * @return 是否上传成功
     */
    public static boolean uploadFile( String ftpFilePath, String ftpFileName, InputStream input ) {
        boolean result = false;

        FTPClient ftp = FtpFileUtil.initFtp();
        if( null == ftp ) return result;

        try {
            //解决ftp不能一次性创建多层目录问题
            String[] ftpPath = ftpFilePath.split("/");
            for( String path : ftpPath ){
                ftp.makeDirectory(path);
                ftp.changeWorkingDirectory(path);
            }

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            ftp.storeFile(ftpFileName, input);

            ftp.logout();
            result = true;
        } catch (IOException e) {
            result = false;
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

    /**
     * 构建FTP连接参数
     */
    @Component
    static class FTPParam {
        public static String host;
        public static int post;
        public static String userName;
        public static String password;

        @Value("${JMonkey.ftp.host:127.0.0.1}")
        public void setHost( String host ){
            this.host = host;
        }

        @Value("${JMonkey.ftp.post:21}")
        public void setPost( int post ){
            this.post = post;
        }

        @Value("${JMonkey.ftp.userName:name}")
        public void setUserName( String userName ){
            this.userName = userName;
        }

        @Value("${JMonkey.ftp.password:password}")
        public void setPassword( String password ){
            this.password = password;
        }
    }
}
