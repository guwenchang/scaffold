package com.smart.auth.center.consts;


import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.ResponseStatus;

/**
 * 各api需要的url
 * @author guwenchang
 * @date 2019-06-14
 */
public enum ApiUrl {
    /**
     * Github
     */
    GITHUB {
        @Override
        public String authorize() {
            return "https://github.com/login/oauth/authorize";
        }

        @Override
        public String accessToken() {
            return "https://github.com/login/oauth/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.github.com/user";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 新浪微博
     */
    WEIBO {
        @Override
        public String authorize() {
            return "https://api.weibo.com/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://api.weibo.com/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weibo.com/2/users/show.json";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 支付宝
     */
    ALIPAY {
        @Override
        public String authorize() {
            return "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";
        }

        @Override
        public String accessToken() {
            return "https://openapi.alipay.com/gateway.do";
        }

        @Override
        public String userInfo() {
            return "https://openapi.alipay.com/gateway.do";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * QQ
     */
    QQ {
        @Override
        public String authorize() {
            return "https://graph.qq.com/oauth2.0/authorize";
        }

        @Override
        public String accessToken() {
            return "https://graph.qq.com/oauth2.0/token";
        }

        @Override
        public String userInfo() {
            return "https://graph.qq.com/user/get_user_info";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }
    },
    /**
     * 微信
     */
    WECHAT {
        @Override
        public String authorize() {
            return "https://open.weixin.qq.com/connect/qrconnect";
        }

        @Override
        public String accessToken() {
            return "https://api.weixin.qq.com/sns/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weixin.qq.com/sns/userinfo";
        }

        @Override
        public String revoke() {
            throw new AuthException(ResponseStatus.UNSUPPORTED);
        }

        @Override
        public String refresh() {
            return "https://api.weixin.qq.com/sns/oauth2/refresh_token";
        }
    };
    /**
     * 授权的api
     *
     * @return url
     */
    public abstract String authorize();

    /**
     * 获取accessToken的api
     *
     * @return url
     */
    public abstract String accessToken();

    /**
     * 获取用户信息的api
     *
     * @return url
     */
    public abstract String userInfo();

    /**
     * 取消授权的api
     *
     * @return url
     */
    public abstract String revoke();

    /**
     * 刷新授权的api
     *
     * @return url
     */
    public abstract String refresh();

}
