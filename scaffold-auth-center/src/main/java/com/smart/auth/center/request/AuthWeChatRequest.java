package com.smart.auth.center.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.smart.auth.center.config.AuthConfig;
import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.model.AuthToken;
import com.smart.auth.center.model.AuthUser;
import com.smart.auth.center.model.AuthUserGender;
import com.smart.auth.center.utils.UrlBuilder;
import com.smart.starter.core.model.ApiResult;


/**
 * 微信登录
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthWeChatRequest extends BaseAuthRequest {
    public AuthWeChatRequest(AuthConfig config) {
        super(config, AuthSource.WECHAT);
    }

    /**
     * 微信的特殊性，此时返回的信息同时包含 openid 和 access_token
     *
     * @param code 授权码
     * @return 所有信息
     */
    @Override
    protected AuthToken getAccessToken(String code) {
        String accessTokenUrl = UrlBuilder.getWeChatAccessTokenUrl(config.getClientId(), config.getClientSecret(), code);
        return this.getToken(accessTokenUrl);
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        String openId = authToken.getOpenId();

        HttpResponse response = HttpRequest.get(UrlBuilder.getWeChatUserInfoUrl(accessToken, openId)).execute();
        JSONObject object = JSONObject.parseObject(response.body());

        this.checkResponse(object);

        return AuthUser.builder()
                .username(object.getString("nickname"))
                .nickname(object.getString("nickname"))
                .avatar(object.getString("headimgurl"))
                .location(object.getString("country") + "-" + object.getString("province") + "-" + object.getString("city"))
                .uuid(openId)
                .gender(AuthUserGender.getRealGender(object.getString("sex")))
                .token(authToken)
                .source(AuthSource.WECHAT)
                .build();
    }

    @Override
    public ApiResult refresh(AuthToken oldToken) {
        String refreshTokenUrl = UrlBuilder.getWeChatRefreshUrl(config.getClientId(), oldToken.getRefreshToken());
        return ApiResult.success(this.getToken(refreshTokenUrl));
    }

    /**
     * 检查响应内容是否正确
     *
     * @param object 请求响应内容
     */
    private void checkResponse(JSONObject object) {
        if (object.containsKey("errcode")) {
            throw new AuthException(object.getIntValue("errcode"), object.getString("errmsg"));
        }
    }
    /**
     * 获取token，适用于获取access_token和刷新token
     *
     * @param accessTokenUrl 实际请求token的地址
     * @return token对象
     */
    private AuthToken getToken(String accessTokenUrl) {
        HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
        JSONObject object = JSONObject.parseObject(response.body());

        this.checkResponse(object);

        return AuthToken.builder()
                .accessToken(object.getString("access_token"))
                .refreshToken(object.getString("refresh_token"))
                .expireIn(object.getIntValue("expires_in"))
                .openId(object.getString("openid"))
                .build();
    }
}
