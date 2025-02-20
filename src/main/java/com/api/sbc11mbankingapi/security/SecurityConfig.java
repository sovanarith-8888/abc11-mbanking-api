package com.api.sbc11mbankingapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor

public class SecurityConfig {
    private final UserDetailsService   userDetailsService;
    private final PasswordEncoder passwordEncoderBean;
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider (){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoderBean);
        return null;
    }

    @Bean
    SecurityFilterChain configFilterChain(HttpSecurity http) throws Exception {

        // protect route
        http.authorizeHttpRequests(endpoint -> endpoint
                .requestMatchers("/api/v1/account-types").permitAll()
                //.requestMatchers("/api/v1/users").au
                .anyRequest().authenticated());

        // Security mechnism
        http.httpBasic(Customizer.withDefaults());

        http.csrf(token->token.disable() );
        http.sessionManagement(session-> session.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
        )); // change to stateless
        return http.build();
    }
}
