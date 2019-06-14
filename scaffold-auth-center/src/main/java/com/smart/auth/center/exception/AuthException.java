package com.smart.auth.center.exception;


import com.smart.auth.center.model.ResponseStatus;

/**
 * 认识异常
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthException extends RuntimeException {

    private int errorCode;
    private String errorMsg;

    public AuthException(String errorMsg) {
        this(ResponseStatus.FAILURE.getCode(), errorMsg);
    }

    public AuthException(int errorCode, String errorMsg) {
        super(errorCode + ":" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AuthException(ResponseStatus status) {
        super(status.getMsg());
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
