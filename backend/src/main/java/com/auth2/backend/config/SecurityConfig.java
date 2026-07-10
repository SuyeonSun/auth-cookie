package com.auth2.backend.config;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        PathPatternRequestMatcher.Builder mvc = PathPatternRequestMatcher.withDefaults();
        RequestMatcher h2ConsoleMatcher = PathRequest.toH2Console();

        http
                .csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleMatcher))
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(h2ConsoleMatcher).permitAll()
                        .requestMatchers(
                                mvc.matcher("/swagger-ui/**"),
                                mvc.matcher("/swagger-ui.html"),
                                mvc.matcher("/v3/api-docs/**"))
                        .permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }
}
