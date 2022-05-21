package keno.SnsChats.security;

import keno.SnsChats.utils.RequestLoggingFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityDsl extends AbstractHttpConfigurer<SecurityDsl, HttpSecurity> {
    @Override
    public void init(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
    @Override
    public void configure(HttpSecurity http) {
        ApplicationContext context = http.getSharedObject(ApplicationContext.class);
        RequestLoggingFilter filter = context.getBean(RequestLoggingFilter.class);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
