package com.smart.auth.center.request;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.smart.auth.center.config.AuthConfig;
import com.smart.auth.center.consts.ApiUrl;
import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.model.AuthToken;
import com.smart.auth.center.model.AuthUser;
import com.smart.auth.center.model.AuthUserGender;
import org.springframework.util.StringUtils;

/**
 * 支付宝
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthAlipayRequest extends BaseAuthRequest {

    private AlipayClient alipayClient;

    public AuthAlipayRequest(AuthConfig config) {
        super(config, AuthSource.ALIPAY);
        this.alipayClient = new DefaultAlipayClient(ApiUrl.ALIPAY.accessToken(), config.getClientId(), config.getClientSecret(), "json", "UTF-8", config.getAlipayPublicKey(), "RSA2");
    }

    @Override
    protected AuthToken getAccessToken(String code) {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(code);
        AlipaySystemOauthTokenResponse response = null;
        try {
            response = this.alipayClient.execute(request);
        } catch (Exception e) {
            throw new AuthException("Unable to get token from alipay using code [" + code + "]", e);
        }
        if (!response.isSuccess()) {
            throw new AuthException(response.getSubMsg());
        }
        return AuthToken.builder()
                .accessToken(response.getAccessToken())
                .uid(response.getUserId())
                .expireIn(Integer.parseInt(response.getExpiresIn()))
                .refreshToken(response.getRefreshToken())
                .build();
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse response = null;
        try {
            response = this.alipayClient.execute(request, accessToken);
        } catch (AlipayApiException e) {
            throw new AuthException(e.getErrMsg(), e);
        }
        if (!response.isSuccess()) {
            throw new AuthException(response.getSubMsg());
        }
        String province = response.getProvince(),
                city = response.getCity();
        return AuthUser.builder()
                .uuid(response.getUserId())
                .username(StringUtils.isEmpty(response.getUserName()) ? response.getNickName() : response.getUserName())
                .nickname(response.getNickName())
                .avatar(response.getAvatar())
                .location(String.format("%s %s", StringUtils.isEmpty(province) ? "" : province, StringUtils.isEmpty(city) ? "" : city))
                .gender(AuthUserGender.getRealGender(response.getGender()))
                .token(authToken)
                .source(AuthSource.ALIPAY)
                .build();
    }
}
