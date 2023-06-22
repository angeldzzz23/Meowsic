package com.meowsic.meows.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers(HttpMethod.GET, "/api/**").authenticated();
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());


        return http.build();
    }


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> {
////                    authorize.anyRequest().authenticated();
//                    authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
////                            .requestMatchers(HttpMethod.GET, "/api/categories/**").permitAll()
//                            .requestMatchers("/api/auth/**").permitAll()
//                            .anyRequest().authenticated();
//                }).httpBasic(Customizer.withDefaults())
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(authenticationEntryPoint))
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

}
