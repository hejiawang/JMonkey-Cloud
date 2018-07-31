package com.wang.jmonkey.cloud.common.component.aop;

import com.wang.jmonkey.cloud.common.http.result.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 校验失败异常处理
 * @Auther: HeJiawang
 * @Date: 2018/7/30
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionAop {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResult<Void> handleException(Exception e){
        log.error(e.getMessage(), e);

        HttpResult<Void> httpResult = new HttpResult<>();

        BindingResult result = null;
        if (e instanceof MethodArgumentNotValidException) result = ((MethodArgumentNotValidException) e).getBindingResult();
        else if (e instanceof BindException) result = ((BindException) e).getBindingResult();

        if (result != null) {
            StringBuilder errorMsg = new StringBuilder();
            result.getAllErrors().forEach( error ->  errorMsg.append(error.getDefaultMessage()).append(",") );
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());

            httpResult.setIsSuccess(false).setMessage(errorMsg.toString());
        }

        return httpResult;
    }

}
