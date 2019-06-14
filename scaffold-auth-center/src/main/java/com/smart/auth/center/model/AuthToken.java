package com.smart.auth.center.model;

import lombok.Builder;
import lombok.Data;
/**
 * token
 * @author guwenchang
 * @date 2019-06-14
 */
@Data
@Builder
public class AuthToken {
    private String accessToken;
    private int expireIn;
    private String refreshToken;
    private String uid;
    private String openId;
    private String accessCode;

}
