//package com.example.travelAgency.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableMethodSecurity
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//
//            http.csrf((csrf) -> csrf.disable())
//                    .authorizeHttpRequests((authorize) -> authorize
//                            .requestMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll()
//                            .requestMatchers(HttpMethod.GET,"/api/tour/findAll").permitAll()
//                            .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//
//            return http.build();
//    }

import org.springframework.context.annotation.Bean;

//@Bean passEncoder
//@Bean authenticationManagaer
//}
