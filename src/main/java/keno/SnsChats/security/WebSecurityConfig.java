package keno.SnsChats.security;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests(authorize -> authorize
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .apply(securityDsl());
                return http.build();
    }

    private SecurityDsl securityDsl() {
        return new SecurityDsl();
    }

}
