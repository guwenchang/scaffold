package com.smart.auth.center.utils;


import com.smart.auth.center.consts.ApiUrl;

import java.text.MessageFormat;

/**
 *
 * @author guwenchang
 * @date 2019-06-14
 */
public class UrlBuilder {

    private static final String GITHUB_ACCESS_TOKEN_PATTERN = "{0}?client_id={1}&client_secret={2}&code={3}&redirect_uri={4}";
    private static final String GITHUB_USER_INFO_PATTERN = "{0}?access_token={1}";
    private static final String GITHUB_AUTHORIZE_PATTERN = "{0}?client_id={1}&state=1&redirect_uri={2}";

    private static final String WEIBO_ACCESS_TOKEN_PATTERN = "{0}?client_id={1}&client_secret={2}&grant_type=authorization_code&code={3}&redirect_uri={4}";
    private static final String WEIBO_USER_INFO_PATTERN = "{0}?{1}";
    private static final String WEIBO_AUTHORIZE_PATTERN = "{0}?client_id={1}&response_type=code&redirect_uri={2}";

    private static final String ALIPAY_AUTHORIZE_PATTERN = "{0}?app_id={1}&scope=auth_user&redirect_uri={2}&state=init";

    private static final String QQ_ACCESS_TOKEN_PATTERN = "{0}?client_id={1}&client_secret={2}&grant_type=authorization_code&code={3}&redirect_uri={4}";
    private static final String QQ_USER_INFO_PATTERN = "{0}?oauth_consumer_key={1}&access_token={2}&openid={3}";
    private static final String QQ_AUTHORIZE_PATTERN = "{0}?client_id={1}&response_type=code&redirect_uri={2}&state={3}";
    private static final String QQ_OPENID_PATTERN = "{0}?access_token={1}";

    private static final String WECHAT_AUTHORIZE_PATTERN = "{0}?appid={1}&redirect_uri={2}&response_type=code&scope=snsapi_login&state={3}#wechat_redirect";
    private static final String WECHAT_ACCESS_TOKEN_PATTERN = "{0}?appid={1}&secret={2}&code={3}&grant_type=authorization_code";
    private static final String WECHAT_REFRESH_TOKEN_PATTERN = "{0}?appid={1}&grant_type=refresh_token&refresh_token={2}";
    private static final String WECHAT_USER_INFO_PATTERN = "{0}?access_token={1}&openid={2}&lang=zh_CN";


    /**
     * 获取githubtoken的接口地址
     *
     * @param clientId     github 应用的Client ID
     * @param clientSecret github 应用的Client Secret
     * @param code         github 授权前的code，用来换token
     * @param redirectUri  待跳转的页面
     * @return full url
     */
    public static String getGithubAccessTokenUrl(String clientId, String clientSecret, String code, String redirectUri) {
        return MessageFormat.format(GITHUB_ACCESS_TOKEN_PATTERN, ApiUrl.GITHUB.accessToken(), clientId, clientSecret, code, redirectUri);
    }

    /**
     * 获取github用户详情的接口地址
     *
     * @param token github 应用的token
     * @return full url
     */
    public static String getGithubUserInfoUrl(String token) {
        return MessageFormat.format(GITHUB_USER_INFO_PATTERN, ApiUrl.GITHUB.userInfo(), token);
    }

    /**
     * 获取github授权地址
     *
     * @param clientId    github 应用的Client ID
     * @param redirectUrl github 应用授权成功后的回调地址
     * @return full url
     */
    public static String getGithubAuthorizeUrl(String clientId, String redirectUrl) {
        return MessageFormat.format(GITHUB_AUTHORIZE_PATTERN, ApiUrl.GITHUB.authorize(), clientId, redirectUrl);
    }

    /**
     * 获取weibo token的接口地址
     *
     * @param clientId     weibo 应用的App Key
     * @param clientSecret weibo 应用的App Secret
     * @param code         weibo 授权前的code，用来换token
     * @param redirectUri  待跳转的页面
     * @return full url
     */
    public static String getWeiboAccessTokenUrl(String clientId, String clientSecret, String code, String redirectUri) {
        return MessageFormat.format(WEIBO_ACCESS_TOKEN_PATTERN, ApiUrl.WEIBO.accessToken(), clientId, clientSecret, code, redirectUri);
    }

    /**
     * 获取weibo用户详情的接口地址
     *
     * @param token weibo 应用的token
     * @return full url
     */
    public static String getWeiboUserInfoUrl(String token) {
        return MessageFormat.format(WEIBO_USER_INFO_PATTERN, ApiUrl.WEIBO.userInfo(), token);
    }

