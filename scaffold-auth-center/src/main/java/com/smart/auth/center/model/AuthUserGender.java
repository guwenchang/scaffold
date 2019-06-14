package com.smart.auth.center.model;

import java.util.Arrays;

/**
 * 用户性别
 * @author guwenchang
 * @date 2019-06-14
 */
public enum AuthUserGender {
    MALE(1, "男"), FEMALE(0, "女"), UNKNOW(-1, "");
    private int code;
    private String desc;

    AuthUserGender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AuthUserGender getRealGender(String code) {
        if (code == null) {
            return UNKNOW;
        }
        String[] males = {"m", "男", "1", "male", "F"};
        if (Arrays.asList(males).contains(code)) {
            return MALE;
        }
        String[] females = {"f", "女", "0", "female"};
        if (Arrays.asList(females).contains(code)) {
            return FEMALE;
        }
        return UNKNOW;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
