package com.juperdog.resourceserv.configs;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * Created by wasan_kha on 10/6/2017 AD.
 */
@Configuration
@EnableResourceServer
//@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2Config extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler(){
        return new OAuth2MethodSecurityExpressionHandler();
    }

//    @Primary
//    @Bean
//    public RemoteTokenServices tokenService() {
//        RemoteTokenServices tokenService = new RemoteTokenServices();
//        tokenService.setCheckTokenEndpointUrl(
//                "http://localhost:8081/auth/oauth/check_token");
//        tokenService.setClientId("clientId");
//        tokenService.setClientSecret("secret");
//        return tokenService;
//    }

}
