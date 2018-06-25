package com.wang.jmonkey.cloud.common.component.aop;

import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import com.wang.jmonkey.cloud.common.model.vo.UserVo;
import com.wang.jmonkey.cloud.common.utils.UserUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/25
 */
@Aspect
@Component
public class ControllerAop {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Autowired
    private CacheManager cacheManager;

    @Pointcut("execution(public com.wang.jmonkey.cloud.common.http.result.HttpResult *(..))")
    public void pointCutR() { }

    /**
     * 拦截器具体实现
     *
     * @param pjp 切点 所有返回对象R
     * @return R  结果包装
     */
    @Around("pointCutR()")
    public Object methodRHandler(ProceedingJoinPoint pjp) {
        return methodHandler(pjp);
    }

    private Object methodHandler(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = UserUtils.getToken(request);
        UserVo userVo = null;
        if (StringUtils.isNotEmpty(token)) {
            userVo = cacheManager.getCache(SecurityConstants.TOKEN_USER_DETAIL).get(token, UserVo.class);
        }
        String username;
        if (userVo == null) {
            username = UserUtils.getUserName(request);
            if (StringUtils.isNotEmpty(username)) {
                UserUtils.setUser(username);
            }
        } else {
            username = userVo.getUsername();
            UserUtils.setUser(username);
        }
        logger.info("Controller AOP get username:{}", username);

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(pjp.getArgs()));

        Object result;

        try {
            result = pjp.proceed();
            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            logger.error("异常信息：", e);
            throw new RuntimeException(e);
        } finally {
            if (StringUtils.isNotEmpty(username)) {
                UserUtils.clearAllUserInfo();
            }
        }

        return result;
    }
}
