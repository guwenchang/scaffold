package com.smart.auth.center.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.smart.auth.center.config.AuthConfig;
import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.model.AuthToken;
import com.smart.auth.center.model.AuthUser;
import com.smart.auth.center.utils.GlobalAuthUtil;
import com.smart.auth.center.utils.UrlBuilder;

import java.util.Map;

/**
 * Github登录
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthGithubRequest extends BaseAuthRequest {

    public AuthGithubRequest(AuthConfig config) {
        super(config, AuthSource.GITHUB);
    }

    @Override
    protected AuthToken getAccessToken(String code) {
        String accessTokenUrl = UrlBuilder.getGithubAccessTokenUrl(config.getClientId(), config.getClientSecret(), code, config.getRedirectUri());
        HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
        Map<String, String> res = GlobalAuthUtil.parseStringToMap(response.body());
        if (res.containsKey("error")) {
            throw new AuthException(res.get("error") + ":" + res.get("error_description"));
        }
        return AuthToken.builder()
                .accessToken(res.get("access_token"))
                .build();
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        HttpResponse response = HttpRequest.get(UrlBuilder.getGithubUserInfoUrl(accessToken)).execute();
        String userInfo = response.body();
        JSONObject object = JSONObject.parseObject(userInfo);
        return AuthUser.builder()
                .uuid(object.getString("id"))
                .username(object.getString("login"))
                .avatar(object.getString("avatar_url"))
                .blog(object.getString("blog"))
                .nickname(object.getString("name"))
                .company(object.getString("company"))
                .location(object.getString("location"))
                .email(object.getString("email"))
                .remark(object.getString("bio"))
                .token(authToken)
                .source(AuthSource.GITHUB)
                .build();
    }
}
