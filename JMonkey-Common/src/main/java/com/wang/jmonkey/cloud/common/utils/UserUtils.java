package com.wang.jmonkey.cloud.common.utils;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.wang.jmonkey.cloud.common.constant.CommonConstant;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/25
 */
@Slf4j
public class UserUtils {

    private static final ThreadLocal<String> THREAD_LOCAL_USER = new TransmittableThreadLocal<>();
    private static final String KEY_USER = "user";

    /**
     * 获取请求中token
     *
     * @param httpServletRequest request
     * @return token
     */
    public static String getToken(HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader(CommonConstant.REQ_HEADER);
        return StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
    }

    /**
     * 根据用户请求中的token 获取用户名
     *
     * @param request Request
     * @return "" or username
     */
    public static String getUserName(HttpServletRequest request) {
        String username = "";
        String authorization = request.getHeader(CommonConstant.REQ_HEADER);
        if (StringUtils.isEmpty(authorization)) {
            return username;
        }
        String token = StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
        if (StringUtils.isEmpty(token)) {
            return username;
        }
        String key = Base64.getEncoder().encodeToString(SecurityConstants.JWT_KEY.getBytes());
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            username = claims.get("user_name").toString();
        } catch (Exception ex) {
            log.error("用户名解析异常,token:{},key:{}", token, key);
        }
        return username;
    }

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @param httpServletRequest request
     * @return 角色名
     */
    public static List<String> getRole(HttpServletRequest httpServletRequest) {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(SecurityConstants.JWT_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        List<String> roleCodes = (List<String>) claims.get("authorities");
        return roleCodes;
    }

    /**
     * 设置用户信息
     * @param username 用户名
     */
    public static void setUser(String username) {
        THREAD_LOCAL_USER.set(username);
        MDC.put(KEY_USER, username);
    }

    /**
     * 从threadlocal 获取用户名
     * @return 用户名
     */
    public static String getUser() {
        return THREAD_LOCAL_USER.get();
    }

    public static void clearAllUserInfo() {
        THREAD_LOCAL_USER.remove();
        MDC.remove(KEY_USER);
    }
}
