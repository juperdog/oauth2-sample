package com.juperdog.client.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * Created by wasan_kha on 10/9/2017 AD.
 */
@Configuration
@EnableOAuth2Client
public class OAuthConfig {

    private String redirectUri = "/callback";

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
                                                 OAuth2ProtectedResourceDetails details) {
        OAuth2RestTemplate oauth2RestTemplate = new OAuth2RestTemplate(details, oauth2ClientContext);
        return oauth2RestTemplate;
    }

    @Bean
    public OAuth2ClientAuthenticationProcessingFilter oauth2ClientAuthenticationProcessingFilter(
            OAuth2RestTemplate oauth2RestTemplate,
            RemoteTokenServices tokenService) {

        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(redirectUri);
        filter.setRestTemplate(oauth2RestTemplate);
        filter.setTokenServices(tokenService);
        return filter;
    }

    @Bean
    public LogFilter logFilter(){
        return new LogFilter();
    }

    @Bean
    public RemoteTokenServices tokenService(OAuth2ProtectedResourceDetails details) {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl("http://localhost:8081/auth/oauth/check_token");
        tokenService.setClientId(details.getClientId());
        tokenService.setClientSecret(details.getClientSecret());
        return tokenService;
    }


    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        // May need an OAuth2AuthenticationEntryPoint for non-browser clients
        return new LoginUrlAuthenticationEntryPoint(redirectUri);
    }

}
