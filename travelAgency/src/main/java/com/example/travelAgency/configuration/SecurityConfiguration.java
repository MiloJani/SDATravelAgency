package com.example.travelAgency.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic")
public class SecurityConfiguration {

   @Bean
   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

         http.csrf((csrf) -> csrf.disable())
                    .authorizeHttpRequests((authorize) -> authorize
                            .requestMatchers(HttpMethod.GET,"/api/").permitAll()
                            .requestMatchers(HttpMethod.POST,"/api/auth/login").permitAll()
                            .requestMatchers(HttpMethod.POST,"/api/auth/register").permitAll()
                            .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/swagger-resources/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
                            .requestMatchers(HttpMethod.GET, "/webjars/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/v2/api-docs").permitAll()
                            .requestMatchers(HttpMethod.GET,"swagger-ui/index.html").permitAll()
                            .requestMatchers(HttpMethod.POST,"/api/").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT,"/api/").hasAnyRole("ADMIN","USER")
//                            .requestMatchers(HttpMethod.POST,"/api/auth/registerStaff").permitAll()
//                            .requestMatchers("/swagger-ui/**").permitAll()
//                            .requestMatchers("/v3/api-docs/**").permitAll()
//                            .requestMatchers("/api/tour/**").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                            .requestMatchers("/api/**").permitAll()
                           .anyRequest().authenticated())
                 .httpBasic(Customizer.withDefaults());

           return http.build();
   }



@Bean
AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
            return configuration.getAuthenticationManager();
            }


@Bean
public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        }
}
