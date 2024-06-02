//package com.example.travelAgency.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableMethodSecurity
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//   @Bean
//   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//
//         http.csrf((csrf) -> csrf.disable())
//                    .authorizeHttpRequests((authorize) -> authorize
//                            .requestMatchers("/swagger-ui/**").permitAll()
//                            .requestMatchers("/api/tour/**").permitAll()
//                           .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//
//           return http.build();
//   }
//
//
//
//@Bean
//AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//            return configuration.getAuthenticationManager();
//            }
//
//
//@Bean
//public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//        }
//}
