package com.cjs.example.config;

import com.cjs.example.util.MyUserInfoTokenServices;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @author ccq
 * @since 2021/1/21 10:38
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final ResourceServerProperties sso;

    private final OAuth2RestOperations restTemplate;

    private final AuthoritiesExtractor authoritiesExtractor;

    private final PrincipalExtractor principalExtractor;

    public ResourceServerConfig(ResourceServerProperties sso,
                                UserInfoRestTemplateFactory restTemplateFactory,
                                ObjectProvider<AuthoritiesExtractor> authoritiesExtractor,
                                ObjectProvider<PrincipalExtractor> principalExtractor) {
        this.sso = sso;
        this.restTemplate = restTemplateFactory.getUserInfoRestTemplate();
        this.authoritiesExtractor = authoritiesExtractor.getIfAvailable();
        this.principalExtractor = principalExtractor.getIfAvailable();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/test/**")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST).access("#oauth2.hasAnyScope('write')")
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("test").tokenServices(userInfoTokenServices());
        super.configure(resources);
    }

    @Bean
    public ResourceServerTokenServices userInfoTokenServices() {
        MyUserInfoTokenServices services = new MyUserInfoTokenServices(
                this.sso.getUserInfoUri(), this.sso.getClientId());
        services.setRestTemplate(this.restTemplate);
        services.setTokenType(this.sso.getTokenType());
        if (this.authoritiesExtractor != null) {
            services.setAuthoritiesExtractor(this.authoritiesExtractor);
        }
        if (this.principalExtractor != null) {
            services.setPrincipalExtractor(this.principalExtractor);
        }
        return services;
    }
}
