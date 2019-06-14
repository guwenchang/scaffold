package com.smart.auth.center.request;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.smart.auth.center.config.AuthConfig;
import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.model.AuthToken;
import com.smart.auth.center.model.AuthUser;
import com.smart.auth.center.model.AuthUserGender;
import com.smart.auth.center.utils.GlobalAuthUtil;
import com.smart.auth.center.utils.UrlBuilder;
import org.springframework.util.StringUtils;


import java.util.Map;

/**
 * qq登录
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthQqRequest extends BaseAuthRequest {
    public AuthQqRequest(AuthConfig config) {
        super(config, AuthSource.QQ);
    }

    @Override
    protected AuthToken getAccessToken(String code) {
        String accessTokenUrl = UrlBuilder.getQqAccessTokenUrl(config.getClientId(), config.getClientSecret(), code, config
                .getRedirectUri());
        HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
        Map<String, String> accessTokenObject = GlobalAuthUtil.parseStringToMap(response.body());
        if (!accessTokenObject.containsKey("access_token")) {
            throw new AuthException("Unable to get token from qq using code [" + code + "]");
        }
        return AuthToken.builder()
                .accessToken(accessTokenObject.get("access_token"))
                .expireIn(Integer.valueOf(accessTokenObject.get("expires_in")))
                .refreshToken(accessTokenObject.get("refresh_token"))
                .build();
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        String openId = this.getOpenId(accessToken);
        HttpResponse response = HttpRequest.get(UrlBuilder.getQqUserInfoUrl(config.getClientId(), accessToken, openId))
                .execute();
        JSONObject object = JSONObject.parseObject(response.body());
        if (object.getIntValue("ret") != 0) {
            throw new AuthException(object.getString("msg"));
        }
        String avatar = object.getString("figureurl_qq_2");
        if (StringUtils.isEmpty(avatar)) {
            avatar = object.getString("figureurl_qq_1");
        }
        return AuthUser.builder()
                .username(object.getString("nickname"))
                .nickname(object.getString("nickname"))
                .avatar(avatar)
                .location(object.getString("province") + "-" + object.getString("city"))
                .uuid(openId)
                .gender(AuthUserGender.getRealGender(object.getString("gender")))
                .token(authToken)
                .source(AuthSource.QQ)
                .build();
    }

    private String getOpenId(String accessToken) {
        HttpResponse response = HttpRequest.get(UrlBuilder.getQqOpenidUrl("https://graph.qq.com/oauth2.0/me", accessToken))
                .execute();
        if (response.isOk()) {
            String body = response.body();
            String removePrefix = StrUtil.replace(body, "callback(", "");
            String removeSuffix = StrUtil.replace(removePrefix, ");", "");
            String openId = StrUtil.trim(removeSuffix);
            JSONObject object = JSONObject.parseObject(openId);
            if (object.containsKey("openid")) {
                return object.getString("openid");
            }
            throw new AuthException("Invalid openId");
        }
        throw new AuthException("Invalid openId");
    }
}
