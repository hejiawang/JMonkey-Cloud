package com.wang.jmonkey.cloud.common.constant;

/**
 * @Description: 授权类型
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public interface SecurityConstants {

    /**
     * 授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";
    /**
     * 密码模式
     */
    String PASSWORD = "password";
    /**
     * 刷新token
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * 基础角色
     */
    String BASE_ROLE = "ROLE_BASE";

    /**
     * jwt签名
     */
    String JWT_KEY = "JMONKEY_JWT_KEY";

    /**
     * 资源服务的ID
     */
    String RESOURCE_ID = "JMONKEY_RESOURCE_ID";

    /**
     * token-uservo
     */
    String TOKEN_USER_DETAIL = "token-user-detail";

    /**
     * 项目的license
     */
    String JMONKEY_LICENSE = "made by hejiawang";

    /**
     * 前缀
     */
    String JMONKEY_PREFIX = "jmonkey_";
}
