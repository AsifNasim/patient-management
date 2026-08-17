package com.pm.authservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    "Allow every HTTP request, don't require authentication, and disable CSRF protection."
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(
                authorize -> authorize.anyRequest().permitAll()
        ).csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

//   @Bean --> "Create this object and keep it in the Spring container so other classes can use it."
    @Bean
    public PasswordEncoder passwordEncoder(){
//        "Use BCrypt for hashing and checking passwords."
        return new BCryptPasswordEncoder();
    }
}
