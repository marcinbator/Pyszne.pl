package com.example.pyszne_pl_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Configuration of secure authentication process

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() { //Bean that is urgent for registration process (hashes)
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(1) //Order of using filterChains
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception { //Config of URLs that require authentication
        http
                .securityMatcher("/api/**") //URLs
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest() //POST, GET etc
                        .authenticated() //Needs to be authenticated
                )
                .formLogin((formLogin)->formLogin //Settings of login form
                        .loginPage("/login") //Custom login URL (page specified in WebConfig)
                        .defaultSuccessUrl("/")); //Custom success URL
        return http.build();
    }


    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception { //Same as above but for any other URLs
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .permitAll() //Open, does not require authentication
                )
                .formLogin((formLogin)->formLogin
                        .loginPage("/login"))
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login"));
        return http.build();
    }

}
