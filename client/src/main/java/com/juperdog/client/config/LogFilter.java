package com.juperdog.client.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by wasan_kha on 10/12/2017 AD.
 */
@Order(-20)
public class LogFilter extends GenericFilterBean {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    OAuth2ProtectedResourceDetails details;

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        logger.info(">>>>>>>>>>>>>>>> OAuth2ClientContext.accessToken : "+oauth2ClientContext.getAccessToken());
        logger.info(">>>>>>>>>>>>>>>> OAuth2ProtectedResourceDetails.clientId : "+details.getClientId());
        logger.info(">>>>>>>>>>>>>>>> OAuth2ProtectedResourceDetails.clientSecret : "+details.getClientSecret());
        logger.info(">>>>>>>>>>>>>>>> OAuth2ProtectedResourceDetails.clientAuthenticationScheme : "+details.getClientAuthenticationScheme());

        chain.doFilter(request, response);
    }
}
