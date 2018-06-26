package com.wang.jmonkey.cloud.gateway.componet.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.wang.jmonkey.cloud.common.component.bean.FilterUrlsPropertiesConfig;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import com.wang.jmonkey.cloud.common.exception.ValidateCodeException;
import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 验证码校验
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Slf4j
@RefreshScope
@Configuration("validateCodeFilter")
@ConditionalOnProperty(value = "security.validate.code", havingValue = "true")
public class ValidateCodeFilter extends ZuulFilter {

    private static final String EXPIRED_CAPTCHA_ERROR = "验证码已过期，请重新获取";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER + 1;
    }

    /**
     * 是否校验验证码
     * 1. 判断验证码开关是否开启
     * 2. 判断请求是否登录请求
     *
     * @return true or false
     */
    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        if ( !StrUtil.containsAnyIgnoreCase(request.getRequestURI(), SecurityConstants.OAUTH_TOKEN_URL) ) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        try {
            checkCode(RequestContext.getCurrentContext().getRequest());
        } catch (ValidateCodeException e) {
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.setResponseStatusCode(478);
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            ctx.setResponseBody(JSONObject.toJSONString(new HttpResult<>(e)));
        }

        return null;
    }

    /**
     * 检查验证码是否正确
     * @param httpServletRequest request
     * @throws ValidateCodeException 验证码校验异常
     */
    private void checkCode( HttpServletRequest httpServletRequest ) throws ValidateCodeException {
        String code = httpServletRequest.getParameter("code");
        if (StrUtil.isBlank(code)) {
            throw new ValidateCodeException("请输入验证码");
        }

        String key = SecurityConstants.DEFAULT_CODE_KEY + httpServletRequest.getParameter("randomStr");
        if (!redisTemplate.hasKey(key))  throw new ValidateCodeException(EXPIRED_CAPTCHA_ERROR);

        Object codeObj = redisTemplate.opsForValue().get(key);
        if (codeObj == null) throw new ValidateCodeException(EXPIRED_CAPTCHA_ERROR);

        String saveCode = codeObj.toString();
        if (StrUtil.isBlank(saveCode)) {
            redisTemplate.delete(key);
            throw new ValidateCodeException(EXPIRED_CAPTCHA_ERROR);
        }

        if (!StrUtil.equals(saveCode, code)) {
            redisTemplate.delete(key);
            throw new ValidateCodeException("验证码错误，请重新输入");
        }

        redisTemplate.delete(key);
    }
}
