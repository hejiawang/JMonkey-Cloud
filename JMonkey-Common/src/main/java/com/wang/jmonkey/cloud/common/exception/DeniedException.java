package com.wang.jmonkey.cloud.common.exception;

/**
 * @Description: 403 授权拒绝
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
public class DeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DeniedException() {
    }

    public DeniedException(String message) {
        super(message);
    }

    public DeniedException(Throwable cause) {
        super(cause);
    }

    public DeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
