package com.smart.auth.center.request;

import com.smart.auth.center.authorization.AuthorizationFactory;
import com.smart.auth.center.config.AuthConfig;
import com.smart.auth.center.exception.AuthException;
import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.model.AuthToken;
import com.smart.auth.center.model.AuthUser;
import com.smart.auth.center.model.ResponseStatus;
import com.smart.auth.center.utils.AuthConfigChecker;
import com.smart.starter.core.model.ApiResult;
import lombok.Data;


/**
 *
 * @author guwenchang
 * @date 2019-06-14
 */
@Data
public abstract class BaseAuthRequest implements AuthRequest {
    protected AuthConfig config;
    protected AuthSource source;

    public BaseAuthRequest(AuthConfig config, AuthSource source) {
        this.config = config;
        this.source = source;
        if (!AuthConfigChecker.isSupportedAuth(config)) {
            throw new AuthException(ResponseStatus.PARAMETER_INCOMPLETE);
        }
    }

    protected abstract AuthToken getAccessToken(String code);

    protected abstract AuthUser getUserInfo(AuthToken authToken);

    @Override
    public ApiResult login(String code) {
        try {
            AuthToken authToken = this.getAccessToken(code);
            AuthUser user = this.getUserInfo(authToken);
            return ApiResult.success(user);
        } catch (Exception e) {
            return ApiResult.error(e.getMessage());
        }
    }

    @Override
    public String authorize() {
        return AuthorizationFactory.getAuthorize(source).getAuthorizeUrl(config);
    }
}