    /**
     * 获取weibo授权地址
     *
     * @param clientId    weibo 应用的Client ID
     * @param redirectUrl weibo 应用授权成功后的回调地址
     * @return full url
     */
    public static String getWeiboAuthorizeUrl(String clientId, String redirectUrl) {
        return MessageFormat.format(WEIBO_AUTHORIZE_PATTERN, ApiUrl.WEIBO.authorize(), clientId, redirectUrl);
    }


    /**
     * 获取qq token的接口地址
     *
     * @param clientId     qq 应用的App Key
     * @param clientSecret qq 应用的App Secret
     * @param code         qq 授权前的code，用来换token
     * @param redirectUri  待跳转的页面
     * @return full url
     */
    public static String getQqAccessTokenUrl(String clientId, String clientSecret, String code, String redirectUri) {
        return MessageFormat.format(QQ_ACCESS_TOKEN_PATTERN, ApiUrl.QQ.accessToken(), clientId, clientSecret, code, redirectUri);
    }

    /**
     * 获取qq用户详情的接口地址
     *
     * @param clientId qq 应用的clientId
     * @param token    qq 应用的token
     * @param openId   qq 应用的openId
     * @return full url
     */
    public static String getQqUserInfoUrl(String clientId, String token, String openId) {
        return MessageFormat.format(QQ_USER_INFO_PATTERN, ApiUrl.QQ.userInfo(), clientId, token, openId);
    }

    /**
     * 获取qq授权地址
     *
     * @param clientId    qq 应用的Client ID
     * @param redirectUrl qq 应用授权成功后的回调地址
     * @return full url
     */
    public static String getQqAuthorizeUrl(String clientId, String redirectUrl) {
        return MessageFormat.format(QQ_AUTHORIZE_PATTERN, ApiUrl.QQ.authorize(), clientId, redirectUrl, System.currentTimeMillis());
    }

    /**
     * 获取qq授权地址
     *
     * @param url   获取qqopenid的api接口地址
     * @param token qq 应用授权的token
     * @return full url
     */
    public static String getQqOpenidUrl(String url, String token) {
        return MessageFormat.format(QQ_OPENID_PATTERN, url, token);
    }

    /**
     * 获取alipay授权地址
     *
     * @param clientId    alipay 应用的Client ID
     * @param redirectUrl alipay 应用授权成功后的回调地址
     * @return full url
     */
    public static String getAlipayAuthorizeUrl(String clientId, String redirectUrl) {
        return MessageFormat.format(ALIPAY_AUTHORIZE_PATTERN, ApiUrl.ALIPAY.authorize(), clientId, redirectUrl);
    }

    /**
     * 获取微信 授权地址
     *
     * @param clientId    微信 应用的appid
     * @param redirectUrl 微信 应用授权成功后的回调地址
     * @return full url
     */
    public static String getWeChatAuthorizeUrl(String clientId, String redirectUrl) {
        return MessageFormat.format(WECHAT_AUTHORIZE_PATTERN, ApiUrl.WECHAT.authorize(), clientId, redirectUrl, System.currentTimeMillis());
    }

    /**
     * 获取微信 token的接口地址
     *
     * @param clientId     微信 应用的appid
     * @param clientSecret 微信 应用的secret
     * @param code         微信 授权前的code，用来换token
     * @return full url
     */
    public static String getWeChatAccessTokenUrl(String clientId, String clientSecret, String code) {
        return MessageFormat.format(WECHAT_ACCESS_TOKEN_PATTERN, ApiUrl.WECHAT.accessToken(), clientId, clientSecret, code);
    }

    /**
     * 获取微信 用户详情的接口地址
     *
     * @param token  微信 应用返回的 access token
     * @param openId 微信 应用返回的openId
     * @return full url
     */
    public static String getWeChatUserInfoUrl(String token, String openId) {
        return MessageFormat.format(WECHAT_USER_INFO_PATTERN, ApiUrl.WECHAT.userInfo(), token, openId);
    }

    /**
     * 获取微信 刷新令牌 地址
     *
     * @param clientId     微信 应用的appid
     * @param refreshToken 微信 应用返回的刷新token
     * @return full url
     */
    public static String getWeChatRefreshUrl(String clientId, String refreshToken) {
        return MessageFormat.format(WECHAT_REFRESH_TOKEN_PATTERN, ApiUrl.WECHAT.refresh(), clientId, refreshToken);
    }

}
