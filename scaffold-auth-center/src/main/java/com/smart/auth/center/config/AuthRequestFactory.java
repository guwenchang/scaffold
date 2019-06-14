package com.smart.auth.center.config;


import com.smart.auth.center.model.AuthSource;
import com.smart.auth.center.request.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权工厂类
 * @author guwenchang
 * @date 2019-06-14
 */
@Component
@EnableConfigurationProperties(ThirdAuthProperties.class)
public class AuthRequestFactory {

    @Resource
    private ThirdAuthProperties thirdAuthProperties;

    private Map<String, AuthRequest> authRequestMap = new HashMap<>();

    @PostConstruct
    public void registerAllAuth() {
        for (Map.Entry<String, AuthConfig> authRequestEntry : thirdAuthProperties.getAuthConfigs().entrySet()) {
            if (authRequestEntry.getKey().equals(AuthSource.GITHUB.toString())){
                authRequestMap.put(authRequestEntry.getKey(),new AuthGithubRequest(authRequestEntry.getValue()));
            }
            if (authRequestEntry.getKey().equals(AuthSource.ALIPAY.toString())){
                authRequestMap.put(authRequestEntry.getKey(),new AuthAlipayRequest(authRequestEntry.getValue()));
            }
            if (authRequestEntry.getKey().equals(AuthSource.QQ.toString())){
                authRequestMap.put(authRequestEntry.getKey(),new AuthQqRequest(authRequestEntry.getValue()));
            }
            if (authRequestEntry.getKey().equals(AuthSource.WECHAT.toString())){
                authRequestMap.put(authRequestEntry.getKey(),new AuthWeChatRequest(authRequestEntry.getValue()));
            }
            if (authRequestEntry.getKey().equals(AuthSource.WEIBO.toString())){
                authRequestMap.put(authRequestEntry.getKey(),new AuthWeiboRequest(authRequestEntry.getValue()));
            }
        }
    }


    public AuthRequest getAuthRequest(String source){
        return authRequestMap.get(source.toUpperCase());
    }

}
