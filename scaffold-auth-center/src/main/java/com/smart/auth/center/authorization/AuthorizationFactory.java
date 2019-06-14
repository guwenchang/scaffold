package com.smart.auth.center.authorization;


import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.model.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权工厂类
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthorizationFactory {

    private static Map<String, Authorization> authorizationMap = new HashMap<>();
    private static boolean loader = false;

    private AuthorizationFactory() {

    }

    /**
     * 根据第三方平台，获取具体的授权工具
     *
     * @param source 平台
     * @return 具体的Authorization
     */
    public static Authorization getAuthorize(AuthSource source) {
        if (null == source) {
            throw new AuthException(ResponseStatus.NO_AUTH_SOURCE);
        }
        registerAllAuthorize();

        Authorization authorization = authorizationMap.get(source.toString());
        if (null == authorization) {
            throw new AuthException(ResponseStatus.UNIDENTIFIED_PLATFORM);
        }
        return authorization;
    }

    /**
     * 将所有Authorize的实现类注册到authorizeMap中，
     * 每次增加新的平台都需要在这儿添加注册代码
     */
    private static void registerAllAuthorize() {
        if (loader) {
            return;
        }
        AuthorizationFactory.register(AuthSource.ALIPAY, new AlipayAuthorization());
        AuthorizationFactory.register(AuthSource.GITHUB, new GithubAuthorization());
        AuthorizationFactory.register(AuthSource.QQ, new QqAuthorization());
        AuthorizationFactory.register(AuthSource.WECHAT, new WeChatAuthorization());
        AuthorizationFactory.register(AuthSource.WEIBO, new WeiboAuthorization());
        loader = true;
    }

    private static void register(AuthSource authSource, Authorization authorization) {
        authorizationMap.put(authSource.toString(), authorization);
    }
}
