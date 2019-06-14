package com.smart.auth.center.request;


import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthToken;
import com.smart.starter.core.model.ApiResult;
import com.smart.auth.center.model.ResponseStatus;

/**
 *
 * @author guwenchang
 * @date 2019-06-14
 */
public interface AuthRequest {

    /**
     * 返回认证url，可自行跳转页面
     *
     * @return 返回授权地址
     */
    default String authorize() {
        throw new AuthException(ResponseStatus.NOT_IMPLEMENTED);
    }

    /**
     * 第三方登录
     *
     * @param code 通过authorize换回的code
     * @return 返回登录成功后的用户信息
     */
    default ApiResult login(String code) {
        throw new AuthException(ResponseStatus.NOT_IMPLEMENTED);
    }


    /**
     * 刷新access token （续期）
     *
     * @param authToken 登录成功后返回的Token信息
     * @return AuthResponse
     */
    default ApiResult refresh(AuthToken authToken) {
        throw new AuthException(ResponseStatus.NOT_IMPLEMENTED);
    }
}
