package com.smart.auth.center.model;

/**
 * auth code
 * @author guwenchang
 * @date 2019-06-14
 */
public enum ResponseStatus {
    SUCCESS(0, "Success"),
    FAILURE(1, "Failure"),
    NOT_IMPLEMENTED(5001, "Not Implemented"),
    PARAMETER_INCOMPLETE(5002, "Parameter incomplete"),
    UNSUPPORTED(5003, "Unsupported operation"),
    NO_AUTH_SOURCE(5004, "AuthSource cannot be null"),
    UNIDENTIFIED_PLATFORM(5005, "Unidentified platform"),
    ;

    private int code;
    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

